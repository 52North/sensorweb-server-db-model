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

package org.n52.series.db.beans.parameter.dataset;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.n52.series.db.beans.parameter.BooleanParameterEntity;

import java.io.Serial;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity(name = "org.n52.series.db.beans.parameter.dataset.DatasetBooleanParameterEntity")
@DiscriminatorValue("bool")
public class DatasetBooleanParameterEntity extends DatasetParameterEntity<Boolean> implements BooleanParameterEntity {

    @Serial
    private static final long serialVersionUID = 3130389439734626025L;

    @Column(name = "value_boolean")
    private Boolean value;

    @Override
    public String getValueAsString() {
        return isSetValue() ? getValue().toString() : null;
    }

    @Override
    public Boolean getValue() {
        return value;
    }

    @Override
    public void setValue(Boolean value) {
        this.value = value;
    }
}
