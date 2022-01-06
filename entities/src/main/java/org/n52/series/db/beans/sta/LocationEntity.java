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

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.FormatEntity;
import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.PlatformEntity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class LocationEntity extends DescribableEntity implements Serializable, HasGeometry, HibernateRelations.HasName,
        HibernateRelations.HasDescription, HibernateRelations.IsProcessed {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";
    public static final String PROPERTY_LOCATION_ENCODINT = "locationEncoding";

    private static final long serialVersionUID = -8201429072560300649L;

    private String location;
    private GeometryEntity geometryEntity;
    private FormatEntity locationEncoding;
    private Set<PlatformEntity> platforms;
    private Set<HistoricalLocationEntity> historicalLocations;
    private boolean processed;

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
    public void setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        this.geometryEntity.setSrid(geometry.getSRID());
    }

    @Override
    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public Set<PlatformEntity> getPlatforms() {
        return platforms;
    }

    public LocationEntity setPlatforms(Set<PlatformEntity> platformEntities) {
        this.platforms = platformEntities;
        return this;
    }

    public boolean hasPlatforms() {
        return getPlatforms() != null && !getPlatforms().isEmpty();
    }

    @Deprecated
    public Set<PlatformEntity> getThings() {
        return getPlatforms();
    }

    @Deprecated
    public LocationEntity setThings(Set<PlatformEntity> platformEntities) {
        return setPlatforms(platformEntities);
    }

    @Deprecated
    public boolean hasThings() {
        return hasPlatforms();
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

    @Override
    public boolean isProcessed() {
        return this.processed;
    }

    @Override
    public void setProcessed(boolean processsed) {
        this.processed = processsed;
    }
}
