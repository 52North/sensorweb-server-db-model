/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.parameter.phenomenon;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.PhenomenonEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public abstract class PhenomenonParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_PHENOMENON = "phenomenon";
    public static final String PROP_PHENOMENON_ID = "phenomenonId";
    private static final long serialVersionUID = 5234864540316301294L;
    private PhenomenonEntity phenomenon;
    private Long phenomenonId;

    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    public void setPhenomenon(PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
    }

    public Long getPhenomenonId() {
        return phenomenonId;
    }

    public void setPhenomenonId(Long observationId) {
        this.phenomenonId = observationId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setPhenomenon((PhenomenonEntity) entity);
    }
}
