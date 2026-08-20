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

import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;

import java.io.Serial;
import java.util.Collection;
import java.util.Set;

@MappedSuperclass
public abstract class CompositeDataEntity extends DataEntity<Set<DataEntity<?>>> {

    @Serial
    private static final long serialVersionUID = -2942122854792122664L;

    // the child observations reference their parent via fk_parent_observation_id, see DataEntity#parent
    @OneToMany(targetEntity = DataEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "fk_parent_observation_id", foreignKey = @ForeignKey(name = "fk_parent_observation"))
    private Set<DataEntity<?>> value;

    @Override
    public void setValue(Set<DataEntity<?>> value) {
        this.value = value;
    }

    @Override
    public Set<DataEntity<?>> getValue() {
        return value;
    }

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return false;
    }

}
