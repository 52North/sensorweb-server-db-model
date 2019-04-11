/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
 * Software GmbH
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

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.n52.series.db.beans.dataset.DatasetType;
import org.n52.series.db.beans.dataset.ObservationType;
import org.n52.series.db.beans.dataset.ValueType;
import org.n52.series.db.beans.ereporting.EReportingProfileDatasetEntity;
import org.n52.series.db.beans.sampling.SamplingProfileDatasetEntity;
import org.n52.series.db.common.Utils;

public class DatasetEntity extends DescribableEntity implements Serializable {

    public static final String ENTITY_ALIAS = "dataset";

    public static final String PROPERTY_OFFERING = "offering";
    public static final String PROPERTY_PROCEDURE = "procedure";
    public static final String PROPERTY_PLATFORM = "platform";
    public static final String PROPERTY_PHENOMENON = "phenomenon";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_FEATURE = "feature";
    public static final String PROPERTY_DATASET_TYPE = "datasetType";
    public static final String PROPERTY_OBSERVATION_TYPE = "observationType";
    public static final String PROPERTY_VALUE_TYPE = "valueType";
    public static final String PROPERTY_FIRST_VALUE_AT = "firstValueAt";
    public static final String PROPERTY_LAST_VALUE_AT = "lastValueAt";
    public static final String PROPERTY_PUBLISHED = "published";
    public static final String PROPERTY_DELETED = "deleted";
    public static final String HIDDEN_CHILD = "hidden";

    public static final String PROPERTY_MOBILE = "mobile";
    public static final String PROPERTY_INSITU = "insitu";

    public static final String PROPERTY_UNIT = "unit";

    public static final String PROPERTY_SAMPLING_PROFILE = "samplingProfile";
    public static final String PROPERTY_EREPORTING_PROFILE = "ereportingProfile";

    private static final long serialVersionUID = -7491530543976690237L;

    private PhenomenonEntity phenomenon;

    private ProcedureEntity procedure;

    private OfferingEntity offering;

    private AbstractFeatureEntity<?> feature;

    private CategoryEntity category;

    private PlatformEntity platform;

    private boolean published = true;

    private boolean deleted;

    private boolean disabled;

    private DatasetType datasetType;

    private ObservationType observationType;

    private ValueType valueType;

    private Set<Date> resultTimes;

    private Date firstValueAt;

    private Date lastValueAt;

    private DataEntity<?> firstObservation;

    private DataEntity<?> lastObservation;

    private BigDecimal firstQuantityValue;

    private BigDecimal lastQuantityValue;

    private UnitEntity unit;

    private long observationCount = -1;

    private boolean hidden;

    private FormatEntity omObservationType;

    private boolean mobile;

    private boolean insitu = true;

    private String originTimezone;

    private Set<RelatedDatasetEntity> relatedDatasets;

    private List<DatasetEntity> referenceValues;

    private Integer numberOfDecimals;

    private VerticalMetadataEntity verticalMetadata;

    private SamplingProfileDatasetEntity samplingProfile;

    private EReportingProfileDatasetEntity ereportingProfile;

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

    public CategoryEntity getCategory() {
        return category;
    }

    public DatasetEntity setCategory(CategoryEntity category) {
        this.category = category;
        return this;
    }

    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    public DatasetEntity setPhenomenon(final PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
        return this;
    }

    public PhenomenonEntity getObservableProperty() {
        return getPhenomenon();
    }

    public DatasetEntity setObservableProperty(final PhenomenonEntity observableProperty) {
        return setPhenomenon(observableProperty);
    }

    public ProcedureEntity getProcedure() {
        return procedure;
    }

    public DatasetEntity setProcedure(final ProcedureEntity procedure) {
        this.procedure = procedure;
        return this;
    }

    public OfferingEntity getOffering() {
        return offering;
    }

    public DatasetEntity setOffering(final OfferingEntity offering) {
        this.offering = offering;
        return this;
    }

    public boolean isSetOffering() {
        return getOffering() != null;
    }

    public AbstractFeatureEntity<?> getFeature() {
        return feature;
    }

    public DatasetEntity setFeature(AbstractFeatureEntity<?> feature) {
        this.feature = feature;
        return this;
    }

