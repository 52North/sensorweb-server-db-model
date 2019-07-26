/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceEntity extends DescribableEntity {

    private static final long serialVersionUID = 8926184900932191238L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceEntity.class);

    private String url;

    private String type = "RESTful series data access layer.";

    private List<String> noDataValues;

    private String version;

    private boolean supportsFirstLatest = true;

    private String connector;

    public ServiceEntity() {
        noDataValues = Collections.emptyList();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(final String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public boolean isNoDataValue(DataEntity<?> observation) {
        return (observation == null) || observation.isNoDataValue(noDataValues);
    }

    public String getNoDataValues() {
        // XXX make parsing more robust
        final String csv = Arrays.toString(noDataValues.toArray(new Double[0]));
        return csv.substring(1).substring(0, csv.length() - 2);
    }

    public void setNoDataValues(final String noDataValues) {
        LOGGER.debug("Set noData values: {}", noDataValues);
        if ((noDataValues == null) || noDataValues.isEmpty()) {
            this.noDataValues = Collections.emptyList();
        } else {
            final String[] values = noDataValues.split(",");
            this.noDataValues = Arrays.asList(values);
        }
    }

    public boolean isSupportsFirstLatest() {
        return supportsFirstLatest;
    }

    public void setSupportsFirstLatest(final boolean supportsFirstLatest) {
        this.supportsFirstLatest = supportsFirstLatest;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(final String version) {
        this.version = version;
    }

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName()).append(" [").append(" url: ").append(getUrl()).append(", type: ")
                .append(getType()).append(", version: ").append(getVersion()).append(", noDataValues: ")
                .append(getNoDataValues()).append(" ]").toString();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ServiceEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
