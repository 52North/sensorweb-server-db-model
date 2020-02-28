/*
 * Copyright (C) 2018-2020 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.sta;

import org.n52.series.db.beans.AbstractFeatureEntity;

import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public class StaFeatureEntity<T> extends AbstractFeatureEntity<T> {

    private Set<StaDataEntity<?>> observations;

    public StaFeatureEntity(AbstractFeatureEntity<T> afe) {
        super();
        this.setIdentifier(afe.getIdentifier());

        this.setGeometry(afe.getGeometry());
        this.setGeometryEntity(afe.getGeometryEntity());
        this.setXml(afe.getXml());
        this.setFeatureType(afe.getFeatureType());
        this.setUrl(afe.getUrl());
        this.setChildren(afe.getChildren());
        this.setParents(afe.getParents());
        this.setIdentifier(afe.getIdentifier());
        this.setParameters(afe.getParameters());
    }

    public StaFeatureEntity<T> setObservations(Set<StaDataEntity<?>> observations) {
        this.observations = observations;
        return this;
    }

    public Set<StaDataEntity<?>> getObservations() {
        return observations;
    }
}
