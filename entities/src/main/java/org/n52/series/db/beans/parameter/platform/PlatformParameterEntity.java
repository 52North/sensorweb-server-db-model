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
package org.n52.series.db.beans.parameter.platform;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.PlatformEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class PlatformParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_PLATFORM = "platform";
    public static final String PROP_PLATFORM_ID = "platformId";
    private static final long serialVersionUID = -8427939633323086462L;
    private PlatformEntity platform;

    private long platformId;

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public long getPlatformId() {
        return platformId;
    }

    public void setPlatformId(long platformId) {
        this.platformId = platformId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setPlatform((PlatformEntity) entity);
    }

}
