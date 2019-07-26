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
package org.n52.series.db.beans.sta;

import java.util.LinkedHashSet;
import java.util.Set;

public interface StaRelations {

    interface Datastreams<T> {

        T setDatastreams(Set<DatastreamEntity> datastreams);

        Set<DatastreamEntity> getDatastreams();

        default void addDatastream(DatastreamEntity datastream) {
            if (getDatastreams() == null) {
                setDatastreams(new LinkedHashSet<>());
            }
            getDatastreams().add(datastream);
        }

        default boolean hasDatastreams() {
            return getDatastreams() != null && !getDatastreams().isEmpty();
        }

    }

    interface Datastream<T> {

        T setDatastream(DatastreamEntity datastreams);

        DatastreamEntity getDatastream();

        default boolean hasDatastream() {
            return getDatastream() != null;
        }

    }

    interface Locations<T> {

        T setLocations(Set<LocationEntity> Locations);

        Set<LocationEntity> getLocations();

        default void addLocationEntity(LocationEntity Location) {
            if (getLocations() == null) {
                setLocations(new LinkedHashSet<>());
            }
            getLocations().add(Location);
        }

        default boolean hasLocationEntities() {
            return getLocations() != null && !getLocations().isEmpty();
        }

    }

}
