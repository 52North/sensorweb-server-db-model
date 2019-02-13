/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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
 */
public class ResultTemplateEntity extends IdEntity implements Serializable, HasResultStructure, HasResultEncoding {

    public static final String PROPERTY_OFFERING = "offering";

    public static final String PROPERTY_PHENOMENON = "phenomenon";

    public static final String PROPERTY_IDENTIFIER = "identifier";

    public static final String PROPERTY_FEATURE = "feature";

    private static final long serialVersionUID = -8847952458819368733L;

    private PhenomenonEntity phenomenon;

    private OfferingEntity offering;

    private ProcedureEntity procedure;

    private AbstractFeatureEntity<?> feature;

    private String identifier;

    private String domain;

    private String structure;

    private String encoding;

    public ResultTemplateEntity() {
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * @return the phenomenon
     */
    public PhenomenonEntity getPhenomenon() {
        return phenomenon;
    }

    /**
     * @param phenomenon
     *            the phenomenon to set
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
     * @param offering
     *            the offering to set
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
     * @param procedure
     *            the procedure to set
     */
    public void setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
    }

    /**
     * @return the featureOfInterest
     */
    public AbstractFeatureEntity<?> getFeature() {
        return feature;
    }

    /**
     * @param featureOfInterest
     *            the featureOfInterest to set
     */
    public void setFeature(AbstractFeatureEntity<?> featureOfInterest) {
        this.feature = featureOfInterest;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isSetIdentifier() {
        return (getIdentifier() != null) && !getIdentifier().isEmpty();
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

    public boolean isSetProcedure() {
        return getProcedure() != null;
    }

    public boolean isSetFeature() {
        return getFeature() != null;
    }

}
