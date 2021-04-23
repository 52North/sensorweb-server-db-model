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
import org.n52.series.db.beans.parameter.license.LicenseParameterEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@SequenceGenerator(name = "license_seq", allocationSize = 1)
@Table(name = "license")
public class LicenseEntity extends IdEntity implements HibernateRelations.HasId, HibernateRelations.HasName,
        HibernateRelations.HasAbstractDatasets, HibernateRelations.HasStaIdentifier, HibernateRelations.HasParameters {

    public static final String PROPERTY_DATASETS = "datasets";
    public static final String PROPERTY_DEFINITION = "definition";
    public static final String PROPERTY_LOGO = "logo";
    private static final long serialVersionUID = 6159174609682812188L;

    @Id
    @Column(nullable = false, name = "license_id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = STA_IDENTIFIER, unique = true)
    private String staIdentifier;

    @Column(name = NAME, nullable = false)
    private String name;

    @Column(name = PROPERTY_DEFINITION, nullable = false)
    private String definition;

    @Column(name = PROPERTY_LOGO)
    private String logo;

    @OneToMany(mappedBy = AbstractDatasetEntity.PROPERTY_LICENSE)
    private Set<AbstractDatasetEntity> datasets;

    @OneToMany(mappedBy = LicenseParameterEntity.PROP_LICENSE, targetEntity = LicenseParameterEntity.class)
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

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
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
        if (obj == null || !(obj instanceof LicenseEntity)) {
            return false;
        }
        return Objects.equals(this.hashCode(), obj.hashCode());
    }
}
