package org.n52.series.db.beans.ereporting;

import java.util.Collection;
import java.util.Set;

import org.n52.series.db.beans.DataEntity;

public class EReportingComplexDataEntity extends DataEntity<Set<DataEntity< ? >>> {

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        // TODO Auto-generated method stub
        return false;
    }

}
