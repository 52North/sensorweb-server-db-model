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
package org.n52.series.db.beans.parameter.project;

import org.n52.series.db.beans.parameter.BooleanParameterEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public class ProjectBooleanParameterEntity extends ProjectParameterEntity<Boolean> implements BooleanParameterEntity {

    private static final long serialVersionUID = -1280123654095577480L;

    @Override
    public String getValueAsString() {
        return isSetValue() ? getValue().toString() : null;
    }

}
