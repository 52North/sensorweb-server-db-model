/**
 * Copyright (C) 2012-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.series.db.beans;

import java.io.Serializable;

import org.n52.series.db.beans.HibernateRelations.HasDeletedFlag;
import org.n52.series.db.beans.HibernateRelations.HasDisabledFlag;
import org.n52.series.db.beans.HibernateRelations.HasHiddenChildFlag;
import org.n52.series.db.beans.HibernateRelations.HasObservableProperty;
import org.n52.series.db.beans.HibernateRelations.HasObservationType;
import org.n52.series.db.beans.HibernateRelations.HasOffering;
import org.n52.series.db.beans.HibernateRelations.HasProcedure;
//import org.n52.sos.ogc.series.wml.DefaultPointMetadata;
//import org.n52.sos.ogc.series.wml.Metadata;

/**
 * @since 4.0.0
 *
 */
public class ObservationConstellationEntity extends PkidEntity
        implements Serializable,
                   HasProcedure<ObservationConstellationEntity>,
                   HasObservableProperty<ObservationConstellationEntity>,
                   HasOffering<ObservationConstellationEntity>,
                   HasObservationType<ObservationConstellationEntity>,
                   HasHiddenChildFlag<ObservationConstellationEntity>,
                   HasDeletedFlag<ObservationConstellationEntity>,
                   HasDisabledFlag<ObservationConstellationEntity> {

    public static final String ID = "observationConstellationId";

    private static final long serialVersionUID = -3890149740562709928L;
    private PhenomenonEntity observableProperty;
    private ProcedureEntity procedure;
    private ObservationTypeEntity observationType;
    private OfferingEntity offering;
    private Boolean deleted = false;
    private Boolean disabled = false;
    private Boolean hiddenChild = false;


    @Override
    public PhenomenonEntity getObservableProperty() {
        return observableProperty;
    }

    @Override
    public ObservationConstellationEntity setObservableProperty(PhenomenonEntity observableProperty) {
        this.observableProperty = observableProperty;
        return this;
    }

    @Override
    public ProcedureEntity getProcedure() {
        return procedure;
    }

    @Override
    public ObservationConstellationEntity setProcedure(ProcedureEntity procedure) {
        this.procedure = procedure;
        return this;
    }

    @Override
    public ObservationTypeEntity getObservationType() {
        return observationType;
    }

    @Override
    public ObservationConstellationEntity setObservationType(ObservationTypeEntity observationType) {
        this.observationType = observationType;
        return this;
    }

    @Override
    public OfferingEntity getOffering() {
        return offering;
    }

    @Override
    public ObservationConstellationEntity setOffering(OfferingEntity offering) {
        this.offering = offering;
        return this;
    }
    
    @Override
    public boolean isSetOffering() {
        return getOffering() != null;
    }

    @Override
    public boolean getDeleted() {
        return deleted;
    }

    @Override
    public ObservationConstellationEntity setDeleted(boolean deleted) {
        this.deleted = deleted;
        return this;
    }

    @Override
    public boolean isDeleted() {
        return deleted;
    }

    @Override
    public ObservationConstellationEntity setDisabled(boolean disabled) {
        this.disabled = disabled;
        return this;
    }

    @Override
    public boolean getDisabled() {
        return disabled;
    }

    @Override
    public boolean isDisabled() {
        return getDisabled();
    }

    @Override
    public ObservationConstellationEntity setHiddenChild(boolean hiddenChild) {
        this.hiddenChild = hiddenChild;
        return this;
    }

    public boolean getHiddenChild() {
        return hiddenChild;
    }

    @Override
    public boolean isHiddenChild() {
        return hiddenChild;
    }

    @Override
    public boolean isSetObservationType() {
        return getObservationType() != null &&
               getObservationType().isSetType();
    }

    @Override
    public String toString() {
        return String
                .format("ObservationConstellation [pkid=%s, observableProperty=%s, procedure=%s, "
                        + "observationType=%s, offering=%s, deleted=%s, hiddenChild=%s",
                        getPkid(), observableProperty, procedure, observationType, offering, deleted,
                        hiddenChild);
    }

}
