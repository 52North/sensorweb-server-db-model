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
package org.n52.series.db.beans;

import java.util.Collection;

public class TextDataEntity extends DataEntity<String> {

    private static final long serialVersionUID = 4925354534934095827L;

    private String valueIdentifier;

    private String valueName;

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
}
