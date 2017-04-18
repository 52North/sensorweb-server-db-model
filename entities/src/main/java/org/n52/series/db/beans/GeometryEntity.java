/*
 * Copyright (C) 2015-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public License
 * version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */

package org.n52.series.db.beans;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;

/**
 * TODO: JavaDoc
 *
 * @author <a href="mailto:h.bredel@52north.org">Henning Bredel</a>
 */
public class GeometryEntity {

    public static final String PROPERTY_GEOMETRY = "geometry";

    public GeometryFactory geometryFactory;

    private Geometry geometry;

    private Double lon;

    private Double lat;

    private Double alt;

    public boolean isSetGeometry() {
        return geometry != null && !geometry.isEmpty();
    }

    public GeometryEntity setGeometry(Geometry geometry) {
        this.geometry = geometry;
        return this;
    }

    /**
     * Returns the {@link Geometry} or creates a {@link Geometry} with the given srid in case of geometry has
     * been set via lat/lon.
     *
     * @return the geometry or a created geometry (with given srid)
     */
    public Geometry getGeometry() {
        Geometry builtGeometry = isSetLonLat()
                ? createPoint()
                : geometry;
        return builtGeometry;
    }

    private Geometry createPoint() {
        Coordinate coordinate = alt != null && !alt.isNaN()
                // XXX configure axis switch here
                ? new Coordinate(lon, lat, alt)
                : new Coordinate(lon, lat);
        return geometryFactory.createPoint(coordinate);
    }

    public boolean isSetLonLat() {
        return lon != null && lat != null;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getAlt() {
        return alt;
    }

    public void setAlt(Double alt) {
        this.alt = alt;
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
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName())
          .append(" [");
        sb.append(" latitude: ")
          .append(getLat());
        sb.append(", longitude: ")
          .append(getLon());
        return sb.append(" ]")
                 .toString();
    }

}
