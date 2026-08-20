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

package org.n52.series.db.beans.i18n;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import org.n52.series.db.beans.DataEntity;

import java.io.Serial;

@Entity(name = "org.n52.series.db.beans.i18n.I18nDataEntity")
@Table(
    name = "observation_i18n",
    indexes = @Index(name = "idx_observation_i18n_observation", columnList = "fk_observation_id"))
@AttributeOverride(name = "id", column = @Column(name = "observation_i18n_id"))
@AssociationOverride(name = "entity", joinColumns = @JoinColumn(name = "fk_observation_id", nullable = false,
                                                                insertable = false, updatable = false))
public class I18nDataEntity extends I18nEntity<DataEntity<?>> {

    @Serial
    private static final long serialVersionUID = 6049859871182587108L;

    @Column(name = "value_name")
    private String valueName;

    @Column(name = "value_description")
    private String valueDescription;

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String shortName) {
        this.valueName = shortName;
    }

    public String getValueDescription() {
        return valueDescription;
    }

    public void setValueDescription(String longName) {
        this.valueDescription = longName;
    }

    public boolean hasValueDescription() {
        return getValueDescription() != null && !getValueDescription().isEmpty();
    }

    public boolean hasValueName() {
        return getValueName() != null && !getValueName().isEmpty();
    }
}
