/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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

import java.util.Collection;

/**
 * DataEntity with a measurement consisting of a SensorML, e.g. a SensorML event encoded in XML.
 */
public class SensorML20DataEntity extends DataEntity<String> {

    private static final long serialVersionUID = 6575930482296453999L;

    private String value;

    @Override
    public boolean isNoDataValue(Collection<String> noDataValues) {
        return getValue() == null ? false : noDataValues.contains(getValue());
    }
}