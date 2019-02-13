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
package org.n52.series.db.beans.sampling;

import org.n52.series.db.beans.HibernateRelations.HasDatasets;
import org.n52.series.db.common.Utils;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.DescribableEntity;

public class MeasuringProgramEntity extends DescribableEntity implements HasDatasets {

    private static final long serialVersionUID = 2525309717383048842L;

    private String producer;

    private Date measuringTimeStart;

    private Date measuringTimeEnd;

    private final Set<SamplingEntity> samplings = new LinkedHashSet<>();

    private final Set<DatasetEntity> datasets = new LinkedHashSet<>();

    /**
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }

    /**
     * @param producer
     *            the producer to set
     */
    public void setProducer(String producer) {
        this.producer = producer;
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
     */
    public void setOrderId(String orderId) {
        this.setIdentifier(orderId);
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
     */
    public void setMeasuringTimeStart(Date measuringTimeStart) {
        this.measuringTimeStart = Utils.createUnmutableTimestamp(measuringTimeStart);
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
     */
    public void setMeasuringTimeEnd(Date measuringTimeEnd) {
        this.measuringTimeEnd = Utils.createUnmutableTimestamp(measuringTimeEnd);
    }

    public boolean isSetMeasuringTimeEnd() {
        return getMeasuringTimeEnd() != null;
    }

    public void setSamplings(Set<SamplingEntity> samplings) {
        this.samplings.clear();
        if (samplings != null) {
            this.samplings.addAll(samplings);
        }
    }

    public Set<SamplingEntity> getSamplings() {
        return samplings;
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

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
