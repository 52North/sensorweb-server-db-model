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

package org.n52.series.db.beans;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceEntity extends DescribableEntity {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceEntity.class);

    private String url;

    private String type = "Thin DB access layer service.";

    private List<String> noDataValues;

    private String version;

    public ServiceEntity() {
        noDataValues = Collections.emptyList();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isNoDataValue(DataEntity< ? > observation) {
        return observation.isNoDataValue(noDataValues);
    }

    public String getNoDataValues() {
        // XXX make parsing more robust
        final String csv = Arrays.toString(noDataValues.toArray(new Double[0]));
        return csv.substring(1)
                  .substring(0, csv.length() - 2);
    }

    public void setNoDataValues(String noDataValues) {
        LOGGER.debug("Set noData values: {}", noDataValues);
        if (noDataValues == null || noDataValues.isEmpty()) {
            this.noDataValues = Collections.emptyList();
        } else {
            String[] values = noDataValues.split(",");
            this.noDataValues = Arrays.asList(values);
        }
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" url: ")
                 .append(getUrl())
                 .append(", type: ")
                 .append(getType())
                 .append(", version: ")
                 .append(getVersion())
                 .append(", noDataValues: ")
                 .append(getNoDataValues())
                 .append(" ]")
                 .toString();
    }

}
