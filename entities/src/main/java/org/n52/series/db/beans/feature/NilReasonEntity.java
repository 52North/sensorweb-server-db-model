/*
 * Copyright 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.feature;

import org.n52.series.db.beans.DescribableEntity;

/**
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public abstract class NilReasonEntity extends DescribableEntity {

    private static final long serialVersionUID = -4118970139033618118L;

    private String nilReason;

    /**
     * @return the nilReason
     */
    public String getNilReason() {
        return nilReason;
    }

    /**
     * @param nilReason
     *            the nilReason to set
     */
    public void setNilReason(String nilReason) {
        this.nilReason = nilReason;
    }

    public boolean isSetNilReason() {
        return getNilReason() != null && !getNilReason().isEmpty();
    }
}
