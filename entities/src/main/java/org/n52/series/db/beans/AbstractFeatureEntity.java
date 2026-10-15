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
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.SQLRestriction;
import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.HibernateRelations.HasDatasets;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasXml;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.i18n.I18nFeatureEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureParameterEntity;

import java.io.Serial;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.AbstractFeatureEntity")
@Table(name = "feature",
        indexes = { @Index(name = "idx_feature_format", columnList = "fk_format_id"),
                @Index(name = "idx_feature_identifier", columnList = "identifier"),
                @Index(name = "idx_feature_staIdentifier", columnList = "sta_identifier"),
                @Index(name = "idx_feature_identifier_codespace", columnList = "fk_identifier_codespace_id"),
                @Index(name = "idx_feature_name_codespace", columnList = "fk_name_codespace_id") },
        uniqueConstraints = { @UniqueConstraint(name = "un_feature_identifier", columnNames = { "identifier" }),
                @UniqueConstraint(name = "un_feature_staIdentifier", columnNames = { "sta_identifier" }),
                @UniqueConstraint(name = "un_feature_url", columnNames = { "url" }) })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "discriminator")
@AttributeOverride(name = "id", column = @Column(name = "feature_id"))
public abstract class AbstractFeatureEntity<E> extends HierarchicalEntity<E>
        implements HasXml, HasGeometry, HasDatasets, IsStaEntity {

    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";
    public static final String PROPERTY_GEOMETRY = "geometry";
    public static final String PROPERTY_GEOMETRY_ENTITY_GEOMETRY = PROPERTY_GEOMETRY_ENTITY + "." + GEOMETRY;
    public static final String PROPERTY_GEOMETRY_ENTITY_LAT = PROPERTY_GEOMETRY_ENTITY + ".lat";
    public static final String PROPERTY_GEOMETRY_ENTITY_LON = PROPERTY_GEOMETRY_ENTITY + ".lon";
    public static final String PROPERTY_FEATURE_TYPE = "featureType";

    @Serial
    private static final long serialVersionUID = 6712642995944229067L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_format_id", nullable = false, foreignKey = @ForeignKey(name = "fk_feature_format"))
    private FormatEntity featureType;

    @Column(name = "xml", columnDefinition = "text")
    // @Comment("The XML encoded representation of the feature.")
    private String xml;

    @Column(name = "url")
    // @Comment("Optional URL to an external resource that describes the feature, e.g. a WFS")
    private String url;

    @Embedded
    @AttributeOverride(name = "geometry", column = @Column(name = "geom"))
    private GeometryEntity geometryEntity;

    @OneToMany(mappedBy = DatasetEntity.PROPERTY_FEATURE, fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<DatasetEntity> datasets;

    @Transient
    private Set<DataEntity<?>> observations;

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = FeatureParameterEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_feature_id", nullable = false, foreignKey = @ForeignKey(name = "fk_param_feature_id"))
    @SQLRestriction("fk_parent_parameter_id is null")
    public Set<ParameterEntity<?>> getParameters() {
        return super.getParameters();
    }

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = I18nFeatureEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_feature_id", nullable = false, foreignKey = @ForeignKey(name = "fk_feature"))
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return super.getTranslations();
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
    public String getXml() {
        return xml;
    }

    @Override
    public void setXml(String xml) {
        this.xml = xml;
    }

    public FormatEntity getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FormatEntity featureType) {
        this.featureType = featureType;
    }

    public boolean isSetFeatureType() {
        return getFeatureType() != null && getFeatureType().isSetFormat();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSetUrl() {
        return getUrl() != null && !getUrl().isEmpty();
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
    }

    public Set<DataEntity<?>> getObservations() {
        return observations != null ? observations
                : getDatasets().stream().flatMap(d -> d.getObservations().stream()).collect(Collectors.toSet());
    }

    public AbstractFeatureEntity<E> setObservations(Set<DataEntity<?>> observations) {
        this.observations = observations;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Objects.hash(observations));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractFeatureEntity afe && super.equals(obj)
                && Objects.hash(observations) == Objects.hash(afe.getObservations());
    }
}
