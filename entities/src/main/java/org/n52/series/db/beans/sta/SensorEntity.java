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

import org.n52.series.db.beans.ProcedureEntity;
import org.n52.series.db.beans.sta.StaRelations.Datastreams;

public class SensorEntity extends ProcedureEntity implements Datastreams<SensorEntity> {

    private static final long serialVersionUID = -8010667038475754604L;
    private final ProcedureEntity procedure;
    private Set<DatastreamEntity> datastreams;

    public SensorEntity() {
        this.procedure = new ProcedureEntity();
    }

    public SensorEntity(ProcedureEntity procedure) {
        this.procedure = procedure;
        setId(procedure.getId());
        setIdentifier(procedure.getIdentifier());
        setStaIdentifier(procedure.getStaIdentifier());
        setName(procedure.getName());
        setDescription(procedure.getDescription());
        setDescriptionFile(procedure.getDescriptionFile());
        setFormat(procedure.getFormat());
        setProcedureHistory(procedure.getProcedureHistory());
    }

    @Override
    public SensorEntity setDatastreams(Set<DatastreamEntity> datastreams) {
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

    public ProcedureEntity asProcedureEntity() {
        procedure.setId(getId());
        procedure.setIdentifier(getIdentifier());
        procedure.setStaIdentifier(getStaIdentifier());
        procedure.setName(getName());
        procedure.setDescription(getDescription());
        procedure.setFormat(getFormat());
        procedure.setDescriptionFile(getDescriptionFile());
        procedure.setProcedureHistory(getProcedureHistory());
        return procedure;
    }
}
