/*
 * Copyright 2015-2021 52°North Spatial Information Research GmbH
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

import java.util.Objects;

import org.n52.series.db.beans.IdEntity;

public abstract class AbstractI18nEntity<T extends IdEntity> extends IdEntity {

    public static final String PROPERTY_LOCALE = "locale";
    public static final String PROPERTY_ENTITY = "entity";
    private static final long serialVersionUID = -5046004232290585428L;

    private T entity;

    private String locale;

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

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getLocale());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof AbstractI18nEntity)) {
            return false;
        }
        AbstractI18nEntity<?> other = (AbstractI18nEntity<?>) obj;
        return super.equals(obj) && Objects.equals(getLocale(), other.getLocale());
    }
}
