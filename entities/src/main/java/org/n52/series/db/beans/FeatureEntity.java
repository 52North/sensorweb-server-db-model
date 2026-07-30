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

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

import java.io.Serial;
import java.util.Set;

@Entity(name = "org.n52.series.db.beans.FeatureEntity")
@DiscriminatorValue("null")
public class FeatureEntity extends AbstractFeatureEntity<FeatureEntity> {

    @Serial
    private static final long serialVersionUID = 3926633318714623558L;

    @Override
    @ManyToMany(fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    @JoinTable(name = "feature_hierarchy",
            joinColumns = @JoinColumn(name = "fk_child_feature_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_feature_child")),
            inverseJoinColumns = @JoinColumn(name = "fk_parent_feature_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_feature_parent")))
    public Set<FeatureEntity> getParents() {
        return super.getParents();
    }

    @Override
    @ManyToMany(mappedBy = "parents", fetch = FetchType.LAZY)
    @Access(AccessType.PROPERTY)
    public Set<FeatureEntity> getChildren() {
        return super.getChildren();
    }

}
