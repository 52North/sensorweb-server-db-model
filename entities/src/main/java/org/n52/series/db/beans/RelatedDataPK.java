package org.n52.series.db.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RelatedDataPK implements Serializable {

    @Column(name = "fk_observation_id")
    private Long observationId;

    @Column(name = "fk_related_observation_id")
    private Long relatedObservationId;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RelatedDataPK that = (RelatedDataPK) o;
        return Objects.equals(observationId, that.observationId)
                && Objects.equals(relatedObservationId, that.relatedObservationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(observationId, relatedObservationId);
    }
}