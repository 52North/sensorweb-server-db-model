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

import java.util.Set;

public class ProcedureEntity extends HierarchicalEntity<ProcedureEntity> {

    public static final String PROPERTY_MOBILE = "mobile";
    public static final String PROPERTY_INSITU = "insitu";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_VALID_PROCEDURE_TIME = "validProceduretime";
    public static final String PROPERTY_PROCEDURE_DESCRIPTION_FORMAT = "procedureDescriptionFormat";

    private static final long serialVersionUID = 4028002933920185756L;

    private boolean reference;

    private boolean mobile;

    private boolean insitu;

    private ProcedureDescriptionFormatEntity procedureDescriptionFormat;

    private boolean deleted;

    private String descriptionFile;

    private ProcedureEntity typeOf;

    private boolean type;

    private boolean aggregation;

    private Set<ValidProcedureTimeEntity> validProcedureTimes;

    public boolean isReference() {
        return reference;
    }

    public void setReference(boolean reference) {
        this.reference = reference;
    }

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isInsitu() {
        return insitu;
    }

    public void setInsitu(boolean insitu) {
        this.insitu = insitu;
    }

    public ProcedureDescriptionFormatEntity getProcedureDescriptionFormat() {
        return this.procedureDescriptionFormat;
    }

    public void setProcedureDescriptionFormat(ProcedureDescriptionFormatEntity procedureDescriptionFormat) {
        this.procedureDescriptionFormat = procedureDescriptionFormat;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getDescriptionFile() {
        return descriptionFile;
    }

    public void setDescriptionFile(String descriptionFile) {
        this.descriptionFile = descriptionFile;
    }

    public ProcedureEntity getTypeOf() {
        return typeOf;
    }

    public void setTypeOf(ProcedureEntity typeOf) {
        this.typeOf = typeOf;
    }

    public boolean isSetTypeOf() {
        return getTypeOf() != null;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean isType) {
        this.type = isType;
    }

    public boolean isAggregation() {
        return aggregation;
    }

    public void setAggregation(boolean isAggregation) {
        this.aggregation = isAggregation;
    }

    public Set<ValidProcedureTimeEntity> getValidProcedureTimes() {
        return validProcedureTimes;
    }

    public void setValidProcedureTimes(Set<ValidProcedureTimeEntity> validProcedureTimes) {
        this.validProcedureTimes = validProcedureTimes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" Domain id: ")
                 .append(getDomainId())
                 .append(", service: ")
                 .append(getService())
                 .append(" ]")
                 .toString();
    }
}
