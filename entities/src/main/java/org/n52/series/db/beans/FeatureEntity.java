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

import com.vividsolutions.jts.geom.Geometry;

public class FeatureEntity extends HierarchicalEntity<FeatureEntity> {

    private GeometryEntity geometryEntity;

    public Geometry getGeometry() {
        return geometryEntity != null
                ? geometryEntity.getGeometry()
                : null;
    }

    public void setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
    }

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public boolean isSetGeometry() {
        return geometryEntity != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
          .append(" [")
          .append(" Domain id: ")
          .append(getDomainId())
          .append(", service: ")
          .append(getService())
          .append(" ]")
          .toString();
    }

}
