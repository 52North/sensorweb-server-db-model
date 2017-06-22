package org.n52.series.db.beans.ereporting;

import java.util.Collection;

public class EReportingBlobDataEntity extends EReportingDataEntity<Object> {

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return getValue() == null;
    }

}
