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

package org.n52.series.db.beans.metadata;

import java.sql.Timestamp;
import java.util.Date;

import org.n52.series.db.beans.IdEntity;

public abstract class MetadataEntity<T> extends IdEntity {

    public static final String PROPERTY_DOMAIN = "domain";

    static final String PROPERTY_NAME = "name";

    static final String PROPERTY_SERIES_ID = "dataset";

    private static final long serialVersionUID = -8312685947116728741L;

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
}