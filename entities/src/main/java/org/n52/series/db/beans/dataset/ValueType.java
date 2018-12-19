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

public enum ValueType {
    quantity, count, text, category, bool, geometry, blob, referenced, not_initialized;

    public static final String ALL = "all";

    public static Set<ValueType> convert(Set<String> valueType) {
        if (valueType != null) {
            if (valueType.contains(ALL)) {
                return new LinkedHashSet<>(Arrays.asList(values()));
            }
            return valueType.stream().map(vt -> ValueType.valueOf(vt)).collect(Collectors.toSet());
        }
        return null;
    }
}