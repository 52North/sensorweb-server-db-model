package org.n52.series.db.beans.ereporting;

import java.util.Collection;

import org.n52.series.db.beans.DataEntity;

public class EReportingSweDataArrayDataEntity extends DataEntity<String> {

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        String value = getValue();
        return value == null
                || noDataValues.contains(value);
    }
}
