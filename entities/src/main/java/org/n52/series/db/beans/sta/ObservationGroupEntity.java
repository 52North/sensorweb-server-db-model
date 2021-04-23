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

package org.n52.series.db.beans.sta;

import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.observationgroup.ObservationGroupParameterEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@Table(name = "observationgroup")
@SequenceGenerator(name = "observation_group_seq", allocationSize = 1)
public class ObservationGroupEntity extends IdEntity
        implements HibernateRelations.HasId, HibernateRelations.HasName, HibernateRelations.HasStaIdentifier,
        HibernateRelations.HasDescription, HibernateRelations.IsProcessed, HibernateRelations.HasParameters {

    public static final String PROP_ENTITIES = "entities";
    private static final long serialVersionUID = 3611419770138299218L;

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "observation_group_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = "sta_identifier", unique = true)
    private String staIdentifier;

    /**
     * Name of the entity.
     */
    @Column
    private String name;

    @Column
    private String description;

    @OneToMany(mappedBy = ObservationRelationEntity.PROPERTY_GROUP)
    private Set<ObservationRelationEntity> entities;

    @OneToMany(mappedBy = ObservationGroupParameterEntity.PROP_OBS_GROUP,
            targetEntity = ObservationGroupParameterEntity.class)
    private Set<ParameterEntity<?>> parameters;

    @Transient
    private boolean processed;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStaIdentifier() {
        return staIdentifier;
    }

    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    public Set<ObservationRelationEntity> getEntities() {
        return entities;
    }

    public void setEntities(Set<ObservationRelationEntity> entities) {
        this.entities = entities;
    }

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public void setProcessed(boolean processed) {
        this.processed = processed;
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
        return Objects.hash(id, staIdentifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ObservationGroupEntity)) {
            return false;
        }
        return Objects.equals(this.hashCode(), obj.hashCode());
    }
}
