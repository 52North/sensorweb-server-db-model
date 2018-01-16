/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

import org.n52.series.db.beans.data.Data.ProfileData;
import java.math.BigDecimal;

public class ProfileDataEntity extends CompositeDataEntity {

public class ProfileDataEntity extends CompositeDataEntity implements ProfileData {

    private static final long serialVersionUID = -7431276500677067329L;

    private BigDecimal fromLevel;

    private BigDecimal toLevel;

    private UnitEntity levelUnit;

    public BigDecimal getFromLevel() {
        return fromLevel;
    }

    public void setFromLevel(BigDecimal fromLevel) {
        this.fromLevel = fromLevel;
    }

    public BigDecimal getToLevel() {
        return toLevel;
    }

    public void setToLevel(BigDecimal toLevel) {
        this.toLevel = toLevel;
    }

    public UnitEntity getLevelUnit() {
        return levelUnit;
    }

    public void setLevelUnit(UnitEntity levelUnit) {
        this.levelUnit = levelUnit;
    }

    public boolean hasLevelUnit() {
        return getLevelUnit() != null && getLevelUnit().isSetIdentifier();
    }

    public boolean hasFromLevel() {
        return getFromLevel() != null;
    }

    public boolean hasToLevel() {
        return getToLevel() != null;
    }

}
