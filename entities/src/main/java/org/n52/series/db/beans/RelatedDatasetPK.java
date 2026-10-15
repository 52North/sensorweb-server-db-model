package org.n52.series.db.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelatedDatasetPK implements Serializable {

    @Column(name = "fk_dataset_id")
    private Long datasetId;

    @Column(name = "fk_related_dataset_id")
    private Long relatedDatasetId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RelatedDatasetPK that = (RelatedDatasetPK) o;
        return Objects.equals(datasetId, that.datasetId) && Objects.equals(relatedDatasetId, that.relatedDatasetId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasetId, relatedDatasetId);
    }
}