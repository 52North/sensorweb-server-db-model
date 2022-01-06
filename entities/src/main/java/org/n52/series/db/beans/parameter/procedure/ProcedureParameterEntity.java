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
package org.n52.series.db.beans.parameter.procedure;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.ProcedureEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class ProcedureParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_PROCEDURE = "procedure";
    public static final String PROP_PROCEDURE_ID = "procedureId";
    private static final long serialVersionUID = -3203271103169023133L;
    private ProcedureEntity procedure;
    private long procedureId;

    public ProcedureEntity getProcedure() {
        return procedure;
    }

    public void setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
    }

    public long getProcedureId() {
        return procedureId;
    }

    public void setProcedureId(long procedureId) {
        this.procedureId = procedureId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setProcedure((ProcedureEntity) entity);
    }
}
