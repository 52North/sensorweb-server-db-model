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

import java.util.Set;

import org.n52.series.db.beans.PhenomenonEntity;
import org.n52.series.db.beans.sta.StaRelations.Datastreams;

public class ObservablePropertyEntity extends PhenomenonEntity implements Datastreams<PhenomenonEntity> {

    private static final long serialVersionUID = -1903162304158931533L;
    private final PhenomenonEntity phenomenon;
    private Set<DatastreamEntity> datastreams;

    public ObservablePropertyEntity() {
        this.phenomenon = new PhenomenonEntity();
    }

    public ObservablePropertyEntity(PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
        setId(phenomenon.getId());
        setIdentifier(phenomenon.getIdentifier());
        setStaIdentifier(phenomenon.getStaIdentifier());
        setName(phenomenon.getName());
        setDescription(phenomenon.getDescription());
    }

    @Override
    public PhenomenonEntity setDatastreams(Set<DatastreamEntity> datastreams) {
        this.datastreams = datastreams;
        return this;
    }

    @Override
    public Set<DatastreamEntity> getDatastreams() {
        return datastreams;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public PhenomenonEntity asPhenomenonEntity() {
        phenomenon.setId(getId());
        phenomenon.setIdentifier(getIdentifier());
        phenomenon.setStaIdentifier(getStaIdentifier());
        phenomenon.setName(getName());
        phenomenon.setDescription(getDescription());
        return phenomenon;
    }

}
