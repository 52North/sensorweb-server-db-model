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
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Table;
import org.n52.series.db.beans.CategoryEntity;

@Entity(name = "org.n52.series.db.beans.i18n.I18nCategoryEntity")
@Table(name = "category_i18n", indexes = @Index(name = "idx_category_i18n_category", columnList = "fk_category_id"))
@AttributeOverride(name = "id", column = @Column(name = "category_i18n_id"))
@AssociationOverride(name = "entity",
        joinColumns = @JoinColumn(name = "fk_category_id", nullable = false, insertable = false, updatable = false))
public class I18nCategoryEntity extends I18nEntity<CategoryEntity> {

    @Serial
    private static final long serialVersionUID = -203423201673121632L;
}
