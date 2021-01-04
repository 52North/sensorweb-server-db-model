/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans.parameter;

import java.util.Map;

import org.n52.series.db.beans.UnitEntity;
import org.n52.series.db.beans.HibernateRelations.HasUnit;

public class ParameterCategoryEntity extends ParameterEntity<String> implements HasUnit {

    private static final long serialVersionUID = -6262887605542676492L;

    private UnitEntity unit;

    @Override
    public Map<String, Object> toValueMap(String locale) {
        Map<String, Object> valueMap = super.toValueMap(locale);
        if (isSetUnit()) {
            valueMap.put("unit", getUnit().getNameI18n(locale));
        }
        return valueMap;
    }

    @Override
    public UnitEntity getUnit() {
        return unit;
    }

    @Override
    public void setUnit(final UnitEntity unit) {
        this.unit = unit;
    }

    @Override
    public boolean isSetUnit() {
        return getUnit() != null;
    }

    @Override
    public String getValueAsString() {
        return getValue();
    }
}
