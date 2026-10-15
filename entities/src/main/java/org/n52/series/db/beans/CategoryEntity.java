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

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.n52.series.db.beans.i18n.I18nCategoryEntity;
import org.n52.series.db.beans.i18n.I18nEntity;

import java.io.Serial;
import java.util.Set;

@Entity(name = "org.n52.series.db.beans.CategoryEntity")
@Table(name = "category", indexes = @Index(name = "idx_category_identifier", columnList = "identifier"),
        uniqueConstraints = @UniqueConstraint(name = "un_category_identifier", columnNames = { "identifier" }))
@AttributeOverride(name = "id", column = @Column(name = "category_id"))
@AttributeOverride(name = "staIdentifier",
        column = @Column(name = "identifier", insertable = false, updatable = false))
public class CategoryEntity extends DescribableEntity {

    @Serial
    private static final long serialVersionUID = -5508957540970020954L;

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = I18nCategoryEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_category_id", nullable = false, foreignKey = @ForeignKey(name = "fk_category"))
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return super.getTranslations();
    }
}
