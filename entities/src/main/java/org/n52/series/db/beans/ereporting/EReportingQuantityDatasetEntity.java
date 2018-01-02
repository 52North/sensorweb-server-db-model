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

import java.util.HashSet;
import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.dataset.QuantityDataset;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasEReportingSamplingPoint;

public class EReportingQuantityDatasetEntity extends DatasetEntity
        implements QuantityDataset<EReportingQuantityDatasetEntity>, HasEReportingSamplingPoint {

    private static final long serialVersionUID = -8934345303908852017L;

    private Set<EReportingQuantityDatasetEntity> referenceValues = new HashSet<>();

    private int numberOfDecimals;

    private EReportingSamplingPointEntity samplingPoint;

    public EReportingQuantityDatasetEntity() {
        super(DATASET_TYPE);
    }

    @Override
    public Set<EReportingQuantityDatasetEntity> getReferenceValues() {
        return referenceValues;
    }

    @Override
    public EReportingQuantityDatasetEntity setReferenceValues(Set<EReportingQuantityDatasetEntity> refValues) {
        this.referenceValues = refValues;
        return this;
    }

    @Override
    public int getNumberOfDecimals() {
        return numberOfDecimals;
    }

    @Override
    public EReportingQuantityDatasetEntity setNumberOfDecimals(int numberOfDecimals) {
        this.numberOfDecimals = numberOfDecimals;
        return this;
    }

    @Override
    public EReportingSamplingPointEntity getSamplingPoint() {
        return samplingPoint;
    }

    @Override
    public void setSamplingPoint(EReportingSamplingPointEntity samplingPoint) {
        this.samplingPoint = samplingPoint;
    }

}
