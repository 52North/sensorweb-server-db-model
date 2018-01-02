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
package org.n52.series.db.beans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuantityDataEntity extends DataEntity<Double> {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityDataEntity.class);

    private static final long serialVersionUID = 7619426522406105659L;

    private static final Double DOUBLE_THRESHOLD = 0.01;

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        Double value = getValue();
        return value == null
                || Double.isNaN(value)
                || containsValue(noDataValues, value);
    }

    private boolean containsValue(Collection<String> collection, double key) {
        if (collection == null) {
            return false;
        }
        for (Double noDataValue : convertToDoubles(collection)) {
            if (Math.abs(noDataValue / key - 1) < DOUBLE_THRESHOLD) {
                return true;
            }
        }
        return false;
    }

    private Collection<Double> convertToDoubles(Collection<String> collection) {
        List<Double> validatedValues = new ArrayList<>();
        for (String value : collection) {
            String trimmed = value.trim();
            try {
                validatedValues.add(Double.parseDouble(trimmed));
            } catch (NumberFormatException e) {
                LOGGER.trace("Ignoring NO_DATA value {} (not a double).", trimmed);
            }
        }
        return validatedValues;
    }

}
