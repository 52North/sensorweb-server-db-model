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

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DiscriminatorOptions;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;
import org.n52.series.db.beans.HibernateRelations.HasDataset;
import org.n52.series.db.beans.HibernateRelations.HasFeature;
import org.n52.series.db.beans.HibernateRelations.HasParameters;
import org.n52.series.db.beans.HibernateRelations.HasPhenomenonTime;
import org.n52.series.db.beans.HibernateRelations.HasResultTime;
import org.n52.series.db.beans.HibernateRelations.HasValidTime;
import org.n52.series.db.beans.HibernateRelations.IsNoDataValue;
import org.n52.series.db.beans.HibernateRelations.IsProcessed;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.ereporting.EReportingProfileDataEntity;
import org.n52.series.db.beans.quality.QualityEntity;
import org.n52.series.db.beans.sampling.SamplingProfileDataEntity;
import org.n52.series.db.beans.sta.GroupEntity;
import org.n52.series.db.beans.sta.RelationEntity;
import org.n52.series.db.beans.sta.StaRelations;
import org.n52.series.db.common.Utils;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.DataEntity")
@Table(name = "observation",
        indexes = { @Index(name = "idx_observation_dataset", columnList = "fk_dataset_id"),
                @Index(name = "idx_sampling_time_start", columnList = "sampling_time_start"),
                @Index(name = "idx_sampling_time_end", columnList = "sampling_time_end"),
                @Index(name = "idx_result_time", columnList = "result_time"),
                @Index(name = "idx_observation_staIdentifier", columnList = "sta_identifier"),
                @Index(name = "idx_observation_identifier_codespace", columnList = "fk_identifier_codespace_id"),
                @Index(name = "idx_observation_name_codespace", columnList = "fk_name_codespace_id"),
                @Index(name = "idx_observation_is_deleted", columnList = "is_deleted"),
                @Index(name = "idx_observation_parent", columnList = "fk_parent_observation_id"),
                @Index(name = "idx_observation_result_template", columnList = "fk_result_template_id") },
        uniqueConstraints = {
                @UniqueConstraint(name = "un_observation_identity",
                        columnNames = { "value_type", "fk_dataset_id", "sampling_time_start", "sampling_time_end",
                                "result_time", "vertical_from", "vertical_to" }),
                @UniqueConstraint(name = "un_observation_identifier", columnNames = { "identifier" }),
                @UniqueConstraint(name = "un_observation_staIdentifier", columnNames = { "sta_identifier" }) })
