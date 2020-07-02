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

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import org.n52.series.db.beans.HibernateRelations.HasDataset;
import org.n52.series.db.beans.HibernateRelations.HasParameters;
import org.n52.series.db.beans.HibernateRelations.HasPhenomenonTime;
import org.n52.series.db.beans.HibernateRelations.HasResultTime;
import org.n52.series.db.beans.HibernateRelations.HasValidTime;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.ereporting.EReportingProfileDataEntity;
import org.n52.series.db.beans.sampling.SamplingProfileDataEntity;
import org.n52.series.db.common.Utils;

public abstract class DataEntity<T> extends DescribableEntity
        implements Comparable<DataEntity<T>>, Serializable, HasPhenomenonTime<DataEntity<?>>, IsStaEntity,
        HasResultTime, HasValidTime<DataEntity<T>>, HasParameters, HasDataset {

    public static final String PROPERTY_ID = "id";

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

    public static final BigDecimal NOT_SET_VERTICAL = BigDecimal.valueOf(0);

    private static final long serialVersionUID = 273612846605300612L;

    private Date samplingTimeStart;

    private Date samplingTimeEnd;

    private T value;

    private GeometryEntity geometryEntity;

    private boolean deleted;

    private Date validTimeStart;

    private Date validTimeEnd;

    private Date resultTime;

    private Long parent;

    private DatasetEntity dataset;

    private Long datasetId;

    private Set<RelatedDataEntity> relatedObservations = new HashSet<>(0);

    private String valueIdentifier;

    private String valueName;

    private String valueDescription;

    private BigDecimal verticalFrom = NOT_SET_VERTICAL;

    private BigDecimal verticalTo = NOT_SET_VERTICAL;

    private DetectionLimitEntity detectionLimit;

    private SamplingProfileDataEntity samplingProfile;

    private EReportingProfileDataEntity ereportingProfile;

    protected DataEntity() {

    }

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
     * @return
     */

    @Override
    public DataEntity<T> setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
        return this;
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
    public DataEntity<T> setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
        return this;
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

    public abstract boolean isNoDataValue(Collection<String> noDataValues);

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public void setGeometryEntity(final GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public boolean isSetGeometryEntity() {
        return (geometryEntity != null) && !geometryEntity.isEmpty();
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
    public DataEntity<T> setValidTimeStart(final Date validTimeStart) {
        this.validTimeStart = Utils.createUnmutableTimestamp(validTimeStart);
        return this;
    }

    @Override
    public Date getValidTimeEnd() {
        return Utils.createUnmutableTimestamp(validTimeEnd);
    }

    @Override
    public DataEntity<T> setValidTimeEnd(final Date validTimeEnd) {
        this.validTimeEnd = Utils.createUnmutableTimestamp(validTimeEnd);
        return this;
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

    public Long getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(Long datasetId) {
        this.datasetId = datasetId;
    }

    public Set<RelatedDataEntity> getRelatedObservations() {
        return relatedObservations;
    }

    public void setRelatedObservations(final Set<RelatedDataEntity> relatedObservations) {
        this.relatedObservations = relatedObservations;
    }

    public boolean hasRelatedObservations() {
        return (getRelatedObservations() != null) && !getRelatedObservations().isEmpty();
    }

    public String getValueIdentifier() {
        return valueIdentifier;
    }

    public void setValueIdentifier(final String valueIdentifier) {
        this.valueIdentifier = valueIdentifier;
    }

    public boolean hasValueIdentifier() {
        return (getValueIdentifier() != null) && !getValueIdentifier().isEmpty();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(final String valueName) {
        this.valueName = valueName;
    }

    public boolean hasValueName() {
        return (getValueName() != null) && !getValueName().isEmpty();
    }

    public String getValueDescription() {
        return valueDescription;
    }

    public void setValueDescription(final String valueDescription) {
        this.valueDescription = valueDescription;
    }

    public boolean hasValueDescription() {
        return (getValueDescription() != null) && !getValueDescription().isEmpty();
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

    @Override
    public int compareTo(DataEntity<T> o) {
        return Comparator.comparing(DataEntity<T>::getSamplingTimeEnd)
                .thenComparing(DataEntity<T>::getSamplingTimeStart).thenComparing(DataEntity<T>::getId)
                .compare(this, o);
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" id: ").append(getId()).append(" ]")
                .toString();
    }
}
