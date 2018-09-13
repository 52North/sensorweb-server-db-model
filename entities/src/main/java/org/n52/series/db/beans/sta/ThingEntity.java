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

import java.io.Serializable;
import java.util.Set;
import org.n52.series.db.beans.HibernateRelations.HasDescription;
import org.n52.series.db.beans.HibernateRelations.HasName;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class ThingEntity extends AbstractStaEntity implements Serializable, HasName, HasDescription {

    private static final long serialVersionUID = -6769297522935770467L;

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_PROPERTIES = "properties";
    public static final String PROPERTY_LOCATION = "location";
    public static final String PROPERTY_HISTORICAL_LOCATIONS = "historicalLocations";

    private String name;
    private String description;
    private String properties;
    private Set<LocationEntity> locationEntities;
    private Set<HistoricalLocationEntity> historicalLocationEntities;
    private Set<DatastreamEntity> datastreamEntities;

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

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getProperties() {
        return properties;
    }

    public Set<LocationEntity> getLocationEntities() {
        return locationEntities;
    }

    public void setLocationEntities(Set<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
    }

    public Set<HistoricalLocationEntity> getHistoricalLocationEntities() {
        return historicalLocationEntities;
    }

    public void setHistoricalLocationEntities(Set<HistoricalLocationEntity> historicalLocationEntities) {
        this.historicalLocationEntities = historicalLocationEntities;
    }

    public Set<DatastreamEntity> getDatastreamEntities() {
        return datastreamEntities;
    }

    public void setDatastreamEntities(Set<DatastreamEntity> datastreamEntities) {
        this.datastreamEntities = datastreamEntities;
    }

}
