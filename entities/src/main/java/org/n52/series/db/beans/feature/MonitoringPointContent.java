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
import java.util.List;

import org.n52.series.db.beans.feature.gmd.ResponsiblePartyEntity;
import org.n52.series.db.beans.feature.gml.VerticalDatumEntity;
import org.n52.shetland.util.CollectionHelper;

public class MonitoringPointContent {

    /* 0..* */
    private List<ResponsiblePartyEntity> relatedParty = new ArrayList<>();
    /* 0..* */
    private List<VerticalDatumEntity> verticalDatum = new ArrayList<>();

    public List<ResponsiblePartyEntity> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(Collection<ResponsiblePartyEntity> relatedParty) {
        this.relatedParty.clear();
        if (!CollectionHelper.nullEmptyOrContainsOnlyNulls(relatedParty)) {
            this.relatedParty.addAll(relatedParty);
        }
    }

    public void addRelatedParty(Collection<ResponsiblePartyEntity> relatedParty) {
        if (relatedParty != null) {
            this.relatedParty.addAll(relatedParty);
        }
    }

    public void addRelatedParty(ResponsiblePartyEntity relatedParty) {
        if (relatedParty != null) {
            this.relatedParty.add(relatedParty);
        }
    }

    public boolean hasRelatedParty() {
        return !CollectionHelper.nullEmptyOrContainsOnlyNulls(getRelatedParty());
    }

    public List<VerticalDatumEntity> getVerticalDatum() {
        return verticalDatum;
    }

    public void setVerticalDatum(Collection<VerticalDatumEntity> verticalDatum) {
        this.verticalDatum.clear();
        if (!CollectionHelper.nullEmptyOrContainsOnlyNulls(verticalDatum)) {
            this.verticalDatum.addAll(verticalDatum);
        }
    }

    public void addVerticalDatum(Collection<VerticalDatumEntity> verticalDatum) {
        if (verticalDatum != null) {
            this.verticalDatum.addAll(verticalDatum);
        }
    }

    public void addVerticalDatum(VerticalDatumEntity verticalDatum) {
        if (verticalDatum != null) {
            this.verticalDatum.add(verticalDatum);
        }
    }

    public boolean hasVerticalDatum() {
        return !CollectionHelper.nullEmptyOrContainsOnlyNulls(getVerticalDatum());
    }
}
