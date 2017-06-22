/*
 * Copyright (C) 2015-2017 52°North Initiative for Geospatial Open Source
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
 * if the distribution is compliant with both the GNU General Public License
 * version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */

package org.n52.series.db.beans.metadata;

import java.sql.Timestamp;
import java.util.Date;

import org.n52.series.db.beans.PkidEntity;

public abstract class MetadataEntity<T> extends PkidEntity {

    static final String PROPERTY_NAME = "name";

    static final String PROPERTY_SERIES_ID = "dataset";

    private Long dataset;

    private String name;

    private String type;

    private T value;

    private Date lastUpdate;

    private String domain;

    public Long getDataset() {
        return dataset;
    }

    public void setDataset(Long dataset) {
        this.dataset = dataset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Date getLastUpdate() {
        return lastUpdate != null
            ? new Timestamp(lastUpdate.getTime())
            : null;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate != null
            ? new Timestamp(lastUpdate.getTime())
            : null;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

//    public DatabaseMetadataOutput<T> toOutput() {
//        return DatabaseMetadataOutput.<T> create()
//                                     .setValue(value)
//                                     .setLastUpdatedAt(lastUpdate);
//    }

}
