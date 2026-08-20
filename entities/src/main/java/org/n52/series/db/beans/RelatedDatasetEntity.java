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

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity(name = "org.n52.series.db.beans.RelatedDatasetEntity")
@Table(name = "related_dataset",
        indexes = @Index(name = "idx_related_dataset_related_dataset", columnList = "fk_related_dataset_id"))
// table comment: Store the relation of two datasets, e.g. one dataset depends on other datasets to provide
// context
public class RelatedDatasetEntity extends AbstractRelationEntity<DatasetEntity> {

    @EmbeddedId
    private RelatedDatasetPK id = new RelatedDatasetPK();

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("relatedDatasetId")
    @JoinColumn(name = "fk_related_dataset_id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_rel_dataset_rel_dataset"))
    private DatasetEntity relatedDataset;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId("datasetId")
    @JoinColumn(name = "fk_dataset_id")
    private DatasetEntity dataset;

    @Override
    public DatasetEntity getItem() {
        return dataset;
    }

    @Override
    public void setItem(DatasetEntity item) {
        this.dataset = item;
    }

    @Override
    public DatasetEntity getRelatedItem() {
        return relatedDataset;
    }

    @Override
    public void setRelatedItem(DatasetEntity relatedItem) {
        this.relatedDataset = relatedItem;
    }
}
