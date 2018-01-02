/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.n52.series.db.beans.parameter.Parameter;
import org.n52.series.db.common.Utils;

public abstract class DataEntity<T> implements Comparable<DataEntity<T>>, Serializable {

    public static final String PROPERTY_ID = "id";

    public static final String PROPERTY_DATASET = "dataset";

    public static final String PROPERTY_RESULT_TIME = "result_time";

    public static final String PROPERTY_PHENOMENON_TIME_START = "phenomenon_time_start";

    public static final String PROPERTY_PHENOMENON_TIME_END = "phenomenon_time_end";

    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";

    public static final String PROPERTY_DELETED = "deleted";

    public static final String PROPERTY_PARENT = "parent";

    public static final String PROPERTY_DOMAIN_ID = "domain_id";

    public static final String PROPERTY_CHILDREN = "children";

    private static final long serialVersionUID = 273612846605300612L;

    private Long id;

    /**
     * Identification of the entity without special chars.
     */
    private String domainId;

    private CodespaceEntity codespace;

    /**
     * Default name of the entity.
     */
    private String name;

    private CodespaceEntity codespaceName;

    /**
     * Default description of the entity.
     */
    private String description;

    private Date phenomenonTimeStart;

    private Date phenomenonTimeEnd;

    private T value;

    private GeometryEntity geometryEntity;

    private Boolean deleted;

    private Date validTimeStart;

    private Date validTimeEnd;

    private Date resultTime;

    private boolean parent;

    private boolean child;

    private DatasetEntity dataset;

    private Set<Parameter< ? >> parameters = new HashSet<>(0);

    private Set<RelatedDataEntity> relatedObservations = new HashSet<>(0);

    private String valueIdentifier;

    private String valueName;

    private String valueDescription;

    protected DataEntity() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public CodespaceEntity getCodespace() {
        return codespace;
    }

    public void setCodespace(CodespaceEntity codespace) {
        this.codespace = codespace;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CodespaceEntity getCodespaceName() {
        return codespaceName;
    }

    public void setCodespaceName(CodespaceEntity codespaceName) {
        this.codespaceName = codespaceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the phenomenonTimeStart
     */
    public Date getPhenomenonTimeStart() {
        return Utils.createUnmutableTimestamp(phenomenonTimeStart);
    }

    /**
     * @param phenomenonTimeStart
     *        the phenomenonTimeStart
     */
    public void setPhenomenonTimeStart(Date phenomenonTimeStart) {
        this.phenomenonTimeStart = Utils.createUnmutableTimestamp(phenomenonTimeStart);
    }

    /**
     * @return the phenomenonTimeEnd
     */
    public Date getPhenomenonTimeEnd() {
        return Utils.createUnmutableTimestamp(phenomenonTimeEnd);
    }

    /**
     * @param phenomenonTimeEnd
     *        the phenomenonTimeEnd
     */
    public void setPhenomenonTimeEnd(Date phenomenonTimeEnd) {
        this.phenomenonTimeEnd = Utils.createUnmutableTimestamp(phenomenonTimeEnd);
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public abstract boolean isNoDataValue(Collection<String> noDataValues);

    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public boolean isSetGeometryEntity() {
        return geometryEntity != null && !geometryEntity.isEmpty();
    }

    public boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getValidTimeStart() {
        return Utils.createUnmutableTimestamp(validTimeStart);
    }

    public void setValidTimeStart(Date validTimeStart) {
        this.validTimeStart = Utils.createUnmutableTimestamp(validTimeStart);
    }

    public Date getValidTimeEnd() {
        return Utils.createUnmutableTimestamp(validTimeEnd);
    }

    public void setValidTimeEnd(Date validTimeEnd) {
        this.validTimeEnd = Utils.createUnmutableTimestamp(validTimeEnd);
    }

    public boolean isSetValidTime() {
        return isSetValidStartTime() && isSetValidEndTime();
    }

    public boolean isSetValidStartTime() {
        return validTimeStart != null;
    }

    public boolean isSetValidEndTime() {
        return validTimeEnd != null;
    }

    public Date getResultTime() {
        return Utils.createUnmutableTimestamp(resultTime);
    }

    public void setResultTime(Date resultTime) {
        this.resultTime = Utils.createUnmutableTimestamp(resultTime);
    }

    public boolean isParent() {
        return parent;
    }

    public void setParent(boolean parent) {
        this.parent = parent;
    }

    public boolean isChild() {
        return child;
    }

    public void setChild(boolean child) {
        this.child = child;
    }

    public Set<Parameter< ? >> getParameters() {
        return parameters;
    }

    public void setParameters(Set<Parameter< ? >> parameters) {
        this.parameters = parameters;
    }

    public boolean hasParameters() {
        return getParameters() != null && !getParameters().isEmpty();
    }

    public DatasetEntity getDataset() {
        return dataset;
    }

    public void setDataset(DatasetEntity dataset) {
        this.dataset = dataset;
    }

    public Set<RelatedDataEntity> getRelatedObservations() {
        return relatedObservations;
    }

    public void setRelatedObservations(Set<RelatedDataEntity> relatedObservations) {
        this.relatedObservations = relatedObservations;
    }

    public String getValueIdentifier() {
        return valueIdentifier;
    }

    public void setValueIdentifier(String valueIdentifier) {
        this.valueIdentifier = valueIdentifier;
    }

    public boolean has() {
        return getValueIdentifier() != null && !getValueIdentifier().isEmpty();
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public boolean hasgetValueName() {
        return getValueName() != null && !getValueName().isEmpty();
    }

    public String getValueDescription() {
        return valueDescription;
    }

    public void setValueDescription(String valueDescription) {
        this.valueDescription = valueDescription;
    }

    public boolean hasValueDescription() {
        return getValueDescription() != null && !getValueDescription().isEmpty();
    }

    @Override
    public int compareTo(DataEntity<T> o) {
        return Comparator.comparing(DataEntity<T>::getPhenomenonTimeEnd)
                         .thenComparing(DataEntity<T>::getPhenomenonTimeStart)
                         .thenComparing(DataEntity<T>::getId)
                         .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null)
                ? 0
                : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DataEntity< ? > other = (DataEntity< ? >) obj;
        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" id: ")
                 .append(id)
                 .append(" ]")
                 .toString();
    }
}
