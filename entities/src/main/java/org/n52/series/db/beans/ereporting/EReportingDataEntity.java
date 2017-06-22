package org.n52.series.db.beans.ereporting;

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.EReportingValues;

public abstract class EReportingDataEntity<T> extends DataEntity<T> implements EReportingValues {

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
