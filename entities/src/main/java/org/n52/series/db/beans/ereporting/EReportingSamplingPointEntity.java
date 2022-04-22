/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Entity for AQD e-Reporting SamplingPoint
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class EReportingSamplingPointEntity extends DescribableEntity
        implements HasAssessmentType, HasStation, HasNetwork {

    private static final long serialVersionUID = 506067361074437086L;

    private EReportingAssessmentTypeEntity assessmentType;

    private EReportingStationEntity station;

    private EReportingNetworkEntity network;

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
        return getAssessmentType() != null && getAssessmentType().isSetAssessmentType();
    }

    @Override
    public EReportingNetworkEntity getNetwork() {
        return network;
    }

    @Override
    public EReportingSamplingPointEntity setNetwork(EReportingNetworkEntity network) {
        this.network = network;
        return this;
    }

    @Override
    public boolean isSetNetwork() {
        return getNetwork() != null;
    }

    @Override
    public EReportingStationEntity getStation() {
        return station;
    }

    @Override
    public EReportingSamplingPointEntity setStation(EReportingStationEntity station) {
        this.station = station;
        return this;
    }

    @Override
    public boolean isSetStation() {
        return getStation() != null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof EReportingSamplingPointEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
