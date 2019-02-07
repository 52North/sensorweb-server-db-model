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

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.dataset.Dataset;

public abstract class EReportingDatasetEntity extends DatasetEntity {

    public static final String SAMPLING_POINT = "samplingPoint";
    private static final long serialVersionUID = -182651044543274208L;

    private EReportingSamplingPointEntity samplingPoint;

    public EReportingSamplingPointEntity getSamplingPoint() {
        return samplingPoint;
    }

    public void setSamplingPoint(EReportingSamplingPointEntity samplingPoint) {
        this.samplingPoint = samplingPoint;
    }

    @Override
    public void copy(Dataset dataset) {
        if (dataset instanceof EReportingDatasetEntity) {
            setSamplingPoint(((EReportingDatasetEntity) dataset).getSamplingPoint());
        }
        super.copy(dataset);
    }
}
