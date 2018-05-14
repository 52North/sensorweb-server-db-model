/*
 * Copyright 2018 52°North Initiative for Geospatial Open Source Software GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.n52.series.db.beans.sta;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import java.util.Set;
import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations.HasDescription;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasName;
import org.n52.series.db.beans.IdEntity;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class LocationEntity extends IdEntity
        implements Serializable, HasName, HasDescription, HasGeometry<LocationEntity> {

    private static final long serialVersionUID = -8201429072560300649L;

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";

    private String name;
    private String description;
    private GeometryEntity geometryEntity;
    private Set<LocationEncodingEntity> locationEncodings;

    public Set<LocationEncodingEntity> getLocationEncodings() {
        return locationEncodings;
    }

    public void setLocationEncodings(Set<LocationEncodingEntity> locationEncodings) {
        this.locationEncodings = locationEncodings;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public LocationEntity setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        this.geometryEntity.setSrid(geometry.getSRID());
        return this;
    }

    @Override
    public LocationEntity setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
        return this;
    }

}
