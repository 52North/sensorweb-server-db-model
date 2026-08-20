/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.n52.series.db.beans;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "org.n52.series.db.beans.RelatedDataEntity")
@Table(name = "related_observation",
        indexes = {
                @Index(name = "idx_related_observation_related_observation", columnList = "fk_related_observation_id"),
                @Index(name = "idx_related_observation", columnList = "fk_observation_id") })
// table comment: Store the relation of two observation, e.g. one observation depends on other observations to
// provide context
@AttributeOverride(name = "id", column = @Column(name = "procedure_id"))
public class RelatedDataEntity extends AbstractRelationEntity<DataEntity<?>> {

    public static final String PROPERTY_OBSERVATION = "observation";
    public static final String PROPERTY_RELATED_OBSERVATION = "relatedObservation";

    @EmbeddedId
    private RelatedDataPK id = new RelatedDataPK();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("relatedObservationId")
    @JoinColumn(name = "fk_related_observation_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_rel_obs_related"))
    private DataEntity<?> relatedObservation;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("observationId")
    @JoinColumn(name = "fk_observation_id")
    private DataEntity<?> observation;

    @Override
    public DataEntity<?> getItem() {
        return observation;
    }

    @Override
    public void setItem(DataEntity<?> item) {
        this.observation = item;
    }

    @Override
    public DataEntity<?> getRelatedItem() {
        return relatedObservation;
    }

    @Override
    public void setRelatedItem(DataEntity<?> relatedItem) {
        this.relatedObservation = relatedItem;
    }
}
