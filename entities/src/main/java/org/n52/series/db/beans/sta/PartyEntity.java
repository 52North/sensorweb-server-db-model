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

import java.io.Serializable;
import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.PlatformEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class PartyEntity extends DescribableEntity
        implements Serializable, HibernateRelations.HasName, HibernateRelations.HasDescription,
        HibernateRelations.HasDatasets, StaRelations.HasPlatforms<PartyEntity>, StaRelations.HasGroups<PartyEntity> {

    private static final long serialVersionUID = -7546755723749812564L;

    private RolePartyCode role = RolePartyCode.individual;

    private String displayName;
    private Set<DatasetEntity> datasets;
    private Set<PlatformEntity> platforms;
    private Set<GroupEntity> groups;

    public String getAuthId() {
        return getIdentifier();
    }

    public PartyEntity setAuthId(String authId) {
        setIdentifier(authId);
        return this;
    }

    public RolePartyCode getRole() {
        return role;
    }

    public PartyEntity setRole(RolePartyCode role) {
        this.role = role;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public PartyEntity setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    public boolean isSetDisplayName() {
        return getDisplayName() != null && !getDisplayName().isEmpty();
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public PartyEntity setPlatforms(Set<PlatformEntity> platforms) {
        this.platforms = platforms;
        return this;
    }

    @Override
    public Set<PlatformEntity> getPlatforms() {
        return platforms;
    }

    @Override
    public Set<GroupEntity> getGroups() {
        return groups;
    }

    @Override
    public PartyEntity setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
        return this;
    }

}
