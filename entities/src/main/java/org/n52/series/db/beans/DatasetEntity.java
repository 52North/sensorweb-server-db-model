/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.n52.series.db.beans.data.Data;
import org.n52.series.db.beans.dataset.Dataset;
import org.n52.series.db.common.Utils;

public class DatasetEntity extends DescribableEntity implements Serializable, Dataset {

    public static final String ENTITY_ALIAS = "dataset";

    public static final String PROPERTY_OFFERING = "offering";
    public static final String PROPERTY_PROCEDURE = "procedure";
    public static final String PROPERTY_PHENOMENON = "phenomenon";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_FEATURE = "feature";
    public static final String PROPERTY_VALUE_TYPE = "valueType";
    public static final String PROPERTY_FIRST_VALUE_AT = "firstValueAt";
    public static final String PROPERTY_LAST_VALUE_AT = "lastValueAt";
    public static final String PROPERTY_PUBLISHED = "published";
    public static final String PROPERTY_DELETED = "deleted";
    public static final String HIDDEN_CHILD = "hidden";

    public static final String PROPERTY_UNIT = "unit";

    private static final long serialVersionUID = -7491530543976690237L;

    private PhenomenonEntity phenomenon;

    private ProcedureEntity procedure;

    private OfferingEntity offering;

    private AbstractFeatureEntity feature;

    private CategoryEntity category;

    private PlatformEntity platform;

    private boolean published = true;

    private boolean deleted;

    private boolean disabled;

    private String valueType;

    private Set<Date> resultTimes;

    private Date firstValueAt;

    private Date lastValueAt;

    private Data firstObservation;

    private Data lastObservation;

    private BigDecimal firstQuantityValue;

    private BigDecimal lastQuantityValue;

    private UnitEntity unit;

    private long observationCount = -1;

    private boolean hidden;

    private FormatEntity observationType;

    private final Set<RelatedDatasetEntity> relatedDatasets = new LinkedHashSet<>();

    public DatasetEntity() {
        this((String) null);
    }

    public DatasetEntity(final String type) {
        this.valueType = type;
    }

    @Override
    public CategoryEntity getCategory() {
        return category;
    }

    @Override
    public void setCategory(final CategoryEntity category) {
        this.category = category;
    }

    @Override
    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    @Override
    public DatasetEntity setPhenomenon(final PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
        return this;
    }

    @Override
    public PhenomenonEntity getObservableProperty() {
        return getPhenomenon();
    }

    @Override
    public DatasetEntity setObservableProperty(final PhenomenonEntity observableProperty) {
        return setPhenomenon(observableProperty);
    }

    @Override
    public ProcedureEntity getProcedure() {
        return procedure;
    }

    @Override
    public DatasetEntity setProcedure(final ProcedureEntity procedure) {
        this.procedure = procedure;
        return this;
    }

    @Override
    public OfferingEntity getOffering() {
        return offering;
    }

    @Override
    public DatasetEntity setOffering(final OfferingEntity offering) {
        this.offering = offering;
        return this;
    }

    @Override
    public boolean isSetOffering() {
        return getOffering() != null;
    }

    @Override
    public AbstractFeatureEntity getFeature() {
        return feature;
    }

    @Override
    public void setFeature(final AbstractFeatureEntity feature) {
        this.feature = feature;
    }

    @Override
    public boolean isSetFeature() {
        return getFeature() != null;
    }

    @Override
    public PlatformEntity getPlatform() {
        return platform;
    }

    @Override
    public void setPlatform(final PlatformEntity platform) {
        this.platform = platform;
    }

    @Override
    public Boolean isPublished() {
        return published;
    }

