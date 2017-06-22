package org.n52.series.db.beans.ereporting;

import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.DatasetEntity;

public class EReportingDatasetEntity<T extends DataEntity< ? >> extends DatasetEntity<T> {

    private EReportingSamplingPointEntity samplingPoint;

    public EReportingDatasetEntity(String datasetType) {
        super(datasetType);
    }

    public EReportingSamplingPointEntity getSamplingPoint() {
        return samplingPoint;
    }

    public void setSamplingPoint(EReportingSamplingPointEntity samplingPoint) {
        this.samplingPoint = samplingPoint;
    }
}
