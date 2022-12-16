/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.sta;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.sta.StaRelations.StaPlusTime;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class ProjectEntity extends DescribableEntity implements Serializable, HibernateRelations.HasName,
        HibernateRelations.HasDescription, StaPlusTime<ProjectEntity>, HibernateRelations.HasAbstractDatasets {
    public static final String PROPERTY_URL = "url";
    private static final long serialVersionUID = -2909642026383185577L;

    private String classification;
    private String termsOfUse;
    private String privacyPolicy;
    private Date creationTime;
    private Date runTimeStart;
    private Date runTimeEnd;
    private String url;
    private Set<AbstractDatasetEntity> datasets;

    public String getClassification() {
        return classification;
    }

    public ProjectEntity setClassification(String classification) {
        this.classification = classification;
        return this;
    }

    public String getTermsOfUse() {
        return termsOfUse;
    }

    public ProjectEntity setTermsOfUse(String termsOfUse) {
        this.termsOfUse = termsOfUse;
        return this;
    }

    public String getPrivacyPolicy() {
        return privacyPolicy;
    }

    public ProjectEntity setPrivacyPolicy(String privacyPolicy) {
        this.privacyPolicy = privacyPolicy;
        return this;
    }

    @Override
    public Date getCreationTime() {
        return creationTime;
    }

    @Override
    public ProjectEntity setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
        return this;
    }

    @Override
    public Date getRunTimeStart() {
        return runTimeStart;
    }

    @Override
    public ProjectEntity setRunTimeStart(Date runTimeStart) {
        this.runTimeStart = runTimeStart;
        return this;
    }

    @Override
    public Date getRunTimeEnd() {
        return runTimeEnd;
    }

    @Override
    public ProjectEntity setRunTimeEnd(Date runTimeEnd) {
        this.runTimeEnd = runTimeEnd;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public ProjectEntity setUrl(String url) {
        this.url = url;
        return this;
    }

    public boolean isSetUrl() {
        return getUrl() != null && !getUrl().isEmpty();
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

}
