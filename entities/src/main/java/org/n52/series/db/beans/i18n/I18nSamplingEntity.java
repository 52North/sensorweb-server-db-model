/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
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

import java.io.Serial;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import org.n52.series.db.beans.sampling.SamplingEntity;

//@Entity(name = "org.n52.series.db.beans.i18n.I18nSamplingEntity")
//@Table(name = "sampling_i18n", indexes = @Index(name = "idx_sampling_i18n_sampling", columnList = "fk_sampling_id"))
//@AttributeOverride(name = "id", column = @Column(name = "sampling_i18n_id"))
//@AssociationOverride(name = "entity", joinColumns = @JoinColumn(name = "fk_sampling_id", nullable = false))
public class I18nSamplingEntity extends I18nEntity<SamplingEntity> {

    @Serial
    private static final long serialVersionUID = 6375003360445007130L;

    @Column(name = "sampling_method")
    private String samplingMethod;

    @Column(name = "environmental_conditions")
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
