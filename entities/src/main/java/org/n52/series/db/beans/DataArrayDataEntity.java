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

package org.n52.series.db.beans;

import java.util.Set;

public class DataArrayDataEntity extends CompositeDataEntity {

    private static final long serialVersionUID = -1618516259763515255L;

    private String structure;

    private String encoding;

    @Override
    public Set<DataEntity<?>> getValue() {
        return super.getValue();
    }

    @Override
    public void setValue(Set<DataEntity<?>> value) {
        super.setValue(value);
    }

    /**
     * @return the structure
     */
    public String getStructure() {
        return structure;
    }

    /**
     * @param structure
     *            the structure to set
     */
    public void setStructure(String structure) {
        this.structure = structure;
    }

    /**
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * @param encoding
     *            the encoding to set
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

}
