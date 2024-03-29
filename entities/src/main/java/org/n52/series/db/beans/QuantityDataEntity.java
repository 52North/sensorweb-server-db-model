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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuantityDataEntity extends DataEntity<BigDecimal> implements NumericalDataEntity<BigDecimal> {

    public static final BigDecimal DOUBLE_THRESHOLD = BigDecimal.valueOf(0.0001d);
    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityDataEntity.class);
    private static final long serialVersionUID = 7619426522406105659L;

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return getValue() == null ? false : containsValue(noDataValues, getValue());
    }

    @Override
    public boolean checkNoDataValue(Collection<BigDecimal> noDataValues) {
        return getValue() == null ? false : checkValue(noDataValues, getValue());
    }

    private boolean checkValue(Collection<BigDecimal> collection, BigDecimal value) {
        if (collection == null) {
            return false;
        }
        for (BigDecimal noDataValue : collection) {
            if (noDataValue.subtract(value).abs().compareTo(DOUBLE_THRESHOLD) < 0) {
                return true;
            }
        }
        return false;
    }

    private boolean containsValue(Collection<String> collection, BigDecimal value) {
        if (collection == null) {
            return false;
        }
        return checkValue(convertToDoubles(collection), value);
    }

    private Collection<BigDecimal> convertToDoubles(Collection<String> collection) {
        List<BigDecimal> validatedValues = new ArrayList<>();
        for (String value : collection) {
            String trimmed = value.trim();
            try {
                validatedValues.add(new BigDecimal(trimmed));
            } catch (NumberFormatException e) {
                LOGGER.trace("Ignoring NO_DATA value {} (not a big decimal value).", trimmed);
            }
        }
        return validatedValues;
    }

}
