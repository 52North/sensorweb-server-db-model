/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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

import org.n52.series.db.beans.HibernateRelations.HasDatasets;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.AbstractStaEntity;
import org.n52.series.db.beans.sta.DatastreamEntity;
import org.n52.series.db.beans.sta.HistoricalLocationEntity;
import org.n52.series.db.beans.sta.LocationEntity;
import org.n52.series.db.beans.sta.StaRelations.Locations;

public class PlatformEntity extends DescribableEntity
        implements AbstractStaEntity, Locations<PlatformEntity>, HasDatasets, IsStaEntity {

    public static final String PROPERTY_LOCATIONS = "locations";
    public static final String PROPERTY_PROPERTIES = "properties";
    public static final String PROPERTY_HISTORICAL_LOCATIONS = "historicalLocations";
    public static final String PROPERTY_DATASTREAMS = "datastreams";

    private static final long serialVersionUID = 3615089936334873353L;

    private String properties;
    private Set<ParameterEntity<?>> parameters;
    private Set<LocationEntity> locations;
    private Set<HistoricalLocationEntity> historicalLocations;
    private Set<DatastreamEntity> datastreams;
    private Set<DatasetEntity> datasets;
    private boolean processed;

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
    public Set<LocationEntity> getLocations() {
        return locations;
    }

    @Override
    public PlatformEntity setLocations(Set<LocationEntity> locations) {
        this.locations = locations;
        return this;
    }

    public Set<HistoricalLocationEntity> getHistoricalLocations() {
        return historicalLocations;
    }

    public PlatformEntity setHistoricalLocations(Set<HistoricalLocationEntity> historicalLocations) {
        this.historicalLocations = historicalLocations;
        return this;
    }

    public PlatformEntity addHistoricalLocation(HistoricalLocationEntity historicalLocation) {
        if (historicalLocations == null) {
            historicalLocations = new LinkedHashSet<>();
        }
        historicalLocations.add(historicalLocation);
        return this;
    }

    public Set<DatastreamEntity> getDatastreams() {
        return datastreams;
    }

    public PlatformEntity setDatastreams(Set<DatastreamEntity> datastreams) {
        this.datastreams = datastreams;
        return this;
    }

    public boolean hasDatastreams() {
        return getDatastreams() != null && !getDatastreams().isEmpty();
    }

    public boolean hasHistoricalLocations() {
        return getHistoricalLocations() != null && !getHistoricalLocations().isEmpty();
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public AbstractStaEntity setProcessed(boolean processsed) {
        this.processed = processsed;
        return this;
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