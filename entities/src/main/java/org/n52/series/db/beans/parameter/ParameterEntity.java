/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.IdEntity;

public abstract class ParameterEntity<T> extends IdEntity implements ValuedParameter<T> {

    public static final String PROPERTY_PARENT = "parent";

    private static final long serialVersionUID = -1489503368673412638L;
    private String name;
    private String description;
    private Date lastUpdate;
    private String domain;
    private Long parent;
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
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean isSetName() {
        return getName() != null && !getName().isEmpty();
    }

    public Date getLastUpdate() {
        return lastUpdate != null ? new Timestamp(lastUpdate.getTime()) : null;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate != null ? new Timestamp(lastUpdate.getTime()) : null;
    }

    public boolean isSetLastUpdate() {
        return getLastUpdate() != null;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public boolean isSetDomain() {
        return getDomain() != null && !getDomain().isEmpty();
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public boolean hasParent() {
        return getParent() != null;
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

    public abstract void setDescribeableEntity(DescribableEntity entity);

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getValueAsString(), getDomain(), getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ParameterEntity)) {
            return false;
        }
        return super.equals(obj) && Objects.equals(getValueAsString(), ((ParameterEntity<?>) obj).getValueAsString())
                && Objects.equals(getDomain(), ((ParameterEntity<?>) obj).getDomain())
                && Objects.equals(getName(), ((ParameterEntity<?>) obj).getName())
                && Objects.equals(getValueAsString(), ((ParameterEntity<?>) obj).getValueAsString());
    }
}
