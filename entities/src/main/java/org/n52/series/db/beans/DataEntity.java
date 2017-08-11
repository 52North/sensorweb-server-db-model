/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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

    public static final String PROPERTY_PKID = "pkid";

    public static final String PROPERTY_DATASETS = "datasets";

    public static final String PROPERTY_RESULT_TIME = "resultTime";

    public static final String PROPERTY_PHENOMENON_TIME_START = "phenomenonTimeStart";

    public static final String PROPERTY_PHENOMENON_TIME_END = "phenomenonTimeEnd";

    private static final long serialVersionUID = 273612846605300612L;

    private Long pkid;

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

    // private final Set<Parameter< ? >> parameters = new HashSet<>(0);
    private Set<Parameter> parameters = new HashSet<>(0);

    private final Set<DatasetEntity> datasets = new HashSet<>(0);

    private final Set<RelatedDataEntity> relatedObservations = new HashSet<>(0);

    protected DataEntity() {

    }

    public Long getPkid() {
        return pkid;
    }

    public void setPkid(Long pkid) {
        this.pkid = pkid;
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

    // public Set<Parameter< ? >> getParameters() {
    public Set<Parameter> getParameters() {
        return parameters;
    }

    // public void setParameters(Set<Parameter< ? >> parameters) {
    // if (parameters != null) {
    // this.parameters.clear();
    // this.parameters.addAll(parameters);
    // }
    // }

    @SuppressWarnings(value = "unchecked")
    public void setParameters(Object parameters) {
        if (parameters instanceof Set< ? >) {
            this.parameters = (Set<Parameter>) parameters;
        } else {
            getParameters().add((Parameter) parameters);
        }
    }

    public boolean hasParameters() {
        return getParameters() != null && !getParameters().isEmpty();
    }

    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    public void setDatasets(Set<DatasetEntity> datasets) {
        if (datasets != null) {
            this.datasets.clear();
            this.datasets.addAll(datasets);
        }
    }

    public Set<RelatedDataEntity> getRelatedObservations() {
        return relatedObservations;
    }

    public void setRelatedObservations(Set<RelatedDataEntity> relatedObservations) {
        if (relatedObservations != null) {
            this.relatedObservations.clear();
            this.relatedObservations.addAll(relatedObservations);
        }
    }

    @Override
    public int compareTo(DataEntity<T> o) {
        return Comparator.comparing(DataEntity<T>::getPhenomenonTimeEnd)
                         .thenComparing(DataEntity<T>::getPhenomenonTimeStart)
                         .thenComparing(DataEntity<T>::getPkid)
                         .compare(this, o);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((pkid == null)
                ? 0
                : pkid.hashCode());
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
        if (pkid == null) {
            if (other.pkid != null) {
                return false;
            }
        } else if (!pkid.equals(other.pkid)) {
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
                 .append(pkid)
                 .append(" ]")
                 .toString();
    }
}
