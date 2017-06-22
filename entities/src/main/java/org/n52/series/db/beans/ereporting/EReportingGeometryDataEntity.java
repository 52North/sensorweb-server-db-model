package org.n52.series.db.beans.ereporting;

import java.util.Collection;

import org.n52.series.db.beans.GeometryEntity;

public class EReportingGeometryDataEntity extends EReportingDataEntity<GeometryEntity> {

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        GeometryEntity value = getValue();
        return value == null
                || value.isEmpty();
    }
}
