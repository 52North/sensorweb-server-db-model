/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
import java.util.LinkedHashSet;
import java.util.Set;

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.FormatEntity;
import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.PlatformEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class LocationEntity extends StaDescribableEntity implements Serializable, HasGeometry<LocationEntity> {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";
    public static final String PROPERTY_LOCATION_ENCODINT = "locationEncoding";

    private static final long serialVersionUID = -8201429072560300649L;

    private String identifier;
    private String location;
    private GeometryEntity geometryEntity;
    private FormatEntity locationEncoding;
    private Set<PlatformEntity> things;
    private Set<HistoricalLocationEntity> historicalLocations;

    public FormatEntity getLocationEncoding() {
        return locationEncoding;
    }

    public LocationEntity setLocationEncoding(FormatEntity locationEncoding) {
        this.locationEncoding = locationEncoding;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public LocationEntity setLocation(String location) {
        this.location = location;
        return this;
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

    public Set<PlatformEntity> getThings() {
        return things;
    }

    public LocationEntity setThings(Set<PlatformEntity> thingEntities) {
        this.things = thingEntities;
        return this;
    }

    public boolean hasThings() {
        return getThings() != null && !getThings().isEmpty();
    }

    public Set<HistoricalLocationEntity> getHistoricalLocations() {
        return historicalLocations;
    }

    public LocationEntity setHistoricalLocations(Set<HistoricalLocationEntity> historicalLocationEntities) {
        this.historicalLocations = historicalLocationEntities;
        return this;
    }

    public LocationEntity addHistoricalLocation(HistoricalLocationEntity historicalLocationEntity) {
        if (historicalLocations == null) {
            historicalLocations = new LinkedHashSet<>();
        }
        historicalLocations.add(historicalLocationEntity);
        return this;
    }

    public boolean hasHistoricalLocations() {
        return getHistoricalLocations() != null && !getHistoricalLocations().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof LocationEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
