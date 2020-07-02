/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans.sta;

import java.io.Serializable;
import java.util.Set;

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class DatasetAggregationEntity extends StaDescribableEntity implements Serializable,
        // HasObservationType<DatasetAggregationEntity>, HasObservableProperty<DatasetAggregationEntity>,
        // HasPhenomenonTime<DatasetAggregationEntity>, HasUnit<DatasetAggregationEntity>,
        // HasProcedure<DatasetAggregationEntity>,
        HasGeometry<DatasetAggregationEntity> {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_OBSERVATION_TYPE = "observationType";
    public static final String PROPERTY_UNIT = "unitOfMeasurement";
    public static final String PROPERTY_OBSERVED_AREA = "observedArea";
    public static final String PROPERTY_SAMPLING_TIME_START = "samplingTimeStart";
    public static final String PROPERTY_SAMPLING_TIME_END = "samplingTimeEnd";
    public static final String PROPERTY_RESULT_TIME_START = "resultTimeStart";
    public static final String PROPERTY_RESULT_TIME_END = "resultTimeEnd";
    public static final String PROPERTY_THING = "thing";
    public static final String PROPERTY_SENSOR = "procedure";
    public static final String PROPERTY_OBSERVABLE_PROPERTY = "observableProperty";
    public static final String PROPERTY_DATASETS = "datasets";
    public static final String PROPERTY_OBSERVATIONS = "observations";

    private static final long serialVersionUID = -9067390076853876658L;
    private GeometryEntity geometryEntity;
    // private Date samplingTimeStart;
    // private Date samplingTimeEnd;
    // private Date resultTimeStart;
    // private Date resultTimeEnd;
    //
    // private FormatEntity observationType;
    // private UnitEntity unitOfMeasurement;
    // private PlatformEntity thing;
    // private ProcedureEntity procedure;
    // private PhenomenonEntity observableProperty;

    private Set<DatasetEntity> datasets;
    private Set<AbstractObservationEntity> observations;

    // @Override
    // public Date getSamplingTimeStart() {
    // return Utils.createUnmutableTimestamp(samplingTimeStart);
    // }
    //
    // @Override
    // public DatasetAggregationEntity setSamplingTimeStart(Date samplingTimeStart) {
    // this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
    // return this;
    // }
    //
    // @Override
    // public Date getSamplingTimeEnd() {
    // return Utils.createUnmutableTimestamp(samplingTimeEnd);
    // }
    //
    // @Override
    // public DatasetAggregationEntity setSamplingTimeEnd(Date samplingTimeEnd) {
    // this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
    // return this;
    // }
    //
    // public Date getResultTimeStart() {
    // return Utils.createUnmutableTimestamp(resultTimeStart);
    // }
    //
    // public DatasetAggregationEntity setResultTimeStart(Date resultTimeStart) {
    // this.resultTimeStart = Utils.createUnmutableTimestamp(resultTimeStart);
    // return this;
    // }
    //
    // public boolean hasResultTimeStart() {
    // return getResultTimeStart() != null;
    // }
    //
    // public Date getResultTimeEnd() {
    // return Utils.createUnmutableTimestamp(resultTimeEnd);
    // }
    //
    // public DatasetAggregationEntity setResultTimeEnd(Date resultTimeEnd) {
    // this.resultTimeEnd = Utils.createUnmutableTimestamp(resultTimeEnd);
    // return this;
    // }
    //
    // public boolean hasResultTimeEnd() {
    // return getResultTimeEnd() != null;
    // }
    //
    // @Override
    // public UnitEntity getUnit() {
    // return unitOfMeasurement;
    // }
    //
    // @Override
    // public DatasetAggregationEntity setUnit(UnitEntity unit) {
    // this.unitOfMeasurement = unit;
    // return this;
    // }
    //
    // @Override
    // public boolean isSetUnit() {
    // return getUnitOfMeasurement() != null && getUnitOfMeasurement().isSetIdentifier();
    // }
    //
    // @Override
    // public FormatEntity getObservationType() {
    // return observationType;
    // }
    //
    // @Override
    // public DatasetAggregationEntity setObservationType(FormatEntity observationType) {
    // this.observationType = observationType;
    // return this;
    // }
    //
    // @Override
    // public boolean isSetObservationType() {
    // return this.observationType != null;
    // }
    //
    // public PlatformEntity getThing() {
    // return thing;
    // }
    //
    // public DatasetAggregationEntity setThing(PlatformEntity thing) {
    // this.thing = thing;
    // return this;
    // }
    //
    // public boolean hasThing() {
    // return thing != null;
    // }
    //
    // @Override
    // public DatasetAggregationEntity setProcedure(ProcedureEntity procedure) {
    // this.procedure = procedure;
    // return this;
    // }
    //
    // @Override
    // public ProcedureEntity getProcedure() {
    // return procedure;
    // }
    //
    // public boolean hasProcedure() {
    // return procedure != null;
    // }
    //
    // public UnitEntity getUnitOfMeasurement() {
    // return unitOfMeasurement;
    // }
    //
    // public DatasetAggregationEntity setUnitOfMeasurement(UnitEntity unitOfMeasurement) {
    // this.unitOfMeasurement = unitOfMeasurement;
    // return this;
    // }
    //
    // @Override
    // public DatasetAggregationEntity setObservableProperty(PhenomenonEntity observableProperty) {
    // this.observableProperty = observableProperty;
    // return this;
    // }
    //
    // @Override
    // public PhenomenonEntity getObservableProperty() {
    // return observableProperty;
    // }
    //
    // public boolean hasObservableProperty() {
    // return observableProperty != null;
    // }

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public DatasetAggregationEntity setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        this.geometryEntity.setSrid(geometry.getSRID());
        return this;
    }

    @Override
    public DatasetAggregationEntity setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
        return this;
    }

    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    public DatasetAggregationEntity setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
        return this;
    }

    public DatasetAggregationEntity setObservations(Set<AbstractObservationEntity> observations) {
        this.observations = observations;
        return this;
    }

    public Set<AbstractObservationEntity> getObservations() {
        return observations;
    }

    public boolean hasObservations() {
        return getObservations() != null && !getObservations().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof DatasetAggregationEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
