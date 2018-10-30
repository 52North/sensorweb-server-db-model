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
import java.util.LinkedHashSet;
import java.util.Set;

import org.n52.series.db.beans.sta.StaRelations.Locations;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ThingEntity extends AbstractNameDescriptionStaEntity implements Serializable, Locations<ThingEntity> {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_PROPERTIES = "properties";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_HISTORICAL_LOCATIONS = "historicalLocations";

    private static final long serialVersionUID = -6769297522935770467L;

    private String properties;
    private Set<LocationEntity> locationEntities;
    private Set<HistoricalLocationEntity> historicalLocationEntities;
    private Set<DatastreamEntity> datastreamEntities;

    public ThingEntity setProperties(String properties) {
        this.properties = properties;
        return this;
    }

    public String getProperties() {
        return properties;
    }

    public Set<LocationEntity> getLocationEntities() {
        return locationEntities;
    }

    public ThingEntity setLocationEntities(Set<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
        return this;
    }

    public Set<HistoricalLocationEntity> getHistoricalLocationEntities() {
        return historicalLocationEntities;
    }

    public ThingEntity setHistoricalLocationEntities(Set<HistoricalLocationEntity> historicalLocationEntities) {
        this.historicalLocationEntities = historicalLocationEntities;
        return this;
    }

    public ThingEntity addHistoricalLocation(HistoricalLocationEntity historicalLocationEntity) {
        if (historicalLocationEntities == null) {
            historicalLocationEntities = new LinkedHashSet<>();
        }
        historicalLocationEntities.add(historicalLocationEntity);
        return this;
    }

    public Set<DatastreamEntity> getDatastreamEntities() {
        return datastreamEntities;
    }

    public ThingEntity setDatastreamEntities(Set<DatastreamEntity> datastreamEntities) {
        this.datastreamEntities = datastreamEntities;
        return this;
    }

    public boolean hasDatastreamEntities() {
        return getDatastreamEntities() != null && !getDatastreamEntities().isEmpty();
    }

    public boolean hasHistoricalLocationEntities() {
        return getHistoricalLocationEntities() != null && !getHistoricalLocationEntities().isEmpty();
    }

    public boolean hasProperties() {
        return getProperties() != null && !getProperties().isEmpty();
    }

}
