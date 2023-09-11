/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
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

import java.util.Set;

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.DescribableEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class RelationEntity extends DescribableEntity implements StaRelations.HasGroups<RelationEntity> {

    public static final String PROPERTY_SUBJECT = "subject";
    public static final String PROPERTY_OBJECT = "object";
    public static final String PROPERTY_ROLE = "role";
    public static final String PROPERTY_EXTERNAL_OBJECT = "externalObject";

    private static final long serialVersionUID = -8131424037218012268L;

    private String role;
    private String externalObject;
    private DataEntity<?> subject;
    private DataEntity<?> object;
    private Set<GroupEntity> groups;

    public String getRole() {
        return role;
    }

    public RelationEntity setRole(String role) {
        this.role = role;
        return this;
    }

    public String getExternalObject() {
        return externalObject;
    }

    public RelationEntity setExternalObject(String externalObject) {
        this.externalObject = externalObject;
        return this;
    }

    public boolean isSetExternalObject() {
        return getExternalObject() != null && !getExternalObject().isEmpty();
    }

    public DataEntity<?> getSubject() {
        return subject;
    }

    public RelationEntity setSubject(DataEntity<?> subject) {
        this.subject = subject;
        return this;
    }

    public DataEntity<?> getObject() {
        return object;
    }

    public RelationEntity setObject(DataEntity<?> object) {
        this.object = object;
        return this;
    }

    public boolean isSetObject() {
        return getObject() != null;
    }

    @Override
    public Set<GroupEntity> getGroups() {
        return groups;
    }

    @Override
    public RelationEntity setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
        return this;
    }
}
