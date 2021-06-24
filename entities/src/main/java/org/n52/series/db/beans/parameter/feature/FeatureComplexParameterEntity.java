/*
 * Copyright (C) 2015-2021 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.parameter.feature;

import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.n52.series.db.beans.parameter.ComplexParameterEntity;

public class FeatureComplexParameterEntity extends FeatureParameterEntity<Set<FeatureParameterEntity<?>>>
        implements ComplexParameterEntity<Set<FeatureParameterEntity<?>>> {

    private static final long serialVersionUID = -5166758396873257962L;

    @Override
    public Set<FeatureParameterEntity<?>> getValue() {
        return super.getValue() != null ? new TreeSet<>(super.getValue()) : super.getValue();
    }

    @Override
    public void setValue(Set<FeatureParameterEntity<?>> value) {
        super.setValue(value);
    }

    @Override
    public String getValueAsString() {
        return isSetValue()
                ? String.join("", getValue().stream().map(v -> v.getValueAsString()).collect(Collectors.toList()))
                : null;
    }

}