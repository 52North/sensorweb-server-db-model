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
package org.n52.series.db.beans;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.SecondaryTable;

import java.io.Serial;
import java.util.Collection;

@Entity(name = "org.n52.series.db.beans.BlobDataEntity")
@SecondaryTable(name = "value_blob",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "fk_observation_id",
                foreignKey = @ForeignKey(name = "fk_blob_value")))
@DiscriminatorValue("blob")
public class BlobDataEntity extends DataEntity<Object> {

    @Serial
    private static final long serialVersionUID = 2881474333508410655L;

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return getValue() == null;
    }
}
