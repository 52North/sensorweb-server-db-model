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
package org.n52.series.db.beans;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.hibernate.annotations.ColumnDefault;
import org.n52.series.db.beans.HibernateRelations.HasProcedure;
import org.n52.series.db.beans.HibernateRelations.HasProcedureDescriptionFormat;
import org.n52.series.db.beans.HibernateRelations.HasXml;
import org.n52.series.db.common.Utils;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @since 1.0.0
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.ProcedureHistoryEntity")
@Table(name = "procedure_history",
        indexes = { @Index(name = "idx_procedure_history_procedure", columnList = "fk_procedure_id"),
                @Index(name = "idx_procedure_history_format", columnList = "fk_format_id"),
                @Index(name = "idx_start_time", columnList = "valid_from"),
                @Index(name = "idx_end_time", columnList = "valid_to") })
// table comment: Storage of historical procedure descriptions as XML encoded text with period of validity.
@AttributeOverride(name = "id", column = @Column(name = "procedure_history_id"))
public class ProcedureHistoryEntity extends IdEntity
        implements Serializable, HasProcedure, HasProcedureDescriptionFormat, HasXml {

    public static final String PROPERTY_PROCEDURE = "procedure";
    public static final String START_TIME = "startTime";
    public static final String END_TIME = "endTime";

    @Serial
    private static final long serialVersionUID = -3658568714438752174L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_procedure_id", nullable = false, foreignKey = @ForeignKey(name = "fk_ph_procedure_id"))
    private ProcedureEntity procedure;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_format_id", nullable = false, foreignKey = @ForeignKey(name = "fk_pdf_id"))
    private FormatEntity format;

    @Temporal(TemporalType.TIMESTAMP) // DELETE THIS LINE if the field is a java.time type
    @Column(name = "valid_from", nullable = false, length = 29)
    // @Comment("The timestamp from which this procedure description is valid.")
    private Date startTime;

    @Temporal(TemporalType.TIMESTAMP) // DELETE THIS LINE if the field is a java.time type
    @Column(name = "valid_to", length = 29)
    @ColumnDefault("NULL")
    // @Comment("The timestamp until this procedure description is valid. If null, this procedure description
    // is currently valid")
    private Date endTime;

    @Column(name = "xml", nullable = false, columnDefinition = "text")
    // @Comment("XML representation of this procedure description")
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
