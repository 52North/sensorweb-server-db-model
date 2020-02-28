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

import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.sta.StaRelations.Datastream;

import java.util.Collection;

public class StaDataEntity<T> extends DataEntity<T> implements Datastream<StaDataEntity> {

    private static final long serialVersionUID = -4720091385202877301L;

    private DatastreamEntity datastream;

    private AbstractFeatureEntity<?> featureOfInterest;

    private boolean processed;

    public StaDataEntity() {
    }

    public StaDataEntity(DataEntity<T> entity) {
        super();

        this.setIdentifier(entity.getIdentifier());
        this.setName(entity.getName());
        this.setDescription(entity.getDescription());
        this.setParameters(entity.getParameters());
        this.setId(entity.getId());

        this.setSamplingTimeStart(entity.getSamplingTimeStart());
        this.setSamplingTimeEnd(entity.getSamplingTimeEnd());
        this.setValue(entity.getValue());
        this.setGeometryEntity(entity.getGeometryEntity());
        this.setDeleted(entity.getDeleted());
        this.setValidTimeStart(entity.getValidTimeStart());
        this.setValidTimeEnd(entity.getValidTimeEnd());
        this.setResultTime(entity.getResultTime());
        this.setParent(entity.getParent());
        this.setDataset(entity.getDataset());
        this.setRelatedObservations(entity.getRelatedObservations());
        this.setValueIdentifier(entity.getValueIdentifier());
        this.setValueName(entity.getValueName());
        this.setValueDescription(entity.getValueDescription());
        this.setVerticalFrom(entity.getVerticalFrom());
        this.setVerticalTo(entity.getVerticalTo());
        this.setDetectionLimit(entity.getDetectionLimit());
        this.setSamplingProfile(entity.getSamplingProfile());
        this.setEreportingProfile(entity.getEreportingProfile());
    }

    @Override
    public DatastreamEntity getDatastream() {
        return datastream;
    }

    @Override
    public StaDataEntity setDatastream(DatastreamEntity datastream) {
        this.datastream = datastream;
        return this;
    }

    public AbstractFeatureEntity<?> getFeatureOfInterest() {
        return featureOfInterest;
    }

    public void setFeatureOfInterest(AbstractFeatureEntity<?> featureOfInterest) {
        this.featureOfInterest = featureOfInterest;
    }

    public boolean hasFeatureOfInterest() {
        return getFeatureOfInterest() != null;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return getValue() == null ? false : noDataValues.contains(getValue());
    }

}
