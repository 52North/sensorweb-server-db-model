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
package org.n52.series.db.beans.feature;

import java.util.ArrayList;
import java.util.Collection;

import org.n52.series.db.beans.feature.gmd.ResponsiblePartyEntity;
import org.n52.series.db.beans.feature.gml.VerticalDatumEntity;
import org.n52.shetland.util.CollectionHelper;

public class MonitoringPointContent {

    /* 0..* */
    private Collection<ResponsiblePartyEntity> relatedParties = new ArrayList<>();

    /* 0..* */
    private Collection<VerticalDatumEntity> verticalDatums = new ArrayList<>();

    public Collection<ResponsiblePartyEntity> getRelatedParties() {
        return relatedParties;
    }

    public void setRelatedParties(Collection<ResponsiblePartyEntity> relatedParties) {
        this.relatedParties.clear();
        if (!CollectionHelper.nullEmptyOrContainsOnlyNulls(relatedParties)) {
            this.relatedParties.addAll(relatedParties);
        }
    }

    public void addAllRelatedParties(Collection<ResponsiblePartyEntity> relatedPartiesToAdd) {
        if (relatedPartiesToAdd != null) {
            this.relatedParties.addAll(relatedPartiesToAdd);
        }
    }

    public void addRelatedParty(ResponsiblePartyEntity relatedParty) {
        if (relatedParty != null) {
            this.relatedParties.add(relatedParty);
        }
    }

    public boolean hasRelatedParties() {
        return !CollectionHelper.nullEmptyOrContainsOnlyNulls(getRelatedParties());
    }

    public Collection<VerticalDatumEntity> getVerticalDatums() {
        return verticalDatums;
    }

    public void setVerticalDatums(Collection<VerticalDatumEntity> verticalDatums) {
        this.verticalDatums.clear();
        if (!CollectionHelper.nullEmptyOrContainsOnlyNulls(verticalDatums)) {
            this.verticalDatums.addAll(verticalDatums);
        }
    }

    public void addAllVerticalDatums(Collection<VerticalDatumEntity> verticalDatumsToAdd) {
        if (verticalDatumsToAdd != null) {
            this.verticalDatums.addAll(verticalDatumsToAdd);
        }
    }

    public void addVerticalDatum(VerticalDatumEntity verticalDatum) {
        if (verticalDatum != null) {
            this.verticalDatums.add(verticalDatum);
        }
    }

    public boolean hasVerticalDatums() {
        return !CollectionHelper.nullEmptyOrContainsOnlyNulls(getVerticalDatums());
    }
}
