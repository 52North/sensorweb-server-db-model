package org.n52.series.db.beans.ereporting;

import java.util.Collection;

public class EReportingCategoryDataEntity extends EReportingDataEntity<String> {

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        String value = getValue();
        return value == null
                || noDataValues.contains(value);
    }

}
