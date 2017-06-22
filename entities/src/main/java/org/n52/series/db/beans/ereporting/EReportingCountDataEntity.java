package org.n52.series.db.beans.ereporting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EReportingCountDataEntity extends EReportingDataEntity<Integer> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EReportingCountDataEntity.class);

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

}
