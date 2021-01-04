/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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

import org.n52.series.db.beans.HibernateRelations.HasDescriptionTranslation;
import org.n52.series.db.beans.HibernateRelations.HasId;
import org.n52.series.db.beans.HibernateRelations.HasNameTranslation;
import org.n52.series.db.beans.HibernateRelations.HasParameters;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public interface Describable<T>
        extends IdentifierNameDescriptionEntity, HasId, HasParameters, HasNameTranslation, HasDescriptionTranslation {

    ServiceEntity getService();

    DescribableEntity setService(ServiceEntity service);

    default boolean hasService() {
        return getService() != null;
    }

    default Set<Map<String, Object>> getMappedParameters(String locale) {
        return hasParameters() ? getParameters().stream().map(e -> e.toValueMap(locale)).collect(Collectors.toSet())
                : null;
    }

    default String getLabelFrom(String locale) {
        if (isi18nNameAvailable(locale)) {
            return getNameI18n(locale);
        } else if (isSetName()) {
            return getName();
        } else if (isSetIdentifier()) {
            return getIdentifier();
        } else {
            // absolute fallback
            return Long.toString(getId());
        }
    }

}
