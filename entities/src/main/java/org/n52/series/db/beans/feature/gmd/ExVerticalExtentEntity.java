/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.feature.gmd;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.feature.gml.VerticalCRSEntity;

/**
 * Hibernate entity for exVerticalExtent.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class ExVerticalExtentEntity extends AbstractCiEntity {

    private static final long serialVersionUID = 4387639041569175476L;

    private Double minimumValue;
    private String minValuNilReason;
    private Double maximumValue;
    private String maxValuNilReason;
    private VerticalCRSEntity verticalCRS;

    /**
     * @return the minimumValue
     */
    public Double getMinimumValue() {
        return minimumValue;
    }

    /**
     * @param minimumValue
     *        the minimumValue to set
     */
    public void setMinimumValue(Double minimumValue) {
        this.minimumValue = minimumValue;
    }

    public boolean isSetMinimumValue() {
        return getMinimumValue() != null;
    }

    /**
     * @return the minValuNilReason
     */
    public String getMinValuNilReason() {
        return minValuNilReason;
    }

    /**
     * @param minValuNilReason
     *        the minValuNilReason to set
     */
    public void setMinValuNilReason(String minValuNilReason) {
        this.minValuNilReason = minValuNilReason;
    }

    public boolean isSetMinValuNilReason() {
        return getMinValuNilReason() != null && getMinValuNilReason().isEmpty();
    }

    /**
     * @return the maximumValue
     */
    public Double getMaximumValue() {
        return maximumValue;
    }

    /**
     * @param maximumValue
     *        the maximumValue to set
     */
    public void setMaximumValue(Double maximumValue) {
        this.maximumValue = maximumValue;
    }

    public boolean isSetMaximumValue() {
        return getMaximumValue() != null;
    }

    /**
     * @return the maxValuNilReason
     */
    public String getMaxValuNilReason() {
        return maxValuNilReason;
    }

    /**
     * @param maxValuNilReason
     *        the maxValuNilReason to set
     */
    public void setMaxValuNilReason(String maxValuNilReason) {
        this.maxValuNilReason = maxValuNilReason;
    }

    public boolean isSetMaxValuNilReason() {
        return getMaxValuNilReason() != null && getMaxValuNilReason().isEmpty();
    }

    /**
     * @return the verticalCRS
     */
    public VerticalCRSEntity getVerticalCRS() {
        return verticalCRS;
    }

    /**
     * @param verticalCRS
     *        the verticalCRS to set
     */
    public void setVerticalCRS(VerticalCRSEntity verticalCRS) {
        this.verticalCRS = verticalCRS;
    }

    public boolean isSetVerticalCRS() {
        return getVerticalCRS() != null;
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ExVerticalExtentEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
