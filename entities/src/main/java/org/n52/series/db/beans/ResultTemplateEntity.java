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

import org.n52.series.db.beans.HibernateRelations.HasResultEncoding;
import org.n52.series.db.beans.HibernateRelations.HasResultStructure;

/**
 * @since 1.0.0
 *
 */
public class ResultTemplateEntity extends PkidEntity implements Serializable,  HasResultStructure, HasResultEncoding {

    private static final long serialVersionUID = -8847952458819368733L;

    private DatasetEntity<DataEntity<?>> dataset;

    private String identifier;

    private String resultStructure;

    private String resultEncoding;

    public ResultTemplateEntity() {
    }

    public DatasetEntity<DataEntity<?>> getDataset() {
        return dataset;
    }

    public void setDataset(DatasetEntity<DataEntity<?>> dataset) {
        this.dataset = dataset;
    }

    public String getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public boolean isSetIdentifier() {
        return getIdentifier() != null && !getIdentifier().isEmpty();
    }

    @Override
    public String getResultStructure() {
        return resultStructure;
    }

    @Override
    public boolean isSetResultStructure() {
        return getResultStructure() != null && !getResultStructure().isEmpty();
    }

    @Override
    public void setResultStructure(String resultStructure) {
        this.resultStructure = resultStructure;
    }

    @Override
    public String getResultEncoding() {
        return this.resultEncoding;
    }

    @Override
    public boolean isSetResultEncoding() {
        return getResultEncoding() != null && !getResultEncoding().isEmpty();
    }

    @Override
    public void setResultEncoding(String resultEncoding) {
        this.resultEncoding = resultEncoding;
    }

}
