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
package org.n52.sensorweb.server.db.repositories.core;

import java.util.List;
import java.util.Set;

import org.n52.sensorweb.server.db.repositories.ParameterServiceRepository;
import org.n52.series.db.beans.ProcedureEntity;
import org.n52.series.db.beans.ServiceEntity;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ProcedureRepository extends ParameterServiceRepository<ProcedureEntity> {

    @Override
    default List<ProcedureEntity> findByService(ServiceEntity service) {
        return findAll(createExample(new ProcedureEntity(), createMatcher()));
    }

    @Override
    default Set<String> getMatcherIgnorePaths() {
        Set<String> paths = ParameterServiceRepository.super.getMatcherIgnorePaths();
        paths.add(ProcedureEntity.PROPERTY_REFERENCE);
        paths.add(ProcedureEntity.PROPERTY_AGGRAGATION);
        return paths;
    }
}
