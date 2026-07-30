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
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OrderColumn;
import jakarta.persistence.Transient;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import org.joda.time.DateTimeZone;
import org.n52.series.db.beans.HibernateRelations.HasTags;
import org.n52.series.db.beans.dataset.DatasetType;
import org.n52.series.db.beans.dataset.ObservationType;
import org.n52.series.db.beans.dataset.ValueType;
import org.n52.series.db.beans.sampling.SamplingProfileDatasetEntity;

import java.io.Serial;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.DatasetEntity")
@DiscriminatorValue("null")
public class DatasetEntity extends AbstractDatasetEntity implements HasTags {

    public static final String ENTITY_ALIAS = "dataset";

    public static final String PROPERTY_DATASET_TYPE = "datasetType";
    public static final String PROPERTY_OBSERVATION_TYPE = "observationType";
    public static final String PROPERTY_VALUE_TYPE = "valueType";
    public static final String PROPERTY_PUBLISHED = "published";
    public static final String PROPERTY_DELETED = "deleted";
    public static final String PROPERTY_DISABLED = "disabled";
    public static final String HIDDEN_CHILD = "hidden";

    public static final String PROPERTY_MOBILE = "mobile";
    public static final String PROPERTY_INSITU = "insitu";

    public static final String PROPERTY_SAMPLING_PROFILE = "samplingProfile";
    public static final String PROPERTY_EREPORTING_PROFILE = "ereportingProfile";
    private static final String OFFSET_REGEX = "([+-](?:2[0-3]|[01][0-9]):[0-5][0-9])";
    @Serial
    private static final long serialVersionUID = -7491530543976690237L;

    @Enumerated(EnumType.STRING)
    @Column(name = "dataset_type", nullable = false)
    @ColumnDefault("'not_initialized'")
    @Check(constraints = "dataset_type in ('individualObservation', 'sampling', 'timeseries', 'profile', "
            + "'trajectory', 'not_initialized')")
    // @Comment("Indicator whether the dataset provides individualObservation (individual observations),
    // timeseries
    // (timeseries obervations) or trajectories (trajectory observations).")
    private DatasetType datasetType;

    @Enumerated(EnumType.STRING)
    @Column(name = "observation_type", nullable = false)
    @ColumnDefault("'not_initialized'")
    @Check(constraints = "observation_type in ('simple', 'profile', 'timeseries', 'trajectory', 'not_initialized')")
    // @Comment("Indicator whether the dataset observations are of type simple (a simple observation, e.g. a
    // scalar
    // value like the temperature) or profile (profile observations)")
    private ObservationType observationType;

    @Enumerated(EnumType.STRING)
    @Column(name = "value_type", nullable = false)
    @ColumnDefault("'not_initialized'")
    @Check(constraints = "value_type in ('quantity', 'count', 'text', 'category', 'bool', 'geometry', 'blob', "
            + "'reference', 'complex', 'dataarray', 'not_initialized')")
    // @Comment("Indicator of the type of the single values. Valid values are quantity (scalar values), count
    // (integer
    // values), text (textual values), category (categorical values), bool (boolean values), reference
    // (references, e
    // .g. link to a source, photo, video)")
    private ValueType valueType;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_deleted", nullable = false)
    @ColumnDefault("0")
    // @Comment("Flag that indicates if this dataset is deleted")
    private boolean deleted;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_disabled", nullable = false)
    @ColumnDefault("0")
    // @Comment("Flag that indicates if this dataset is disabled for insertion of new data")
    private boolean disabled;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_published", nullable = false)
    @ColumnDefault("1")
    // @Comment("Flag that indicates if this dataset should be published")
    private boolean published;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_mobile", nullable = false)
    @ColumnDefault("0")
    // @Comment("Flag that indicates if the procedure is mobile (1/true) or stationary (0/false).")
    private boolean mobile;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_insitu", nullable = false)
    @ColumnDefault("1")
    // @Comment("Flag that indicates if the procedure is insitu (1/true) or remote (0/false).")
    private boolean insitu = true;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Column(name = "is_hidden", nullable = false)
    @ColumnDefault("0")
    // @Comment("Flag that indicates if this dataset should be hidden, e.g. for sub-datasets of a complex
    // datasets")
    private boolean hidden;

    @Column(name = "origin_timezone", length = 40)
    // @Comment("Define the origin timezone of the dataset timestamps. Possible values are offset (+02:00), id
    // (CET)
    // or full name (Europe/Berlin). It no time zone is defined, UTC would be used as default.")
    private String originTimezone;

