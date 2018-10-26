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

package org.n52.series.db.beans.sta;

import java.io.Serializable;
import java.util.Set;

import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;

import com.vividsolutions.jts.geom.Geometry;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class LocationEntity extends AbstractNameDescriptionStaEntity
        implements Serializable, HasGeometry {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";

    private static final long serialVersionUID = -8201429072560300649L;

    private String location;
    private GeometryEntity geometryEntity;
    private LocationEncodingEntity locationEncoding;
    private Set<ThingEntity> thingEntities;
    private Set<HistoricalLocationEntity> historicalLocationEntities;

    public LocationEncodingEntity getLocationEncoding() {
        return locationEncoding;
    }

    public void setLocationEncoding(LocationEncodingEntity locationEncoding) {
        this.locationEncoding = locationEncoding;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean hasLocation() {
        return getLocation() != null && !getLocation().isEmpty();
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

    public Set<ThingEntity> getThingEntities() {
        return thingEntities;
    }

    public void setThingEntities(Set<ThingEntity> thingEntities) {
        this.thingEntities = thingEntities;
    }

    public boolean hasThings() {
        return getThingEntities() != null && !getThingEntities().isEmpty();
    }

    public Set<HistoricalLocationEntity> getHistoricalLocationEntities() {
        return historicalLocationEntities;
    }

    public void setHistoricalLocationEntities(Set<HistoricalLocationEntity> historicalLocationEntities) {
        this.historicalLocationEntities = historicalLocationEntities;
    }

}
