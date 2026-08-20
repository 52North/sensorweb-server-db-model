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

import java.io.Serial;

import jakarta.persistence.AssociationOverride;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import org.n52.series.db.beans.UnitEntity;

@Entity(name = "org.n52.series.db.beans.i18n.I18nUnitEntity")
@Table(name = "unit_i18n", indexes = @Index(name = "idx_unit_i18n_unit", columnList = "fk_unit_id"))
@AttributeOverrides({ @AttributeOverride(name = "id", column = @Column(name = "unit_i18n_id")),
        @AttributeOverride(name = "description",
                column = @Column(name = "unit_i18n_id", insertable = false, updatable = false)) })
@AssociationOverride(name = "entity", joinColumns = @JoinColumn(name = "fk_unit_id", nullable = false))
public class I18nUnitEntity extends I18nEntity<UnitEntity> {

    @Serial
    private static final long serialVersionUID = -611501137242466095L;

    // re-uses existing i18n logic
    // maps attribute 'unit' to internationalizable attribute 'name'
}
