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
package org.n52.series.db.beans;

import java.io.Serializable;

import org.n52.series.db.beans.HibernateRelations.HasResultEncoding;
import org.n52.series.db.beans.HibernateRelations.HasResultStructure;

/**
 * @since 4.0.0
 *
 */
public class ResultTemplateEntity extends PkidEntity implements Serializable,  HasResultStructure, HasResultEncoding {

    private static final long serialVersionUID = -8847952458819368733L;

    private DatasetEntity<DataEntity<?>> dataset;

    private String identifier;

    private String resultStructure;

    private String resultEncoding;

    public ResultTemplateEntity() {
    }

    public DatasetEntity<DataEntity<?>> getDataset() {
        return dataset;
    }

    public void setDataset(DatasetEntity<DataEntity<?>> dataset) {
        this.dataset = dataset;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isSetIdentifier() {
        return getIdentifier() != null && !getIdentifier().isEmpty();
    }

    @Override
    public String getResultStructure() {
        return resultStructure;
    }

    @Override
    public boolean isSetResultStructure() {
        return getResultStructure() != null && !getResultStructure().isEmpty();
    }

    @Override
    public void setResultStructure(String resultStructure) {
        this.resultStructure = resultStructure;
    }

    @Override
    public String getResultEncoding() {
        return this.resultEncoding;
    }

    @Override
    public boolean isSetResultEncoding() {
        return getResultEncoding() != null && !getResultEncoding().isEmpty();
    }

    @Override
    public void setResultEncoding(String resultEncoding) {
        this.resultEncoding = resultEncoding;
    }

}
