/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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

import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.CodespaceEntity;
import org.n52.series.db.beans.HibernateRelations.HasRemarks;
import org.n52.series.db.beans.feature.ReferenceEntity;

/**
 * Hibernate entiity for the verticalDatum
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 *
 */
public class VerticalDatumEntity extends ReferenceEntity implements HasRemarks<VerticalDatumEntity> {

    private static final long serialVersionUID = -2829473090233745827L;

    private String remarks;
    private DomainOfValidityEntity domainOfValidity;
    private Set<String> scope;
    private String anchorDefinition;
    private CodespaceEntity codespaceAnchorDefinition;
    private Date realizationEpoch;

    public String getRemarks() {
        return remarks;
    }

    public VerticalDatumEntity setRemarks(String remarks) {
        this.remarks = remarks;
        return this;
    }

    /**
     * @return the domainOfValidity
     */
    public DomainOfValidityEntity getDomainOfValidity() {
        return domainOfValidity;
    }

    /**
     * @param domainOfValidity
     *            the domainOfValidity to set
     */
    public void setDomainOfValidity(DomainOfValidityEntity domainOfValidity) {
        this.domainOfValidity = domainOfValidity;
    }

    public boolean isSetDomainOfValidity() {
        return getDomainOfValidity() != null;
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
     * @return the anchorDefinition
     */
    public String getAnchorDefinition() {
        return anchorDefinition;
    }

    /**
     * @param anchorDefinition
     *            the anchorDefinition to set
     */
    public void setAnchorDefinition(String anchorDefinition) {
        this.anchorDefinition = anchorDefinition;
    }

    public boolean isSetAnchorDefinition() {
        return getAnchorDefinition() != null && !getAnchorDefinition().isEmpty();
    }

    public CodespaceEntity getCodespaceAnchorDef() {
        return codespaceAnchorDefinition;
    }

    public void setCodespaceAnchorDef(CodespaceEntity codespaceAnchorDefinition) {
        this.codespaceAnchorDefinition = codespaceAnchorDefinition;
    }

    public boolean isSetCodespaceAnchorDefinition() {
        return getCodespaceAnchorDef() != null && getCodespaceAnchorDef().isSetCodespace();
    }

    /**
     * @return the realizationEpoch
     */
    public Date getRealizationEpoch() {
        return realizationEpoch;
    }

    /**
     * @param realizationEpoch
     *            the realizationEpoch to set
     */
    public void setRealizationEpoch(Date realizationEpoch) {
        this.realizationEpoch = realizationEpoch;
    }

    public boolean isSetRealizationEpoch() {
        return getRealizationEpoch() != null;
    }
}
