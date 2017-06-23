/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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

import java.util.HashSet;
import java.util.Set;

import org.n52.series.db.beans.dataset.MeasurementDataset;

public class MeasurementDatasetEntity extends DatasetEntity<MeasurementDataEntity>
        implements MeasurementDataset<MeasurementDatasetEntity> {

    private static final long serialVersionUID = 4788481449399555710L;

    private Set<MeasurementDatasetEntity> referenceValues = new HashSet<>();

    private int numberOfDecimals;

    public MeasurementDatasetEntity() {
        super(DATASET_TYPE);
    }

    @Override
    public Set<MeasurementDatasetEntity> getReferenceValues() {
        return referenceValues;
    }

    @Override
    public MeasurementDatasetEntity setReferenceValues(Set<MeasurementDatasetEntity> referenceValues) {
        this.referenceValues = referenceValues;
        return this;
    }

    @Override
    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    @Override
    public MeasurementDatasetEntity setNumberOfDecimals(int numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
        return this;
    }

}
