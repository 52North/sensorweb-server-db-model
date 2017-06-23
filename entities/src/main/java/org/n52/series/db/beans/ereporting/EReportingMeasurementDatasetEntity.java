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
package org.n52.series.db.beans.ereporting;

import java.util.HashSet;
import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.dataset.MeasurementDataset;

public class EReportingMeasurementDatasetEntity extends DatasetEntity<EReportingMeasurementDataEntity> implements MeasurementDataset<EReportingMeasurementDatasetEntity>{

    private static final long serialVersionUID = -8934345303908852017L;

    private Set<EReportingMeasurementDatasetEntity> referenceValues = new HashSet<>();

    private int numberOfDecimals;

    public EReportingMeasurementDatasetEntity() {
        super(DATASET_TYPE);
    }

    public Set<EReportingMeasurementDatasetEntity> getReferenceValues() {
        return referenceValues;
    }

    public EReportingMeasurementDatasetEntity setReferenceValues(Set<EReportingMeasurementDatasetEntity> referenceValues) {
        this.referenceValues = referenceValues;
        return this;
    }

    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    public EReportingMeasurementDatasetEntity setNumberOfDecimals(int numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
        return this;
    }

}
