package org.n52.series.db.beans.sta;

public interface AggregationEntity<T> extends AbstractDatastreamEntity {

    void copy(T from);
}
