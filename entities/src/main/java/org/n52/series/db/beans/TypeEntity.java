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

public abstract class TypeEntity<T> extends PkidEntity {

    public static final String TYPE = "type";

    private static final long serialVersionUID = -8428858401445365107L;

    private String type;

    public String getType() {
        return this.type;
    }

    public TypeEntity<T> setType(String type) {
        this.type = type;
        return this;
    }

    public boolean isSetType() {
        return getType() != null && !getType().isEmpty();
    }
}
