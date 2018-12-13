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

public class NotInitializedDatasetEntity extends DatasetEntity {

    private static final long serialVersionUID = 3447190730799856292L;

    @Override
    public void setFirstObservation(DataEntity<?> observation) {
        // TODO Auto-generated method stub

    }

    @Override
    public void setLastObservation(DataEntity<?> observation) {
        // TODO Auto-generated method stub

    }

    @Override
    public DataEntity<?> getFirstObservation() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public DataEntity<?> getLastObservation() {
        // TODO Auto-generated method stub
        return null;
    }

    public Long getUnitId() {
        return getUnit() != null ? getUnit().getId() : null;
    }

    public void setUnitId(Long unitId) {
        // only required for Hibernate
    }

    public Long getFirstObservationId() {
        return getFirstObservation() != null ? getFirstObservation().getId() : null;
    }

    public void setFirstObservationId(Long firstObservationId) {
        // only required for Hibernate
    }

    public Long getLastObservationId() {
        return getLastObservation() != null ? getLastObservation().getId() : null;
    }

    public void setLastObservationId(Long lastObservationId) {
        // only required for Hibernate
    }

}
