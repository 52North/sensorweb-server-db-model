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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.SQLRestriction;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.i18n.I18nPhenomenonEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonParameterEntity;

import java.io.Serial;
import java.util.Objects;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.PhenomenonEntity")
@Table(name = "phenomenon",
        indexes = { @Index(name = "idx_phenomenon_identifier", columnList = "identifier"),
                @Index(name = "idx_phenomenon_staIdentifier", columnList = "sta_identifier"),
                @Index(name = "idx_phenomenon_identifier_codespace", columnList = "fk_identifier_codespace_id"),
                @Index(name = "idx_phenomenon_name_codespace", columnList = "fk_name_codespace_id") },
        uniqueConstraints = { @UniqueConstraint(name = "un_phenomenon_identifier", columnNames = { "identifier" }),
                @UniqueConstraint(name = "un_phenomenon_staIdentifier", columnNames = { "sta_identifier" }) })
// table comment: Storage of the phenomenon/observableProperties, e.g. air temperature, water temperature, ...
@AttributeOverride(name = "id", column = @Column(name = "phenomenon_id"))
public class PhenomenonEntity extends HierarchicalEntity<PhenomenonEntity>
        implements HibernateRelations.HasAbstractDatasets, IsStaEntity {

    @Serial
    private static final long serialVersionUID = 2302654989683191424L;

    @OneToMany(mappedBy = AbstractDatasetEntity.PROPERTY_PHENOMENON, fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AbstractDatasetEntity> datasets;

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = PhenomenonParameterEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_phenomenon_id", nullable = false, foreignKey = @ForeignKey(name = "fk_param_phenomenon_id"))
    @SQLRestriction("fk_parent_parameter_id is null")
    public Set<ParameterEntity<?>> getParameters() {
        return super.getParameters();
    }

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = I18nPhenomenonEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_phenomenon_id", nullable = false, foreignKey = @ForeignKey(name = "fk_phenomenon"))
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return super.getTranslations();
    }

    @Override
    @ManyToMany(fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "composite_phenomenon",
            joinColumns = @JoinColumn(name = "fk_child_phenomenon_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_phenomenon_child")),
            inverseJoinColumns = @JoinColumn(name = "fk_parent_phenomenon_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_phenomenon_parent")))
    public Set<PhenomenonEntity> getParents() {
        return super.getParents();
    }

    @Override
    @ManyToMany(mappedBy = "parents", fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    public Set<PhenomenonEntity> getChildren() {
        return super.getChildren();
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datastreams) {
        this.datasets = datastreams;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStaIdentifier());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PhenomenonEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
