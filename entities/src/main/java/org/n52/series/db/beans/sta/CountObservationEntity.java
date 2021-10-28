/*
 * Copyright 2015-2021 52°North Spatial Information Research GmbH
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

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Represents an STA Observation with ValueType Quantity. For more information
 *
 * @see ObservationEntity
 *
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@DiscriminatorValue("count")
public class CountObservationEntity extends ObservationEntity<Integer> {

    private static final long serialVersionUID = -5135462531107840141L;

    @Column(name = "value_count")
    private Integer value;

    @Override
    public CountObservationEntity setValue(Integer value) {
        this.value = value;
        return this;
    }

    @Override
    public Integer getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}
