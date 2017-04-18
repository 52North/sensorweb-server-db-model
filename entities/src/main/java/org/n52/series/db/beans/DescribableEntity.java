/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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

import org.n52.series.db.beans.parameter.Parameter;

public class DescribableEntity {

    public static final String PROPERTY_PKID = "pkid";

    public static final String PROPERTY_NAME = "name";

    public static final String PROPERTY_DOMAIN_ID = "domainId";

    public static final String PROPERTY_SERVICE_ID = "serviceid";

    /**
     * A serial primary key.
     */
    private Long pkid;

    /**
     * Identification of the entity without special chars.
     */
    private String domainId;

    /**
     * Default name of the entity.
     */
    private String name;

    /**
     * Default description of the entity.
     */
    private String description;

    private ServiceEntity service;

    private Set<I18nEntity> translations;

    private Set<Parameter< ? >> parameters;

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSetName() {
        return getName() != null && !getName().isEmpty();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isSetDescription() {
        return getDescription() != null && !getDescription().isEmpty();
    }

    public Set<I18nEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<I18nEntity> translations) {
        this.translations = translations;
    }

    public Set<Parameter< ? >> getParameters() {
        return parameters;
    }

    public void setParameters(Set<Parameter< ? >> parameters) {
        this.parameters = parameters;
    }

    public boolean hasParameters() {
        return getParameters() != null && !getParameters().isEmpty();
    }

    public ServiceEntity getService() {
        return service;
    }

    public void setService(ServiceEntity service) {
        this.service = service;
    }

    public String getNameI18n(String locale) {
        if (noTranslationAvailable(locale)) {
            return name;
        }
        String candidate = name;
        String countryCode = getCountryCode(locale);
        for (I18nEntity translation : translations) {
            String translatedLocale = translation.getLocale();
            if (translatedLocale.equals(locale)) {
                // locale matches exactly
                return translation.getName();
            }
            if (translatedLocale.equals(countryCode)) {
                // hold a country candidate
                candidate = translation.getName();
            }
        }
        return candidate;
    }

    public String getLabelFrom(String locale) {
        if (isi18nNameAvailable(locale)) {
            return getNameI18n(locale);
        } else if (isNameAvailable()) {
            return getName();
        } else if (isDomainIdAvailable()) {
            return getDomainId();
        } else {
            // absolute fallback
            return Long.toString(getPkid());
        }
    }

    private boolean isNameAvailable() {
        return getName() != null && !getName().isEmpty();
    }

    private boolean isDomainIdAvailable() {
        return getDomainId() != null && !getDomainId().isEmpty();
    }

    private boolean isi18nNameAvailable(String locale) {
        return getNameI18n(locale) != null && !getNameI18n(locale).isEmpty();
    }

    private boolean noTranslationAvailable(String locale) {
        return translations == null
                || locale == null
                || translations.isEmpty()
                || locale.isEmpty();
    }

    private String getCountryCode(String locale) {
        return locale.split("_")[0];
    }

}
