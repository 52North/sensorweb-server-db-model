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

package org.n52.series.db.beans.parameter.observation;

import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.ObservationEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class ObservationParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_OBSERVATION = "observation";
    public static final String PROP_OBSERVATION_ID = "observationId";

    private ObservationEntity observation;
    private long observationId;

    public ObservationEntity getObservation() {
        return observation;
    }

    public void setObservation(ObservationEntity observation) {
        this.observation = observation;
    }

    public long getObservationId() {
        return observationId;
    }

    public void setObservationId(long observationId) {
        this.observationId = observationId;
    }
}