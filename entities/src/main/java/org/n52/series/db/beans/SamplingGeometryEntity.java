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
package org.n52.series.db.beans;

import java.util.Date;

import org.n52.series.db.common.Utils;

public class SamplingGeometryEntity extends IdEntity {

    private static final long serialVersionUID = -3036211037882973515L;

    private Date timestamp;

    private GeometryEntity geometryEntity;

    private DatasetEntity dataset;

    public Date getTimestamp() {
        return Utils.createUnmutableTimestamp(timestamp);
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = Utils.createUnmutableTimestamp(timestamp);
    }

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public DatasetEntity getDataset() {
        return dataset;
    }

    public void setDataset(DatasetEntity dataset) {
        this.dataset = dataset;
    }
}
