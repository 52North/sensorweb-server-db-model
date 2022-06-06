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

import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@Table(name = "party")
@SequenceGenerator(name = "cs_observation_seq", allocationSize = 1)
public class PartyEntity extends IdEntity
        implements HibernateRelations.HasId, HibernateRelations.HasStaIdentifier, HibernateRelations.HasDescription {

    public static final String PROPERTY_DATASTREAMS = "datasets";
    public static final String PROPERTY_DISPLAY_NAME = "displayName";
    public static final String PROPERTY_PERSONAL_DATA = "personalData";
    public static final String PROPERTY_ROLE = "role";
    public static final String PROPERTY_AUTH_ID = "authId";

    private static final long serialVersionUID = 5875256537419920242L;

    @Id
    @Column(nullable = false, name = "party_id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "party_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = STA_IDENTIFIER, unique = true)
    private String staIdentifier;

    @Column(name = PROPERTY_DESCRIPTION)
    private String description;

    @Column(name = PROPERTY_AUTH_ID)
    private String authId;

    @Enumerated(EnumType.STRING)
    @Column(name = PROPERTY_ROLE, nullable = false)
    private Role role;

    @Column(name = PROPERTY_DISPLAY_NAME)
    private String displayName;

    // personal data is stored as a json string
    @Column(name = PROPERTY_PERSONAL_DATA)
    private String personalData;

    // #### OData Linked Entities

    @OneToMany(mappedBy = StaPlusDataset.PROPERTY_PARTY)
    private Set<StaPlusDataset> datastreams;

    @OneToMany(mappedBy = StaPlusPlatformEntity.PROPERTY_PARTY)
    private Set<StaPlusPlatformEntity> things;

    @OneToMany(mappedBy = GroupEntity.PROPERTY_PARTY)
    private Set<GroupEntity> groups;

    @OneToMany(mappedBy = RelationEntity.PROPERTY_PARTY)
    private Set<RelationEntity> relations;

    // ############################

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
        if (obj == null || !(obj instanceof PartyEntity)) {
            return false;
        }
        return Objects.equals(this.hashCode(), obj.hashCode());
    }

    public String getStaIdentifier() {
        return staIdentifier;
    }

    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String nickname) {
        this.displayName = nickname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getAuthId() {
        return authId;
    }

    public void setAuthId(String authId) {
        this.authId = authId;
    }

    public Set<StaPlusDataset> getDatastreams() {
        return datastreams;
    }

    public void setDatastreams(Set<StaPlusDataset> observations) {
        this.datastreams = observations;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    public Set<StaPlusPlatformEntity> getThings() {
        return things;
    }

    public void setThings(Set<StaPlusPlatformEntity> things) {
        this.things = things;
    }

    public enum Role {
        INDIVIDUAL, INSTITUTIONAL;
    }
}
