/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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

import java.util.LinkedHashSet;
import java.util.Set;

import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.AbstractStaEntity;
import org.n52.series.db.beans.sta.DatastreamEntity;
import org.n52.series.db.beans.sta.HistoricalLocationEntity;
import org.n52.series.db.beans.sta.LocationEntity;
import org.n52.series.db.beans.sta.StaRelations.Locations;

public class PlatformEntity extends DescribableEntity implements AbstractStaEntity, Locations<PlatformEntity> {

    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_PROPERTIES = "properties";
    public static final String PROPERTY_HISTORICAL_LOCATIONS = "historicalLocations";

    private static final long serialVersionUID = 3615089936334873353L;

    private String properties;
    private Set<ParameterEntity<?>> parameters;
    private Set<LocationEntity> locationEntities;
    private Set<HistoricalLocationEntity> historicalLocationEntities;
    private Set<DatastreamEntity> datastreamEntities;

    public PlatformEntity setProperties(String properties) {
        this.properties = properties;
        return this;
    }

    public String getProperties() {
        return properties;
    }

    public boolean hasProperties() {
        return getProperties() != null && !getProperties().isEmpty();
    }

    @Override
    public Set<ParameterEntity<?>> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Set<ParameterEntity<?>> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean hasParameters() {
        return (getParameters() != null) && !getParameters().isEmpty();
    }

    @Override
    public Set<LocationEntity> getLocationEntities() {
        return locationEntities;
    }

    @Override
    public PlatformEntity setLocationEntities(Set<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
        return this;
    }

    public Set<HistoricalLocationEntity> getHistoricalLocationEntities() {
        return historicalLocationEntities;
    }

    public PlatformEntity setHistoricalLocationEntities(Set<HistoricalLocationEntity> historicalLocationEntities) {
        this.historicalLocationEntities = historicalLocationEntities;
        return this;
    }

    public PlatformEntity addHistoricalLocation(HistoricalLocationEntity historicalLocationEntity) {
        if (historicalLocationEntities == null) {
            historicalLocationEntities = new LinkedHashSet<>();
        }
        historicalLocationEntities.add(historicalLocationEntity);
        return this;
    }

    public Set<DatastreamEntity> getDatastreamEntities() {
        return datastreamEntities;
    }

    public PlatformEntity setDatastreamEntities(Set<DatastreamEntity> datastreamEntities) {
        this.datastreamEntities = datastreamEntities;
        return this;
    }

    public boolean hasDatastreamEntities() {
        return getDatastreamEntities() != null && !getDatastreamEntities().isEmpty();
    }

    public boolean hasHistoricalLocationEntities() {
        return getHistoricalLocationEntities() != null && !getHistoricalLocationEntities().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PlatformEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
