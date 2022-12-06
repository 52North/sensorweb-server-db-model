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

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import org.n52.series.db.beans.PlatformEntity;
import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.HibernateRelations;

public interface StaRelations extends HibernateRelations {

    interface HasLocations<T> {

        T setLocations(Set<LocationEntity> locations);

        Set<LocationEntity> getLocations();

        @Deprecated
        default void addLocationEntity(LocationEntity location) {
            addLocation(location);
        }

        default void addLocation(LocationEntity location) {
            if (getLocations() == null) {
                setLocations(new LinkedHashSet<>());
            }
            getLocations().add(location);
        }

        @Deprecated
        default boolean hasLocationEntities() {
            return hasLocations();
        }

        default boolean hasLocations() {
            return getLocations() != null && !getLocations().isEmpty();
        }

    }

    interface HasHistoricalLocations<T> {

        String PROPERTY_HISTORICAL_LOCATIONS = "historicalLocations";

        T setHistoricalLocations(Set<HistoricalLocationEntity> historicalLocations);

        Set<HistoricalLocationEntity> getHistoricalLocations();

        default T addHistoricalLocation(HistoricalLocationEntity historicalLocation) {
            if (getHistoricalLocations() == null) {
                setHistoricalLocations(new LinkedHashSet<>());
            }
            getHistoricalLocations().add(historicalLocation);
            return (T) this;
        }

        default boolean hasHistoricalLocations() {
            return getHistoricalLocations() != null && !getHistoricalLocations().isEmpty();
        }

    }

    interface StaPlusTime<T> {

        T setCreationTime(Date creationTime);

        Date getCreationTime();

        default boolean isSetCreationTime() {
            return getCreationTime() != null;
        }

        T setRunTimeStart(Date runTimeStart);

        Date getRunTimeStart();

        default boolean isSetRunTimeSart() {
            return getRunTimeStart() != null;
        }

        T setRunTimeEnd(Date runTimeEnd);

        Date getRunTimeEnd();

        default boolean isSetRunTimeEnd() {
            return getRunTimeEnd() != null;
        }

    }

    interface HasPlatforms<T> {

        String PLATFORMS = "platforms";

        String PROPERTY_PLATFORMS = PLATFORMS;

        Set<PlatformEntity> getPlatforms();

        T setPlatforms(Set<PlatformEntity> platforms);

        default boolean hasPlatforms() {
            return getPlatforms() != null && !getPlatforms().isEmpty();
        }

    }

    interface HasGroups<T> {

        String GROUPS = "groups";

        String PROPERTY_GROUPS = GROUPS;

        Set<GroupEntity> getGroups();

        T setGroups(Set<GroupEntity> groups);

        default boolean hasRelations() {
            return getGroups() != null && !getGroups().isEmpty();
        }

    }

    interface HasLicense<T> {

        String LICENSE = "license";

        String PROPERTY_LICENSE = LICENSE;

        LicenseEntity getLicense();

        T setLicense(LicenseEntity license);

        default boolean isSetLicense() {
            return getLicense() != null;
        }
    }

    interface HasParty<T> {

        String PARTY = "party";

        String PROPERTY_PARTY = PARTY;

        PartyEntity getParty();

        T setParty(PartyEntity party);

        default boolean isSetParty() {
            return getParty() != null;
        }
    }

    interface HasRelation<T> {

        String PROPERTY_SUBJECTS = "subjects";

        String PROPERTY_OBJECTS = "objects";

        Set<DataEntity<?>> getSubjects();

        T setSubjects(Set<DataEntity<?>> subjects);

        Set<DataEntity<?>> getObjects();

        T setObjects(Set<DataEntity<?>> objects);

        default boolean isSetSubjects() {
            return getSubjects() != null && !getSubjects().isEmpty();
        }

        default boolean isSetParty() {
            return getObjects() != null && !getObjects().isEmpty();
        }
    }

}
