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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@Table(name = "observationrelation")
@SequenceGenerator(name = "observation_rel_seq", allocationSize = 1)
public class ObservationRelationEntity extends IdEntity
        implements HibernateRelations.HasId, HibernateRelations.HasStaIdentifier {

    public static final String PROPERTY_GROUP = "group";
    public static final String PROPERTY_OBSERVATION = "observation";
    public static final String PROPERTY_TYPE = "type";
    private static final long serialVersionUID = -5523688573276493324L;

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "observation_rel_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = "sta_identifier", unique = true)
    private String staIdentifier;

    /**
     * Type of the relation.
     */
    @Column(name = PROPERTY_TYPE, nullable = false)
    private String type;

    @ManyToOne(targetEntity = ObservationEntity.class, optional = false)
    @JoinColumn(name = PROPERTY_OBSERVATION, referencedColumnName = "observation_id")
    private ObservationEntity observation;

    @ManyToOne(targetEntity = ObservationGroupEntity.class, optional = false)
    private ObservationGroupEntity group;

    @Override
    public String getStaIdentifier() {
        return staIdentifier;
    }

    @Override
    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ObservationEntity getObservation() {
        return observation;
    }

    public void setObservation(ObservationEntity entity) {
        this.observation = entity;
    }

    public ObservationGroupEntity getGroup() {
        return group;
    }

    public void setGroup(ObservationGroupEntity group) {
        this.group = group;
    }
}
