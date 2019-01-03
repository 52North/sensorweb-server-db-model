/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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

public abstract class AbstractRelationEntity<T> extends IdEntity {

    public static final String PROPERTY_ITEM = "item";
    public static final String PROPERTY_RELATED_ITEM = "relatedItem";

    private static final long serialVersionUID = -2573767006446257428L;

    private T item;

    private T relatedItem;

    private String role;

    private String relatedUrl;

    /**
     * @return the item
     */
    public T getItem() {
        return item;
    }

    /**
     * @param item
     *            the item to set
     */
    public void setItem(T item) {
        this.item = item;
    }

    /**
     * @return the relatedItem
     */
    public T getRelatedItem() {
        return relatedItem;
    }

    /**
     * @param relatedItem
     *            the relatedItem to set
     */
    public void setRelatedItem(T relatedItem) {
        this.relatedItem = relatedItem;
    }

    /**
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role the role to set
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
     * @param relatedUrl the relatedUrl to set
     */
    public void setRelatedUrl(String relatedUrl) {
        this.relatedUrl = relatedUrl;
    }

    public boolean isSetRelatedUrl() {
        return getRelatedUrl() != null && !getRelatedUrl().isEmpty();
    }
}
