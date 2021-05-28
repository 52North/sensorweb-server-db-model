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
package org.n52.series.db.beans.feature;

import java.util.Collection;
import java.util.Collections;

import org.n52.series.db.beans.FeatureEntity;
import org.n52.series.db.beans.feature.gmd.ResponsiblePartyEntity;
import org.n52.series.db.beans.feature.gml.VerticalDatumEntity;

/**
 * Hibernate entiity for the abstract monitoringPoint
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public abstract class AbstractMonitoringFeature extends FeatureEntity {

    private static final long serialVersionUID = 3379003106634935899L;

    private MonitoringPointContent content;

    /**
     * @return the content
     */
    public MonitoringPointContent getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public void setContent(MonitoringPointContent content) {
        this.content = content;
    }

    public boolean isSetContent() {
        return getContent() != null;
    }

    public Collection<ResponsiblePartyEntity> getRelatedParty() {
        if (isSetContent()) {
            return getContent().getRelatedParty();
        }
        return Collections.emptyList();
    }

    public AbstractMonitoringFeature setRelatedParty(Collection<ResponsiblePartyEntity> relatedParty) {
        if (!isSetContent()) {
            setContent(new MonitoringPointContent());
        }
        getContent().setRelatedParty(relatedParty);
        return this;
    }

    public AbstractMonitoringFeature addRelatedParty(Collection<ResponsiblePartyEntity> relatedParty) {
        if (!isSetContent()) {
            setContent(new MonitoringPointContent());
        }
        getContent().addAllRelatedParty(relatedParty);
        return this;
    }

    public AbstractMonitoringFeature addRelatedParty(ResponsiblePartyEntity relatedParty) {
        if (!isSetContent()) {
            setContent(new MonitoringPointContent());
        }
        getContent().addRelatedParty(relatedParty);
        return this;
    }

    public boolean hasRelatedParty() {
        return isSetContent() ? getContent().hasRelatedParties() : false;
    }

    public Collection<VerticalDatumEntity> getVerticalDatum() {
        if (isSetContent()) {
            return getContent().getVerticalDatum();
        }
        return Collections.emptyList();
    }

    public AbstractMonitoringFeature setVerticalDatum(Collection<VerticalDatumEntity> verticalDatum) {
        if (!isSetContent()) {
            setContent(new MonitoringPointContent());
        }
        getContent().setVerticalDatum(verticalDatum);
        return this;
    }

    public AbstractMonitoringFeature addVerticalDatum(Collection<VerticalDatumEntity> verticalDatum) {
        if (!isSetContent()) {
            setContent(new MonitoringPointContent());
        }
        getContent().addAllVerticalDatum(verticalDatum);
        return this;
    }

    public AbstractMonitoringFeature addVerticalDatum(VerticalDatumEntity verticalDatum) {
        if (!isSetContent()) {
            setContent(new MonitoringPointContent());
        }
        getContent().addVerticalDatum(verticalDatum);
        return this;
    }

    public boolean hasVerticalDatum() {
        return isSetContent() ? getContent().hasVerticalDatum() : false;
    }
}
