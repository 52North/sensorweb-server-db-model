/*
 * Copyright (C) 2015-2021 52°North Spatial Information Research GmbH
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

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasProcedureDescriptionFormat;
import org.n52.series.db.beans.HibernateRelations.HasProcedureHistory;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;

import java.util.Set;

public class ProcedureEntity extends HierarchicalEntity<ProcedureEntity> implements HasProcedureHistory,
        HasProcedureDescriptionFormat, HasGeometry, HibernateRelations.HasAbstractDatasets, IsStaEntity {

    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_VALID_PROCEDURE_TIME = "procedureHistory";
    public static final String PROPERTY_PROCEDURE_DESCRIPTION_FORMAT = "format";
    public static final String PROPERTY_DESCRIPTION_FILE = "descriptionFile";

    private static final long serialVersionUID = 4028002933920185756L;

    private boolean reference;

    private FormatEntity format;

    private boolean deleted;

    private String descriptionFile;

    private ProcedureEntity typeOf;

    private boolean type;

    private boolean aggregation;

    private Set<ProcedureHistoryEntity> procedureHistory;

    private GeometryEntity geometryEntity;

    private Set<AbstractDatasetEntity> datasets;

    public boolean isReference() {
        return reference;
    }

    public void setReference(boolean reference) {
        this.reference = reference;
    }

    @Override
    public FormatEntity getFormat() {
        return this.format;
    }

    @Override
    public void setFormat(FormatEntity format) {
        this.format = format;
    }

    public boolean isSetFormat() {
        return getFormat() != null && getFormat().isSetFormat();
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescriptionFile() {
        return descriptionFile;
    }

    public void setDescriptionFile(String descriptionFile) {
        this.descriptionFile = descriptionFile;
    }

    public boolean isSetDescriptionFile() {
        return getDescriptionFile() != null && !getDescriptionFile().isEmpty();
    }

    public ProcedureEntity getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(ProcedureEntity typeOf) {
        this.typeOf = typeOf;
    }

    public boolean isSetTypeOf() {
        return getTypeOf() != null;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean isType) {
        this.type = isType;
    }

    public boolean isAggregation() {
        return aggregation;
    }

    public void setAggregation(boolean isAggregation) {
        this.aggregation = isAggregation;
    }

    @Override
    public Set<ProcedureHistoryEntity> getProcedureHistory() {
        return procedureHistory;
    }

    @Override
    public void setProcedureHistory(Set<ProcedureHistoryEntity> procedureHistory) {
        this.procedureHistory = procedureHistory;
    }

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public void setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        if (geometry != null) {
            this.geometryEntity.setSrid(geometry.getSRID());
        }
    }

    @Override
    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ProcedureEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
