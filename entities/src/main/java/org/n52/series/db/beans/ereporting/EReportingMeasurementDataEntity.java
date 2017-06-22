package org.n52.series.db.beans.ereporting;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EReportingMeasurementDataEntity extends EReportingDataEntity<Double> {

    private static final Logger LOGGER = LoggerFactory.getLogger(EReportingMeasurementDataEntity.class);

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
