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

package org.n52.series.db.beans.i18n;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.IdEntity;

public class I18nEntity<T extends DescribableEntity> extends IdEntity {

    public static final String PROPERTY_LOCALE = "locale";

    private static final long serialVersionUID = 693520332508628558L;

    private T entity;

    private String locale;

    private String name;

    private String shortName;

    private String longName;

    private String description;

    public T getEntity() {
        return entity;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean hasName() {
        return getName() != null && !getName().isEmpty();
    }

    public boolean hasDescription() {
        return getDescription() != null && !getDescription().isEmpty();
    }

    public boolean hasLongName() {
        return getLongName() != null && !getLongName().isEmpty();
    }

    public boolean hasShortName() {
        return getShortName() != null && !getShortName().isEmpty();
    }
}
