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

public class RelatedDataEntity extends AbstractRelationEntity {

    private static final long serialVersionUID = 2436177373903826414L;

    private DatasetEntity data;

    private DatasetEntity relatedData;

    /**
     * @return the data
     */
    public DatasetEntity getData() {
        return data;
    }

    /**
     * @param data
     *            the data to set
     */
    public void setData(DatasetEntity data) {
        this.data = data;
    }

    /**
     * @return the relatedData
     */
    public DatasetEntity getRelatedData() {
        return relatedData;
    }

    /**
     * @param relatedData
     *            the relatedData to set
     */
    public void setRelatedData(DatasetEntity relatedData) {
        this.relatedData = relatedData;
    }

    public boolean isSetRelatedData() {
        return getRelatedData() != null;
    }

}
