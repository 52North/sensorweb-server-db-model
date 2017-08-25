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

import java.util.HashSet;
import java.util.Set;

public abstract class HierarchicalEntity<T> extends DescribableEntity {

    private static final long serialVersionUID = -530148269689996337L;

    private Set<T> children = new HashSet<>();

    private Set<T> parents = new HashSet<>();

    public void setChildren(Set<T> children) {
        this.children = children;
    }

    public void addChild(T child) {
        if (children != null) {
            this.children.add(child);
        }
    }

    public Set<T> getChildren() {
        return children;
    }

    public void setParents(Set<T> parents) {
        this.parents = parents;
    }

    public void addParent(T parent) {
        if (parents != null) {
            this.parents.add(parent);
        }
    }

    public Set<T> getParents() {
        return parents;
    }

    public final boolean hasChildren() {
        return getChildren() != null && !getChildren().isEmpty();
    }

    public final boolean hasParents() {
        return getParents() != null && !getParents().isEmpty();
    }

}
