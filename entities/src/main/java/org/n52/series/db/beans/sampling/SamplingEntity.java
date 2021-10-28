/*
 * Copyright 2015-2021 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.sampling;

import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.HibernateRelations.HasDatasets;
import org.n52.series.db.beans.HibernateRelations.HasSamplingTime;
import org.n52.series.db.common.Utils;

public class SamplingEntity extends DescribableEntity implements HasDatasets, HasSamplingTime {

    public static final String PROPERTY_DATASETS = "datasets";

    public static final String PROPERTY_MEASURING_PROGRAM = "measuringProgram";

    public static final String PROPERTY_SAMPLING_TIME_START = "samplingTimeStart";

    public static final String PROPERTY_SAMPLING_TIME_END = "samplingTimeEnd";

    private static final long serialVersionUID = -8840602794587590180L;

    private Set<DatasetEntity> datasets;

    private MeasuringProgramEntity measuringProgram;

    private String sampler;

    private String samplingMethod;

    private String environmentalConditions;

    private Date samplingTimeStart;

    private Date samplingTimeEnd;

    private Set<DataEntity<?>> observations;

    /**
     * @return the measuringProgram
     */
    public MeasuringProgramEntity getMeasuringProgram() {
        return measuringProgram;
    }

    /**
     * @param measuringProgram
     *            the measuringProgram to set
     */
    public void setMeasuringProgram(MeasuringProgramEntity measuringProgram) {
        this.measuringProgram = measuringProgram;
    }

    /**
     * @return the sampler
     */
    public String getSampler() {
        return sampler;
    }

    /**
     * @param sampler
     *            the sampler to set
     */
    public void setSampler(String sampler) {
        this.sampler = sampler;
    }

    public boolean isSetSampler() {
        return getSampler() != null;
    }

    /**
     * @return the samplingMethod
     */
    public String getSamplingMethod() {
        return samplingMethod;
    }

    /**
     * @param samplingMethod
     *            the samplingMethod to set
     */
    public void setSamplingMethod(String samplingMethod) {
        this.samplingMethod = samplingMethod;
    }

    public boolean isSetSamplingMethod() {
        return getSamplingMethod() != null && !getSamplingMethod().isEmpty();
    }

    /**
     * @return the environmentalConditions
     */
    public String getEnvironmentalConditions() {
        return environmentalConditions;
    }

    /**
     * @param environmentalConditions
     *            the environmentalConditions to set
     */
    public void setEnvironmentalConditions(String environmentalConditions) {
        this.environmentalConditions = environmentalConditions;
    }

    public boolean isSetEnvironmentalConditions() {
        return getEnvironmentalConditions() != null && !getEnvironmentalConditions().isEmpty();
    }

    /**
     * @return the samplingTimeStart
     */
    @Override
    public Date getSamplingTimeStart() {
        return Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @param samplingTimeStart
     *            the samplingTimeStart
     */
    @Override
    public void setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @return the samplingTimeEnd
     */
    @Override
    public Date getSamplingTimeEnd() {
        return Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    /**
     * @param samplingTimeEnd
     *            the samplingTimeEnd
     */
    @Override
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public boolean hasDatasets() {
        return HasDatasets.super.hasDatasets() && !getDatasets().isEmpty();
    }

    public void setObservations(Set<DataEntity<?>> observations) {
        this.observations = observations;
    }

    public Set<DataEntity<?>> getObservations() {
        return observations;
    }

    public boolean hasObservations() {
        return getObservations() != null && !getObservations().isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
