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

package org.n52.series.db.beans.sampling;

import org.n52.series.db.beans.HibernateRelations.*;
import org.n52.series.db.common.Utils;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.IdEntity;

public class SamplingEntity extends IdEntity implements HasDatasets, HasSamplingTime {

    private static final long serialVersionUID = -8840602794587590180L;

    private final Set<DatasetEntity> datasets = new LinkedHashSet<>();

    private MonitoringProgramEntity monitoringProgram;

    private String label;

    private String sampler;

    private String samplingMethod;

    private String environmentalConditions;

    private String comment;

    private Date samplingTimeStart;

    private Date samplingTimeEnd;

    /**
     * @return the monitoringProgram
     */
    public MonitoringProgramEntity getMonitoringProgram() {
        return monitoringProgram;
    }

    /**
     * @param monitoringProgram the monitoringProgram to set
     */
    public void setMonitoringProgram(MonitoringProgramEntity monitoringProgram) {
        this.monitoringProgram = monitoringProgram;
    }

    /**
     * @return the label
     */
    public String getLabel() {
        return label;
    }

    /**
     * @param label the label to set
     */
    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * @return the sampler
     */
    public String getSampler() {
        return sampler;
    }

    /**
     * @param sampler the sampler to set
     */
    public void setSampler(String sampler) {
        this.sampler = sampler;
    }

    /**
     * @return the samplingMethod
     */
    public String getSamplingMethod() {
        return samplingMethod;
    }

    /**
     * @param samplingMethod the samplingMethod to set
     */
    public void setSamplingMethod(String samplingMethod) {
        this.samplingMethod = samplingMethod;
    }

    /**
     * @return the environmentalConditions
     */
    public String getEnvironmentalConditions() {
        return environmentalConditions;
    }

    /**
     * @param environmentalConditions the environmentalConditions to set
     */
    public void setEnvironmentalConditions(String environmentalConditions) {
        this.environmentalConditions = environmentalConditions;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the samplingTimeStart
     */
    public Date getSamplingTimeStart() {
        return Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @param samplingTimeStart
     *        the samplingTimeStart
     */
    public void setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @return the samplingTimeEnd
     */
    public Date getSamplingTimeEnd() {
        return Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    /**
     * @param samplingTimeEnd
     *        the samplingTimeEnd
     */
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets.clear();
        if (datasets != null) {
            this.datasets.addAll(datasets);
        }
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

}
