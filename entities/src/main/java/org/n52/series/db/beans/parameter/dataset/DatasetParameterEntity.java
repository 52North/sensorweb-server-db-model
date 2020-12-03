/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.parameter.dataset;

import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class DatasetParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_DATASET = "dataset";
    public static final String PROP_DATASET_ID = "datasetId";
    private static final long serialVersionUID = 8580995030975785255L;
    private AbstractDatasetEntity dataset;
    private long datasetId;

    public AbstractDatasetEntity getDataset() {
        return dataset;
    }

    public void setDataset(AbstractDatasetEntity dataset) {
        this.dataset = dataset;
    }

    public long getDatasetId() {
        return datasetId;
    }

    public void setDatasetId(long observationId) {
        this.datasetId = observationId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setDataset((AbstractDatasetEntity) entity);
    }
}
