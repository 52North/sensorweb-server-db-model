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
import org.n52.series.db.beans.parameter.ParameterEntity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@Table(name = "observationgroup")
@SequenceGenerator(name = "observation_group_seq", allocationSize = 1)
public class ObservationGroupEntity
        implements HibernateRelations.HasId, HibernateRelations.HasName, HibernateRelations.HasStaIdentifier,
        HibernateRelations.HasDescription, HibernateRelations.IsProcessed, HibernateRelations.HasParameters {

    public static final String PROP_ENTITIES = "entities";
    public static final String PROP_PARENT = "parent";

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "observation_seq")
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

    @ManyToMany(targetEntity = ParameterEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "observationgroup_parameter",
            inverseForeignKey = @ForeignKey(name = "fk_observationgroup_parameter"),
            joinColumns = { @JoinColumn(name = "fk_observationgroup_id") },
            foreignKey = @ForeignKey(name = "fk_parameter_observationgroup"),
            inverseJoinColumns = { @JoinColumn(name = "fk_parameter_id") })
    private Set<ParameterEntity<?>> parameters;

    @Transient
    private boolean processed;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

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
        return this.parameters;
    }

    @Override
    public void setParameters(Set<ParameterEntity<?>> parameters) {
        this.parameters = parameters;
    }
}
