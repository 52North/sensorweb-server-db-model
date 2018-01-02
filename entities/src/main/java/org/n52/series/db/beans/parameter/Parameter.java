/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.parameter;

import java.util.HashMap;
import java.util.Map;

import org.n52.series.db.beans.IdEntity;

public abstract class Parameter<T> extends IdEntity implements ValuedParameter<T, Parameter<T>> {

    private static final long serialVersionUID = -1489503368673412638L;

    private String name;

    private T value;

    public Map<String, Object> toValueMap(String locale) {
        Map<String, Object> valueMap = new HashMap<>();
        valueMap.put("name", getName());
        valueMap.put("value", getValue());
        return valueMap;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Parameter<T> setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public boolean isSetName() {
        return getName() != null && !getName().isEmpty();
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public boolean isSetValue() {
        return getValue() != null;
    }

}
