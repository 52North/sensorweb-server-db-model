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

package org.n52.series.db.beans.data;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations.HasDataset;
import org.n52.series.db.beans.HibernateRelations.HasId;
import org.n52.series.db.beans.HibernateRelations.HasPhenomenonTime;
import org.n52.series.db.beans.IdentifierNameDescriptionEntity;
import org.n52.series.db.beans.RelatedDataEntity;
import org.n52.series.db.beans.UnitEntity;
import org.n52.series.db.beans.parameter.Parameter;

public interface Data<T>
        extends
        HasId,
        IdentifierNameDescriptionEntity,
        HasPhenomenonTime,
        HasDataset {

    BigDecimal NOT_SET_VERTICAL = BigDecimal.valueOf(-99999);

    T getValue();

    void setValue(T value);

    boolean hasValue();

    boolean isNoDataValue(Collection<String> notDataValues);

    GeometryEntity getGeometryEntity();

    void setGeometryEntity(GeometryEntity geometryEntity);

    boolean isSetGeometryEntity();

    boolean getDeleted();

    void setDeleted(boolean deleted);

    Date getValidTimeStart();

    void setValidTimeStart(Date validTimeStart);

    Date getValidTimeEnd();

    void setValidTimeEnd(Date validTimeSEnd);

    boolean isSetValidTime();

    boolean isSetValidStartTime();

    boolean isSetValidEndTime();

    Date getResultTime();

    void setResultTime(Date resultTime);

    boolean isParent();

    void setParent(boolean parent);

    boolean isChild();

    void setChild(boolean child);

    Set<RelatedDataEntity> getRelatedObservations();

    void setRelatedObservations(Set<RelatedDataEntity> relatedData);

    default boolean hasRelatedObservations() {
        return (getRelatedObservations() != null) && !getRelatedObservations().isEmpty();
    }

    Set<Parameter< ? >> getParameters();

    void setParameters(Set<Parameter< ? >> parameters);

    default boolean hasParameters() {
        return (getParameters() != null) && !getParameters().isEmpty();
    }

    String getValueIdentifier();

    void setValueIdentifier(String valudIdentifier);

    default boolean hasValueIdentifier() {
        return (getValueIdentifier() != null) && !getValueIdentifier().isEmpty();
    }

    String getValueName();

    void setValueName(String valueName);

    default boolean hasValueName() {
        return (getValueDescription() != null) && !getValueName().isEmpty();
    }

    String getValueDescription();

    void setValueDescription(String valueDescription);

    default boolean hasValueDescription() {
        return (getValueDescription() != null) && !getValueDescription().isEmpty();
    }

    BigDecimal getVerticalFrom();

    void setVerticalFrom(BigDecimal fromLeve);

    BigDecimal getVerticalTo();

    void setVerticalTo(BigDecimal to);

    default boolean hasVerticalFrom() {
        return (getVerticalFrom() != null) && !getVerticalFrom().equals(NOT_SET_VERTICAL);
    }

    default boolean hasVerticalTo() {
        return (getVerticalTo() != null) && !getVerticalFrom().equals(NOT_SET_VERTICAL);
    }

    interface BlobData extends Data<Object> {
        String VALUE_TYPE = "blob";
    }

    interface BooleanData extends Data<Boolean> {
        String VALUE_TYPE = "boolean";
    }

    interface CategoryData extends Data<String> {
        String VALUE_TYPE = "category";
    }

    interface ComplexData extends Data<Set<DataEntity< ? >>> {
        String VALUE_TYPE = "complex";
    }

    interface CountData extends Data<Integer> {
        String VALUE_TYPE = "count";
    }

    interface DataArrayData extends Data<Set<DataEntity< ? >>> {
        String VALUE_TYPE = "dataarray";
    }

    interface GeometryData extends Data<GeometryEntity> {
        String VALUE_TYPE = "geoemtry";
    }

    interface ProfileData extends Data<Set<DataEntity< ? >>> {
        String VALUE_TYPE = "profile";

        String getVerticalFromName();

        void setVerticalFromName(String fromName);

        String getVerticalToName();

        void setVerticalToName(String toName);

        UnitEntity getVerticalUnit();

        void setVerticalUnit(UnitEntity levelEntity);

        default boolean hasVerticalUnit() {
            return (getVerticalUnit() != null) && getVerticalUnit().isSetIdentifier();
        }

        default boolean hasVerticalFromName() {
            return (getVerticalFromName() != null) && !getVerticalFromName().isEmpty();
        }

        default boolean hasVerticalToName() {
            return (getVerticalToName() != null) && !getVerticalToName().isEmpty();
        }
    }

    interface QuantityData extends Data<BigDecimal> {
        String VALUE_TYPE = "quantity";
        BigDecimal DOUBLE_THRESHOLD = BigDecimal.valueOf(0.0001d);
    }

    interface ReferencedData extends Data<String> {
        String VALUE_TYPE = "referenced";
    }

    interface TextData extends Data<String> {
        String VALUE_TYPE = "text";
    }

}
