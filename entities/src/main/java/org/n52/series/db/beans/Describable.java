/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.n52.series.db.beans.HibernateRelations.HasId;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.parameter.Parameter;

public interface Describable extends IdentifierNameDescriptionEntity, HasId {

    Set<I18nEntity< ? extends Describable>> getTranslations();

    void setTranslations(Set<I18nEntity< ? extends Describable>> translations);

    Set<Parameter< ? >> getParameters();

    void setParameters(Set<Parameter< ? >> parameters);

    default boolean hasParameters() {
        return getParameters() != null && !getParameters().isEmpty();
    }

    default Set<Map<String, Object>> getMappedParameters(String locale) {
        return hasParameters()
                ? getParameters().stream()
                                 .map(e -> e.toValueMap(locale))
                                 .collect(Collectors.toSet())
                : null;
    }

    ServiceEntity getService();

    DescribableEntity setService(ServiceEntity service);

    String getNameI18n(String locale);

    default String getLabelFrom(String locale) {
        if (isi18nNameAvailable(locale)) {
            return getNameI18n(locale);
        } else if (isNameAvailable()) {
            return getName();
        } else if (isDomainAvailable()) {
            return getDomain();
        } else {
            // absolute fallback
            return Long.toString(getId());
        }
    }

    default boolean isNameAvailable() {
        return getName() != null && !getName().isEmpty();
    }

    default boolean isDomainAvailable() {
        return getDomain() != null && !getDomain().isEmpty();
    }

    default boolean isi18nNameAvailable(String locale) {
        return getNameI18n(locale) != null && !getNameI18n(locale).isEmpty();
    }

    default boolean noTranslationAvailable(String locale) {
        return getTranslations() == null
                || locale == null
                || getTranslations().isEmpty()
                || locale.isEmpty();
    }

    default String getCountryCode(String locale) {
        return locale.split("_")[0];
    }

}
