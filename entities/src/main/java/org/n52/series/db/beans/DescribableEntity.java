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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@MappedSuperclass
public abstract class DescribableEntity extends IdentifiableEntity implements Describable, Serializable {

    public static final String PROPERTY_IDENTIFIER = IDENTIFIER;
    public static final String PROPERTY_STA_IDENTIFIER = STA_IDENTIFIER;
    public static final String PROPERTY_IDENTIFIER_CODESPACE = IDENTIFIER_CODESPACE;

    public static final String PROPERTY_SERVICE = "service";
    public static final String PROPERTY_SERVICE_ID = PROPERTY_SERVICE + "." + PROPERTY_ID;

    public static final String PROPERTY_DOMAIN_ID = PROPERTY_IDENTIFIER;
    public static final String PROPERTY_CODESPACE = PROPERTY_IDENTIFIER_CODESPACE;

    @Serial
    private static final long serialVersionUID = -4448231483118864847L;

    @Column(name = "name")
    // @Comment("The human readable name of the feature.")
    private String name;

    @Column(name = "description", columnDefinition = "text")
    // @Comment("A short description of the feature")
    private String description;

    @Transient
    private CodespaceEntity identifierCodespace;

    @Transient
    private CodespaceEntity nameCodespace;

    @Transient
    // explictly mapped in subclasses
    private Set<ParameterEntity<?>> parameters;

    @Transient
    // explictly mapped in subclasses
    private Set<I18nEntity<? extends Describable>> translations;

    // decision: not mapped here - only present in profiles/persistence-units that add the
    // orm.xml override for this attribute (e.g. the "proxy" profile), since some deployments
    // never had a service/fk_service_id column and must not gain one.
    @Transient
    private ServiceEntity service;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public void addParameters(Set<ParameterEntity<?>> parameters) {
        if (parameters != null) {
            if (this.getParameters() == null) {
                setParameters(new LinkedHashSet<>());
            }
            this.getParameters().addAll(parameters);
        }
    }

    @Override
    public void addParameter(ParameterEntity<?> parameter) {
        if (parameter != null) {
            if (this.getParameters() == null) {
                setParameters(new LinkedHashSet<>());
            }
            this.getParameters().add(parameter);
        }
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
        return Objects.hash(super.hashCode(), getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DescribableEntity)) {
            return false;
        }
        DescribableEntity other = (DescribableEntity) obj;
        return super.equals(other) && Objects.equals(getName(), other.getName());
    }
}