    @Override
    public void setPublished(final boolean published) {
        this.published = published;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public DatasetEntity setDeleted(final boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    @Override
    public boolean getDeleted() {
        return deleted;
    }

    @Override
    public DatasetEntity setDisabled(final boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    @Override
    public boolean getDisabled() {
        return disabled;
    }

    @Override
    public boolean isDisabled() {
        return disabled;
    }

    @Override
    public boolean isSetObservationType() {
        return (getObservationType() != null) && getObservationType().isSetFormat();
    }

    @Override
    public Date getFirstValueAt() {
        return Utils.createUnmutableTimestamp(firstValueAt);
    }

    @Override
    public void setFirstValueAt(final Date firstValueAt) {
        this.firstValueAt = Utils.createUnmutableTimestamp(firstValueAt);
    }

    @Override
    public boolean isSetFirstValueAt() {
        return getFirstValueAt() != null;
    }

    @Override
    public Date getLastValueAt() {
        return Utils.createUnmutableTimestamp(lastValueAt);
    }

    @Override
    public void setLastValueAt(final Date lastValueAt) {
        this.lastValueAt = Utils.createUnmutableTimestamp(lastValueAt);
    }

    @Override
    public boolean isSetLastValueAt() {
        return getLastValueAt() != null;
    }

    @Override
    public Data getFirstObservation() {
        return firstObservation;
    }

    @Override
    public void setFirstObservation(final Data firstObservation) {
        this.firstObservation = firstObservation;
    }

    @Override
    public Data getLastObservation() {
        return lastObservation;
    }

    @Override
    public void setLastObservation(final Data lastObservation) {
        this.lastObservation = lastObservation;
    }

    @Override
    public BigDecimal getFirstQuantityValue() {
        return firstQuantityValue;
    }

    @Override
    public void setFirstQuantityValue(final BigDecimal firstValue) {
        this.firstQuantityValue = firstValue;
    }

    @Override
    public BigDecimal getLastQuantityValue() {
        return lastQuantityValue;
    }

    @Override
    public void setLastQuantityValue(final BigDecimal lastValue) {
        this.lastQuantityValue = lastValue;
    }

    @Override
    public String getValueType() {
        return (valueType == null) || valueType.isEmpty()
            // backward compatible
            ? getDefaultValueType()
            : valueType;
    }

    @Override
    public void setValueType(final String valueType) {
        this.valueType = valueType;
    }

    /**
     * @return a list of result times
     * @since 2.0.0
     */
    @Override
    public Set<Date> getResultTimes() {
        final Set<Date> unmodifiableResultTimes = wrapToUnmutables(resultTimes);
        return unmodifiableResultTimes != null
            ? Collections.unmodifiableSet(unmodifiableResultTimes)
            : null;
    }

    /**
     * @param resultTimes
     *        a list of result times
     * @since 2.0.0
     */
    @Override
    public void setResultTimes(final Set<Date> resultTimes) {
        this.resultTimes = wrapToUnmutables(resultTimes);
    }

    private Set<Date> wrapToUnmutables(final Set<Date> dates) {
        return dates != null
            ? dates.stream()
                   .map(Utils::createUnmutableTimestamp)
                   .collect(Collectors.toSet())
            : null;
    }

    @Override
    public UnitEntity getUnit() {
        return unit;
    }

    @Override
    public void setUnit(final UnitEntity unit) {
        this.unit = unit;
    }

    @Override
    public boolean hasUnit() {
        return unit != null;
    }

    public String getUnitI18nName(final String locale) {
        return unit != null
            // ? unit.getNameI18n(locale)
            ? unit.getUnit()
            : "";
    }

    @Override
    public void setObservationCount(final long count) {
        this.observationCount = count;
    }

    @Override
    public long getObservationCount() {
        return observationCount;
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public DatasetEntity setHidden(final boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    @Override
    public FormatEntity getObservationType() {
        return observationType;

    }

    @Override
    public DatasetEntity setObservationType(final FormatEntity observationType) {
        this.observationType = observationType;
        return this;
    }

    @Override
    public boolean isSetObservationtype() {
        return (getObservationType() != null) && getObservationType().isSetFormat();
    }

    @Override
    public Set<RelatedDatasetEntity> getRelatedDatasets() {
        return relatedDatasets;
    }

    @Override
    public void setRelatedObservations(final Set<RelatedDatasetEntity> relatedDataset) {
        this.relatedDatasets.clear();
        if (relatedDataset != null) {
            this.relatedDatasets.addAll(relatedDataset);
        }
    }

    @Override
    public boolean hasRelatedDatasets() {
        return (getRelatedDatasets() != null) && !getRelatedDatasets().isEmpty();
    }

    @Override
    public String getLabelFrom(final String locale) {
        final StringBuilder sb = new StringBuilder();
        sb.append(phenomenon.getLabelFrom(locale))
          .append(" ");
        sb.append(procedure.getLabelFrom(locale))
          .append(", ");
        sb.append(feature.getLabelFrom(locale))
          .append(", ");
        return sb.append(offering.getLabelFrom(locale))
                 .toString();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" id: ")
                 .append(getId())
                 .append(" , category: ")
                 .append(getCategory())
                 .append(" , phenomenon: ")
                 .append(getPhenomenon())
                 .append(" , procedure: ")
                 .append(getProcedure())
                 .append(" , offering: ")
                 .append(getOffering())
                 .append(" , feature: ")
                 .append(getFeature())
                 .append(" , service: ")
                 .append(getService())
                 .append(" ]")
                 .toString();
    }

    @Override
    public void copy(final Dataset dataset) {
        setIdentifier(dataset.getIdentifier());
        setIdentifierCodespace(dataset.getIdentifierCodespace());
        setName(dataset.getName());
        setNameCodespace(dataset.getNameCodespace());
        setDescription(dataset.getDescription());
        if (dataset.getParameters() != null) {
            setParameters(dataset.getParameters()
                                 .stream()
                                 .collect(Collectors.toSet()));
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
        setObservationType(dataset.getObservationType());
        setOffering(dataset.getOffering());
        setPhenomenon(dataset.getPhenomenon());
        setPlatform(dataset.getPlatform());
        setProcedure(dataset.getProcedure());
        setPublished(dataset.isPublished());
        if (dataset.getRelatedDatasets() != null) {
            setRelatedObservations(dataset.getRelatedDatasets()
                                          .stream()
                                          .collect(Collectors.toSet()));
        }
        if (dataset.getResultTimes() != null) {
            setResultTimes(dataset.getResultTimes()
                                  .stream()
                                  .collect(Collectors.toSet()));
        }
        setUnit(dataset.getUnit());
    }

}
