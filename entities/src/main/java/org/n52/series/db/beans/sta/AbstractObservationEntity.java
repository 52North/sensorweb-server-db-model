/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.sta;

import java.io.Serializable;

import javax.persistence.Transient;

import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;

public abstract class AbstractObservationEntity<T> extends IdEntity implements Serializable,
        HibernateRelations.HasPhenomenonTime, HibernateRelations.HasAbstractDataset, HibernateRelations.HasId,
        HibernateRelations.HasIdentifier, HibernateRelations.HasStaIdentifier, HibernateRelations.HasResultTime,
        HibernateRelations.HasValidTime, HibernateRelations.HasParameters, HibernateRelations.HasName,
        HibernateRelations.HasDescription, HibernateRelations.HasSamplingGeometry, HibernateRelations.HasFeature,
        HibernateRelations.IsProcessed, HibernateRelations.IsStaEntity, HibernateRelations.HasVerticalFromTo {

    private static final long serialVersionUID = -5478132580391608848L;

    @Transient
    private boolean processed;

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public void setProcessed(boolean processed) {
        this.processed = processed;
    }

    public abstract T getValue();

    public abstract AbstractObservationEntity<T> setValue(T value);

    public boolean hasValue() {
        return getValue() != null;
    }
}
