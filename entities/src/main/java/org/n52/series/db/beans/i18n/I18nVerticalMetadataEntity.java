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
package org.n52.series.db.beans.i18n;

import org.n52.series.db.beans.VerticalMetadataEntity;

public class I18nVerticalMetadataEntity extends AbstractI18nEntity<VerticalMetadataEntity> {

    private static final long serialVersionUID = 329570776993990200L;

    private String verticalOriginName;
    private String verticalfromName;
    private String verticaltoName;

    public String getverticalOriginName() {
        return verticalOriginName;
    }

    public void setVerticalOriginName(String name) {
        this.verticalOriginName = name;
    }

    public String getVerticalFromName() {
        return verticalfromName;
    }

    public void setVerticalFromName(String name) {
        this.verticalfromName = name;
    }

    public String getVerticalToName() {
        return verticaltoName;
    }

    public void setVerticalToName(String name) {
        this.verticaltoName = name;
    }
}
