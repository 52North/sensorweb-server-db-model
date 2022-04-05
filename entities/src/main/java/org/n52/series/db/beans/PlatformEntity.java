/*
 * Copyright 2015-2022 52°North Spatial Information Research GmbH
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

import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.sta.HistoricalLocationEntity;
import org.n52.series.db.beans.sta.LocationEntity;
import org.n52.series.db.beans.sta.plus.PartyEntity;
import org.n52.series.db.beans.sta.StaRelations.HasLocations;

import java.util.LinkedHashSet;
import java.util.Set;

public class PlatformEntity extends DescribableEntity implements HasLocations, IsStaEntity,
        HibernateRelations.HasAbstractDatasets, HibernateRelations.IsProcessed, HibernateRelations.HasParameters {

    public static final String PROPERTY_LOCATIONS = "locations";
    public static final String PROPERTY_HISTORICAL_LOCATIONS = "historicalLocations";
    public static final String PROPERTY_DATASETS = "datasets";
    public static final String PROPERTY_PARTY = "party";
    private static final long serialVersionUID = 3615089936334873353L;

    private Set<LocationEntity> locations;
    private Set<HistoricalLocationEntity> historicalLocations;
    private Set<AbstractDatasetEntity> datasets;
    private PartyEntity party;
    private boolean processed;

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

    public boolean hasHistoricalLocations() {
        return getHistoricalLocations() != null && !getHistoricalLocations().isEmpty();
    }

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public void setProcessed(boolean processsed) {
        this.processed = processsed;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public Set<LocationEntity> getLocations() {
        return locations;
    }

    @Override
    public void setLocations(Set<LocationEntity> locations) {
        this.locations = locations;
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> observations) {
        this.datasets = observations;
    }

    public PartyEntity getParty() {
        return party;
    }

    public void setParty(PartyEntity party) {
        this.party = party;
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
