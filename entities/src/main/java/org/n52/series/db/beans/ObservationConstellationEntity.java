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
 * @since 1.0.0
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

    private static final long serialVersionUID = -3890149740562709928L;
    
    private PhenomenonEntity observableProperty;
    private ProcedureEntity procedure;
    private OfferingEntity offering;
    private ObservationTypeEntity observationType;
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
