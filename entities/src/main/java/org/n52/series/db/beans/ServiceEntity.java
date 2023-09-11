/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
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

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceEntity extends DescribableEntity {

    private static final long serialVersionUID = 8926184900932191238L;

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceEntity.class);

    private String url;

    private String type = "RESTful series data access layer.";

    private List<String> noDataValues = new LinkedList<>();

    private String version;

    private boolean supportsFirstLast = true;

    private String connector;

    private ServiceMetadataEntity serviceMetadata;

    private Set<BigDecimal> quantityNoDataValues = new LinkedHashSet<>();

    private Set<Integer> countNoDataValues = new LinkedHashSet<>();

    public ServiceEntity() {
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
        return observation == null || !observation.hasDetectionLimit() && checkNoDataValue(observation);
    }

    public String getNoDataValues() {
        return String.join(",", noDataValues);
    }

    public void setNoDataValues(final String noDataValues) {
        LOGGER.debug("Set noData values: {}", noDataValues);
        this.noDataValues.clear();
        this.quantityNoDataValues.clear();
        this.countNoDataValues.clear();
        if (noDataValues != null && !noDataValues.isEmpty()) {
            final String[] values = noDataValues.split(",");
            this.noDataValues.addAll(Arrays.asList(values));
            convertToBigDecimal(this.noDataValues);
            convertToIntegers(this.noDataValues);
        }
    }

    public void setNoDataValues(Collection<String> noDataValuesList, Collection<BigDecimal> quantityNoDataValues,
            Collection<Integer> countNoDataValues) {
        this.noDataValues.clear();
        this.quantityNoDataValues.clear();
        this.countNoDataValues.clear();
        this.noDataValues.addAll(noDataValuesList);
        this.quantityNoDataValues.addAll(quantityNoDataValues);
        this.countNoDataValues.addAll(countNoDataValues);
    }

    public boolean getSupportsFirstLast() {
        return supportsFirstLast;
    }

    public void setSupportsFirstLast(boolean supportsFirstLast) {
        this.supportsFirstLast = supportsFirstLast;
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

    public ServiceMetadataEntity getServiceMetadata() {
        return serviceMetadata;
    }

    public void setServiceMetadata(ServiceMetadataEntity serviceMetadata) {
        this.serviceMetadata = serviceMetadata;
    }

    public boolean isSetServiceMetadata() {
        return getServiceMetadata() != null && getServiceMetadata().isSetMetadata();
    }

    private boolean checkNoDataValue(DataEntity<?> observation) {
        if (observation instanceof QuantityDataEntity) {
            return ((QuantityDataEntity) observation).checkNoDataValue(quantityNoDataValues);
        } else if (observation instanceof CountDataEntity) {
            return ((CountDataEntity) observation).checkNoDataValue(countNoDataValues);
        }
        return observation.isNoDataValue(noDataValues);
    }

    private void convertToBigDecimal(Collection<String> collection) {
        for (String value : collection) {
            String trimmed = value.trim();
            try {
                this.quantityNoDataValues.add(new BigDecimal(trimmed));
            } catch (NumberFormatException e) {
                LOGGER.trace("Ignoring NO_DATA value {} (not a big decimal value).", trimmed);
            }
        }
    }

    private void convertToIntegers(Collection<String> collection) {
        for (String value : collection) {
            String trimmed = value.trim();
            try {
                this.countNoDataValues.add(Integer.parseInt(trimmed));
            } catch (NumberFormatException e) {
                LOGGER.trace("Ignoring NO_DATA value {} (not an integer).", trimmed);
            }
        }
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