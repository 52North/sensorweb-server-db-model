/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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

import java.util.Set;

import org.n52.series.db.beans.i18n.I18nVerticalMetadataEntity;

public class VerticalMetadataEntity extends IdEntity {

    private static final long serialVersionUID = 3156288491348980598L;

    private Short orientation;

    private String verticalOriginName;

    private String verticalfromName;

    private String verticaltoName;

    private UnitEntity verticalUnit;

    private Set<I18nVerticalMetadataEntity> translations;

    public Short getOrientation() {
        return orientation;
    }

    public void setOrientation(Short orientation) {
        this.orientation = orientation;
    }

    public boolean isSetOrientation() {
        return orientation != null;
    }

    public boolean isAboveVerticalOrigin() {
        return isSetOrientation() && getOrientation() >= 1;
    }

    public boolean isBelowVerticalOrigin() {
        return isSetOrientation() && getOrientation() <= -1;
    }

    public String getVerticalOriginName() {
        return verticalOriginName;
    }

    public void setVerticalOriginName(String name) {
        this.verticalOriginName = name;
    }

    public boolean isSetVerticalOrigiName() {
        return getVerticalOriginName() != null && !getVerticalOriginName().isEmpty();
    }

    public String getVerticalFromName() {
        return verticalfromName;
    }

    public void setVerticalFromName(String name) {
        this.verticalfromName = name;
    }

    public boolean isSetVerticalFromName() {
        return getVerticalFromName() != null && !getVerticalFromName().isEmpty();
    }

    public String getVerticalToName() {
        return verticaltoName;
    }

    public void setVerticalToName(String name) {
        this.verticaltoName = name;
    }

    public boolean isSetVerticalToName() {
        return getVerticalToName() != null && !getVerticalToName().isEmpty();
    }

    public boolean areVerticalNamesEqual() {
        return isSetVerticalFromName() && isSetVerticalToName()
                && getVerticalFromName().equalsIgnoreCase(getVerticalToName());
    }

    public UnitEntity getVerticalUnit() {
        return verticalUnit;
    }

    public boolean hasVerticalUnit() {
        return getVerticalUnit() != null;
    }

    public void setVerticalUnit(UnitEntity verticalUnit) {
        if (this.verticalUnit == null && verticalUnit != null) {
            this.verticalUnit = verticalUnit;
        }
    }

    public Set<I18nVerticalMetadataEntity> getTranslations() {
        return translations;
    }

    public void setTranslations(Set<I18nVerticalMetadataEntity> translations) {
        this.translations = translations;
    }
}
