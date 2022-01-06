/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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

import org.n52.series.db.beans.HibernateRelations.HasTags;
import org.joda.time.DateTimeZone;
import org.n52.series.db.beans.dataset.DatasetType;
import org.n52.series.db.beans.dataset.ObservationType;
import org.n52.series.db.beans.dataset.ValueType;
import org.n52.series.db.beans.sampling.SamplingProfileDatasetEntity;

import java.time.ZoneOffset;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

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
    private static final long serialVersionUID = -7491530543976690237L;

    private boolean published = true;

    private boolean deleted;

    private boolean disabled;

    private DatasetType datasetType;

    private ObservationType observationType;

    private ValueType valueType;

    private long observationCount = -1;

    private boolean hidden;

    private boolean mobile;

    private boolean insitu = true;

    private String originTimezone;

    private DateTimeZone timeZone;

    private Set<RelatedDatasetEntity> relatedDatasets;

    private List<DatasetEntity> referenceValues;

    private Integer numberOfDecimals;

    private VerticalMetadataEntity verticalMetadata;

    private SamplingProfileDatasetEntity samplingProfile;

    private boolean ereportingProfile;

    private Set<TagEntity> tags;

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
        return (getRelatedDatasets() != null) && !getRelatedDatasets().isEmpty();
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
