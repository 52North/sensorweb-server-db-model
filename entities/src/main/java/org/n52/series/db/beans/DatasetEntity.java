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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
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

    private final Set<RelatedDatasetEntity> relatedDatasets = new LinkedHashSet<>();

    private List<DatasetEntity> referenceValues = new ArrayList<>();

    private Integer numberOfDecimals;

    private VerticalMetadataEntity verticalMetadata;

    private SamplingProfileDatasetEntity samplingProfile;

    private EReportingProfileDatasetEntity ereportingProfile;

    public DatasetEntity() {
        this(ValueType.not_initialized);
    }

    public DatasetEntity(final String type) {
        this(ValueType.valueOf(type));
    }

    public DatasetEntity(ValueType type) {
        this.valueType = type;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(final CategoryEntity category) {
        this.category = category;
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

    public void setFeature(AbstractFeatureEntity<?> feature) {
        this.feature = feature;
    }

    public boolean isSetFeature() {
        return getFeature() != null;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(final PlatformEntity platform) {
        this.platform = platform;
    }

    public Boolean isPublished() {
        return published;
    }

    public void setPublished(final boolean published) {
        this.published = published;
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

    public void setFirstValueAt(final Date firstValueAt) {
        this.firstValueAt = Utils.createUnmutableTimestamp(firstValueAt);
    }

    public boolean isSetFirstValueAt() {
        return getFirstValueAt() != null;
    }

    public Date getLastValueAt() {
        return Utils.createUnmutableTimestamp(lastValueAt);
    }

    public void setLastValueAt(final Date lastValueAt) {
        this.lastValueAt = Utils.createUnmutableTimestamp(lastValueAt);
    }

    public boolean isSetLastValueAt() {
        return getLastValueAt() != null;
    }

    public DataEntity<?> getFirstObservation() {
        return firstObservation;
    }

    public void setFirstObservation(DataEntity<?> firstObservation) {
        this.firstObservation = firstObservation;
    }

    public DataEntity<?> getLastObservation() {
        return lastObservation;
    }

    public void setLastObservation(DataEntity<?> lastObservation) {
        this.lastObservation = lastObservation;
    }

    public BigDecimal getFirstQuantityValue() {
        return firstQuantityValue;
    }

    public void setFirstQuantityValue(final BigDecimal firstValue) {
        this.firstQuantityValue = firstValue;
    }

    public BigDecimal getLastQuantityValue() {
        return lastQuantityValue;
    }

    public void setLastQuantityValue(final BigDecimal lastValue) {
        this.lastQuantityValue = lastValue;
    }

    public DatasetType getDatasetType() {
        return datasetType;
    }

    public void setDatasetType(DatasetType datasetType) {
        this.datasetType = datasetType;
    }

    public ObservationType getObservationType() {
        return observationType;
    }

    public void setObservationType(ObservationType observationType) {
        this.observationType = observationType;
    }

    public ValueType getValueType() {
        return valueType;
    }

    public void setValueType(ValueType valueType) {
        this.valueType = valueType;
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

    public void setResultTimes(Set<Date> resultTimes) {
        this.resultTimes = wrapToUnmutables(resultTimes);
    }

    private Set<Date> wrapToUnmutables(final Set<Date> dates) {
        return dates != null
                ? dates.stream().map(d -> d != null ? new Timestamp(d.getTime()) : null).collect(Collectors.toSet())
                : null;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(final UnitEntity unit) {
        this.unit = unit;
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

    public DatasetEntity setReferenceValues(Collection<DatasetEntity> referenceValues) {
        this.referenceValues.clear();
        if (referenceValues != null) {
            this.referenceValues.addAll(referenceValues);
        }
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

    public void setObservationCount(long count) {
        this.observationCount = count;
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

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isInsitu() {
        return insitu;
    }

    public void setInsitu(boolean insitu) {
        this.insitu = insitu;
    }

    public String getOriginTimezone() {
        return originTimezone;
    }

    public void setOriginTimezone(String originTimezone) {
        this.originTimezone = originTimezone;
    }

    public boolean isSetOriginTimezone() {
        return getOriginTimezone() != null && !getOriginTimezone().isEmpty();
    }

    public Set<RelatedDatasetEntity> getRelatedDatasets() {
        return relatedDatasets;
    }

    public void setRelatedObservations(final Set<RelatedDatasetEntity> relatedDataset) {
        this.relatedDatasets.clear();
        if (relatedDataset != null) {
            this.relatedDatasets.addAll(relatedDataset);
        }
    }

    public boolean hasRelatedDatasets() {
        return (getRelatedDatasets() != null) && !getRelatedDatasets().isEmpty();
    }

    public VerticalMetadataEntity getVerticalMetadata() {
        return verticalMetadata;
    }

    public void setVerticalMetadata(VerticalMetadataEntity verticalMetadata) {
        this.verticalMetadata = verticalMetadata;
    }

    public boolean hasVerticalMetadata() {
        return getVerticalMetadata() != null;
    }

    public SamplingProfileDatasetEntity getSamplingProfile() {
        return samplingProfile;
    }

    public void setSamplingProfile(SamplingProfileDatasetEntity samplingProfile) {
        this.samplingProfile = samplingProfile;
    }

    public boolean hasSamplingProfile() {
        return getSamplingProfile() != null;
    }

    public EReportingProfileDatasetEntity getEreportingProfile() {
        return ereportingProfile;
    }

    public void setEreportingProfile(EReportingProfileDatasetEntity ereportingProfile) {
        this.ereportingProfile = ereportingProfile;
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

}
