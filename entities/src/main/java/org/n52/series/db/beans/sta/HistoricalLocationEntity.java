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
import java.util.Date;
import java.util.Set;

import org.n52.series.db.common.Utils;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class HistoricalLocationEntity extends AbstractStaEntity implements Serializable {

    public static final String PROPERTY_TIME = "time";

    private static final long serialVersionUID = 5564686026419270062L;

    private Date time;
    private Set<LocationEntity> locationEntities;
    private ThingEntity thingEntity;

    public Date getTime() {
        return Utils.createUnmutableTimestamp(time);
    }

    public void setTime(Date time) {
        this.time = Utils.createUnmutableTimestamp(time);
    }

    public Set<LocationEntity> getLocationEntities() {
        return locationEntities;
    }

    public void setLocationEntities(Set<LocationEntity> locationEntities) {
        this.locationEntities = locationEntities;
    }

    public ThingEntity getThingEntity() {
        return thingEntity;
    }

    public void setThingEntity(ThingEntity thingEntity) {
        this.thingEntity = thingEntity;
    }

}
