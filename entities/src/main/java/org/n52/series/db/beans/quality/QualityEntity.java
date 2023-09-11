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
package org.n52.series.db.beans.quality;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.UnitEntity;
import org.n52.series.db.beans.HibernateRelations.HasUnitValue;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public abstract class QualityEntity<T> extends DescribableEntity implements HasUnitValue<T> {

    private static final long serialVersionUID = 4794651765162321131L;
    private UnitEntity unit;

    public abstract void setValue(T value);

    public abstract T getValue();

    public boolean isSetValue() {
        return getValue() != null;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }

}
