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

package org.n52.series.db.beans.ereporting;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasAssessmentType;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasNetwork;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasStation;

/**
 * Entity for AQD e-Reporting SamplingPoint
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class EReportingSamplingPointEntity extends DescribableEntity implements HasAssessmentType,
        HasStation, HasNetwork {

    public static final String ID = "samplingPointId";

    private static final long serialVersionUID = 506067361074437086L;

    private Long samplingPointId;

    private EReportingAssessmentTypeEntity assessmentType;

    private EReportingStationEntity eReportingStationEntity;

    private EReportingNetworkEntity eReportingNetworkEntity;

    /**
     * @return the samplingPointId
     */
    public Long getSamplingPointId() {
        return samplingPointId;
    }

    /**
     * @param samplingPointId
     *        the samplingPointId to set
     */
    public void setSamplingPointId(Long samplingPointId) {
        this.samplingPointId = samplingPointId;
    }

    @Override
    public EReportingAssessmentTypeEntity getAssessmentType() {
        return assessmentType;
    }

    @Override
    public void setAssessmentType(EReportingAssessmentTypeEntity type) {
        this.assessmentType = type;
    }

    @Override
    public boolean isSetAssessmentType() {
        return getAssessmentType() != null
                && getAssessmentType().isSetAssessmentType();
    }

    @Override
    public EReportingNetworkEntity getEReportingNetworkEntity() {
        return eReportingNetworkEntity;
    }

    @Override
    public HasNetwork setEReportingNetworkEntity(EReportingNetworkEntity network) {
        this.eReportingNetworkEntity = network;
        return this;
    }

    @Override
    public boolean isSetEReportingNetworkEntity() {
        return getEReportingNetworkEntity() != null;
    }

    @Override
    public EReportingStationEntity getEReportingStationEntity() {
        return eReportingStationEntity;
    }

    @Override
    public HasStation setEReportingStationEntity(EReportingStationEntity station) {
        this.eReportingStationEntity = station;
        return this;
    }

    @Override
    public boolean isSetEReportingStationEntity() {
        return getEReportingStationEntity() != null;
    }

}
