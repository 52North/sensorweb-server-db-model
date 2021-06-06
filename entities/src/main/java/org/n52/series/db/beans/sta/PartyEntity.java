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
/*
 * Copyright (C) 2018-2020 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */

package org.n52.series.db.beans.sta;

import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.party.PartyParameterEntity;

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
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@SequenceGenerator(name = "cs_observation_seq", allocationSize = 1)
@Table(name = "party")
public class PartyEntity extends IdEntity implements HibernateRelations.HasId, HibernateRelations.HasAbstractDatasets,
        HibernateRelations.HasStaIdentifier, HibernateRelations.HasDescription, HibernateRelations.HasParameters {

    public static final String PROPERTY_DATASTREAMS = "datasets";
    public static final String PROPERTY_NICKNAME = "nickname";
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

    @Column(name = PROPERTY_AUTH_ID)
    private String authId;

    @Column(name = PROPERTY_NICKNAME)
    private String nickname;

    @Column(name = PROPERTY_DESCRIPTION)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = PROPERTY_ROLE, nullable = false)
    private Role role;

    @OneToMany(mappedBy = PartyParameterEntity.PROP_PARTY, targetEntity = PartyParameterEntity.class)
    private Set<ParameterEntity<?>> parameters;

    @OneToMany(mappedBy = AbstractDatasetEntity.PROPERTY_PARTY)
    private Set<AbstractDatasetEntity> datasets;

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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

    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> observations) {
        this.datasets = observations;
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

    public enum Role {
        individual, institution;
    }
}
