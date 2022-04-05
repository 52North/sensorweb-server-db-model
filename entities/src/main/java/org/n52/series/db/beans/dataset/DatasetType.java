/*
 * Copyright 2015-2022 52°North Spatial Information Research GmbH
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

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public enum DatasetType {
    individualObservation, timeseries, profile, trajectory, not_initialized;

    public static final String ALL = "all";

    public static Set<DatasetType> convert(Collection<String> values) {
        if (values != null) {
            return values.stream().map(at -> DatasetType.getIgnoreCase(at)).filter(Objects::nonNull)
                    .collect(Collectors.toSet());
        }
        return null;
    }

    private static DatasetType getIgnoreCase(String value) {
        for (DatasetType dt : values()) {
            if (dt.name().equalsIgnoreCase(value)) {
                return dt;
            }
        }
        return null;
    }
}