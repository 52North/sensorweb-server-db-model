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

import org.n52.series.db.beans.CodespaceEntity;
import org.n52.series.db.beans.HibernateRelations.HasRemarks;
import org.n52.series.db.beans.UnitEntity;
import org.n52.series.db.beans.feature.ReferenceEntity;

/**
 * Hibernate entiity for the coordinateSystemAxis
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class CoordinateSystemAxisEntity extends ReferenceEntity implements HasRemarks<CoordinateSystemAxisEntity> {

    private static final long serialVersionUID = 1841614376918978967L;

    private String remarks;
    private String axisAbbrev;
    private String axisDirection;
    private String rangeMeaning;
    private CodespaceEntity codespaceEntityAxisAbbrev;
    private CodespaceEntity codespaceEntityAxisDirection;
    private CodespaceEntity codespaceEntityRangeMeaning;
    private Double minimumValue;
    private Double maximumValue;
    private UnitEntity uom;

    /**
     * @return the remarks
     */
    @Override
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     *        the remarks to set
     */
    @Override
    public CoordinateSystemAxisEntity setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    /**
     * @return the axisAbbrev
     */
    public String getAxisAbbrev() {
        return axisAbbrev;
    }

    /**
     * @param axisAbbrev
     *        the axisAbbrev to set
     */
    public void setAxisAbbrev(String axisAbbrev) {
        this.axisAbbrev = axisAbbrev;
    }

    /**
     * @return the codespaceEntityAxisAbbrev
     */
    public CodespaceEntity getCodespaceEntityAxisAbbrev() {
        return codespaceEntityAxisAbbrev;
    }

    /**
     * @param codespaceEntityAxisAbbrev
     *        the codespaceEntityAxisAbbrev to set
     */
    public void setCodespaceEntityAxisAbbrev(CodespaceEntity codespaceEntityAxisAbbrev) {
        this.codespaceEntityAxisAbbrev = codespaceEntityAxisAbbrev;
    }

    public boolean isSetCodespaceEntityAxisAbbrev() {
        return getCodespaceEntityAxisAbbrev() != null && getCodespaceEntityAxisAbbrev().isSetCodespaceEntity();
    }

    /**
     * @return the axisDirection
     */
    public String getAxisDirection() {
        return axisDirection;
    }

    /**
     * @param axisDirection
     *        the axisDirection to set
     */
    public void setAxisDirection(String axisDirection) {
        this.axisDirection = axisDirection;
    }

    /**
     * @return the codespaceEntityAxisDirection
     */
    public CodespaceEntity getCodespaceEntityAxisDirection() {
        return codespaceEntityAxisDirection;
    }

    /**
     * @param codespaceEntityAxisDirection
     *        the codespaceEntityAxisDirection to set
     */
    public void setCodespaceEntityAxisDirection(CodespaceEntity codespaceEntityAxisDirection) {
        this.codespaceEntityAxisDirection = codespaceEntityAxisDirection;
    }

    public boolean isSetCodespaceEntityAxisDirection() {
        return getCodespaceEntityAxisDirection() != null && getCodespaceEntityAxisDirection().isSetCodespaceEntity();
    }

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
    public void setMinimumValue(double minimumValue) {
        this.minimumValue = minimumValue;
    }

    public boolean isSetMinimumValue() {
        return getMaximumValue() != null;
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
    public void setMaximumValue(double maximumValue) {
        this.maximumValue = maximumValue;
    }

    public boolean isSetMaximumValue() {
        return getMaximumValue() != null;
    }

    /**
     * @return the rangeMeaning
     */
    public String getRangeMeaning() {
        return rangeMeaning;
    }

    /**
     * @param rangeMeaning
     *        the rangeMeaning to set
     */
    public void setRangeMeaning(String rangeMeaning) {
        this.rangeMeaning = rangeMeaning;
    }

    public boolean isSetRangeMeaning() {
        return getRangeMeaning() != null && !getRangeMeaning().isEmpty();
    }

    /**
     * @return the rangeMeaningCodespaceEntity
     */
    public CodespaceEntity getCodespaceEntityRangeMeaning() {
        return codespaceEntityRangeMeaning;
    }

    /**
     * @param codespaceEntityRangeMeaning
     *        the codespaceEntityRangeMeaning to set
     */
    public void setCodespaceEntityRangeMeaning(CodespaceEntity codespaceEntityRangeMeaning) {
        this.codespaceEntityRangeMeaning = codespaceEntityRangeMeaning;
    }

    public boolean isSetCodespaceEntityRangeMeaning() {
        return getCodespaceEntityRangeMeaning() != null && getCodespaceEntityRangeMeaning().isSetCodespaceEntity();
    }

    /**
     * @return the uom
     */
    public UnitEntity getUom() {
        return uom;
    }

    /**
     * @param uom
     *        the uom to set
     */
    public void setUom(UnitEntity uom) {
        this.uom = uom;
    }
}
