package org.n52.series.db.beans.dataset;

import org.n52.series.db.beans.DatasetEntity;

public interface MeasurementDataset<T extends DatasetEntity<?>> extends Dataset<T> {

    String DATASET_TYPE = "measurement";

    int getNumberOfDecimals();

    T setNumberOfDecimals(int numberOfDecimals);
}
