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
package org.n52.series.db.beans.dataset;

public interface NotInitializedDataset extends Dataset {

    String DATASET_TYPE = "not_initialized";

    @Override
    default String getDefaultDatasetType() {
        return DATASET_TYPE;
    }

    default Long getUnitId() {
        return getUnit() != null
                ? getUnit().getId()
                : null;
    }

    default void setUnitId(Long unitId) {
        // only required for Hibernate
    }

    default Long getFirstObservationId() {
        return getFirstObservation() != null
                ? getFirstObservation().getId()
                : null;
    }

    default void setFirstObservationId(Long firstObservationId) {
        // only required for Hibernate
    }

    default Long getLastObservationId() {
        return getLastObservation() != null
                ? getLastObservation().getId()
                : null;
    }

    default void setLastObservationId(Long lastObservationId) {
        // only required for Hibernate
    }

}
