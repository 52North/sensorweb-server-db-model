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
package org.n52.series.db.beans.parameter.procedure;

import org.n52.series.db.beans.ProcedureEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.ParameterFactory;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class ProcedureParameterEntity<T> extends ParameterEntity<T>
    implements ParameterFactory<ProcedureParameterEntity<?>> {

    public static final String PROP_PROCEDURE = "procedure";
    public static final String PROP_PROCEDURE_ID = "procedureId";

    private ProcedureEntity procedure;
    private long procedureId;

    public ProcedureParameterEntity<?> from(ParameterType type) {
        switch (type) {
            case JSON:
                return new ProcedureJsonParameterEntity();
            case XML:
                return new ProcedureXmlParameterEntity();
            case TEXT:
                return new ProcedureTextParameterEntity();
            case BOOLEAN:
                return new ProcedureBooleanParameterEntity();
            case CATEGORY:
                return new ProcedureCategoryParameterEntity();
            case COUNT:
                return new ProcedureCountParameterEntity();
            case QUANTITY:
                return new ProcedureQuantityParameterEntity();
            default:
                return null;
        }
    }

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
}
