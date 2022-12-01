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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class LicenseEntity extends DescribableEntity implements Serializable, HibernateRelations.HasName,
        HibernateRelations.HasDescription, HibernateRelations.HasDatasets {
    private static final long serialVersionUID = -1938665500675268434L;

    private String logo;
    private Set<DatasetEntity> datasets;
    private Set<GroupEntity> groups;

    public String getDefinition() {
        return getIdentifier();
    }

    public LicenseEntity setDefinition(String definition) {
        setIdentifier(definition);
        return this;
    }

    public String getLogo() {
        return logo;
    }

    public LicenseEntity setLogo(String logo) {
        this.logo = logo;
        return this;
    }

    public boolean isSetLogo() {
        return getLogo() != null && !getLogo().isEmpty();
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public boolean isSeRelationps() {
        return getGroups() != null && !getGroups().isEmpty();
    }

}
