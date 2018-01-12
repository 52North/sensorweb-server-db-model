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

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.n52.series.db.beans.QuantityDataEntity;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.EReportingValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EReportingQuantityDataEntity extends QuantityDataEntity implements EReportingValues {

    private static final long serialVersionUID = 5870100531719269673L;

    private static final Logger LOGGER = LoggerFactory.getLogger(EReportingQuantityDataEntity.class);

    private static final Double DOUBLE_THRESHOLD = 0.01;
    
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

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        Double value = getValue();
        return value == null
                || Double.isNaN(value)
                || containsValue(noDataValues, value);
    }

    @Override
    public boolean isSetValue() {
        return getValue() != null;
    }

    @Override
    public String getValueAsString() {
        return isSetValue()
                ? getValue().toString()
                : "";
    }

    private boolean containsValue(Collection<String> collection, double key) {
        if (collection == null) {
            return false;
        }
        for (Double noDataValue : convertToDoubles(collection)) {
            if (Math.abs(noDataValue / key - 1) < DOUBLE_THRESHOLD) {
                return true;
            }
        }
        return false;
    }

    private Collection<Double> convertToDoubles(Collection<String> collection) {
        List<Double> validatedValues = new ArrayList<>();
        for (String value : collection) {
            String trimmed = value.trim();
            try {
                validatedValues.add(Double.parseDouble(trimmed));
            } catch (NumberFormatException e) {
                LOGGER.trace("Ignoring NO_DATA value {} (not a double).", trimmed);
            }
        }
        return validatedValues;
    }
}
