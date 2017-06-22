package org.n52.series.db.beans.dataset;

import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;

public interface Dataset<T extends DatasetEntity<?>> {

    Set<T> getReferenceValues();

    T setReferenceValues(Set<T> referenceValues);

    default boolean hasReferenceValues() {
        return getReferenceValues() != null && !getReferenceValues().isEmpty();
    }
}
