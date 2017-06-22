/**
 * Copyright (C) 2012-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.series.db.beans.feature.gml;

import org.n52.series.db.beans.CodespaceEntity;
import org.n52.series.db.beans.feature.ReferenceEntity;
import org.n52.series.db.beans.HibernateRelations.HasRemarks;
import org.n52.series.db.beans.UnitEntity;

/**
 * Hibernate entiity for the coordinateSystemAxis
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class CoordinateSystemAxisEntity extends ReferenceEntity implements HasRemarks<CoordinateSystemAxisEntity> {

    private String remarks;
    private String axisAbbrev;
    private CodespaceEntity axisAbbrevCodespaceEntity;
    private String axisDirection;
    private CodespaceEntity axisDirectionCodespaceEntity;
    private Double minimumValue;
    private Double maximumValue;
    private String rangeMeaning;
    private CodespaceEntity rangeMeaningCodespaceEntity;
    private UnitEntity uom;

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
     *            the axisAbbrev to set
     */
    public void setAxisAbbrev(String axisAbbrev) {
        this.axisAbbrev = axisAbbrev;
    }

    /**
     * @return the axisAbbrevCodespaceEntity
     */
    public CodespaceEntity getCodespaceEntityAxisAbbrev() {
        return axisAbbrevCodespaceEntity;
    }

    /**
     * @param axisAbbrevCodespaceEntity
     *            the axisAbbrevCodespaceEntity to set
     */
    public void setCodespaceEntityAxisAbbrev(CodespaceEntity axisAbbrevCodespaceEntity) {
        this.axisAbbrevCodespaceEntity = axisAbbrevCodespaceEntity;
    }

    public boolean isSetCodespaceEntityAxisAbbrev() {
        return getCodespaceEntityAxisAbbrev() != null && getCodespaceEntityAxisAbbrev().isSetCodespace();
    }

    /**
     * @return the axisDirection
     */
    public String getAxisDirection() {
        return axisDirection;
    }

    /**
     * @param axisDirection
     *            the axisDirection to set
     */
    public void setAxisDirection(String axisDirection) {
        this.axisDirection = axisDirection;
    }

    /**
     * @return the axisDirectionCodespaceEntity
     */
    public CodespaceEntity getCodespaceEntityAxisDirection() {
        return axisDirectionCodespaceEntity;
    }

    /**
     * @param axisDirectionCodespaceEntity
     *            the axisDirectionCodespaceEntity to set
     */
    public void setCodespaceEntityAxisDirection(CodespaceEntity axisDirectionCodespaceEntity) {
        this.axisDirectionCodespaceEntity = axisDirectionCodespaceEntity;
    }

    public boolean isSetCodespaceEntityAxisDirection() {
        return getCodespaceEntityAxisDirection() != null && getCodespaceEntityAxisDirection().isSetCodespace();
    }

    /**
     * @return the minimumValue
     */
    public Double getMinimumValue() {
        return minimumValue;
    }

    /**
     * @param minimumValue
     *            the minimumValue to set
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
     *            the maximumValue to set
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
     *            the rangeMeaning to set
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
        return rangeMeaningCodespaceEntity;
    }

    /**
     * @param rangeMeaningCodespaceEntity
     *            the rangeMeaningCodespaceEntity to set
     */
    public void setCodespaceEntityRangeMeaning(CodespaceEntity rangeMeaningCodespaceEntity) {
        this.rangeMeaningCodespaceEntity = rangeMeaningCodespaceEntity;
    }

    public boolean isSetCodespaceEntityRangeMeaning() {
        return getCodespaceEntityRangeMeaning() != null && getCodespaceEntityRangeMeaning().isSetCodespace();
    }

    /**
     * @return the uom
     */
    public UnitEntity getUom() {
        return uom;
    }

    /**
     * @param uom
     *            the uom to set
     */
    public void setUom(UnitEntity uom) {
        this.uom = uom;
    }
}
