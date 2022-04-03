package org.n52.series.db.beans.sta.plus;

import org.n52.series.db.beans.QuantityDataEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StaPlusQuantityDataEntity extends StaPlusDataEntity<BigDecimal> {

    public static final BigDecimal DOUBLE_THRESHOLD = BigDecimal.valueOf(0.0001d);
    private static final Logger LOGGER = LoggerFactory.getLogger(QuantityDataEntity.class);
    private static final long serialVersionUID = 7619426522406105659L;

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return getValue() == null ? false : containsValue(noDataValues, getValue());
    }

    private boolean containsValue(Collection<String> collection, BigDecimal key) {
        if (collection == null) {
            return false;
        }
        for (BigDecimal noDataValue : convertToDoubles(collection)) {
            if (noDataValue.subtract(key).abs().compareTo(DOUBLE_THRESHOLD) < 0) {
                return true;
            }
        }
        return false;
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
