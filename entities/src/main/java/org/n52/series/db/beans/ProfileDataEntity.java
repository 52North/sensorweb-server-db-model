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

public class ProfileDataEntity extends CompositeDataEntity implements ProfileData {

    private static final long serialVersionUID = -7431276500677067329L;

    private String verticalfromName;

    private String verticaltoName;

    private UnitEntity verticalUnit;

    @Override
    public String getVerticalFromName() {
        return verticalfromName;
    }

    @Override
    public void setVerticalFromName(String name) {
        this.verticalfromName = name;
    }

    @Override
    public String getVerticalToName() {
        return verticaltoName;
    }

    @Override
    public void setVerticalToName(String name) {
        this.verticaltoName = name;
    }

    @Override
    public UnitEntity getVerticalUnit() {
        return verticalUnit;
    }

    @Override
    public void setVerticalUnit(UnitEntity verticalUnit) {
        this.verticalUnit = verticalUnit;
    }

}
