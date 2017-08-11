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

public class EReportingGeometryDatasetEntity extends EReportingDatasetEntity {

    private static final long serialVersionUID = -6212212763954201384L;

    private static final String DATASET_TYPE = "geometry";

    private Set<EReportingGeometryDatasetEntity> referenceValues = new HashSet<>();

    public EReportingGeometryDatasetEntity() {
        super(DATASET_TYPE);
    }

    public Set<EReportingGeometryDatasetEntity> getReferenceValues() {
        return referenceValues;
    }

    public void setReferenceValues(Set<EReportingGeometryDatasetEntity> referenceValues) {
        this.referenceValues = referenceValues;
    }

}
