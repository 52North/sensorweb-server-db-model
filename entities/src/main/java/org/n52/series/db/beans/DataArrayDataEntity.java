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

import java.util.Set;
import java.util.TreeSet;

public class DataArrayDataEntity extends CompositeDataEntity {

    private static final long serialVersionUID = -1618516259763515255L;

    private ResultTemplateEntity resultTemplate;

    private String stringValue;

    /**
     * @return the resultTemplate
     */
    public ResultTemplateEntity getResultTemplate() {
        return resultTemplate;
    }

    /**
     * @param resultTemplate
     *            the resultTemplate to set
     */
    public void setResultTemplate(ResultTemplateEntity resultTemplate) {
        this.resultTemplate = resultTemplate;
    }

    public boolean isSetResultTemplate() {
        return getResultTemplate() != null;
    }

    @Override
    public Set<DataEntity<?>> getValue() {
        return super.getValue() != null ? new TreeSet<>(super.getValue()) : super.getValue();
    }

    @Override
    public void setValue(Set<DataEntity<?>> value) {
        super.setValue(value);
    }

    /**
     * @return the stringValue
     */
    public String getStringValue() {
        return stringValue;
    }

    /**
     * @param stringValue
     *            the stringValue to set
     */
    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public boolean isSetStringValue() {
        return getStringValue() != null && !getStringValue().isEmpty();
    }

}
