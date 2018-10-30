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

public class UnitEntity extends DescribableEntity {

    public static final String PROPERTY_UNIT = PROPERTY_IDENTIFIER;
    public static final String PROPERTY_SYMBOL = PROPERTY_IDENTIFIER;
    private static final long serialVersionUID = -7512483445911729980L;

    private String link;

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }

    public boolean isSetLink() {
        return getLink() != null && !getLink().isEmpty();
    }

    // TODO SOS compatible
    public String getUnit() {
        return getIdentifier();
    }

    public void setUnit(String unit) {
        setIdentifier(unit);
    }

    public String getSymbol() {
        return getIdentifier();
    }

    public void setSymbol(String symbol) {
        setIdentifier(symbol);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UnitEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
