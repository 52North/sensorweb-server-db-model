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
package org.n52.series.db.beans.feature.gmd;

import org.n52.series.db.beans.feature.ReferenceEntity;

/**
 * Hibernate entity for CI entities.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public abstract class AbstractCiEntity extends ReferenceEntity {

    private static final long serialVersionUID = 7398216647031698387L;

    private String gmdid;
    private String uuid;

    /**
     * @return the gmd id
     */
    public String getGmdid() {
        return gmdid;
    }

    /**
     * @param gmdid
     *            the gmd id to set
     */
    public void setGmdid(String gmdid) {
        this.gmdid = gmdid;
    }

    public boolean isSetId() {
        return getGmdid() != null && !getGmdid().isEmpty();
    }

    /**
     * @return the uuid
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * @param uuid
     *            the uuid to set
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isSetUuid() {
        return getUuid() != null && !getUuid().isEmpty();
    }
}
