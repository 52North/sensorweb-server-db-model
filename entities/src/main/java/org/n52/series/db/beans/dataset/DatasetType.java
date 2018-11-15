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
package org.n52.series.db.beans.dataset;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum DatasetType {
    individual_observation("individualObservation"), timeseries("timeseries"), profile("profile"), trajectory(
            "trajectory"), not_initialized("NotInitialized");

    public static final String ALL = "all";

    private String outputString;

    DatasetType(String outputString) {
        this.outputString = outputString;
    }

    public String getOutputString() {
        return outputString;
    }

    private static DatasetType getEnum(String dt) {
        for (DatasetType datasetType : DatasetType.values()) {
            if (datasetType.getOutputString().equalsIgnoreCase(dt)) {
                return datasetType;
            }
        }
        return DatasetType.valueOf(dt);
    }

    public static Set<DatasetType> convert(Set<String> datasetType) {
        if (datasetType != null) {
            if (datasetType.contains(ALL)) {
                return new LinkedHashSet<>(Arrays.asList(values()));
            }
            return datasetType.stream().map(dt -> DatasetType.getEnum(dt)).collect(Collectors.toSet());
        }
        return null;
    }
}