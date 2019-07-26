/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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

import java.util.Collection;

import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.sta.StaRelations.Datastream;

public class StaDataEntity extends DataEntity<String> implements Datastream<StaDataEntity> {

    private static final long serialVersionUID = -4720091385202877301L;

    private DatastreamEntity datastream;

    private AbstractFeatureEntity<?> featureOfInterest;

    private boolean processsed;

    public DatastreamEntity getDatastream() {
        return datastream;
    }

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

    public boolean isProcesssed() {
        return processsed;
    }

    public void setProcesssed(boolean processsed) {
        this.processsed = processsed;
    }

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        String value = getValue();
        return (value == null) || noDataValues.contains(value);
    }

}
