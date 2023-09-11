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

import java.io.Serializable;
import java.util.Objects;

import org.n52.series.db.beans.HibernateRelations.HasId;

public abstract class IdEntity implements Serializable, HasId {

    public static final String PROPERTY_ID = "id";

    private static final long serialVersionUID = 1608995723035752862L;

    /**
     * A serial primary key.
     */
    private Long id;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IdEntity)) {
            return false;
        }
        IdEntity other = (IdEntity) obj;
        return Objects.equals(getId(), other.getId()) && getClass() == other.getClass();
    }

}
