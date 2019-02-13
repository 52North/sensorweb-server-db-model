/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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

import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.EReportingQualityData;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasDataCapture;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasPrimaryObservation;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasValidation;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasVerification;

public class EReportingProfileDataEntity
        implements HasValidation, HasVerification, HasPrimaryObservation, HasDataCapture, EReportingQualityData {

    private Integer validation = HasValidation.DEFAULT_VALIDATION;

    private Integer verification = HasVerification.DEFAULT_VERIFICATION;

    private String primaryObservation = HasPrimaryObservation.DEFAULT_PRIMARY_OBSERVATION;

    private Boolean timeCoverageFlag;

    private Boolean dataCaptureFlag;

    private Double dataCapture;

    private Double uncertaintyEstimation;

    public Integer getVerification() {
        return verification;
    }

    public void setVerification(Integer verification) {
        this.verification = verification;
    }

    public Integer getValidation() {
        return validation;
    }

    public void setValidation(Integer validation) {
        this.validation = validation;
    }

    public String getPrimaryObservation() {
        return primaryObservation;
    }

    public void setPrimaryObservation(String primaryObservation) {
        this.primaryObservation = primaryObservation;
    }

    public Boolean getDataCaptureFlag() {
        return this.dataCaptureFlag;
    }

    public void setDataCaptureFlag(Boolean dataCaptureFlag) {
        this.dataCaptureFlag = dataCaptureFlag;
    }

    public Double getDataCapture() {
        return this.dataCapture;
    }

    public void setDataCapture(Double dataCapture) {
        this.dataCapture = dataCapture;
    }

    public Boolean getTimeCoverageFlag() {
        return this.timeCoverageFlag;
    }

    public void setTimeCoverageFlag(Boolean timeCoverageFlag) {
        this.timeCoverageFlag = timeCoverageFlag;
    }

    public Double getUncertaintyEstimation() {
        return this.uncertaintyEstimation;
    }

    public void setUncertaintyEstimation(Double uncertaintyEstimation) {
        this.uncertaintyEstimation = uncertaintyEstimation;
    }

}
