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

package org.n52.series.db.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.n52.series.db.beans.dataset.QuantityDataset;

public class QuantityDatasetEntity extends DatasetEntity implements QuantityDataset<QuantityDatasetEntity> {

    private static final long serialVersionUID = 4788481449399555710L;

    private List<QuantityDatasetEntity> referenceValues = new ArrayList<>();

    private Integer numberOfDecimals;

    public QuantityDatasetEntity() {
        super(DATASET_TYPE);
    }

    @Override
    public List<QuantityDatasetEntity> getReferenceValues() {
        return referenceValues;
    }

    public QuantityDatasetEntity setReferenceValues(Collection<QuantityDatasetEntity> referenceValues) {
        this.referenceValues.clear();
        if (referenceValues != null) {
            this.referenceValues.addAll(referenceValues);
        }
        return this;
    }

    @Override
    public Integer getNumberOfDecimals() {
        return numberOfDecimals;
    }

    @Override
    public QuantityDatasetEntity setNumberOfDecimals(Integer numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
        return this;
    }

}
