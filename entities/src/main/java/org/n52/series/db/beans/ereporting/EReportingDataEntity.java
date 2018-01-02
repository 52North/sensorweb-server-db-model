/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.EReportingValues;

public abstract class EReportingDataEntity<T> extends DataEntity<T> implements EReportingValues {

    private static final long serialVersionUID = 6718001163355558735L;

    private Integer validation = EReportingValues.DEFAULT_VALIDATION;

    private Integer verification = EReportingValues.DEFAULT_VERIFICATION;

    private String primaryObservation = EReportingValues.DEFAULT_PRIMARY_OBSERVATION;

    private Boolean timeCoverageFlag;

    private Boolean dataCaptureFlag;

    private Double dataCapture;

    private Double uncertaintyEstimation;

    @Override
    public Integer getVerification() {
        return verification;
    }

    @Override
    public void setVerification(Integer verification) {
        this.verification = verification;
    }

    @Override
    public Integer getValidation() {
        return validation;
    }

    @Override
    public void setValidation(Integer validation) {
        this.validation = validation;
    }

    @Override
    public String getPrimaryObservation() {
        return primaryObservation;
    }

    @Override
    public void setPrimaryObservation(String primaryObservation) {
        this.primaryObservation = primaryObservation;
    }

    @Override
    public Boolean getDataCaptureFlag() {
        return this.dataCaptureFlag;
    }

    @Override
    public void setDataCaptureFlag(Boolean dataCaptureFlag) {
        this.dataCaptureFlag = dataCaptureFlag;
    }

    @Override
    public Double getDataCapture() {
        return this.dataCapture;
    }

    @Override
    public void setDataCapture(Double dataCapture) {
        this.dataCapture = dataCapture;
    }

    @Override
    public Boolean getTimeCoverageFlag() {
        return this.timeCoverageFlag;
    }

    @Override
    public void setTimeCoverageFlag(Boolean timeCoverageFlag) {
        this.timeCoverageFlag = timeCoverageFlag;
    }

    @Override
    public Double getUncertaintyEstimation() {
        return this.uncertaintyEstimation;
    }

    @Override
    public void setUncertaintyEstimation(Double uncertaintyEstimation) {
        this.uncertaintyEstimation = uncertaintyEstimation;
    }

}
