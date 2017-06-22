/**
 * Copyright (C) 2012-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.series.db.beans.ereporting;

import org.n52.shetland.aqd.AqdConstants;

public interface HiberanteEReportingRelations {

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

    interface EReportingQualityData extends HasTimeCoverageFlag, HasDataCaptureFlag, HasUncertaintyEstimation {

    }

    interface EReportingValues extends HasValidation, HasVerification, HasPrimaryObservation, HasDataCapture, EReportingQualityData {


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
     *
     */
    interface HasStation {
        String STATION = "station";

        /**
         * @return the station
         */
        EReportingStationEntity getStation();

        /**
         * @param station
         *            the station to set
         * @return this
         */
        HasStation setStation(EReportingStationEntity station);

        /**
         * @return <code>true</code>, if station is not null
         */
       default boolean isSetStation() {
           return getStation() != null;
       }
    }

    /**
     * Interface for AQD EReporting Network elements
     *
     */
    interface HasNetwork {
        String NETWORK = "network";

        /**
         * @return the network
         */
        EReportingNetworkEntity getNetwork();

        /**
         * @param network
         *            the network to set
         * @return this
         */
        HasNetwork setNetwork(EReportingNetworkEntity network);

        /**
         * @return <code>true</code>, if network is not null
         */
        default boolean isSetNetwork() {
            return getNetwork() != null;
        }
    }
}
