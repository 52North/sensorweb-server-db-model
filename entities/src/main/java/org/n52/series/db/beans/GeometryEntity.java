/*
 * Copyright (C) 2015-2021 52°North Spatial Information Research GmbH
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

import java.io.Serializable;

import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.GeometryFactory;

public class GeometryEntity implements Serializable {

    public static final String PROPERTY_GEOMETRY = "geometry";
    public static final String PROPERTY_LAT = "lat";
    public static final String PROPERTY_LON = "lon";
    public static final String PROPERTY_ALT = "alt";
    public static final String PROPERTY_SRID = "srid";

    private static final long serialVersionUID = -1411829809704409439L;

    private static final int DEFAULT_SRID = 4326;

    private GeometryFactory geometryFactory;

    private Geometry geometry;

    private Double lon;

    private Double lat;

    private Double alt;

    private int srid;

    public boolean isSetGeometry() {
        return (geometry != null) && !geometry.isEmpty();
    }

    public void setGeometry(final Geometry geometry) {
        this.geometry = geometry;
    }

    /**
     * Returns the {@link Geometry} or creates a {@link Geometry} with the given srid in case of geometry has
     * been set via lat/lon.
     *
     * @return the geometry or a created geometry (with given srid)
     */
    public Geometry getGeometry() {
        Geometry builtGeometry = isSetLonLat() ? createPoint() : geometry;
        return builtGeometry;
    }

    private Geometry createPoint() {
        Coordinate coordinate =
                (alt != null) && !alt.isNaN() ? new Coordinate(lon, lat, alt) : new Coordinate(lon, lat);
        return getGeometryFactory().createPoint(coordinate);
    }

    public boolean isSetLonLat() {
        return (lon != null) && (lat != null);
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(final Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(final Double lat) {
        this.lat = lat;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(final Double alt) {
        this.alt = alt;
    }

    public int getSrid() {
        return srid;
    }

    public GeometryEntity setSrid(final int srid) {
        this.srid = srid;
        return this;
    }

    public boolean isEmpty() {
        return !isSetGeometry() && !isSetLonLat();
    }

    public GeometryFactory getGeometryFactory() {
        return geometryFactory;
    }

    public void setGeometryFactory(GeometryFactory geometryFactory) {
        this.geometryFactory = geometryFactory;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" latitude: ").append(getLat())
                .append(", longitude: ").append(getLon()).append(" ]").toString();
    }

}
