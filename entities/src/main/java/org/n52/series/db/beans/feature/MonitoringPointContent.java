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
package org.n52.series.db.beans.feature;

import java.util.ArrayList;
import java.util.Collection;

import org.n52.series.db.beans.feature.gmd.ResponsiblePartyEntity;
import org.n52.series.db.beans.feature.gml.VerticalDatumEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class MonitoringPointContent {

    /* 0..* */
    private Collection<ResponsiblePartyEntity> relatedParty = new ArrayList<>();

    /* 0..* */
    private Collection<VerticalDatumEntity> verticalDatum = new ArrayList<>();

    public Collection<ResponsiblePartyEntity> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(Collection<ResponsiblePartyEntity> relatedParties) {
        this.relatedParty.clear();
        if (relatedParties != null && !relatedParties.isEmpty()) {
            this.relatedParty.addAll(relatedParties);
        }
    }

    public void addAllRelatedParty(Collection<ResponsiblePartyEntity> rp) {
        if (rp != null) {
            this.relatedParty.addAll(rp);
        }
    }

    public void addRelatedParty(ResponsiblePartyEntity rp) {
        if (rp != null) {
            this.relatedParty.add(rp);
        }
    }

    public boolean hasRelatedParties() {
        return getRelatedParty() != null && !getRelatedParty().isEmpty();
    }

    public Collection<VerticalDatumEntity> getVerticalDatum() {
        return verticalDatum;
    }

    public void setVerticalDatum(Collection<VerticalDatumEntity> verticalDatum) {
        this.verticalDatum.clear();
        if (verticalDatum != null && !verticalDatum.isEmpty()) {
            this.verticalDatum.addAll(verticalDatum);
        }
    }

    public void addAllVerticalDatum(Collection<VerticalDatumEntity> vd) {
        if (vd != null) {
            this.verticalDatum.addAll(vd);
        }
    }

    public void addVerticalDatum(VerticalDatumEntity vd) {
        if (vd != null) {
            this.verticalDatum.add(vd);
        }
    }

    public boolean hasVerticalDatum() {
        return getVerticalDatum() != null && !getVerticalDatum().isEmpty();
    }
}
