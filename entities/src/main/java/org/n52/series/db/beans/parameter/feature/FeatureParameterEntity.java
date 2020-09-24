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
package org.n52.series.db.beans.parameter.feature;

import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.ParameterFactory;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class FeatureParameterEntity<T> extends ParameterEntity<T>
    implements ParameterFactory<FeatureParameterEntity<?>> {

    public static final String PROP_FEATURE = "feature";
    public static final String PROP_FEATURE_ID = "featureId";

    private AbstractFeatureEntity feature;
    private long featureId;

    public FeatureParameterEntity<?> from(ParameterType type) {
        switch (type) {
            case JSON:
                return new FeatureJsonParameterEntity();
            case XML:
                return new FeatureXmlParameterEntity();
            case TEXT:
                return new FeatureTextParameterEntity();
            case BOOLEAN:
                return new FeatureBooleanParameterEntity();
            case CATEGORY:
                return new FeatureCategoryParameterEntity();
            case COUNT:
                return new FeatureCountParameterEntity();
            case QUANTITY:
                return new FeatureQuantityParameterEntity();
            default:
                return null;
        }
    }

    public AbstractFeatureEntity getFeature() {
        return feature;
    }

    public void setFeature(AbstractFeatureEntity observation) {
        this.feature = observation;
    }

    public long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(long observationId) {
        this.featureId = observationId;
    }
}
