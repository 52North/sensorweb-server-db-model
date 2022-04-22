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
package org.n52.series.db.beans.sampling;

import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.HibernateRelations.HasDatasets;
import org.n52.series.db.common.Utils;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class MeasuringProgramEntity extends DescribableEntity implements HasDatasets {

    public static final String PROPERTY_DATASETS = "datasets";

    public static final String PROPERTY_SAMPLINGS = "samplings";

    public static final String PROPERTY_MEASURING_TIME_START = "measuringTimeStart";

    public static final String PROPERTY_MEASURING_TIME_END = "measuringTimeEnd";

    private static final long serialVersionUID = 2525309717383048842L;

    private String producer;

    private Date measuringTimeStart;

    private Date measuringTimeEnd;

    private Set<SamplingEntity> samplings;

    private Set<DatasetEntity> datasets;

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer
     *            the producer to set
     * @return this MeasuringProgramEntity
     */
    public MeasuringProgramEntity setProducer(String producer) {
        this.producer = producer;
        return this;
    }

    /**
     * @return the orderId
     */
    public String getOrderId() {
        return getIdentifier();
    }

    /**
     * @param orderId
     *            the order id to set
     * @return this MeasuringProgramEntity
     */
    public MeasuringProgramEntity setOrderId(String orderId) {
        this.setIdentifier(orderId);
        return this;
    }

    /**
     * @return the measuringTimeStart
     */
    public Date getMeasuringTimeStart() {
        return Utils.createUnmutableTimestamp(measuringTimeStart);
    }

    /**
     * @param measuringTimeStart
     *            the measuringTimeStart
     * @return this MeasuringProgramEntity
     */
    public MeasuringProgramEntity setMeasuringTimeStart(Date measuringTimeStart) {
        this.measuringTimeStart = Utils.createUnmutableTimestamp(measuringTimeStart);
        return this;
    }

    /**
     * @return the measuringTimeEnd
     */
    public Date getMeasuringTimeEnd() {
        return Utils.createUnmutableTimestamp(measuringTimeEnd);
    }

    /**
     * @param measuringTimeEnd
     *            the measuringTimeEnd
     * @return this MeasuringProgramEntity
     */
    public MeasuringProgramEntity setMeasuringTimeEnd(Date measuringTimeEnd) {
        this.measuringTimeEnd = Utils.createUnmutableTimestamp(measuringTimeEnd);
        return this;
    }

    public boolean isSetMeasuringTimeEnd() {
        return getMeasuringTimeEnd() != null;
    }

    public MeasuringProgramEntity setSamplings(Set<SamplingEntity> samplings) {
        this.samplings = samplings;
        return this;
    }

    public Set<SamplingEntity> getSamplings() {
        return samplings;
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
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
