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

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.PlatformEntity;
import org.n52.series.db.beans.sta.StaRelations.HasLocations;
import org.n52.series.db.common.Utils;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class HistoricalLocationEntity extends DescribableEntity implements Serializable,
        HasLocations<HistoricalLocationEntity>, HibernateRelations.IsProcessed, HibernateRelations.HasThing {

    public static final String PROPERTY_IDENTIFIER = "identifier";
    public static final String PROPERTY_TIME = "time";
    public static final String PROPERTY_LOCATIONS = "locations";
    public static final String PROPERTY_PLATFORM = "platform";
    public static final String PROPERTY_THING = PROPERTY_PLATFORM;

    private static final long serialVersionUID = 5564686026419270062L;

    private Date time;

    private Set<LocationEntity> locationEntities;

    private PlatformEntity platformEntity;

    private boolean processed;

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

    @Override
    public PlatformEntity getPlatform() {
        return platformEntity;
    }

    @Override
    public void setPlatform(PlatformEntity platformEntity) {
        this.platformEntity = platformEntity;
    }

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getTime(), getPlatform());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IdEntity)) {
            return false;
        }
        HistoricalLocationEntity other = (HistoricalLocationEntity) obj;
        return super.equals(other) && Objects.equals(getTime(), other.getTime())
                && Objects.equals(getPlatform(), other.getPlatform());
    }

}
