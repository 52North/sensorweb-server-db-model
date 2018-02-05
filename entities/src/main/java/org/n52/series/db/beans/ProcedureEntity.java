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

package org.n52.series.db.beans;

import java.util.Set;

import org.n52.series.db.beans.HibernateRelations.HasProcedureDescriptionFormat;
import org.n52.series.db.beans.HibernateRelations.HasProcedureHistory;

public class ProcedureEntity extends HierarchicalEntity<ProcedureEntity>
        implements HasProcedureHistory, HasProcedureDescriptionFormat<ProcedureEntity> {

    public static final String PROPERTY_MOBILE = "mobile";
    public static final String PROPERTY_INSITU = "insitu";
    public static final String PROPERTY_REFERENCE = "reference";
    public static final String PROPERTY_VALID_PROCEDURE_TIME = "procedureHistory";
    public static final String PROPERTY_PROCEDURE_DESCRIPTION_FORMAT = "format";

    private static final long serialVersionUID = 4028002933920185756L;

    private boolean reference;

    private boolean mobile;

    private boolean insitu = true;

    private FormatEntity format;

    private boolean deleted;

    private String descriptionFile;

    private ProcedureEntity typeOf;

    private boolean type;

    private boolean aggregation;

    private Set<ProcedureHistoryEntity> procedureHistory;

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

    public FormatEntity getFormat() {
        return this.format;
    }

    public ProcedureEntity setFormat(FormatEntity format) {
        this.format = format;
        return this;
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

    public Set<ProcedureHistoryEntity> getProcedureHistory() {
        return procedureHistory;
    }

    public void setProcedureHistory(Set<ProcedureHistoryEntity> procedureHistory) {
        this.procedureHistory = procedureHistory;
    }

}
