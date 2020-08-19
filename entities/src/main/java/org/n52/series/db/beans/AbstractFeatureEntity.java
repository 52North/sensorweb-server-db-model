/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasXml;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;

public abstract class AbstractFeatureEntity<E> extends HierarchicalEntity<E>
        implements HasXml, HasGeometry, IsStaEntity {

    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";
    public static final String PROPERTY_GEOMETRY = "geometry";
    public static final String PROPERTY_GEOMETRY_ENTITY_GEOMETRY = PROPERTY_GEOMETRY_ENTITY + "." + GEOMETRY;
    public static final String PROPERTY_GEOMETRY_ENTITY_LAT = PROPERTY_GEOMETRY_ENTITY + ".lat";
    public static final String PROPERTY_GEOMETRY_ENTITY_LON = PROPERTY_GEOMETRY_ENTITY + ".lon";
    public static final String PROPERTY_FEATURE_TYPE = "featureType";

    private static final long serialVersionUID = 6712642995944229067L;
    private GeometryEntity geometryEntity;
    private FormatEntity featureType;
    private String url;
    private String xml;

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public void setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        if (geometry != null) {
            this.geometryEntity.setSrid(geometry.getSRID());
        }
    }

    @Override
    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    @Override
    public String getXml() {
        return xml;
    }

    @Override
    public void setXml(String xml) {
        this.xml = xml;
    }

    public FormatEntity getFeatureType() {
        return featureType;
    }

    public void setFeatureType(FormatEntity featureType) {
        this.featureType = featureType;
    }

    public boolean isSetFeatureType() {
        return getFeatureType() != null && getFeatureType().isSetFormat();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isSetUrl() {
        return (getUrl() != null) && !getUrl().isEmpty();
    }

}
