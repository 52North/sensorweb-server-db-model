/*
 * Copyright (C) 2015-2021 52°North Spatial Information Research GmbH
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

public class I18nEntity<T extends DescribableEntity> extends AbstractI18nEntity<T> {

    public static final String PROPERTY_LOCALE = "locale";

    public static final String PROPERTY_ENTITY = "entity";

    private static final long serialVersionUID = 693520332508628558L;

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

}