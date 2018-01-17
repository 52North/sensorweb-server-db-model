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

import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasXml;

import com.vividsolutions.jts.geom.Geometry;

public abstract class AbstractFeatureEntity<E> extends HierarchicalEntity<E>
        implements HasXml<AbstractFeatureEntity<E>>, HasGeometry<AbstractFeatureEntity<E>> {

    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";
    public static final String PROPERTY_GEOMETRY_ENTITY_GEOMETRY = PROPERTY_GEOMETRY_ENTITY + ".geometry";
    public static final String PROPERTY_GEOMETRY_ENTITY_LAT = PROPERTY_GEOMETRY_ENTITY + ".lat";
    public static final String PROPERTY_GEOMETRY_ENTITY_LON = PROPERTY_GEOMETRY_ENTITY + ".lon";

    private static final long serialVersionUID = 6712642995944229067L;

    private GeometryEntity geometryEntity;
    private FormatEntity featureType;
    private String url;
    private String xml;

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public AbstractFeatureEntity<E> setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        this.geometryEntity.setSrid(geometry.getSRID());
        return this;
    }

    public AbstractFeatureEntity<E> setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
        return this;
    }

    @Override
    public String getXml() {
        return xml;
    }

    @Override
    public AbstractFeatureEntity<E> setXml(String xml) {
        this.xml = xml;
        return this;
    }

    public FormatEntity getFeatureType() {
        return featureType;
    }

    public AbstractFeatureEntity<E> setFeatureType(FormatEntity featureType) {
        this.featureType = featureType;
        return this;
    }

    public boolean isSetFeatureType() {
        return getFeatureType() != null;
    }

    public String getUrl() {
        return url;
    }

    public AbstractFeatureEntity<E> setUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isSetUrl() {
        return getUrl() != null && !getUrl().isEmpty();
    }

}
