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
package org.n52.series.db.beans.feature.gmd;

import java.util.Set;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * Hibernate entity for exExtent.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class ExExtentEntity extends AbstractCiEntity {

    private static final long serialVersionUID = -5851468464823597666L;

    private Set<ExVerticalExtentEntity> verticalExtent;

    /**
     * @return the verticalExtent
     */
    public Set<ExVerticalExtentEntity> getVerticalExtent() {
        return verticalExtent;
    }

    /**
     * @param verticalExtent
     *            the verticalExtent to set
     */
    public void setVerticalExtent(Set<ExVerticalExtentEntity> verticalExtent) {
        this.verticalExtent = verticalExtent;
    }

    public boolean hasVerticalExtent() {
        return getVerticalExtent() != null && !getVerticalExtent().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ExExtentEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
