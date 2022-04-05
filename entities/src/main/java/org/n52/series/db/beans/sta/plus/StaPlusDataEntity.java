/*
 * Copyright 2015-2022 52°North Spatial Information Research GmbH
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

import org.n52.series.db.beans.DataEntity;

public abstract class StaPlusDataEntity<T> extends DataEntity<T> {

    public static final String PROPERTY_SUBJECTS = "subjects";
    public static final String PROPERTY_OBJECTS = "objects";
    public static final String PROPERTY_GROUPS = "groups";

    private Set<GroupEntity> groups;

    private Set<RelationEntity> subjects;

    private Set<RelationEntity> objects;

    public Set<RelationEntity> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<RelationEntity> subjects) {
        this.subjects = subjects;
    }

    public Set<RelationEntity> getObjects() {
        return objects;
    }

    public void setObjects(Set<RelationEntity> objects) {
        this.objects = objects;
    }

    public Set<GroupEntity> getGroups() {
        return groups;
    }

    public void setGroups(Set<GroupEntity> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" id: ").append(getId()).append(" ]")
                .toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getDataset(), getSamplingTimeStart(), getSamplingTimeEnd(),
                getResultTime(), getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof StaPlusDataEntity)) {
            return false;
        }
        StaPlusDataEntity other = (StaPlusDataEntity) obj;
        return super.equals(obj) && Objects.equals(getDataset(), other.getDataset())
                && Objects.equals(getSamplingTimeStart(), other.getSamplingTimeStart())
                && Objects.equals(getSamplingTimeStart(), other.getSamplingTimeStart())
                && Objects.equals(getSamplingTimeEnd(), other.getSamplingTimeEnd())
                && Objects.equals(getResultTime(), other.getResultTime())
                && Objects.equals(getValue(), other.getValue());
    }
}
