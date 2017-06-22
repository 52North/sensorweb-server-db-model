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

import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.parameter.Parameter;

public class DescribableEntity extends PkidEntity implements IdentifierNameDescriptionEntity<DescribableEntity> {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DOMAIN_ID = "domainId";
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_SERVICE = "service";
    public static final String PROPERTY_CODESPACE = CODESPACE;
    public static final String PROPERTY_CODESPACE_NAME = CODESPACE_NAME;

    /**
     * Identification of the entity without special chars.
     */
    private String domainId;

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

    public String getDomainId() {
        return domainId;
    }

    public DescribableEntity setDomainId(String domainId) {
        this.domainId = domainId;
        return this;
    }

    public CodespaceEntity getCodespace() {
        return this.codespace;
    }

    public DescribableEntity setCodespace(CodespaceEntity codespace) {
        this.codespace = codespace;
        return this;
    }

    public String getName() {
        return name;
    }

    public DescribableEntity setName(String name) {
        this.name = name;
        return this;
    }

    public CodespaceEntity getCodespaceName() {
        return codespaceName;
    }

    public DescribableEntity setCodespaceName(CodespaceEntity codespaceName) {
        this.codespaceName = codespaceName;
        return this;
    }

    public String getDescription() {
        return description;
    }

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
