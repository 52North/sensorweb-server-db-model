/*
 * Copyright 2018 52°North Initiative for Geospatial Open Source Software GmbH.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.n52.series.db.beans.sta;

import com.vividsolutions.jts.geom.Geometry;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.FormatEntity;
import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations.HasDescription;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.HibernateRelations.HasName;
import org.n52.series.db.beans.HibernateRelations.HasObservationType;
import org.n52.series.db.beans.HibernateRelations.HasPhenomenonTime;
import org.n52.series.db.beans.HibernateRelations.HasProcedure;
import org.n52.series.db.beans.HibernateRelations.HasResultTime;
import org.n52.series.db.beans.HibernateRelations.HasUnit;
import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.PhenomenonEntity;
import org.n52.series.db.beans.ProcedureEntity;
import org.n52.series.db.beans.UnitEntity;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class DataStreamEntity extends IdEntity implements Serializable, HasName,
        HasDescription, HasObservationType<DataStreamEntity>, HasPhenomenonTime,
        HasResultTime, HasUnit, HasProcedure<DataStreamEntity>, HasGeometry {

    private static final long serialVersionUID = -9067390076853876658L;

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_OBSERVATION_TYPE = "observationType";
    public static final String PROPERTY_UNIT = "unitOfMeasurement";
    public static final String PROPERTY_OBSERVED_AREA = "observedArea";
    public static final String PROPERTY_SAMPLING_TIME_START = "samplingTimeStart";
    public static final String PROPERTY_SAMPLING_TIME_END = "samplingTimeEnd";
    public static final String PROPERTY_RESULT_TIME = "resultTime";

    private String name;
    private String description;
    private FormatEntity observationType;
    private UnitEntity unitEntity;
    private GeometryEntity geometryEntity;
    private Date samplingTimeStart;
    private Date samplingTimeEnd;
    private Date resultTime;

    private ThingEntity thingEntity;
    private ProcedureEntity procedureEntity;
    private PhenomenonEntity phenomenonEntiy;
    private Set<DatasetEntity> dataSetEntities;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
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
    public Date getSamplingTimeStart() {
        return samplingTimeStart;
    }

    @Override
    public void setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = samplingTimeStart;
    }

    @Override
    public Date getSamplingTimeEnd() {
        return samplingTimeEnd;
    }

    @Override
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = samplingTimeEnd;
    }

    @Override
    public Date getResultTime() {
        return resultTime;
    }

    @Override
    public void setResultTime(Date resultTime) {
        this.resultTime = resultTime;
    }

    @Override
    public UnitEntity getUnit() {
        return unitEntity;
    }

    @Override
    public void setUnit(UnitEntity unit) {
        this.unitEntity = unit;
    }

    @Override
    public boolean isSetUnit() {
        return unitEntity != null;
    }

    public Set<DatasetEntity> getDataSetEntities() {
        return dataSetEntities;
    }

    public void setDataSetEntities(Set<DatasetEntity> dataSetEntities) {
        this.dataSetEntities = dataSetEntities;
    }

    @Override
    public FormatEntity getObservationType() {
        return observationType;
    }

    @Override
    public DataStreamEntity setObservationType(FormatEntity observationType) {
        this.observationType = observationType;
        return this;
    }

    @Override
    public boolean isSetObservationType() {
        return this.observationType != null;
    }

    public ThingEntity getThingEntity() {
        return thingEntity;
    }

    public void setThingEntity(ThingEntity thingEntity) {
        this.thingEntity = thingEntity;
    }

    @Override
    public DataStreamEntity setProcedure(ProcedureEntity procedure) {
        this.procedureEntity = procedure;
        return this;
    }

    @Override
    public ProcedureEntity getProcedure() {
        return procedureEntity;
    }

    public UnitEntity getUnitEntity() {
        return unitEntity;
    }

    public void setUnitEntity(UnitEntity unitEntity) {
        this.unitEntity = unitEntity;
    }

    public ProcedureEntity getProcedureEntity() {
        return procedureEntity;
    }

    public void setProcedureEntity(ProcedureEntity procedureEntity) {
        this.procedureEntity = procedureEntity;
    }

    public PhenomenonEntity getPhenomenonEntiy() {
        return phenomenonEntiy;
    }

    public void setPhenomenonEntiy(PhenomenonEntity phenomenonEntiy) {
        this.phenomenonEntiy = phenomenonEntiy;
    }

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public DataStreamEntity setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        this.geometryEntity.setSrid(geometry.getSRID());
        return this;
    }

    @Override
    public DataStreamEntity setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
        return this;
    }

}
