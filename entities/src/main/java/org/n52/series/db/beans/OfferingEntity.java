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

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.HibernateRelations.HasFeatureTypes;
import org.n52.series.db.beans.HibernateRelations.HasObservationTypes;
import org.n52.series.db.beans.HibernateRelations.HasPhenomenonTime;
import org.n52.series.db.beans.HibernateRelations.HasRelatedFeatures;
import org.n52.series.db.beans.HibernateRelations.HasResultTimes;
import org.n52.series.db.beans.HibernateRelations.HasValidTime;
import org.n52.series.db.common.Utils;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Date;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class OfferingEntity extends HierarchicalEntity<OfferingEntity> implements HasObservationTypes, HasFeatureTypes,
        HasRelatedFeatures, HasPhenomenonTime, HasResultTimes, HasValidTime {

    public static final String PROPERTY_PHENOMENON_TIME_START = "phenomenonTimeStart";
    public static final String PROPERTY_PHENOMENON_TIME_END = "phenomenonTimeEnd";
    public static final String PROPERTY_RESULT_TIME_START = "resultTimeStart";
    public static final String PROPERTY_RESULT_TIME_END = "resultTimeEnd";

    private static final long serialVersionUID = 5862607025737865794L;

    private GeometryEntity geometryEntity;

    private Set<FormatEntity> observationTypes;

    private Set<FormatEntity> featureTypes;

    private Date phenomenonTimeStart;

    private Date phenomenonTimeEnd;

    private Date resultTimeStart;

    private Date resultTimeEnd;

    private Set<RelatedFeatureEntity> relatedFeatures;

    private Date validTimeStart;

    private Date validTimeEnd;

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
