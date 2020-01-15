/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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

import java.util.Set;

/**
 * Hibernate entity for telephone.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class TelephoneEntity extends AbstractCiEntity {

    private static final long serialVersionUID = -3871291699397692580L;

    private Set<String> voice;
    private Set<String> facsimile;

    /**
     * @return the voice
     */
    public Set<String> getVoice() {
        return voice;
    }

    /**
     * @param voice
     *            the voice to set
     */
    public void setVoice(Set<String> voice) {
        this.voice = voice;
    }

    public boolean hasVoice() {
        return getVoice() != null && !getVoice().isEmpty();
    }

    /**
     * @return the facsimile
     */
    public Set<String> getFacsimile() {
        return facsimile;
    }

    /**
     * @param facsimile
     *            the facsimile to set
     */
    public void setFacsimile(Set<String> facsimile) {
        this.facsimile = facsimile;
    }

    public boolean hasFacsimile() {
        return getFacsimile() != null && !getFacsimile().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof TelephoneEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
