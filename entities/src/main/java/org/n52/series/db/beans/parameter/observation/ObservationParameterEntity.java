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
package org.n52.series.db.beans.parameter.observation;

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public abstract class ObservationParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_OBSERVATION = "observation";
    public static final String PROP_OBSERVATION_ID = "observationId";
    private static final long serialVersionUID = -3170715124801725482L;
    private DataEntity observation;
    private Long observationId;

    public DataEntity getObservation() {
        return observation;
    }

    public void setObservation(DataEntity observation) {
        this.observation = observation;
    }

    public Long getObservationId() {
        return observationId;
    }

    public void setObservationId(Long observationId) {
        this.observationId = observationId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setObservation((DataEntity) entity);
    }
}
