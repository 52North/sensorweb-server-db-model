/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

public abstract class DescribableEntity extends IdEntity implements Describable, Serializable {

    public static final String PROPERTY_IDENTIFIER = IDENTIFIER;
    public static final String PROPERTY_STA_IDENTIFIER = STA_IDENTIFIER;
    public static final String PROPERTY_IDENTIFIER_CODESPACE = IDENTIFIER_CODESPACE;
    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_NAME_CODESPACE = NAME_CODESPACE;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_SERVICE = "service";

    public static final String PROPERTY_DOMAIN_ID = PROPERTY_IDENTIFIER;
    public static final String PROPERTY_CODESPACE = PROPERTY_IDENTIFIER_CODESPACE;
    public static final String PROPERTY_CODESPACE_NAME = PROPERTY_NAME_CODESPACE;

    private static final long serialVersionUID = -4448231483118864847L;

    /**
     * Identification of the entity without special chars.
     */
    private String identifier;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    private String staIdentifier;

    private CodespaceEntity identifierCodespace;

    /**
     * Default name of the entity.
     */
    private String name;

    private CodespaceEntity nameCodespace;

    /**
     * Default description of the entity.
     */
    private String description;

    private ServiceEntity service;

    private Set<I18nEntity<? extends Describable>> translations;

    private Set<ParameterEntity<?>> parameters;

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
        if (!isSetStaIdentifier()) {
            setStaIdentifier(processIdentifierForSta(identifier));
        }
    }

    @Override
    public String getStaIdentifier() {
        return staIdentifier;
    }

    @Override
    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    @Override
    public CodespaceEntity getIdentifierCodespace() {
        return this.identifierCodespace;
    }

    @Override
    public void setIdentifierCodespace(CodespaceEntity identifierCodespace) {
        this.identifierCodespace = identifierCodespace;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public CodespaceEntity getNameCodespace() {
        return nameCodespace;
    }

    @Override
    public void setNameCodespace(CodespaceEntity nameCodespace) {
        this.nameCodespace = nameCodespace;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return translations;
    }

    @Override
    public void setTranslations(Set<I18nEntity<? extends Describable>> translations) {
        this.translations = translations;
    }

    @Override
    public Set<ParameterEntity<?>> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Set<ParameterEntity<?>> parameters) {
        this.parameters = parameters;
    }

    @Override
    public ServiceEntity getService() {
        return service;
    }

    @Override
    public DescribableEntity setService(ServiceEntity service) {
        this.service = service;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" Domain id: ").append(getDomain())
                .append(", service: ").append(getService()).append(" ]").toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdentifier(), (this instanceof IsStaEntity ? getStaIdentifier() : ""),
                getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DescribableEntity)) {
            return false;
        }
        DescribableEntity other = (DescribableEntity) obj;
        return super.equals(other) && Objects.equals(getIdentifier(), other.getIdentifier())
                && (this instanceof IsStaEntity ? Objects.equals(getStaIdentifier(), other.getStaIdentifier()) : true)
                && Objects.equals(getName(), other.getName());
    }

    protected String processIdentifierForSta(String identifier) {
        if (identifier == null || identifier.isEmpty()) {
            return generateUUID();
        } else {
            if (identifier.contains("/")) {
                try {
                    URI uri = URI.create(identifier.trim());
                    StringBuffer buffer = new StringBuffer("urn");
                    addValue(buffer, uri.getScheme());
                    addHost(buffer, uri.getHost());
                    addPort(buffer, uri.getPort());
                    addPath(buffer, uri.getPath());
                    return buffer.toString();
                } catch (Exception e) {
                    try {
                        return UUID.nameUUIDFromBytes(identifier.trim().getBytes("UTF8")).toString();
                    } catch (UnsupportedEncodingException e1) {
                        return generateUUID();
                    }
                }
            }
        }
        return identifier.trim();
    }

    private void addValue(StringBuffer buffer, String value) {
        addValue(buffer, value, true);
    }

    private void addValue(StringBuffer buffer, String value, boolean addEmpty) {
        if (value != null && ((addEmpty && value.isEmpty()) || !value.isEmpty())) {
            buffer.append(":").append(value);
        }
    }

    private void addHost(StringBuffer buffer, String value) {
        if (value != null) {
            addValues(value, ".", buffer);
        }
    }

    private void addPort(StringBuffer buffer, int value) {
        if (value >= 0) {
            addValue(buffer, Integer.toString(value));
        }
    }

    private void addPath(StringBuffer buffer, String value) {
        if (value != null) {
            addValues(value, "/", buffer);
        }
    }

    private void addValues(String value, String splitChar, StringBuffer buffer) {
        if (!value.contains(splitChar)) {
            addValue(buffer, value);
        } else {
            Arrays.asList(value.split(Pattern.quote(splitChar))).stream().forEach(v -> addValue(buffer, v, false));
        }
    }
}
