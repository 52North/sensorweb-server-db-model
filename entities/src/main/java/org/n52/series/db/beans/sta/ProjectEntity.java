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
package org.n52.series.db.beans.sta;

import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.project.ProjectParameterEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@SequenceGenerator(name = "project_seq", allocationSize = 1)
@Table(name = "project")
public class ProjectEntity extends IdEntity
        implements HibernateRelations.HasId, HibernateRelations.HasName, HibernateRelations.HasDescription,
        HibernateRelations.HasAbstractDatasets, HibernateRelations.HasStaIdentifier, HibernateRelations.HasParameters {

    public static final String PROPERTY_DATASTREAMS = "datasets";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_RUNTIME_START = "runtimeStart";
    public static final String PROPERTY_RUNTIME_END = "runtimeEnd";
    public static final String PROPERTY_PRIVACY_POLICY = "privacyPolicy";
    public static final String PROPERTY_TERMS_OF_USE = "termsOfUse";
    public static final String PROPERTY_CLASSIFICATION = "classification";
    private static final long serialVersionUID = 1050625647937315126L;

    @Id
    @Column(nullable = false, name = "project_id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = STA_IDENTIFIER, unique = true)
    private String staIdentifier;

    @Column(name = NAME, nullable = false)
    private String name;

    @Column(name = DESCRIPTION, nullable = false)
    private String description;

    @Column(name = PROPERTY_RUNTIME_START, length = 29, nullable = false)
    private Date runtimeStart;

    @Column(name = PROPERTY_RUNTIME_END, length = 29, nullable = false)
    private Date runtimeEnd;

    @Column(name = PROPERTY_PRIVACY_POLICY)
    private String privacyPolicy;

    @Column(name = PROPERTY_TERMS_OF_USE)
    private String termsOfUse;

    @Column(name = PROPERTY_CLASSIFICATION)
    private String classification;

    @Column(name = PROPERTY_URL)
    private String url;

    @OneToMany(mappedBy = AbstractDatasetEntity.PROPERTY_PROJECT)
    private Set<AbstractDatasetEntity> datasets;

    @OneToMany(mappedBy = ProjectParameterEntity.PROP_PROJECT, targetEntity = ProjectParameterEntity.class)
    private Set<ParameterEntity<?>> parameters;

    public String getStaIdentifier() {
        return staIdentifier;
    }

    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

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

    public Date getRuntimeStart() {
        return runtimeStart != null ? new Date(runtimeStart.getTime()) : null;
    }

    public void setRuntimeStart(Date runtimeStart) {
        this.runtimeStart = runtimeStart != null ? new Date(runtimeStart.getTime()) : null;
    }

    public Date getRuntimeEnd() {
        return runtimeEnd != null ? new Date(runtimeEnd.getTime()) : null;
    }

    public void setRuntimeEnd(Date runtimeEnd) {
        this.runtimeEnd = runtimeEnd != null ? new Date(runtimeEnd.getTime()) : null;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public void setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public void setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
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
        if (this.parameters == null) {
            this.parameters = new HashSet<>();
        }
        this.parameters.addAll(parameters);
    }

    @Override
    public void addParameter(ParameterEntity<?> parameter) {
        if (this.parameters == null) {
            this.parameters = new HashSet<>();
        }
        this.parameters.add(parameter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staIdentifier, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProjectEntity)) {
            return false;
        }
        return Objects.equals(this.hashCode(), obj.hashCode());
    }
}
