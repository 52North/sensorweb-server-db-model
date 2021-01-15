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
package org.n52.series.db.beans.i18n;

import org.n52.series.db.beans.sampling.SamplingEntity;

public class I18nSamplingEntity extends I18nEntity<SamplingEntity> {

    private static final long serialVersionUID = 6375003360445007130L;

    private String samplingMethod;

    private String environmentalConditions;

    /**
     * @return the samplingMethod
     */
    public String getSamplingMethod() {
        return samplingMethod;
    }

    /**
     * @param samplingMethod
     *            the samplingMethod to set
     */
    public void setSamplingMethod(String samplingMethod) {
        this.samplingMethod = samplingMethod;
    }

    public boolean isSetSamplingMethod() {
        return getSamplingMethod() != null && !getSamplingMethod().isEmpty();
    }

    /**
     * @return the environmentalConditions
     */
    public String getEnvironmentalConditions() {
        return environmentalConditions;
    }

    /**
     * @param environmentalConditions
     *            the environmentalConditions to set
     */
    public void setEnvironmentalConditions(String environmentalConditions) {
        this.environmentalConditions = environmentalConditions;
    }

    public boolean isSetEnvironmentalConditions() {
        return getEnvironmentalConditions() != null && !getEnvironmentalConditions().isEmpty();
    }
}
