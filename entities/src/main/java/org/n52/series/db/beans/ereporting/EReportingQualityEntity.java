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

import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.EReportingQualityData;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasPrimaryObservation;

public class EReportingQualityEntity extends IdEntity implements HasPrimaryObservation, EReportingQualityData {

    public static final String YEAR = "year";

    public static final String DATASET = "dataset";

    public static final String PRIMARY_OBSERVATION = "primaryObservation";

    private static final long serialVersionUID = 1891418800348199576L;

    private long dataset;

    private int year;

    private long series;

    private String primaryObservation;

    private Boolean timeCoverageFlag;

    private Boolean dataCaptureFlag;

    private Double uncertaintyEstimation;

    /**
     * @return the dataset
     */
    public long getDataset() {
        return dataset;
    }

    /**
     * @param dataset
     *            the dataset to set
     */
    public void setDataset(long dataset) {
        this.dataset = dataset;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * @param year
     *            the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return the series
     */
    public long getSeries() {
        return series;
    }

    /**
     * @param series
     *            the series to set
     */
    public void setSeries(long series) {
        this.series = series;
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