// table comment: Storage of the observation values with the timestamp and additional metadata. The metadata
// are height/depth values for profile observation and sampling geometries for trajectory observations. In
// each observation entry only one value_... column should be filled with a value!
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "value_type")
@DiscriminatorOptions(force = true)
@AttributeOverride(name = "id", column = @Column(name = "observation_id"))
public abstract class DataEntity<T> extends DescribableEntity
        implements Comparable<DataEntity<T>>, Serializable, HasPhenomenonTime, IsStaEntity, HasResultTime,
        HasValidTime, HasParameters, HasDataset, HasFeature, IsProcessed, IsNoDataValue {

    public static final String PROPERTY_DATASET = "dataset";

    public static final String PROPERTY_DATASET_ID = "datasetId";

    public static final String PROPERTY_RESULT_TIME = "resultTime";

    public static final String PROPERTY_SAMPLING_TIME_START = "samplingTimeStart";

    public static final String PROPERTY_SAMPLING_TIME_END = "samplingTimeEnd";

    public static final String PROPERTY_VALID_TIME_START = "valid_time_start";

    public static final String PROPERTY_VALID_TIME_END = "valid_time_end";

    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";

    public static final String PROPERTY_GEOMETRY = "geometry";

    public static final String PROPERTY_DELETED = "deleted";

    public static final String PROPERTY_PARENT = "parent";

    public static final String PROPERTY_IDENTIFIER = "identifier";

    public static final String PROPERTY_VALUE = "value";

    public static final String PROPERTY_PARAMETERS = "parameters";

    public static final String PROPERTY_SAMPLING_PROFILE = "samplingProfile";

    public static final String PROPERTY_EREPORTING_PROFILE = "ereportingProfile";

    public static final String PROPERTY_VALUE_BOOLEAN = "valueBoolean";

    public static final String PROPERTY_VALUE_TEXT = "valueText";

    public static final String PROPERTY_VALUE_QUANTITY = "valueQuantity";

    public static final String PROPERTY_VALUE_CATEGORY = "valueCategory";

    public static final String PROPERTY_VALUE_COUNT = "valueCount";

    public static final BigDecimal NOT_SET_VERTICAL = BigDecimal.valueOf(0);

    @Serial
    private static final long serialVersionUID = 273612846605300612L;

    @Formula("value_type")
    private String valueType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_dataset_id", nullable = false, foreignKey = @ForeignKey(name = "fk_dataset"))
    private DatasetEntity dataset;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sampling_time_start", nullable = false, length = 29)
    // @Comment("The timestamp when the observation period has started or the observation took place. In the
    // the latter, sampling_time_start and sampling_time_end are equal.")
    private Date samplingTimeStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "sampling_time_end", nullable = false, length = 29)
    // @Comment("The timestamp when the measurement period has finished or the observation took place. In the
    // the latter, sampling_time_start and sampling_time_end are equal.")
    private Date samplingTimeEnd;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "result_time", length = 29)
    // @Comment("The timestamp when the observation was published. Might be identical with sampling_time_start
    // and sampling_time_end.")
    private Date resultTime;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_deleted", nullable = false)
    @ColumnDefault("0")
    // @Comment("Flag that indicates if this observation is deleted")
    private boolean deleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_time_start", length = 29)
    @ColumnDefault("NULL")
    // @Comment("The timestamp from when the obervation is valid, e.g. forcaste observations")
    private Date validTimeStart;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "valid_time_end", length = 29)
    @ColumnDefault("NULL")
    // @Comment("The timestamp until when the obervation is valid, e.g. forcaste observations")
    private Date validTimeEnd;

    @Embedded
    private GeometryEntity geometryEntity;

    @OneToMany(mappedBy = "observation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RelatedDataEntity> relatedObservations;

    @Column(name = "value_identifier")
    // @Comment("Identifier of the value. E.g. used in OGC SWE encoded values like SweText")
    private String valueIdentifier;

    @Column(name = "value_name")
    // @Comment("Identifier of the name. E.g. used in OGC SWE encoded values like SweText")
    private String valueName;

    @Column(name = "value_description")
    // @Comment("Identifier of the description. E.g. used in OGC SWE encoded values like SweText")
    private String valueDescription;

    @Column(name = "vertical_from", nullable = false)
    @ColumnDefault("0")
    // @Comment("The start level of a vertical observation, required for profile observations")
    private BigDecimal verticalFrom = NOT_SET_VERTICAL;

    @Column(name = "vertical_to", nullable = false)
    @ColumnDefault("0")
    // @Comment("The end level or the level of a vertical observation, required for profile observations")
    private BigDecimal verticalTo = NOT_SET_VERTICAL;

    @Column(name = "fk_parent_observation_id")
    // @Comment("Reference to the parent observation in the case of complex observations like profiles,
    // complex or swedataarray observations.")
    private Long parent;

    @Embedded
    private EReportingProfileDataEntity ereportingProfile;

    @Column(name = "value_quantity", insertable = false, updatable = false)
    private BigDecimal valueQuantity;

    @Column(name = "value_text", insertable = false, updatable = false)
    private String valueText;

    @Column(name = "value_count", insertable = false, updatable = false)
    private Integer valueCount;

    @Column(name = "value_category", insertable = false, updatable = false)
    private String valueCategory;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "value_boolean", insertable = false, updatable = false)
    private Boolean valueBoolean;

    @Transient
    private T value;

    @Transient
    private DetectionLimitEntity detectionLimit;

    @Transient
    private SamplingProfileDataEntity samplingProfile;

    @Transient
    private AbstractFeatureEntity<?> feature;
    @Transient
    private Set<QualityEntity<?>> qualities = new LinkedHashSet<>();

    private boolean processed;

    /**
     * @return the samplingTimeStart
     */

    @Override
    public Date getSamplingTimeStart() {
        return Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @param samplingTimeStart
     *            the samplingTimeStart
     */

    @Override
    public void setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @return the samplingTimeEnd
     */

    @Override
    public Date getSamplingTimeEnd() {
        return Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    /**
     * @param samplingTimeEnd
     *            the samplingTimeEnd
     */

    @Override
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    public T getValue() {
        return value;
    }

    public void setValue(final T value) {
        this.value = value;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public void setGeometryEntity(final GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public boolean isSetGeometryEntity() {
        return geometryEntity != null && !geometryEntity.isEmpty();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(final boolean deleted) {
        this.deleted = deleted;
    }

    @Override
    public Date getValidTimeStart() {
        return Utils.createUnmutableTimestamp(validTimeStart);
    }

    @Override
    public void setValidTimeStart(final Date validTimeStart) {
        this.validTimeStart = Utils.createUnmutableTimestamp(validTimeStart);
    }

    @Override
    public Date getValidTimeEnd() {
        return Utils.createUnmutableTimestamp(validTimeEnd);
    }

    @Override
    public void setValidTimeEnd(final Date validTimeEnd) {
        this.validTimeEnd = Utils.createUnmutableTimestamp(validTimeEnd);
    }

    @Override
    public boolean isSetValidTime() {
        return isSetValidStartTime() && isSetValidEndTime();
    }

    @Override
    public boolean isSetValidStartTime() {
        return validTimeStart != null;
    }

    @Override
    public boolean isSetValidEndTime() {
        return validTimeEnd != null;
    }

    @Override
    public Date getResultTime() {
        return Utils.createUnmutableTimestamp(resultTime);
    }

    @Override
    public void setResultTime(final Date resultTime) {
        this.resultTime = Utils.createUnmutableTimestamp(resultTime);
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public boolean hasParent() {
        return getParent() != null;
    }

    @Override
    public DatasetEntity getDataset() {
        return dataset;
    }

    @Override
    public void setDataset(final DatasetEntity dataset) {
        this.dataset = dataset;
    }

    public Set<RelatedDataEntity> getRelatedObservations() {
        return relatedObservations;
    }

    public void setRelatedObservations(final Set<RelatedDataEntity> relatedObservations) {
        this.relatedObservations = relatedObservations;
    }

    public boolean hasRelatedObservations() {
        return getRelatedObservations() != null && !getRelatedObservations().isEmpty();
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    public String getValueType() {
        return valueType;
    }

    public String getValueIdentifier() {
        return valueIdentifier;
    }

    public void setValueIdentifier(final String valueIdentifier) {
        this.valueIdentifier = valueIdentifier;
    }

    public boolean hasValueIdentifier() {
        return getValueIdentifier() != null && !getValueIdentifier().isEmpty();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(final String valueName) {
        this.valueName = valueName;
    }

    public boolean hasValueName() {
        return getValueName() != null && !getValueName().isEmpty();
    }

    public String getValueDescription() {
        return valueDescription;
    }

    public void setValueDescription(final String valueDescription) {
        this.valueDescription = valueDescription;
    }

    public boolean hasValueDescription() {
        return getValueDescription() != null && !getValueDescription().isEmpty();
    }

    public boolean hasVerticalInterval() {
        return hasVerticalFrom() && hasVerticalTo() && getVerticalFrom().compareTo(getVerticalTo()) != 0;
    }

    public BigDecimal getVerticalFrom() {
        return verticalFrom;
    }

    public void setVerticalFrom(final BigDecimal verticalFrom) {
        this.verticalFrom = verticalFrom;
    }

    public boolean hasVerticalFrom() {
        return getVerticalFrom() != null;
    }

    public BigDecimal getVerticalTo() {
        return verticalTo;
    }

    public void setVerticalTo(final BigDecimal verticalTo) {
        this.verticalTo = verticalTo;
    }

    public boolean hasVerticalTo() {
        return getVerticalTo() != null;
    }

    public DetectionLimitEntity getDetectionLimit() {
        return detectionLimit;
    }

    public void setDetectionLimit(DetectionLimitEntity detectionLimit) {
        this.detectionLimit = detectionLimit;
    }

    public boolean hasDetectionLimit() {
        return getDetectionLimit() != null;
    }

    public SamplingProfileDataEntity getSamplingProfile() {
        return samplingProfile;
    }

    public void setSamplingProfile(SamplingProfileDataEntity samplingProfile) {
        this.samplingProfile = samplingProfile;
    }

    public boolean hasSamplingProfile() {
        return getSamplingProfile() != null;
    }

    public EReportingProfileDataEntity getEreportingProfile() {
        return ereportingProfile;
    }

    public void setEreportingProfile(EReportingProfileDataEntity ereportingProfile) {
        this.ereportingProfile = ereportingProfile;
    }

    public boolean hasEreportingProfile() {
        return getEreportingProfile() != null;
    }

    public Boolean getValueBoolean() {
        return valueBoolean;
    }

    public void setValueBoolean(Boolean valueBoolean) {
        this.valueBoolean = valueBoolean;
    }

    public String getValueText() {
        return valueText;
    }

    public void setValueText(String valueText) {
        this.valueText = valueText;
    }

    public BigDecimal getValueQuantity() {
        return valueQuantity;
    }

    public void setValueQuantity(BigDecimal valueQuantity) {
        this.valueQuantity = valueQuantity;
    }

    public String getValueCategory() {
        return valueCategory;
    }

    public void setValueCategory(String valueCategory) {
        this.valueCategory = valueCategory;
    }

    public Integer getValueCount() {
        return valueCount;
    }

    public void setValueCount(Integer valueCount) {
        this.valueCount = valueCount;
    }

    @Override
    public AbstractFeatureEntity<?> getFeature() {
        return feature != null ? feature : getDataset().getFeature();
    }

    @Override
    public void setFeature(AbstractFeatureEntity<?> feature) {
        this.feature = feature;
    }

    /**
     * @return the qualities
     */
    public Set<QualityEntity<?>> getQuality() {
        return qualities;
    }

    /**
     * @param qualities
     *            the qualities to set
     * @return this
     */
    public DataEntity<T> setQuality(Set<QualityEntity<?>> qualities) {
        this.qualities.clear();
        addQuality(qualities);
        return this;
    }

    /**
     * @param qualities
     *            the qualities to add
     * @return this
     */
    public DataEntity<T> addQuality(Set<QualityEntity<?>> qualities) {
        if (qualities != null) {
            this.qualities.addAll(qualities);
        }
        return this;
    }

    /**
     * @param quality
     *            the quality to add
     * @return this
     */
    public DataEntity<T> addQuality(QualityEntity<?> quality) {
        if (quality != null) {
            this.qualities.add(quality);
        }
        return this;
    }

    public boolean hasQuality() {
        return getQuality() != null && !getQuality().isEmpty();
    }

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public int compareTo(DataEntity<T> o) {
        return Comparator.comparing(DataEntity<T>::getSamplingTimeEnd)
                .thenComparing(DataEntity<T>::getSamplingTimeStart).thenComparing(DataEntity<T>::getId)
                .compare(this, o);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" id: ").append(getId()).append(" ]")
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDataset(), getSamplingTimeStart(), getSamplingTimeEnd(),
                getResultTime(), getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DataEntity)) {
            return false;
        }
        DataEntity other = (DataEntity) obj;
        return super.equals(obj) && Objects.equals(getDataset(), other.getDataset())
                && Objects.equals(getSamplingTimeStart(), other.getSamplingTimeStart())
                && Objects.equals(getSamplingTimeStart(), other.getSamplingTimeStart())
                && Objects.equals(getSamplingTimeEnd(), other.getSamplingTimeEnd())
                && Objects.equals(getResultTime(), other.getResultTime())
                && Objects.equals(getValue(), other.getValue());
    }
}
