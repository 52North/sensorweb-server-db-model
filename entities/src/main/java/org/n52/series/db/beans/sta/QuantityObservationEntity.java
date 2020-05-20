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

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

/**
 * Represents an STA Observation with ValueType Quantity. For more information
 *
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 * @see org.n52.series.db.beans.sta.ObservationEntity
 */
@Entity
@DiscriminatorValue("quantity")
public class QuantityObservationEntity extends ObservationEntity<BigDecimal> {

    private static final long serialVersionUID = -8508643177021481959L;

    @Column(name = "value_quantity")
    private BigDecimal value;

    @Override
    public QuantityObservationEntity setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    @Override
    public BigDecimal getValue() {
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
