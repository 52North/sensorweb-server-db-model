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
package org.n52.series.db.beans.sta;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.sta.StaRelations.HasLicense;
import org.n52.series.db.beans.sta.StaRelations.HasParty;
import org.n52.series.db.beans.sta.StaRelations.StaPlusTime;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class GroupEntity extends DescribableEntity
        implements Serializable, HibernateRelations.HasName, HibernateRelations.HasDescription,
        StaPlusTime<GroupEntity>, HasLicense<GroupEntity>, HasParty<GroupEntity>, HibernateRelations.IsProcessed {
    public static final String PROPERTY_RELATIONS = "relations";
    public static final String PROPERTY_PURPOSE = "purpose";
    public static final String PROPERTY_OBSERVATIONS = "observations";
    private static final long serialVersionUID = -1355442833604724327L;

    private String purpose;
    private Date creationTime;
    private Date runTimeStart;
    private Date runTimeEnd;
    private LicenseEntity license;
    private PartyEntity party;
    private Set<DataEntity<?>> observations;
    private Set<RelationEntity> relations;
    private boolean processsed;

    public String getPurpose() {
        return purpose;
    }

    public GroupEntity setPurpose(String purpose) {
        this.purpose = purpose;
        return this;
    }

    public boolean isSetPurpose() {
        return getPurpose() != null && !getPurpose().isEmpty();
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public GroupEntity setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    @Override
    public Date getRunTimeStart() {
        return runTimeStart;
    }

    @Override
    public GroupEntity setRunTimeStart(Date runTimeStart) {
        this.runTimeStart = runTimeStart;
        return this;
    }

    @Override
    public Date getRunTimeEnd() {
        return runTimeEnd;
    }

    @Override
    public GroupEntity setRunTimeEnd(Date runTimeEnd) {
        this.runTimeEnd = runTimeEnd;
        return this;
    }

    @Override
    public LicenseEntity getLicense() {
        return license;
    }

    @Override
    public GroupEntity setLicense(LicenseEntity license) {
        this.license = license;
        return this;
    }

    @Override
    public PartyEntity getParty() {
        return party;
    }

    @Override
    public GroupEntity setParty(PartyEntity party) {
        this.party = party;
        return this;
    }

    public Set<DataEntity<?>> getObservations() {
        return observations;
    }

    public void setObservations(Set<DataEntity<?>> observations) {
        this.observations = observations;
    }

    public boolean isSetObservations() {
        return getObservations() != null && !getObservations().isEmpty();
    }

    public Set<RelationEntity> getRelations() {
        return relations;
    }

    public void setRelations(Set<RelationEntity> relations) {
        this.relations = relations;
    }

    public boolean isSetRelations() {
        return getRelations() != null && !getRelations().isEmpty();
    }

    @Override
    public boolean isProcessed() {
        return processsed;
    }

    @Override
    public void setProcessed(boolean processsed) {
        this.processsed = processsed;
    }
}
