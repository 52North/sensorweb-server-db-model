/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.PlatformEntity;
import org.n52.series.db.beans.sta.StaRelations.Locations;
import org.n52.series.db.common.Utils;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class HistoricalLocationEntity extends IdEntity
        implements AbstractStaEntity, Serializable, Locations<HistoricalLocationEntity> {

    public static final String PROPERTY_IDENTIFIER = "identifier";
    public static final String PROPERTY_TIME = "time";
    public static final String PROPERTY_LOCATIONS = "locations";
    public static final String PROPERTY_THING = "thing";

    private static final long serialVersionUID = 5564686026419270062L;

    private String identifier;

    private Date time;

    private Set<LocationEntity> locationEntities;

    private PlatformEntity thingEntity;

    private boolean processed;

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Date getTime() {
        return Utils.createUnmutableTimestamp(time);
    }

    public HistoricalLocationEntity setTime(Date time) {
        this.time = Utils.createUnmutableTimestamp(time);
        return this;
    }

    @Override
    public Set<LocationEntity> getLocations() {
        return locationEntities;
    }

    @Override
    public HistoricalLocationEntity setLocations(Set<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
        return this;
    }

    public PlatformEntity getThing() {
        return thingEntity;
    }

    public HistoricalLocationEntity setThing(PlatformEntity thingEntity) {
        this.thingEntity = thingEntity;
        return this;
    }

    public boolean hasThing() {
        return thingEntity != null;
    }

    @Override
    public boolean isProcesssed() {
        return processed;
    }

    @Override
    public AbstractStaEntity setProcesssed(boolean processsed) {
        this.processed = processsed;
        return this;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTime(), getThing());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IdEntity)) {
            return false;
        }
        HistoricalLocationEntity other = (HistoricalLocationEntity) obj;
        return super.equals(other) && Objects.equals(identifier, other.getIdentifier())
                && Objects.equals(getTime(), other.getTime()) && Objects.equals(getThing(), other.getThing());
    }

}
