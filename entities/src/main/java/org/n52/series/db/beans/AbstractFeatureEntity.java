/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
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

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.HibernateRelations.HasDatasets;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasXml;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public abstract class AbstractFeatureEntity<E> extends HierarchicalEntity<E>
        implements HasXml, HasGeometry, HasDatasets, IsStaEntity {

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
    private Set<DatasetEntity> datasets;
    private Set<DataEntity<?>> observations;

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
        return getUrl() != null && !getUrl().isEmpty();
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
    }

    public Set<DataEntity<?>> getObservations() {
        return observations != null ? observations
                : getDatasets().stream().flatMap(d -> d.getObservations().stream()).collect(Collectors.toSet());
    }

    public AbstractFeatureEntity<E> setObservations(Set<DataEntity<?>> observations) {
        this.observations = observations;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Objects.hash(observations));
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof AbstractFeatureEntity && super.equals(obj)
                && Objects.hash(observations) == Objects.hash(((AbstractFeatureEntity) obj).getObservations());
    }
}
