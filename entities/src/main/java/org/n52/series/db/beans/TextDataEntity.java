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
package org.n52.series.db.beans;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;

import java.io.Serial;
import java.util.Collection;

@Entity(name = "org.n52.series.db.beans.TextDataEntity")
@DiscriminatorValue("text")
public class TextDataEntity extends DataEntity<String> {

    @Serial
    private static final long serialVersionUID = 4925354534934095827L;

    @Column(name = "value_text")
    private String value;

    @Transient
    private String valueIdentifier;

    @Transient
    private String valueName;

    @Transient
    private String valueDescription;

    @Override
    public String getValueIdentifier() {
        return valueIdentifier;
    }

    @Override
    public void setValueIdentifier(String valueIdentifier) {
        this.valueIdentifier = valueIdentifier;
    }

    @Override
    public String getValueName() {
        return valueName;
    }

    @Override
    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public String getValueDescription() {
        return valueDescription;
    }

    @Override
    public void setValueDescription(String valueDescription) {
        this.valueDescription = valueDescription;
    }

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return getValue() == null ? false : noDataValues.contains(getValue());
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
