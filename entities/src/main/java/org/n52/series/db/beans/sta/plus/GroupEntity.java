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
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.observationgroup.ObservationGroupParameterEntity;
import org.n52.series.db.common.Utils;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@Table(name = "group")
@SequenceGenerator(name = "group_seq", allocationSize = 1)
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class GroupEntity extends IdEntity
        implements HibernateRelations.HasId, HibernateRelations.HasName, HibernateRelations.HasStaIdentifier,
        HibernateRelations.HasDescription, HibernateRelations.IsProcessed, HibernateRelations.HasParameters {

    public static final String PROP_RELATIONS = "relations";
    public static final String PROPERTY_LICENSE = "license";
    public static final String PROPERTY_PARTY = "party";
    public static final String PROPERTY_PARENT = "parent";
    public static final String PROPERTY_CHILDREN = "children";

    private static final long serialVersionUID = 3611419770138299218L;

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_seq")
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

    @Column
    private String purpose;

    @Column
    private Date creationTime;

    @Column
    private Date endTime;

    @OneToMany(mappedBy = ObservationGroupParameterEntity.PROP_OBS_GROUP,
            targetEntity = ObservationGroupParameterEntity.class)
    private Set<ParameterEntity<?>> parameters;

    // #### OData Linked Entities

    @OneToOne
    @JoinColumn(name = "parent_id")
    private GroupEntity parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private Set<GroupEntity> children = new HashSet<>();

    @ManyToOne
    private LicenseEntity license;

    @ManyToMany
    @JoinTable(name = "group_observation")
    private Set<StaPlusDataEntity<?>> observations;

    @ManyToOne
    private PartyEntity party;

    @ManyToMany
    @JoinTable(name = "group_relation", joinColumns = { @JoinColumn(name = "fk_group", referencedColumnName = "id") },
            inverseJoinColumns = { @JoinColumn(name = "fk_relation", referencedColumnName = "id") })
    private Set<RelationEntity> relations;

    // #############################

    @Transient
    private boolean processed;

    public GroupEntity() {
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public Date getCreationTime() {
        return Utils.createUnmutableTimestamp(creationTime);
    }

    public void setCreationTime(Date createdStart) {
        this.creationTime = Utils.createUnmutableTimestamp(createdStart);
    }

    public Date getEndTime() {
        return Utils.createUnmutableTimestamp(endTime);
    }

    public void setEndTime(Date createdEnd) {
        this.endTime = Utils.createUnmutableTimestamp(createdEnd);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, staIdentifier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof GroupEntity)) {
            return false;
        }
        return Objects.equals(this.hashCode(), obj.hashCode());
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

    public Set<RelationEntity> getRelations() {
        return relations;
    }

    public void setRelations(Set<RelationEntity> observationRelations) {
        this.relations = observationRelations;
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

    public LicenseEntity getLicense() {
        return license;
    }

    public void setLicense(LicenseEntity license) {
        this.license = license;
    }

    public Set<StaPlusDataEntity<?>> getObservations() {
        return observations;
    }

    public void setObservations(Set<StaPlusDataEntity<?>> observations) {
        this.observations = observations;
    }

    public PartyEntity getParty() {
        return party;
    }

    public void setParty(PartyEntity party) {
        this.party = party;
    }

    public GroupEntity getParent() {
        return parent;
    }

    public void setParent(GroupEntity parent) {
        this.parent = parent;
    }

    public Set<GroupEntity> getChildren() {
        return children;
    }

    public void setChildren(Set<GroupEntity> children) {
        this.children = children;
    }
}
