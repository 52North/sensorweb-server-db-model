/*
 * Copyright (C) 2015-2021 52°North Spatial Information Research GmbH
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
import java.util.Date;

import org.n52.series.db.beans.HibernateRelations.HasProcedure;
import org.n52.series.db.beans.HibernateRelations.HasProcedureDescriptionFormat;
import org.n52.series.db.beans.HibernateRelations.HasXml;
import org.n52.series.db.common.Utils;

/**
 * @since 1.0.0
 */
public class ProcedureHistoryEntity extends IdEntity
        implements Serializable, HasProcedure, HasProcedureDescriptionFormat, HasXml {

    public static final String PROPERTY_PROCEDURE = "procedure";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";

    private static final long serialVersionUID = -3658568714438752174L;

    private FormatEntity format;

    private ProcedureEntity procedure;

    private Date startTime;

    private Date endTime;

    private String xml;

    @Override
    public ProcedureEntity getProcedure() {
        return this.procedure;
    }

    @Override
    public void setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
    }

    @Override
    public FormatEntity getFormat() {
        return this.format;
    }

    @Override
    public void setFormat(FormatEntity format) {
        this.format = format;
    }

    public Date getStartTime() {
        return Utils.createUnmutableTimestamp(this.startTime);
    }

    public ProcedureHistoryEntity setStartTime(Date startTime) {
        this.startTime = Utils.createUnmutableTimestamp(startTime);
        return this;
    }

    public Date getEndTime() {
        return Utils.createUnmutableTimestamp(this.endTime);
    }

    public ProcedureHistoryEntity setEndTime(Date endTime) {
        this.endTime = Utils.createUnmutableTimestamp(endTime);
        return this;
    }

    @Override
    public String getXml() {
        return xml;
    }

    @Override
    public void setXml(String xml) {
        this.xml = xml;
    }
}
