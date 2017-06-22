package org.n52.series.db.beans.dataset;

import org.n52.series.db.beans.DatasetEntity;

public interface BlobDataset<T extends DatasetEntity<?>> extends Dataset<T> {

    String DATASET_TYPE = "text";

}
