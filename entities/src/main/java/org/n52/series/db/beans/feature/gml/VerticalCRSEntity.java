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

package org.n52.series.db.beans.feature.gml;

import java.util.Set;

import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.HibernateRelations.HasRemarks;
import org.n52.series.db.beans.feature.ReferenceEntity;

/**
 * Hibernate entiity for the verticalCRS
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class VerticalCRSEntity extends ReferenceEntity implements HasRemarks<VerticalCRSEntity> {

    private static final long serialVersionUID = 2282402634799023149L;

    private String remarks;
    private Set<DomainOfValidityEntity> domainOfValidity;
    private Set<String> scope;
    private VerticalCSEntity verticalCS;
    private VerticalDatumEntity verticalDatum;

    /**
     * @return the remarks
     */
    @Override
    public String getRemarks() {
        return remarks;
    }

    /**
     * @param remarks
     *            the remarks to set
     */
    @Override
    public VerticalCRSEntity setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    /**
     * @return the domainOfValidity
     */
    public Set<DomainOfValidityEntity> getDomainOfValidity() {
        return domainOfValidity;
    }

    /**
     * @param domainOfValidity
     *            the domainOfValidity to set
     */
    public void setDomainOfValidity(Set<DomainOfValidityEntity> domainOfValidity) {
        this.domainOfValidity = domainOfValidity;
    }

    public boolean hasDomainOfValidity() {
        return getDomainOfValidity() != null && !getDomainOfValidity().isEmpty();
    }

    /**
     * @return the scope
     */
    public Set<String> getScope() {
        return scope;
    }

    /**
     * @param scope
     *            the scope to set
     */
    public void setScope(Set<String> scope) {
        this.scope = scope;
    }

    public boolean hasScope() {
        return getScope() != null && !getScope().isEmpty();
    }

    /**
     * @return the verticalCS
     */
    public VerticalCSEntity getVerticalCS() {
        return verticalCS;
    }

    /**
     * @param verticalCS
     *            the verticalCS to set
     */
    public void setVerticalCS(VerticalCSEntity verticalCS) {
        this.verticalCS = verticalCS;
    }

    public boolean isSetVerticalCS() {
        return getVerticalCS() != null;
    }

    /**
     * @return the verticalDatum
     */
    public VerticalDatumEntity getVerticalDatum() {
        return verticalDatum;
    }

    /**
     * @param verticalDatum
     *            the verticalDatum to set
     */
    public void setVerticalDatum(VerticalDatumEntity verticalDatum) {
        this.verticalDatum = verticalDatum;
    }

    public boolean isSetVerticalDatum() {
        return getVerticalDatum() != null;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof VerticalCRSEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
