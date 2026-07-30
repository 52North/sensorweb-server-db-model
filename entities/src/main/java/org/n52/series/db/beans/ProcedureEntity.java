/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.n52.series.db.beans;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.type.SqlTypes;
import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasProcedureDescriptionFormat;
import org.n52.series.db.beans.HibernateRelations.HasProcedureHistory;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.i18n.I18nProcedureEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureParameterEntity;

import java.io.Serial;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.ProcedureEntity")
@Table(name = "procedure",
        indexes = { @Index(name = "idx_procedure_identifier", columnList = "identifier"),
                @Index(name = "idx_procedure_staIdentifier", columnList = "sta_identifier"),
                @Index(name = "idx_procedure_identifier_codespace", columnList = "fk_identifier_codespace_id"),
                @Index(name = "idx_procedure_name_codespace", columnList = "fk_name_codespace_id"),
                @Index(name = "idx_procedure_is_reference", columnList = "is_reference"),
                @Index(name = "idx_procedure_type_of", columnList = "fk_type_of_procedure_id"),
                @Index(name = "idx_procedure_format", columnList = "fk_format_id") },
        uniqueConstraints = { @UniqueConstraint(name = "un_procedure_identifier", columnNames = { "identifier" }),
                @UniqueConstraint(name = "un_procedure_staIdentifier", columnNames = { "sta_identifier" }) })
@AttributeOverride(name = "id", column = @Column(name = "procedure_id"))
public class ProcedureEntity extends HierarchicalEntity<ProcedureEntity> implements HasProcedureHistory,
        HasProcedureDescriptionFormat, HasGeometry, HibernateRelations.HasAbstractDatasets, IsStaEntity {

    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_AGGRAGATION = "aggregation";
    public static final String PROPERTY_VALID_PROCEDURE_TIME = "procedureHistory";
    public static final String PROPERTY_PROCEDURE_DESCRIPTION_FORMAT = "format";
    public static final String PROPERTY_DESCRIPTION_FILE = "descriptionFile";

    @Serial
    private static final long serialVersionUID = 4028002933920185756L;

    // Currently unmapped properties - might be required for some SOS Profiles
    private boolean deleted;
    private GeometryEntity geometryEntity;
    private boolean type;

    @Column(name = "description_file", columnDefinition = "text")
    private String descriptionFile;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_reference", nullable = false)
    @ColumnDefault("0")
    private boolean reference;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_type_of_procedure_id", foreignKey = @ForeignKey(name = "fk_type_of"))
    private ProcedureEntity typeOf;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_aggregation", nullable = false)
    @ColumnDefault("1")
    private boolean aggregation;

    @OneToMany(mappedBy = AbstractDatasetEntity.PROPERTY_PROCEDURE, fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AbstractDatasetEntity> datasets;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_format_id", nullable = false, foreignKey = @ForeignKey(name = "fk_procedure_format"))
    private FormatEntity format;

    @OneToMany(mappedBy = ProcedureHistoryEntity.PROPERTY_PROCEDURE, fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<ProcedureHistoryEntity> procedureHistory;

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = ProcedureParameterEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_procedure_id", nullable = false, foreignKey = @ForeignKey(name = "fk_param_procedure_id"))
    @SQLRestriction("fk_parent_parameter_id is null")
    public Set<ParameterEntity<?>> getParameters() {
        return super.getParameters();
    }

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = I18nProcedureEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_procedure_id", nullable = false, foreignKey = @ForeignKey(name = "fk_i18n_procedure"))
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return super.getTranslations();
    }

    @Override
    @ManyToMany(fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "procedure_hierarchy",
            joinColumns = @JoinColumn(name = "fk_child_procedure_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_procedure_child")),
            inverseJoinColumns = @JoinColumn(name = "fk_parent_procedure_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_procedure_parent")))
    public Set<ProcedureEntity> getParents() {
        return super.getParents();
    }

    @Override
    @ManyToMany(mappedBy = "parents", fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    public Set<ProcedureEntity> getChildren() {
        return super.getChildren();
    }

    public boolean isReference() {
        return reference;
    }

    public void setReference(boolean reference) {
        this.reference = reference;
    }

    @Override
    public FormatEntity getFormat() {
        return this.format;
    }

    @Override
    public void setFormat(FormatEntity format) {
        this.format = format;
    }

    public boolean isSetFormat() {
        return getFormat() != null && getFormat().isSetFormat();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescriptionFile() {
        return descriptionFile;
    }

    public void setDescriptionFile(String descriptionFile) {
        this.descriptionFile = descriptionFile;
    }

    public boolean isSetDescriptionFile() {
        return getDescriptionFile() != null && !getDescriptionFile().isEmpty();
    }

    public ProcedureEntity getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(ProcedureEntity typeOf) {
        this.typeOf = typeOf;
    }

    public boolean isSetTypeOf() {
        return getTypeOf() != null;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean isType) {
        this.type = isType;
    }

    public boolean isAggregation() {
        return aggregation;
    }

    public void setAggregation(boolean isAggregation) {
        this.aggregation = isAggregation;
    }

    @Override
    public Set<ProcedureHistoryEntity> getProcedureHistory() {
        return procedureHistory;
    }

    @Override
    public void setProcedureHistory(Set<ProcedureHistoryEntity> procedureHistory) {
        this.procedureHistory = procedureHistory;
    }

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public void setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        if (geometry != null) {
            this.geometryEntity.setSrid(geometry.getSRID());
        }
    }

    @Override
    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProcedureEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
