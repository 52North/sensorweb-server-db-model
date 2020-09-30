/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.sta.AbstractDatastreamEntity;
import org.n52.series.db.beans.sta.AbstractObservationEntity;
import org.n52.series.db.common.Utils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public class AbstractDatasetEntity extends DescribableEntity
        implements Serializable, HibernateRelations.IsStaEntity, AbstractDatastreamEntity {

    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_OFFERING = "offering";
    public static final String PROPERTY_PROCEDURE = "procedure";
    public static final String PROPERTY_PLATFORM = "platform";
    public static final String PROPERTY_PHENOMENON = "phenomenon";
    public static final String PROPERTY_FEATURE = "feature";
    public static final String PROPERTY_OM_OBSERVATION_TYPE = "omObservationType";
    public static final String PROPERTY_FIRST_VALUE_AT = "firstValueAt";
    public static final String PROPERTY_LAST_VALUE_AT = "lastValueAt";
    public static final String PROPERTY_FIRST_OBSERVATION = "firstObservation";
    public static final String PROPERTY_LAST_OBSERVATION = "lastObservation";
    public static final String PROPERTY_RESULT_TIME_START = "resultTimeStart";
    public static final String PROPERTY_RESULT_TIME_END = "resultTimeEnd";
    public static final String PROPERTY_UNIT = "unit";
    public static final String PROPERTY_AGGREGATION = "aggregation";
    private static final long serialVersionUID = 4178505006632345142L;

    private AbstractFeatureEntity<?> feature;
    private PhenomenonEntity phenomenon;
    private ProcedureEntity procedure;
    private CategoryEntity category;
    private UnitEntity unit;
    private OfferingEntity offering;
    private PlatformEntity platform;
    private GeometryEntity observedArea;
    private Set<Date> resultTimes;
    private Date firstValueAt;
    private Date lastValueAt;
    private DataEntity<?> firstObservation;
    private DataEntity<?> lastObservation;
    private BigDecimal firstQuantityValue;
    private BigDecimal lastQuantityValue;
    private Date resultTimeStart;
    private Date resultTimeEnd;

    private FormatEntity omObservationType;

    private Set<DataEntity<?>> observations;
    private AbstractDatasetEntity aggregation;
    private boolean processed;

    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(final PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
    }

    @Override
    public PhenomenonEntity getObservableProperty() {
        return getPhenomenon();
    }

    @Override
    public void setObservableProperty(final PhenomenonEntity observableProperty) {
        setPhenomenon(observableProperty);
    }

    @Override
    public ProcedureEntity getProcedure() {
        return procedure;
    }

    @Override
    public void setProcedure(final ProcedureEntity procedure) {
        this.procedure = procedure;
    }

    @Override
    public AbstractFeatureEntity<?> getFeature() {
        return feature;
    }

    @Override
    public void setFeature(AbstractFeatureEntity<?> feature) {
        this.feature = feature;
    }

    public boolean isSetFeature() {
        return getFeature() != null;
    }

    @Override
    public OfferingEntity getOffering() {
        return offering;
    }

    @Override
    public void setOffering(final OfferingEntity offering) {
        this.offering = offering;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    @Override
    public boolean isSetOffering() {
        return getOffering() != null;
    }

    @Override
    public PlatformEntity getPlatform() {
        return platform;
    }

    @Override
    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public boolean isSetPlatform() {
        return getPlatform() != null;
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

    public void setFirstQuantityValue(BigDecimal firstValue) {
        this.firstQuantityValue = firstValue;
    }

    public BigDecimal getLastQuantityValue() {
        return lastQuantityValue;
    }

    public void setLastQuantityValue(BigDecimal lastValue) {
        this.lastQuantityValue = lastValue;
    }

    @Override
    public Date getResultTimeStart() {
        return Utils.createUnmutableTimestamp(resultTimeStart);
    }

    @Override
    public void setResultTimeStart(Date resultTimeStart) {
        this.resultTimeStart = Utils.createUnmutableTimestamp(resultTimeStart);
    }

    public boolean isSetResultTimeStart() {
        return getResultTimeStart() != null;
    }

    @Override
    public Date getResultTimeEnd() {
        return Utils.createUnmutableTimestamp(resultTimeEnd);
    }

    @Override
    public void setResultTimeEnd(Date resultTimeEnd) {
        this.resultTimeEnd = Utils.createUnmutableTimestamp(resultTimeEnd);
    }

    public boolean isSetResultTimeEnd() {
        return getResultTimeEnd() != null;
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

    @Override
    public UnitEntity getUnit() {
        return unit;
    }

    @Override
    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }

    public String getUnitI18nName(final String locale) {
        return unit != null
                // ? unit.getNameI18n(locale)
                ? unit.getUnit()
                : "";
    }

    @Override
    public FormatEntity getOMObservationType() {
        return omObservationType;
    }

    @Override
    public void setOMObservationType(FormatEntity omObservationType) {
        this.omObservationType = omObservationType;
    }

    @Override
    public boolean isSetOMObservationType() {
        return (getOMObservationType() != null) && getOMObservationType().isSetFormat();
    }

    public FormatEntity getOmObservationType() {
        return omObservationType;
    }

    public void setOmObservationType(FormatEntity omObservationType) {
        this.omObservationType = omObservationType;
    }

    @Override
    public GeometryEntity getGeometryEntity() {
        return this.observedArea;
    }

    @Override
    public void setGeometry(Geometry geometry) {
        this.observedArea = new GeometryEntity();
        this.observedArea.setGeometry(geometry);
        this.observedArea.setSrid(geometry.getSRID());
    }

    @Override
    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.observedArea = geometryEntity;
    }

    @Override
    public Date getSamplingTimeStart() {
        return getFirstValueAt();
    }

    @Override
    public void setSamplingTimeStart(Date samplingTimeStart) {
        setFirstValueAt(samplingTimeStart);
    }

    @Override
    public Date getSamplingTimeEnd() {
        return getLastValueAt();
    }

    @Override
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        setLastValueAt(samplingTimeEnd);
    }

    @Override
    public boolean isProcessed() {
        return this.processed;
    }

    @Override
    public void setProcessed(boolean processsed) {
        this.processed = processsed;
    }

    @Override
    public void setObservations(Set<DataEntity<?>> observations) {
        this.observations = observations;
    }

    @Override
    public Set<DataEntity<?>> getObservations() {
        return this.observations;
    }

    public AbstractDatasetEntity getAggregation() {
        return aggregation;
    }

    public void setAggregation(AbstractDatasetEntity aggregation) {
        this.aggregation = aggregation;
    }

    public boolean isSetAggregation() {
        return getAggregation() != null;
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
