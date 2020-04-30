/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
 * Software GmbH
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

import java.util.Objects;

import org.n52.series.db.beans.HibernateRelations.IsStaEntity;

public class PhenomenonEntity extends HierarchicalEntity<PhenomenonEntity> implements IsStaEntity {

    private static final long serialVersionUID = 2302654989683191424L;

    /**
     * Identifier used by SensorThingsAPI for addressing this entity.
     */

    @Override
    public void setIdentifier(String identifier) {
        super.setIdentifier(identifier);
        if (!isSetStaIdentifier()) {
            setStaIdentifier(identifier);
        }
    }

    @Override
    public boolean isSetStaIdentifier() {
        return getStaIdentifier() != null && !getStaIdentifier().isEmpty();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStaIdentifier());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PhenomenonEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
