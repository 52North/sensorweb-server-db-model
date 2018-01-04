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
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

import org.n52.series.db.beans.HibernateRelations.HasDeletedFlag;
import org.n52.series.db.beans.HibernateRelations.HasDisabledFlag;
import org.n52.series.db.beans.HibernateRelations.HasHiddenChildFlag;
import org.n52.series.db.beans.HibernateRelations.HasObservableProperty;
import org.n52.series.db.beans.HibernateRelations.HasObservationType;
import org.n52.series.db.beans.HibernateRelations.HasOffering;
import org.n52.series.db.beans.HibernateRelations.HasProcedure;
import org.n52.series.db.common.Utils;

public class DatasetEntity extends DescribableEntity
        implements Serializable,
        HasProcedure<DatasetEntity>,
        HasObservableProperty<DatasetEntity>,
        HasOffering<DatasetEntity>,
        HasObservationType<DatasetEntity>,
        HasHiddenChildFlag<DatasetEntity>,
        HasDeletedFlag<DatasetEntity>,
        HasDisabledFlag<DatasetEntity> {

    public static final String DEFAULT_VALUE_TYPE = "quantity";

    public static final String ENTITY_ALIAS = "dataset";

    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_FEATURE = "feature";
    public static final String PROPERTY_VALUE_TYPE = "valueType";
    public static final String PROPERTY_FIRST_VALUE_AT = "firstValueAt";
    public static final String PROPERTY_LAST_VALUE_AT = "lastValueAt";
    public static final String PROPERTY_PUBLISHED = "published";
    public static final String PROPERTY_DELETED = "deleted";
    public static final String HIDDEN_CHILD = "hiddenChild";

    private static final long serialVersionUID = -7491530543976690237L;

    private PhenomenonEntity phenomenon;

    private ProcedureEntity procedure;

    private OfferingEntity offering;

    private AbstractFeatureEntity feature;

    private CategoryEntity category;

    private PlatformEntity platform;

    private boolean published = true;

    private boolean deleted = false;

    private boolean disabled = false;

    private String valueType;

    private Set<Date> resultTimes;

    private Date firstValueAt;

    private Date lastValueAt;

    private DataEntity firstObservation;

    private DataEntity lastObservation;

    private double firstValue;

    private double lastValue;

    private UnitEntity unit;

    private long observationCount = -1;

    private boolean hiddenChild = false;

    private ObservationTypeEntity observationType;

    private int decimals;

    public DatasetEntity() {
        this((String) null);
    }

    public DatasetEntity(String type) {
        this.valueType = type;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    public DatasetEntity setPhenomenon(PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
        return this;
    }

    @Override
    public PhenomenonEntity getObservableProperty() {
        return getPhenomenon();
    }

    @Override
    public DatasetEntity setObservableProperty(PhenomenonEntity observableProperty) {
        return setPhenomenon(phenomenon);
    }

    @Override
    public ProcedureEntity getProcedure() {
        return procedure;
    }

    @Override
    public DatasetEntity setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
        return this;
    }

    @Override
    public OfferingEntity getOffering() {
        return offering;
    }

    @Override
    public DatasetEntity setOffering(OfferingEntity offering) {
        this.offering = offering;
        return this;
    }

    @Override
    public boolean isSetOffering() {
        return getOffering() != null;
    }

    public AbstractFeatureEntity getFeature() {
        return feature;
    }

    public void setFeature(AbstractFeatureEntity feature) {
        this.feature = feature;
    }

    public boolean isSetFeature() {
        return getFeature() != null;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public Boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public DatasetEntity setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    @Override
    public boolean getDeleted() {
        return deleted;
    }

    @Override
    public DatasetEntity setDisabled(boolean disabled) {
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
        return getObservationType() != null && getObservationType().isSetType();
    }

    public Date getFirstValueAt() {
        return Utils.createUnmutableTimestamp(firstValueAt);
    }

    public void setFirstValueAt(Date firstValueAt) {
        this.firstValueAt = Utils.createUnmutableTimestamp(firstValueAt);
    }

    public boolean isSetFirstValueAt() {
        return getFirstValueAt() != null;
    }

    public Date getLastValueAt() {
        return Utils.createUnmutableTimestamp(lastValueAt);
    }

    public void setLastValueAt(Date lastValueAt) {
        this.lastValueAt = Utils.createUnmutableTimestamp(lastValueAt);
    }

    public boolean isSetLastValueAt() {
        return getLastValueAt() != null;
    }

    public DataEntity getFirstObservation() {
        return firstObservation;
    }

    public void setFirstObservation(DataEntity firstObservation) {
        this.firstObservation = firstObservation;
    }

    public DataEntity getLastObservation() {
        return lastObservation;
    }

    public void setLastObservation(DataEntity lastObservation) {
        this.lastObservation = lastObservation;
    }

    public double getFirstValue() {
        return firstValue;
    }

    public void setFirstValue(double firstValue) {
        this.firstValue = firstValue;
    }

    public double getLastValue() {
        return lastValue;
    }

    public void setLastValue(double lastValue) {
        this.lastValue = lastValue;
    }

    public String getValueType() {
        return valueType == null || valueType.isEmpty()
                // backward compatible
                ? DEFAULT_VALUE_TYPE
                : valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }

    /**
     * @return a list of result times
     * @since 2.0.0
     */
    public Set<Date> getResultTimes() {
        Set<Date> unmodifiableResultTimes = wrapToUnmutables(resultTimes);
        return unmodifiableResultTimes != null
                ? Collections.unmodifiableSet(unmodifiableResultTimes)
                : null;
    }

    /**
     * @param resultTimes
     *        a list of result times
     * @since 2.0.0
     */
    public void setResultTimes(Set<Date> resultTimes) {
        this.resultTimes = wrapToUnmutables(resultTimes);
    }

    private Set<Date> wrapToUnmutables(Set<Date> dates) {
        return dates != null
                ? dates.stream()
                       .map(d -> d != null
                               ? new Timestamp(d.getTime())
                               : null)
                       .collect(Collectors.toSet())
                : null;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }

    public boolean hasUnit() {
        return unit != null;
    }

    public String getUnitI18nName(String locale) {
        return unit != null
                //                ? unit.getNameI18n(locale)
                ? unit.getUnit()
                : "";
    }

    public void setObservationCount(long count) {
        this.observationCount = count;
    }

    public long getObservationCount() {
        return observationCount;
    }

    public boolean isHiddenChild() {
        return hiddenChild;
    }

    public DatasetEntity setHiddenChild(boolean hiddenChild) {
        this.hiddenChild = hiddenChild;
        return this;
    }

    public ObservationTypeEntity getObservationType() {
        return observationType;

    }

    public DatasetEntity setObservationType(ObservationTypeEntity observationType) {
        this.observationType = observationType;
        return this;
    }

    public boolean isSetObservationtype() {
        return getObservationType() != null && getObservationType().isSetType();
    }

    public int getDecimals() {
        return decimals;
    }

    public void setDecimals(int decimals) {
        this.decimals = decimals;
    }

    @Override
    public String getLabelFrom(String locale) {
        StringBuilder sb = new StringBuilder();
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
        StringBuilder sb = new StringBuilder();
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

}