    public boolean isSetFeature() {
        return getFeature() != null;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public DatasetEntity setPlatform(PlatformEntity platform) {
        this.platform = platform;
        return this;
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

    public boolean isSetOmObservationType() {
        return (getOmObservationType() != null) && getOmObservationType().isSetFormat();
    }

    public Date getFirstValueAt() {
        return Utils.createUnmutableTimestamp(firstValueAt);
    }

    public DatasetEntity setFirstValueAt(Date firstValueAt) {
        this.firstValueAt = Utils.createUnmutableTimestamp(firstValueAt);
        return this;
    }

    public boolean isSetFirstValueAt() {
        return getFirstValueAt() != null;
    }

    public Date getLastValueAt() {
        return Utils.createUnmutableTimestamp(lastValueAt);
    }

    public DatasetEntity setLastValueAt(Date lastValueAt) {
        this.lastValueAt = Utils.createUnmutableTimestamp(lastValueAt);
        return this;
    }

    public boolean isSetLastValueAt() {
        return getLastValueAt() != null;
    }

    public DataEntity<?> getFirstObservation() {
        return firstObservation;
    }

    public DatasetEntity setFirstObservation(DataEntity<?> firstObservation) {
        this.firstObservation = firstObservation;
        return this;
    }

    public DataEntity<?> getLastObservation() {
        return lastObservation;
    }

    public DatasetEntity setLastObservation(DataEntity<?> lastObservation) {
        this.lastObservation = lastObservation;
        return this;
    }

    public BigDecimal getFirstQuantityValue() {
        return firstQuantityValue;
    }

    public DatasetEntity setFirstQuantityValue(BigDecimal firstValue) {
        this.firstQuantityValue = firstValue;
        return this;
    }

    public BigDecimal getLastQuantityValue() {
        return lastQuantityValue;
    }

    public DatasetEntity setLastQuantityValue(BigDecimal lastValue) {
        this.lastQuantityValue = lastValue;
        return this;
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

    /**
     * @return a list of result times
     * @since 2.0.0
     */

    public Set<Date> getResultTimes() {
        final Set<Date> unmodifiableResultTimes = wrapToUnmutables(resultTimes);
        return unmodifiableResultTimes != null ? Collections.unmodifiableSet(unmodifiableResultTimes) : null;
    }

    /**
     * @param resultTimes
     *            a list of result times
     * @since 2.0.0
     */

    public DatasetEntity setResultTimes(Set<Date> resultTimes) {
        this.resultTimes = wrapToUnmutables(resultTimes);
        return this;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public DatasetEntity setUnit(UnitEntity unit) {
        this.unit = unit;
        return this;
    }

    public boolean hasUnit() {
        return unit != null;
    }

    public String getUnitI18nName(final String locale) {
        return unit != null
                // ? unit.getNameI18n(locale)
                ? unit.getUnit()
                : "";
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

    public FormatEntity getOmObservationType() {
        return omObservationType;
    }

    public DatasetEntity setOmObservationType(FormatEntity omObservationType) {
        this.omObservationType = omObservationType;
        return this;
    }

    public boolean isSetOmObservationtype() {
        return (getOmObservationType() != null) && getOmObservationType().isSetFormat();
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

    public EReportingProfileDatasetEntity getEreportingProfile() {
        return ereportingProfile;
    }

    public DatasetEntity setEreportingProfile(EReportingProfileDatasetEntity ereportingProfile) {
        this.ereportingProfile = ereportingProfile;
        return this;
    }

    public boolean hasEreportingProfile() {
        return getEreportingProfile() != null;
    }

    @Override
    public String getLabelFrom(final String locale) {
        final StringBuilder sb = new StringBuilder();
        sb.append(phenomenon.getLabelFrom(locale)).append(" ");
        sb.append(procedure.getLabelFrom(locale)).append(", ");
        sb.append(feature.getLabelFrom(locale)).append(", ");
        return sb.append(offering.getLabelFrom(locale)).toString();
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

    public void copy(DatasetEntity dataset) {
        setIdentifier(dataset.getIdentifier());
        setIdentifierCodespace(dataset.getIdentifierCodespace());
        setName(dataset.getName());
        setNameCodespace(dataset.getNameCodespace());
        setDescription(dataset.getDescription());
        if (dataset.getParameters() != null) {
            setParameters(dataset.getParameters().stream().collect(Collectors.toSet()));
        }
        setCategory(dataset.getCategory());
        setDeleted(dataset.isDeleted());
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
        setOmObservationType(dataset.getOmObservationType());
        setOffering(dataset.getOffering());
        setPhenomenon(dataset.getPhenomenon());
        setPlatform(dataset.getPlatform());
        setProcedure(dataset.getProcedure());
        setPublished(dataset.isPublished());
        if (dataset.getRelatedDatasets() != null) {
            setRelatedObservations(dataset.getRelatedDatasets().stream().collect(Collectors.toSet()));
        }
        if (dataset.getResultTimes() != null) {
            setResultTimes(dataset.getResultTimes().stream().collect(Collectors.toSet()));
        }
        if (dataset.hasSamplingProfile()) {
            setSamplingProfile(new SamplingProfileDatasetEntity().copy(dataset.getSamplingProfile()));
        }
        if (dataset.hasEreportingProfile()) {
            setEreportingProfile(new EReportingProfileDatasetEntity().copy(dataset.getEreportingProfile()));
        }
        setUnit(dataset.getUnit());
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetEntity)) {
            return false;
        }
        return super.equals(obj);
    }

    private Set<Date> wrapToUnmutables(Set<Date> dates) {
        return dates != null
                ? dates.stream().map(d -> d != null ? new Timestamp(d.getTime()) : null).collect(Collectors.toSet())
                : null;
    }

}
