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
package org.n52.series.db.beans.ereporting;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasAssessmentType;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasNetwork;
import org.n52.series.db.beans.ereporting.HiberanteEReportingRelations.HasStation;

/**
 * Entity for AQD e-Reporting SamplingPoint
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class EReportingSamplingPointEntity extends DescribableEntity implements HasAssessmentType,
        HasStation, HasNetwork {

    public static final String ID = "samplingPointId";

    private Long samplingPointId;

    private EReportingAssessmentTypeEntity assessmentType;

    private EReportingStationEntity station;

    private EReportingNetworkEntity network;

    /**
     * @return the samplingPointId
     */
    public Long getSamplingPointId() {
        return samplingPointId;
    }

    /**
     * @param samplingPointId
     *            the samplingPointId to set
     */
    public void setSamplingPointId(Long samplingPointId) {
        this.samplingPointId = samplingPointId;
    }

    @Override
    public EReportingAssessmentTypeEntity getAssessmentType() {
        return assessmentType;
    }

    @Override
    public void setAssessmentType(EReportingAssessmentTypeEntity assessmentType) {
        this.assessmentType = assessmentType;
    }

    @Override
    public boolean isSetAssessmentType() {
        return getAssessmentType() != null &&
               getAssessmentType().isSetAssessmentType();
    }

    @Override
    public EReportingNetworkEntity getNetwork() {
        return network;
    }

    @Override
    public HasNetwork setNetwork(EReportingNetworkEntity network) {
        this.network = network;
        return this;
    }

    @Override
    public boolean isSetNetwork() {
        return getNetwork() != null;
    }

    @Override
    public EReportingStationEntity getStation() {
        return station;
    }

    @Override
    public HasStation setStation(EReportingStationEntity station) {
        this.station = station;
        return this;
    }

    @Override
    public boolean isSetStation() {
        return getStation() != null;
    }

}
