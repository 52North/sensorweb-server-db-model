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

import org.n52.series.db.beans.HibernateRelations;
import org.n52.shetland.aqd.AqdConstants;

public interface HiberanteEReportingRelations
        extends
        HibernateRelations {

    interface HasEReportingSamplingPoint {
        String SAMPLING_POINT = "samplingPoint";

        EReportingSamplingPointEntity getSamplingPoint();

        void setSamplingPoint(EReportingSamplingPointEntity samplingPoint);

        default boolean hasSamplingPoint() {
            return getSamplingPoint() != null;
        }
    }

    interface HasInspireId {
        String INSPIRE_ID = "inspireId";

        String getInspireId();

        void setInspireId(String inspireId);

        default boolean isSetInspireId() {
            return getInspireId() != null && !getInspireId().isEmpty();
        }
    }

    interface HasValidation {

        Integer DEFAULT_VALIDATION = -1;

        String VALIDATION = "validation";

        Integer getValidation();

        void setValidation(Integer validation);

        default boolean isSetValidation() {
            return getValidation() != null;
        }
    }

    interface HasVerification {

        Integer DEFAULT_VERIFICATION = 3;
        String VERIFICATION = "verification";

        Integer getVerification();

        void setVerification(Integer verification);

        default boolean isSetVerification() {
            return getVerification() != null;
        }
    }

    interface HasPrimaryObservation {

        String DEFAULT_PRIMARY_OBSERVATION = AqdConstants.VAR;

        String PRIMARY_OBSERVATION = "primaryObservation";

        String getPrimaryObservation();

        void setPrimaryObservation(String primaryObservation);

        default boolean isSetPrimaryObservation() {
            return getPrimaryObservation() != null && !getPrimaryObservation().isEmpty();
        }
    }

    interface HasTimeCoverageFlag {
        String TIME_COVERAGE_FLAG = "timeCoverageFlag";

        Boolean getTimeCoverageFlag();

        void setTimeCoverageFlag(Boolean timeCoverageFlag);

        default boolean isSetTimeCoverageFlag() {
            return getTimeCoverageFlag() != null;
        }
    }

    interface HasDataCaptureFlag {
        String DATA_CAPTURE_FLAG = "dataCaptureFlag";

        Boolean getDataCaptureFlag();

        void setDataCaptureFlag(Boolean dataCaptureFlag);

        default boolean isSetDataCaptureFlag() {
            return getDataCaptureFlag() != null;
        }
    }

    interface HasDataCapture {

        String DATA_CAPTURE = "dataCapture";

        Double getDataCapture();

        void setDataCapture(Double dataCapture);

        default boolean isSetDataCapture() {
            return getDataCapture() != null;
        }
    }

    interface HasUncertaintyEstimation {
        String UNCERTAINTY_ESTIMATION = "uncertaintyEstimation";

        Double getUncertaintyEstimation();

        void setUncertaintyEstimation(Double uncertaintyEstimation);

        default boolean isSetUncertaintyEstimation() {
            return getUncertaintyEstimation() != null;
        }
    }

    interface EReportingQualityData
            extends
            HasTimeCoverageFlag,
            HasDataCaptureFlag,
            HasUncertaintyEstimation {

    }

    interface EReportingValues
            extends
            HasValidation,
            HasVerification,
            HasPrimaryObservation,
            HasDataCapture,
            EReportingQualityData,
            GetStringValue {

    }

    interface HasAssessmentType {
        String ASSESSMENTTYPE = "assessmentType";

        /**
         * @return the assessmentType
         */
        EReportingAssessmentTypeEntity getAssessmentType();

        /**
         * @param assessmentType
         *            the assessmentType to set
         */
        void setAssessmentType(EReportingAssessmentTypeEntity assessmentType);

        default boolean isSetAssessmentType() {
            return getAssessmentType() != null && getAssessmentType().isSetAssessmentType();
        }
    }

    /**
     * Interface for AQD EReporting Station elements
     */
    interface HasStation {
        String STATION = "station";

        /**
         * @return the station
         */
        EReportingStationEntity getEReportingStationEntity();

        /**
         * @param station
         *            the station to set
         * @return this
         */
        HasStation setEReportingStationEntity(EReportingStationEntity station);

        /**
         * @return <code>true</code>, if station is not null
         */
        default boolean isSetEReportingStationEntity() {
            return getEReportingStationEntity() != null;
        }
    }

    /**
     * Interface for AQD EReporting Network elements
     */
    interface HasNetwork {
        String NETWORK = "network";

        /**
         * @return the network
         */
        EReportingNetworkEntity getEReportingNetworkEntity();

        /**
         * @param network
         *            the network to set
         * @return this
         */
        HasNetwork setEReportingNetworkEntity(EReportingNetworkEntity network);

        /**
         * @return <code>true</code>, if network is not null
         */
        default boolean isSetEReportingNetworkEntity() {
            return getEReportingNetworkEntity() != null;
        }
    }
}
