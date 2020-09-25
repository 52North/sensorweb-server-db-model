/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans.parameter.location;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.n52.series.db.beans.parameter.ComplexParameterEntity;

public class LocationComplexParameterEntity extends LocationParameterEntity<Set<LocationParameterEntity<?>>>
        implements ComplexParameterEntity<Set<LocationParameterEntity<?>>> {

    private static final long serialVersionUID = -5166758396873257962L;

    @Override
    public Set<LocationParameterEntity<?>> getValue() {
        return super.getValue() != null ? new TreeSet<>(super.getValue()) : super.getValue();
    }

    @Override
    public void setValue(Set<LocationParameterEntity<?>> value) {
        super.setValue(value);
    }

    @Override
    public String getValueAsString() {
        return isSetValue()
                ? String.join("", getValue().stream().map(v -> v.getValueAsString()).collect(Collectors.toList()))
                : null;
    }

}
