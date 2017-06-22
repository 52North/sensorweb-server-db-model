package org.n52.series.db.beans.ereporting;

import java.util.Collection;

public class EReportingBooleanDataEntity extends EReportingDataEntity<Boolean> {

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        Boolean value = getValue();
        return value == null
                || noDataValues.contains(value.toString());
    }

}
