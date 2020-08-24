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

package org.n52.series.db.beans;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public class DatasetAggregationEntity extends AbstractDatasetEntity {

    private static final long serialVersionUID = 4214347342270609845L;
    private Set<AbstractDatasetEntity> datasets;

    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }

    public void copy(AbstractDatasetEntity dataset) {
        setIdentifier(dataset.getIdentifier());
        setIdentifierCodespace(dataset.getIdentifierCodespace());
        setStaIdentifier(dataset.getStaIdentifier());
        setName(dataset.getName());
        setNameCodespace(dataset.getNameCodespace());
        setDescription(dataset.getDescription());
        if (dataset.getParameters() != null) {
            setParameters(dataset.getParameters().stream().collect(Collectors.toSet()));
        }
        setCategory(dataset.getCategory());
        setFeature(dataset.getFeature());
        setFirstObservation(dataset.getFirstObservation());
        setFirstQuantityValue(dataset.getFirstQuantityValue());
        setFirstValueAt(dataset.getFirstValueAt());
        setLastObservation(dataset.getLastObservation());
        setLastQuantityValue(dataset.getLastQuantityValue());
        setLastValueAt(dataset.getLastValueAt());
        setOMObservationType(dataset.getOMObservationType());
        setOffering(dataset.getOffering());
        setPhenomenon(dataset.getPhenomenon());
        setPlatform(dataset.getPlatform());
        setProcedure(dataset.getProcedure());
        setProcessed(dataset.isProcessed());
        setSamplingTimeStart(dataset.getSamplingTimeStart());
        setSamplingTimeEnd(dataset.getSamplingTimeEnd());
        setGeometryEntity(dataset.getGeometryEntity());
        if (dataset.getResultTimes() != null) {
            setResultTimes(dataset.getResultTimes().stream().collect(Collectors.toSet()));
        }
        setUnit(dataset.getUnit());
        if (dataset instanceof DatasetAggregationEntity) {
            setDatasets(((DatasetAggregationEntity) dataset).getDatasets());
        }
    }

}
