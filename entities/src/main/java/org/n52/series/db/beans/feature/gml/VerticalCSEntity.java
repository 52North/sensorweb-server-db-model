/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans.feature.gml;

import java.util.Set;

import org.n52.series.db.beans.feature.ReferenceEntity;
import org.n52.series.db.beans.HibernateRelations.HasRemarks;

/**
 * Hibernate entiity for the verticalCS
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class VerticalCSEntity extends ReferenceEntity implements HasRemarks<VerticalCSEntity>{

    private String remarks;
    private Set<CoordinateSystemAxisEntity> coordinateSystemAxis;
    private String aggregation;

    /**
     * @return the remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     *            the remarks to set
     */
    public VerticalCSEntity setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    /**
     * @return the coordinateSystemAxis
     */
    public Set<CoordinateSystemAxisEntity> getCoordinateSystemAxis() {
        return coordinateSystemAxis;
    }

    /**
     * @param coordinateSystemAxis
     *            the coordinateSystemAxis to set
     */
    public void setCoordinateSystemAxis(Set<CoordinateSystemAxisEntity> coordinateSystemAxis) {
        this.coordinateSystemAxis = coordinateSystemAxis;
    }

    public boolean hasCoordinateSystemAxis() {
        return getCoordinateSystemAxis() != null && !getCoordinateSystemAxis().isEmpty();
    }

    /**
     * @return the aggregation
     */
    public String getAggregation() {
        return aggregation;
    }

    /**
     * @param aggregation
     *            the aggregation to set
     */
    public void setAggregation(String aggregation) {
        this.aggregation = aggregation;
    }

    public boolean isSetAggregation() {
        return getAggregation() != null && !getAggregation().isEmpty();
    }
}
