/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.HibernateRelations.HasFeatureTypes;
import org.n52.series.db.beans.HibernateRelations.HasObservationTypes;
import org.n52.series.db.beans.HibernateRelations.HasPhenomenonTime;
import org.n52.series.db.beans.HibernateRelations.HasRelatedFeatures;
import org.n52.series.db.beans.HibernateRelations.HasResultTimes;

import com.vividsolutions.jts.geom.Geometry;

public class OfferingEntity extends HierarchicalEntity<OfferingEntity>
                            implements HasObservationTypes<OfferingEntity>, 
                                        HasFeatureTypes<OfferingEntity>, 
                                        HasRelatedFeatures<OfferingEntity>,
                                        HasPhenomenonTime<OfferingEntity>,
                                        HasResultTimes<OfferingEntity>{

    private Geometry envelope;

    private Set<ObservationTypeEntity> observationTypes;

    private Set<FeatureTypeEntity> featureTypes;

    private Date phenomenonTimeStart;

    private Date phenomenonTimeEnd;

    private Date resultTimeStart;

    private Date resultTimeEnd;

    private Set<RelatedFeatureEntity> relatedFeatures;

    /**
     * @return the envelope
     */
    public Geometry getEnvelope() {
        return envelope;
    }
    
    

    /**
     * @param envelope
     *        the envelope to set
     */
    public OfferingEntity setEnvelope(Geometry envelope) {
        this.envelope = envelope;
        return this;
    }

    public boolean hasEnvelope() {
        return getEnvelope() != null && !getEnvelope().isEmpty();
    }

    /**
     * @return the observationTypes
     */
    public Set<ObservationTypeEntity> getObservationTypes() {
        return observationTypes;
    }

    /**
     * @param observationTypes
     *        the observationTypes to set
     */
    public OfferingEntity setObservationTypes(Set<ObservationTypeEntity> observationTypes) {
        this.observationTypes = observationTypes;
        return this;
    }


    /**
     * @return the featureTypes
     */
    public Set<FeatureTypeEntity> getFeatureTypes() {
        return featureTypes;
    }

    /**
     * @param featureTypes
     *        the featureTypes to set
     */
    public OfferingEntity setFeatureTypes(Set<FeatureTypeEntity> featureTypes) {
        this.featureTypes = featureTypes;
        return this;
    }

    /**
     * @return the phenomenonTimeStart
     */
    public Date getPhenomenonTimeStart() {
        return hasPhenomenonTimeStart()
                ? new Timestamp(phenomenonTimeStart.getTime())
                : null;
    }

    /**
     * @param phenomenonTimeStart
     *        the phenomenonTimeStart to set
     */
    public OfferingEntity setPhenomenonTimeStart(Date phenomenonTimeStart) {
        this.phenomenonTimeStart = phenomenonTimeStart != null
                ? new Timestamp(phenomenonTimeStart.getTime())
                : null;
        return this;
    }

    /**
     * @return the phenomenonTimeEnd
     */
    public Date getPhenomenonTimeEnd() {
        return hasPhenomenonTimeEnd()
                ? new Timestamp(phenomenonTimeEnd.getTime())
                : null;
    }

    /**
     * @param phenomenonTimeEnd
     *        the phenomenonTimeEnd to set
     */
    public OfferingEntity setPhenomenonTimeEnd(Date phenomenonTimeEnd) {
        this.phenomenonTimeEnd = phenomenonTimeEnd != null
                ? new Timestamp(phenomenonTimeEnd.getTime())
                : null;
        return this;
    }

    /**
     * @return the resultTimeStart
     */
    public Date getResultTimeStart() {
        return hasResultTimeStart()
                ? new Timestamp(resultTimeStart.getTime())
                : null;
    }

    /**
     * @param resultTimeStart
     *        the resultTimeStart to set
     */
    public OfferingEntity setResultTimeStart(Date resultTimeStart) {
        this.resultTimeStart = resultTimeStart != null
                ? new Timestamp(resultTimeStart.getTime())
                : null;
        return this;
    }

    /**
     * @return the resultTimeEnd
     */
    public Date getResultTimeEnd() {
        return hasResultTimeEnd()
                ? new Timestamp(resultTimeEnd.getTime())
                : null;
    }

    /**
     * @param resultTimeEnd
     *        the resultTimeEnd to set
     */
    public OfferingEntity setResultTimeEnd(Date resultTimeEnd) {
        this.resultTimeEnd = resultTimeEnd != null
                ? new Timestamp(resultTimeEnd.getTime())
                : null;
        return this;
    }

    @Override
    public Set<RelatedFeatureEntity> getRelatedFeatures() {
        return relatedFeatures;
    }

    @Override
    public OfferingEntity setRelatedFeatures(Set<RelatedFeatureEntity> relatedFeatures) {
        this.relatedFeatures = relatedFeatures;
        return this;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" Domain id: ")
                 .append(getDomainId())
                 .append(" ]")
                 .toString();
    }

}
