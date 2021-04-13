/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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

import org.n52.series.db.beans.HibernateRelations.HasDatasets;
import org.n52.series.db.beans.i18n.I18nEntity;

public class TagEntity extends DescribableEntity implements HasDatasets {

    private static final long serialVersionUID = 7851120161214727821L;
    private Set<DatasetEntity> datasets;
    private Set<I18nEntity<? extends Describable>> translations;

    @Override
    public String getName() {
        return getIdentifier();
    }

    @Override
    public void setName(String name) {
        setIdentifier(name);
    }

    @Override
    public Set<DatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public void setDatasets(Set<DatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return translations;
    }

    @Override
    public void setTranslations(Set<I18nEntity<? extends Describable>> translations) {
        this.translations = translations;
    }

}
