/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans.parameter.feature;

import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class FeatureParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_FEATURE = "feature";
    public static final String PROP_FEATURE_ID = "featureId";
    private static final long serialVersionUID = 1123453212836718013L;
    private AbstractFeatureEntity feature;
    private long featureId;

    public AbstractFeatureEntity getFeature() {
        return feature;
    }

    public void setFeature(AbstractFeatureEntity feature) {
        this.feature = feature;
    }

    public long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(long observationId) {
        this.featureId = observationId;
    }

    @Override
    public void setEntity(Object entity) {
        setFeature((AbstractFeatureEntity) entity);
    }
}
