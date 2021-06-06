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

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@Table(name = "observationrelation", indexes = {
        // @Index(name = "idx_obsrel_subject", columnList = "subject"),
        // @Index(name = "idx_obsrel_object", columnList = "object"),
})
@SequenceGenerator(name = "observation_rel_seq", allocationSize = 1)
public class ObservationRelationEntity extends IdEntity implements HibernateRelations.HasId,
        HibernateRelations.HasStaIdentifier, HibernateRelations.HasName, HibernateRelations.HasDescription {

    public static final String PROPERTY_GROUP = "observationGroups";
    public static final String PROPERTY_ROLE = "role";
    public static final String PROPERTY_NAMESPACE = "namespace";
    public static final String PROPERTY_SUBJECT = "subject";
    public static final String PROPERTY_OBJECT = "object";
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

    @Column(name = PROPERTY_NAME)
    private String name;

    @Column(name = PROPERTY_DESCRIPTION)
    private String description;

    @Column(name = PROPERTY_ROLE, nullable = false)
    private String role;

    @Column(name = PROPERTY_NAMESPACE, nullable = false)
    private String namespace;

    @ManyToMany(mappedBy = "observationRelations")
    private Set<ObservationGroupEntity> observationGroups;

    @ManyToOne
    private DataEntity subject;

    @ManyToOne
    private DataEntity object;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staIdentifier, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ObservationRelationEntity)) {
            return false;
        }
        return Objects.equals(this.hashCode(), obj.hashCode());
    }

    @Override
    public String getStaIdentifier() {
        return staIdentifier;
    }

    @Override
    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Set<ObservationGroupEntity> getObservationGroups() {
        return observationGroups;
    }

    public void setObservationGroups(Set<ObservationGroupEntity> observationGroups) {
        this.observationGroups = observationGroups;
    }

    public DataEntity getSubject() {
        return subject;
    }

    public void setSubject(DataEntity subject) {
        this.subject = subject;
    }

    public DataEntity getObject() {
        return object;
    }

    public void setObject(DataEntity object) {
        this.object = object;
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
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }
}
