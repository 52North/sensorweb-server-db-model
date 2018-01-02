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
package org.n52.series.db.beans.ereporting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EReportingCountDataEntity extends EReportingDataEntity<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EReportingCountDataEntity.class);

    private static final long serialVersionUID = 1753251418906573384L;

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        Integer value = getValue();
        return value == null
                || containsValue(noDataValues, value);
    }

    private boolean containsValue(Collection<String> collection, Integer value) {
        for (Integer noDataValue : convertToIntegers(collection)) {
            if (noDataValue.equals(value)) {
                return true;
            }
        }
        return false;
    }

    private Collection<Integer> convertToIntegers(Collection<String> collection) {
        List<Integer> validatedValues = new ArrayList<>();
        for (String value : collection) {
            String trimmed = value.trim();
            try {
                validatedValues.add(Integer.parseInt(trimmed));
            } catch (NumberFormatException e) {
                LOGGER.debug("Ignoring NO_DATA value {} (not an integer).", trimmed);
            }
        }
        return validatedValues;
    }

    @Override
    public boolean isSetValue() {
        return getValue() != null;
    }

    @Override
    public String getValueAsString() {
        return isSetValue()
                ? getValue().toString()
                : "";
    }

}
