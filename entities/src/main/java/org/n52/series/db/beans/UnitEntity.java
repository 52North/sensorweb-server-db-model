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

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.io.Serial;

@Entity(name = "org.n52.series.db.beans.UnitEntity")
@Table(name = "unit", uniqueConstraints = @UniqueConstraint(name = "un_unit_symbol", columnNames = { "symbol" }))
// table comment: Storage of the units of measurement of the observation values. These may be °C or m as the
// unit for depth/height information.
@AttributeOverride(name = "id", column = @Column(name = "unit_id"))
@AttributeOverride(name = "identifier", column = @Column(name = "symbol"))
@AttributeOverride(name = "staIdentifier", column = @Column(name = "symbol", insertable = false, updatable = false))
@AttributeOverride(name = "description", column = @Column(name = "symbol", insertable = false, updatable = false))
public class UnitEntity extends DescribableEntity {

    public static final String PROPERTY_UNIT = PROPERTY_IDENTIFIER;
    public static final String PROPERTY_SYMBOL = PROPERTY_IDENTIFIER;
    @Serial
    private static final long serialVersionUID = -7512483445911729980L;

    @Column(name = "link")
    // @Comment("Link/reference to an external description of the unit, e.g. to a vocabulary..")
    private String link;

    @Column(name = "symbol", insertable = false, updatable = false)
    // @Comment("Link/reference to an external description of the unit, e.g. to a vocabulary..")
    private String symbol;

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link
     *            the link to set
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
        setIdentifier(unit, false);
    }

    public void setUnit(String unit, boolean staSupportsUrls) {
        setIdentifier(unit, staSupportsUrls);
    }

    public String getSymbol() {
        return getIdentifier();
    }

    public void setSymbol(String symbol) {
        setIdentifier(symbol, false);
    }

    public void setSymbol(String symbol, boolean staSupportsUrls) {
        setIdentifier(symbol, staSupportsUrls);
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