    @Column(name = "decimals")
    // @Comment("Number of decimals that should be present in the output of the observation values. If no
    // value is
    // set, all decimals would be present.")
    private Integer numberOfDecimals;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "dataset_reference",
            joinColumns = @JoinColumn(name = "fk_dataset_id_from", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_dataset_reference_from")),
            inverseJoinColumns = @JoinColumn(name = "fk_dataset_id_to", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_dataset_reference_to")))
    @OrderColumn(name = "sort_order")
    private List<DatasetEntity> referenceValues;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_value_profile_id", foreignKey = @ForeignKey(name = "fk_value_profile"))
    private VerticalMetadataEntity verticalMetadata;

    @JdbcTypeCode(SqlTypes.SMALLINT)
    @Formula("1")
    private boolean ereportingProfile;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tag_dataset",
            joinColumns = @JoinColumn(name = "fk_dataset_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_dataset_tag")),
            inverseJoinColumns = @JoinColumn(name = "fk_tag_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_tag_dataset")))
    private Set<TagEntity> tags;

    @Transient
    private long observationCount = -1;

    @Transient
    private DateTimeZone timeZone;

    @Transient
    private Set<RelatedDatasetEntity> relatedDatasets;

    @Transient
    private SamplingProfileDatasetEntity samplingProfile;

    public DatasetEntity() {
        this(DatasetType.not_initialized, ObservationType.not_initialized, ValueType.not_initialized);
    }

    public DatasetEntity(String datasetType, String observationType, String valueType) {
        this(DatasetType.valueOf(datasetType), ObservationType.valueOf(observationType), ValueType.valueOf(valueType));
    }

    public DatasetEntity(DatasetType datasetType, ObservationType observationType, ValueType valueType) {
        this.datasetType = datasetType;
        this.observationType = observationType;
        this.valueType = valueType;
    }

    public Boolean isPublished() {
        return published;
    }

    public DatasetEntity setPublished(boolean published) {
        this.published = published;
        return this;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public DatasetEntity setDeleted(final boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    public boolean getDeleted() {
        return deleted;
    }

    public DatasetEntity setDisabled(final boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    public boolean getDisabled() {
        return disabled;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public DatasetType getDatasetType() {
        return datasetType;
    }

    public DatasetEntity setDatasetType(DatasetType datasetType) {
        this.datasetType = datasetType;
        return this;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    public DatasetEntity setObservationType(ObservationType observationType) {
        this.observationType = observationType;
        return this;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public DatasetEntity setValueType(ValueType valueType) {
        this.valueType = valueType;
        return this;
    }

    public List<DatasetEntity> getReferenceValues() {
        return referenceValues;
    }

    public DatasetEntity setReferenceValues(List<DatasetEntity> referenceValues) {
        this.referenceValues = referenceValues;
        return this;
    }

    public boolean hasReferenceValues() {
        return getReferenceValues() != null && !getReferenceValues().isEmpty();
    }

    public Integer getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public DatasetEntity setNumberOfDecimals(Integer numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
        return this;
    }

    public DatasetEntity setObservationCount(long count) {
        this.observationCount = count;
        return this;
    }

    public long getObservationCount() {
        return observationCount;
    }

    public boolean isHidden() {
        return hidden;
    }

    public DatasetEntity setHidden(final boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public boolean isMobile() {
        return mobile;
    }

    public DatasetEntity setMobile(boolean mobile) {
        this.mobile = mobile;
        return this;
    }

    public boolean isInsitu() {
        return insitu;
    }

    public DatasetEntity setInsitu(boolean insitu) {
        this.insitu = insitu;
        return this;
    }

    public String getOriginTimezone() {
        return originTimezone;
    }

    public DatasetEntity setOriginTimezone(String originTimezone) {
        this.originTimezone = originTimezone;
        return this;
    }

    public boolean isSetOriginTimezone() {
        return getOriginTimezone() != null && !getOriginTimezone().isEmpty();
    }

    public DateTimeZone getDateTimeZone() {
        if (timeZone == null) {
            if (originTimezone != null && !originTimezone.isEmpty()) {
                if (originTimezone.matches(OFFSET_REGEX)) {
                    this.timeZone =
                            DateTimeZone.forTimeZone(TimeZone.getTimeZone(ZoneOffset.of(originTimezone).normalized()));
                } else {
                    this.timeZone = DateTimeZone.forID(originTimezone.trim());
                }
            }
            this.timeZone = DateTimeZone.UTC;
        }
        return timeZone;
    }

    public Set<RelatedDatasetEntity> getRelatedDatasets() {
        return relatedDatasets;
    }

    public DatasetEntity setRelatedObservations(Set<RelatedDatasetEntity> relatedDataset) {
        this.relatedDatasets = relatedDataset;
        return this;
    }

    public boolean hasRelatedDatasets() {
        return getRelatedDatasets() != null && !getRelatedDatasets().isEmpty();
    }

    public VerticalMetadataEntity getVerticalMetadata() {
        return verticalMetadata;
    }

    public DatasetEntity setVerticalMetadata(VerticalMetadataEntity verticalMetadata) {
        this.verticalMetadata = verticalMetadata;
        return this;
    }

    public boolean hasVerticalMetadata() {
        return getVerticalMetadata() != null;
    }

    public SamplingProfileDatasetEntity getSamplingProfile() {
        return samplingProfile;
    }

    public DatasetEntity setSamplingProfile(SamplingProfileDatasetEntity samplingProfile) {
        this.samplingProfile = samplingProfile;
        return this;
    }

    public boolean hasSamplingProfile() {
        return getSamplingProfile() != null;
    }

    public boolean getEreportingProfile() {
        return ereportingProfile;
    }

    public DatasetEntity setEreportingProfile(boolean ereportingProfile) {
        this.ereportingProfile = ereportingProfile;
        return this;
    }

    public boolean hasEreportingProfile() {
        return getEreportingProfile();
    }

    @Override
    public void setTags(Set<TagEntity> tags) {
        this.tags = tags;
    }

    @Override
    public Set<TagEntity> getTags() {
        return tags;
    }

    public void copy(DatasetEntity dataset) {
        setIdentifier(dataset.getIdentifier());
        setIdentifierCodespace(dataset.getIdentifierCodespace());
        setStaIdentifier(dataset.getStaIdentifier());
        setName(dataset.getName());
        setNameCodespace(dataset.getNameCodespace());
        setDescription(dataset.getDescription());
        if (dataset.getParameters() != null) {
            setParameters(dataset.getParameters().stream().collect(Collectors.toSet()));
        }
        setCategory(dataset.getCategory());
        setDeleted(dataset.isDeleted());
        setDisabled(dataset.isDisabled());
        setFeature(dataset.getFeature());
        setFirstObservation(dataset.getFirstObservation());
        setFirstQuantityValue(dataset.getFirstQuantityValue());
        setFirstValueAt(dataset.getFirstValueAt());
        setHidden(dataset.isHidden());
        setLastObservation(dataset.getLastObservation());
        setLastQuantityValue(dataset.getLastQuantityValue());
        setLastValueAt(dataset.getLastValueAt());
        setObservationCount(dataset.getObservationCount());
        setOMObservationType(dataset.getOMObservationType());
        setOffering(dataset.getOffering());
        setPhenomenon(dataset.getPhenomenon());
        setPlatform(dataset.getPlatform());
        setProcedure(dataset.getProcedure());
        setPublished(dataset.isPublished());
        setProcessed(dataset.isProcessed());
        setSamplingTimeStart(dataset.getSamplingTimeStart());
        setSamplingTimeEnd(dataset.getSamplingTimeEnd());
        setGeometryEntity(dataset.getGeometryEntity());
        setInsitu(dataset.isInsitu());
        setMobile(dataset.isMobile());
        setEreportingProfile(dataset.getEreportingProfile());
        if (dataset.getRelatedDatasets() != null) {
            setRelatedObservations(dataset.getRelatedDatasets().stream().collect(Collectors.toSet()));
        }
        if (dataset.getResultTimes() != null) {
            setResultTimes(dataset.getResultTimes().stream().collect(Collectors.toSet()));
        }
        if (dataset.hasSamplingProfile()) {
            setSamplingProfile(new SamplingProfileDatasetEntity().copy(dataset.getSamplingProfile()));
        }
        if (dataset.hasVerticalMetadata()) {
            setVerticalMetadata(dataset.getVerticalMetadata());
        }
        setUnit(dataset.getUnit());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" id: ").append(getId())
                .append(" , category: ").append(getCategory()).append(" , phenomenon: ").append(getPhenomenon())
                .append(" , procedure: ").append(getProcedure()).append(" , offering: ").append(getOffering())
                .append(" , feature: ").append(getFeature()).append(" , service: ").append(getService()).append(" ]")
                .toString();
    }

}
