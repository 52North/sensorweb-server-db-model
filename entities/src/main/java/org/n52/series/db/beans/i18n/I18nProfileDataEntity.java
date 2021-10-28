/*
 * Copyright 2015-2021 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.i18n;

import org.n52.series.db.beans.ProfileDataEntity;

public class I18nProfileDataEntity extends I18nEntity<ProfileDataEntity> {

    private static final long serialVersionUID = -1039313696988014573L;

    private String orientation;

    private String verticalFromName;

    private String verticalToName;

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getVerticalFromName() {
        return verticalFromName;
    }

    public void setVerticalFromName(String verticalFromName) {
        this.verticalFromName = verticalFromName;
    }

    public String getVerticalToName() {
        return verticalToName;
    }

    public void setVerticalToName(String verticalToName) {
        this.verticalToName = verticalToName;
    }

    public boolean hasOrientation() {
        return getOrientation() != null && !getOrientation().isEmpty();
    }

    public boolean hasVerticalFromName() {
        return getVerticalFromName() != null && !getVerticalFromName().isEmpty();
    }

    public boolean hasVerticalToName() {
        return getVerticalToName() != null && !getVerticalToName().isEmpty();
    }
}
