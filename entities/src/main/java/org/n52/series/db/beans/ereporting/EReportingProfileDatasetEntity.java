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

package org.n52.series.db.beans.ereporting;

import org.n52.series.db.beans.dataset.ProfileDataset;

public abstract class EReportingProfileDatasetEntity extends EReportingDatasetEntity
        implements ProfileDataset {

    private static final long serialVersionUID = -7514394037111286838L;

    private String verticalParameterName;
    private String verticalFromParameterName;
    private String verticalToParameterName;

    @Override
    public String getVerticalParameterName() {
        return verticalParameterName;
    }

    @Override
    public void setVerticalParameterName(String verticalParameterName) {
        this.verticalParameterName = verticalParameterName;
    }

    @Override
    public String getVerticalFromParameterName() {
        return verticalFromParameterName;
    }

    @Override
    public void setVerticalFromParameterName(String verticalFromParameterName) {
        this.verticalFromParameterName = verticalFromParameterName;
    }

    @Override
    public String getVerticalToParameterName() {
        return verticalToParameterName;
    }

    @Override
    public void setVerticalToParameterName(String verticalToParameterName) {
        this.verticalToParameterName = verticalToParameterName;
    }

}
