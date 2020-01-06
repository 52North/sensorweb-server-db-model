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

import java.math.BigDecimal;

public class DetectionLimitEntity {

    private Short flag;

    private BigDecimal detectionLimit;

    /**
     * @return the flag
     */
    public Short getFlag() {
        return flag;
    }

    /**
     * @param flag
     *            the flag to set
     */
    public void setFlag(Short flag) {
        this.flag = flag;
    }

    public boolean isSetFlag() {
        return getFlag() != null;
    }

    /**
     * @return the detectionLimit
     */
    public BigDecimal getDetectionLimit() {
        return detectionLimit;
    }

    /**
     * @param detectionLimit
     *            the detectionLimit to set
     */
    public void setDetectionLimit(BigDecimal detectionLimit) {
        this.detectionLimit = detectionLimit;
    }

    public boolean hasDetectionLimit() {
        return getDetectionLimit() != null;
    }

    public boolean isSetDetectionLimit() {
        return isSetFlag() && hasDetectionLimit();
    }
}
