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

package org.n52.series.db.beans;

import java.io.Serializable;

import org.n52.series.db.beans.HibernateRelations.HasResultEncoding;
import org.n52.series.db.beans.HibernateRelations.HasResultStructure;

/**
 * @since 1.0.0
 *
 */
public class ResultTemplateEntity extends IdEntity implements Serializable, HasResultStructure, HasResultEncoding {

    public static final String PROPERTY_OFFERING = "offering";

    public static final String PROPERTY_PHENOMENON = "phenomenon";

    public static final String PROPERTY_DOMAIN_ID = "domainId";

    public static final String PROPERTY_FEATURE = "feature";

    private static final long serialVersionUID = -8847952458819368733L;

    private PhenomenonEntity phenomenon;

    private OfferingEntity offering;

    private ProcedureEntity procedure;

    private AbstractFeatureEntity feature;

    private String identifier;

    private String domainId;

    private String structure;

    private String encoding;

    public ResultTemplateEntity() {
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    /**
     * @return the phenomenon
     */
    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    /**
     * @param phenomenon the phenomenon to set
     */
    public void setPhenomenon(PhenomenonEntity phenomenon) {
        this.phenomenon = phenomenon;
    }

    /**
     * @return the offering
     */
    public OfferingEntity getOffering() {
        return offering;
    }

    /**
     * @param offering the offering to set
     */
    public void setOffering(OfferingEntity offering) {
        this.offering = offering;
    }

    /**
     * @return the procedure
     */
    public ProcedureEntity getProcedure() {
        return procedure;
    }

    /**
     * @param procedure the procedure to set
     */
    public void setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
    }

    /**
     * @return the featureOfInterest
     */
    public AbstractFeatureEntity getFeature() {
        return feature;
    }

    /**
     * @param featureOfInterest the featureOfInterest to set
     */
    public void setFeature(AbstractFeatureEntity featureOfInterest) {
        this.feature = featureOfInterest;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isSetIdentifier() {
        return getIdentifier() != null && !getIdentifier().isEmpty();
    }

    @Override
    public String getStructure() {
        return structure;
    }

    @Override
    public void setStructure(String resultStructure) {
        this.structure = resultStructure;
    }

    @Override
    public String getEncoding() {
        return this.encoding;
    }

    @Override
    public void setEncoding(String resultEncoding) {
        this.encoding = resultEncoding;
    }

}
