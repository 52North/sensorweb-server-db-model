/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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

import java.util.Objects;
import java.util.Set;

import org.n52.series.db.beans.AbstractFeatureEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public class StaFeatureEntity<T> extends AbstractFeatureEntity<T> {

    private Set<ObservationEntity<?>> observations;

    public StaFeatureEntity(AbstractFeatureEntity<T> afe) {
        super();
        this.setIdentifier(afe.getIdentifier());
        this.setStaIdentifier(afe.getStaIdentifier());
        this.setName(afe.getName());
        this.setDescription(afe.getDescription());
        this.setParameters(afe.getParameters());

        this.setGeometry(afe.getGeometry());
        this.setGeometryEntity(afe.getGeometryEntity());
        this.setXml(afe.getXml());
        this.setFeatureType(afe.getFeatureType());
        this.setUrl(afe.getUrl());
        this.setChildren(afe.getChildren());
        this.setParents(afe.getParents());
        this.setIdentifier(afe.getIdentifier());
    }

    public StaFeatureEntity<T> setObservations(Set<ObservationEntity<?>> observations) {
        this.observations = observations;
        return this;
    }

    public Set<ObservationEntity<?>> getObservations() {
        return observations;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), observations.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof StaFeatureEntity) && super.equals(obj)
                && Objects.hash(observations) == Objects.hash(((StaFeatureEntity) obj).getObservations());
    }
}
