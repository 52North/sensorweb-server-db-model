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

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import java.io.Serial;

@MappedSuperclass
public abstract class AbstractRelationEntity<T> {

    public static final String PROPERTY_ITEM = "item";
    public static final String PROPERTY_RELATED_ITEM = "relatedItem";

    @Column(name = "role")
    // @Comment("Definition of the role of the relation")
    private String role;

    @Column(name = "url")
    // @Comment("URL that point to external information")
    private String relatedUrl;

    /**
     * @return the item
     */
    public abstract T getItem();

    /**
     * @param item
     *            the item to set
     */
    public abstract void setItem(T item);

    /**
     * @return the relatedItem
     */
    public abstract T getRelatedItem();

    /**
     * @param relatedItem
     *            the relatedItem to set
     */
    public abstract void setRelatedItem(T relatedItem);

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     *            the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    public boolean isSetRole() {
        return getRole() != null && !getRole().isEmpty();
    }

    /**
     * @return the relatedUrl
     */
    public String getRelatedUrl() {
        return relatedUrl;
    }

    /**
     * @param relatedUrl
     *            the relatedUrl to set
     */
    public void setRelatedUrl(String relatedUrl) {
        this.relatedUrl = relatedUrl;
    }

    public boolean isSetRelatedUrl() {
        return getRelatedUrl() != null && !getRelatedUrl().isEmpty();
    }
}
