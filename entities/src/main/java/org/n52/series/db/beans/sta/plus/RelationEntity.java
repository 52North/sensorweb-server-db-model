/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.sta.plus;

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
@Table(name = "relation", indexes = {
// @Index(name = "idx_obsrel_subject", columnList = "subject"),
// @Index(name = "idx_obsrel_object", columnList = "object"),
})
@SequenceGenerator(name = "rel_seq", allocationSize = 1)
public class RelationEntity extends IdEntity
        implements HibernateRelations.HasId, HibernateRelations.HasStaIdentifier, HibernateRelations.HasDescription {

    public static final String PROPERTY_GROUPS = "groups";
    public static final String PROPERTY_PARTY = "party";
    public static final String PROPERTY_ROLE = "role";
    public static final String PROPERTY_EXTERNAL_OBJECT = "namespace";
    public static final String PROPERTY_SUBJECT = "subject";
    public static final String PROPERTY_OBJECT = "object";

    private static final long serialVersionUID = -5523688573276493324L;

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rel_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = "sta_identifier", unique = true)
    private String staIdentifier;

    @Column(name = PROPERTY_ROLE, nullable = false)
    private String role;

    @Column(name = PROPERTY_DESCRIPTION)
    private String description;

    @Column(name = PROPERTY_EXTERNAL_OBJECT)
    private String externalObject;

    // #### OData Linked Entities

    @ManyToMany(mappedBy = "relations")
    private Set<GroupEntity> groups;

    @Column(name = PROPERTY_SUBJECT, nullable = false)
    private StaPlusDataEntity<?> subject;

    @Column(name = PROPERTY_OBJECT, nullable = true)
    private StaPlusDataEntity<?> object;

    @ManyToOne
    private PartyEntity party;

    // #############################

    @Override
    public Long getId() {
        return id;
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

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> observationGroups) {
        this.groups = observationGroups;
    }

    public StaPlusDataEntity getSubject() {
        return subject;
    }

    public void setSubject(StaPlusDataEntity subject) {
        this.subject = subject;
    }

    public StaPlusDataEntity getObject() {
        return object;
    }

    public void setObject(StaPlusDataEntity object) {
        this.object = object;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public String getExternalObject() {
        return externalObject;
    }

    public void setExternalObject(String namespace) {
        this.externalObject = namespace;
    }

    public PartyEntity getParty() {
        return party;
    }

    public void setParty(PartyEntity party) {
        this.party = party;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staIdentifier, role);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RelationEntity)) {
            return false;
        }
        return Objects.equals(this.hashCode(), obj.hashCode());
    }
}
