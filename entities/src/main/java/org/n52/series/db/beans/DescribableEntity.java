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

import java.io.Serializable;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.parameter.Parameter;

public class DescribableEntity extends IdEntity implements IdentifierNameDescriptionEntity<DescribableEntity>,
        Serializable {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DOMAIN_ID = "domain";
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_SERVICE = "service";
    public static final String PROPERTY_CODESPACE = CODESPACE;
    public static final String PROPERTY_CODESPACE_NAME = CODESPACE_NAME;

    private static final long serialVersionUID = -4448231483118864847L;

    /**
     * Identification of the entity without special chars.
     */
    private String domain;

    private CodespaceEntity codespace;

    /**
     * Default name of the entity.
     */
    private String name;

    private CodespaceEntity codespaceName;

    /**
     * Default description of the entity.
     */
    private String description;

    private ServiceEntity service;

    private Set<I18nEntity> translations;

    private Set<Parameter< ? >> parameters;

    @Override
    public String getDomain() {
        return domain;
    }

    @Override
    public DescribableEntity setDomain(String domain) {
        this.domain = domain;
        return this;
    }

    @Override
    public CodespaceEntity getCodespace() {
        return this.codespace;
    }

    @Override
    public DescribableEntity setCodespace(CodespaceEntity codespace) {
        this.codespace = codespace;
        return this;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public DescribableEntity setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public CodespaceEntity getCodespaceName() {
        return codespaceName;
    }

    @Override
    public DescribableEntity setCodespaceName(CodespaceEntity codespaceName) {
        this.codespaceName = codespaceName;
        return this;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public DescribableEntity setDescription(String description) {
        this.description = description;
        return this;
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

    public Set<Map<String, Object>> getMappedParameters(String locale) {
        return hasParameters()
                ? parameters.stream()
                            .map(e -> e.toValueMap(locale))
                            .collect(Collectors.toSet())
                : null;
    }

    public ServiceEntity getService() {
        return service;
    }

    public DescribableEntity setService(ServiceEntity service) {
        this.service = service;
        return this;
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
        } else if (isDomainAvailable()) {
            return getDomain();
        } else {
            // absolute fallback
            return Long.toString(getId());
        }
    }

    private boolean isNameAvailable() {
        return getName() != null && !getName().isEmpty();
    }

    private boolean isDomainAvailable() {
        return getDomain() != null && !getDomain().isEmpty();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" Domain id: ")
                 .append(getDomain())
                 .append(", service: ")
                 .append(getService())
                 .append(" ]")
                 .toString();
    }
}
