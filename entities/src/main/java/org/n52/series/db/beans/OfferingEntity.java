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

import com.vividsolutions.jts.geom.Geometry;

public class OfferingEntity extends HierarchicalEntity<OfferingEntity> {

    private Geometry envelope;

    private Set<String> observationTypes;

    private Set<String> featureTypes;

    private Date phenomenonTimeStart;

    private Date phenomenonTimeEnd;

    private Date resultTimeStart;

    private Date resultTimeEnd;

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
    public void setEnvelope(Geometry envelope) {
        this.envelope = envelope;
    }

    public boolean hasEnvelope() {
        return getEnvelope() != null && !getEnvelope().isEmpty();
    }

    /**
     * @return the observationTypes
     */
    public Set<String> getObservationTypes() {
        return observationTypes;
    }

    /**
     * @param observationTypes
     *        the observationTypes to set
     */
    public void setObservationTypes(Set<String> observationTypes) {
        this.observationTypes = observationTypes;
    }

    public boolean hasObservationTypes() {
        return getObservationTypes() != null && !getObservationTypes().isEmpty();
    }

    /**
     * @return the featureTypes
     */
    public Set<String> getFeatureTypes() {
        return featureTypes;
    }

    /**
     * @param featureTypes
     *        the featureTypes to set
     */
    public void setFeatureTypes(Set<String> featureTypes) {
        this.featureTypes = featureTypes;
    }

    public boolean hasFeatureTypes() {
        return getFeatureTypes() != null && !getFeatureTypes().isEmpty();
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
    public void setPhenomenonTimeStart(Date phenomenonTimeStart) {
        this.phenomenonTimeStart = phenomenonTimeStart != null
                ? new Timestamp(phenomenonTimeStart.getTime())
                : null;
    }

    public boolean hasPhenomenonTimeStart() {
        return phenomenonTimeStart != null;
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
    public void setPhenomenonTimeEnd(Date phenomenonTimeEnd) {
        this.phenomenonTimeEnd = phenomenonTimeEnd != null
                ? new Timestamp(phenomenonTimeEnd.getTime())
                : null;
    }

    public boolean hasPhenomenonTimeEnd() {
        return phenomenonTimeEnd != null;
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
    public void setResultTimeStart(Date resultTimeStart) {
        this.resultTimeStart = resultTimeStart != null
                ? new Timestamp(resultTimeStart.getTime())
                : null;
    }

    public boolean hasResultTimeStart() {
        return resultTimeStart != null;
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
    public void setResultTimeEnd(Date resultTimeEnd) {
        this.resultTimeEnd = resultTimeEnd != null
                ? new Timestamp(resultTimeEnd.getTime())
                : null;
    }

    public boolean hasResultTimeEnd() {
        return resultTimeEnd != null;
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
