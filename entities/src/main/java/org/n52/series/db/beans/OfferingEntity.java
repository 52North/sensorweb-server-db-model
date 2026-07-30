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
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.UniqueConstraint;
import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.HibernateRelations.HasFeatureTypes;
import org.n52.series.db.beans.HibernateRelations.HasObservationTypes;
import org.n52.series.db.beans.HibernateRelations.HasPhenomenonTime;
import org.n52.series.db.beans.HibernateRelations.HasRelatedFeatures;
import org.n52.series.db.beans.HibernateRelations.HasResultTimes;
import org.n52.series.db.beans.HibernateRelations.HasValidTime;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.i18n.I18nOfferingEntity;
import org.n52.series.db.common.Utils;

import java.io.Serial;
import java.util.Date;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.OfferingEntity")
@Table(name = "offering",
        indexes = { @Index(name = "idx_offering_identifier", columnList = "identifier"),
                @Index(name = "idx_offering_identifier_codespace", columnList = "fk_identifier_codespace_id"),
                @Index(name = "idx_offering_name_codespace", columnList = "fk_name_codespace_id") },
        uniqueConstraints = @UniqueConstraint(name = "un_offering_identifier", columnNames = { "identifier" }))
@AttributeOverride(name = "id", column = @Column(name = "offering_id"))
@AttributeOverride(name = "staIdentifier", column = @Column(name = "identifier", insertable = false, updatable = false))
public class OfferingEntity extends HierarchicalEntity<OfferingEntity> implements HasObservationTypes, HasFeatureTypes,
        HasRelatedFeatures, HasPhenomenonTime, HasResultTimes, HasValidTime {

    public static final String PROPERTY_PHENOMENON_TIME_START = "phenomenonTimeStart";
    public static final String PROPERTY_PHENOMENON_TIME_END = "phenomenonTimeEnd";
    public static final String PROPERTY_RESULT_TIME_START = "resultTimeStart";
    public static final String PROPERTY_RESULT_TIME_END = "resultTimeEnd";

    @Serial
    private static final long serialVersionUID = 5862607025737865794L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sampling_time_start", length = 29)
    // @Comment("The minimum samplingTimeStart of all observation that belong to this offering. If the column
    // is
    // empty, the information is calculated during the cache update and stored locally. Used for the
    // capabilities of
    // the SOS.")
    private Date phenomenonTimeStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sampling_time_end", length = 29)
    // @Comment("The maximum samplingTimeStart of all observation that belong to this offering. If the column
    // is
    // empty, the information is calculated during the cache update and stored locally. Used for the
    // capabilities of
    // the SOS.")
    private Date phenomenonTimeEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "result_time_start", length = 29)
    // @Comment("The minimum resultTimeStart of all observation that belong to this offering. If the column is
    // empty,
    // the information is calculated during the cache update and stored locally. Used for the capabilities of
    // the SOS.")
    private Date resultTimeStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "result_time_end", length = 29)
    // @Comment("The maximum resultTimeEnd of all observation that belong to this offering. If the column is
    // empty,
    // the information is calculated during the cache update and stored locally. Used for the capabilities of
    // the SOS.")
    private Date resultTimeEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_time_start", length = 29)
    // @Comment("The minimum validTimeStart of all observation that belong to this offering. If the column is
    // empty,
    // the information is calculated during the cache update and stored locally. Used for the capabilities of
    // the SOS.")
    private Date validTimeStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_time_end", length = 29)
    // @Comment("The maximum validTimeEnd of all observation that belong to this offering. If the column is
    // empty, the
    // information is calculated during the cache update and stored locally. Used for the capabilities of the
    // SOS.")
    private Date validTimeEnd;

    @Embedded
    private GeometryEntity geometryEntity;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offering_observation_type",
            joinColumns = @JoinColumn(name = "fk_offering_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_offering_observation_type")), // points back at
                                                                                      // OfferingEntity
            inverseJoinColumns = @JoinColumn(name = "fk_format_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_observation_type_offering")) // points at the target
    )
    private Set<FormatEntity> observationTypes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offering_feature_type",
            joinColumns = @JoinColumn(name = "fk_offering_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_offering_feature_type")), // points back at
                                                                                  // OfferingEntity
            inverseJoinColumns = @JoinColumn(name = "fk_format_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_feature_type_offering")) // points at the target
    )
    private Set<FormatEntity> featureTypes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "offering_related_feature",
            joinColumns = @JoinColumn(name = "fk_offering_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_offering_related_feature")), // points back at
                                                                                     // OfferingEntity
            inverseJoinColumns = @JoinColumn(name = "fk_related_feature_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_related_feature_offering")) // points at the target
    )
    private Set<RelatedFeatureEntity> relatedFeatures;

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = I18nOfferingEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_offering_id", nullable = false, foreignKey = @ForeignKey(name = "fk_offering"))
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return super.getTranslations();
    }

    @Override
    @ManyToMany(fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "offering_hierarchy",
            joinColumns = @JoinColumn(name = "fk_child_offering_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_offering_child")),
            inverseJoinColumns = @JoinColumn(name = "fk_parent_offering_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_offering_parent")))
    public Set<OfferingEntity> getParents() {
        return super.getParents();
    }

    @Override
    @ManyToMany(mappedBy = "parents", fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    public Set<OfferingEntity> getChildren() {
        return super.getChildren();
    }

    public Geometry getGeometry() {
        return geometryEntity != null ? geometryEntity.getGeometry() : null;
    }

    public OfferingEntity setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        this.geometryEntity.setSrid(geometry.getSRID());
        return this;
    }

    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public boolean isSetGeometry() {
        return geometryEntity != null;
    }

    /**
     * @return the observationTypes
     */
    @Override
    public Set<FormatEntity> getObservationTypes() {
        return observationTypes;
    }

    /**
     * @param observationTypes
     *            the observationTypes to set
     */
    @Override
    public void setObservationTypes(Set<FormatEntity> observationTypes) {
        this.observationTypes = observationTypes;
    }

    /**
     * @return the featureTypes
     */
    @Override
    public Set<FormatEntity> getFeatureTypes() {
        return featureTypes;
    }

    /**
     * @param featureTypes
     *            the featureTypes to set
     */
    @Override
    public void setFeatureTypes(Set<FormatEntity> featureTypes) {
        this.featureTypes = featureTypes;
    }

    @Override
    public Date getSamplingTimeStart() {
        return Utils.createUnmutableTimestamp(phenomenonTimeStart);
    }

    @Override
    public void setSamplingTimeStart(Date time) {
        this.phenomenonTimeStart = Utils.createUnmutableTimestamp(time);
    }

    @Override
    public Date getSamplingTimeEnd() {
        return Utils.createUnmutableTimestamp(phenomenonTimeEnd);
    }

    @Override
    public void setSamplingTimeEnd(Date time) {
        this.phenomenonTimeEnd = Utils.createUnmutableTimestamp(time);
    }

    /**
     * @return the resultTimeStart
     */
    @Override
    public Date getResultTimeStart() {
        return Utils.createUnmutableTimestamp(resultTimeStart);
    }

    /**
     * @param resultTimeStart
     *            the resultTimeStart to set
     */
    @Override
    public void setResultTimeStart(Date resultTimeStart) {
        this.resultTimeStart = Utils.createUnmutableTimestamp(resultTimeStart);
    }

    /**
     * @return the resultTimeEnd
     */
    @Override
    public Date getResultTimeEnd() {
        return Utils.createUnmutableTimestamp(resultTimeEnd);
    }

    /**
     * @param resultTimeEnd
     *            the resultTimeEnd to set
     */
    @Override
    public void setResultTimeEnd(Date resultTimeEnd) {
        this.resultTimeEnd = Utils.createUnmutableTimestamp(resultTimeEnd);
    }

    /**
     * @return the validTimeStart
     */
    @Override
    public Date getValidTimeStart() {
        return Utils.createUnmutableTimestamp(validTimeStart);
    }

    /**
     * @param validTimeStart
     *            the validTimeStart to set
     */
    @Override
    public void setValidTimeStart(Date validTimeStart) {
        this.validTimeStart = Utils.createUnmutableTimestamp(validTimeStart);
    }

    /**
     * @return the validTimeEnd
     */
    @Override
    public Date getValidTimeEnd() {
        return Utils.createUnmutableTimestamp(validTimeEnd);
    }

    /**
     * @param validTimeEnd
     *            the validTimeEnd to set
     */
    @Override
    public void setValidTimeEnd(Date validTimeEnd) {
        this.validTimeEnd = Utils.createUnmutableTimestamp(validTimeEnd);
    }

    @Override
    public boolean isSetValidTime() {
        return getValidTimeStart() != null && getValidTimeEnd() != null;
    }

    @Override
    public Set<RelatedFeatureEntity> getRelatedFeatures() {
        return relatedFeatures;
    }

    @Override
    public void setRelatedFeatures(Set<RelatedFeatureEntity> relatedFeatures) {
        this.relatedFeatures = relatedFeatures;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof OfferingEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
