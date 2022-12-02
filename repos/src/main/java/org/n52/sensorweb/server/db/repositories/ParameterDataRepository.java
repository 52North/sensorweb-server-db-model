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
package org.n52.sensorweb.server.db.repositories;

import org.n52.series.db.beans.DescribableEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;

import com.cosium.spring.data.jpa.entity.graph.repository.EntityGraphQueryByExampleExecutor;

@NoRepositoryBean
public interface ParameterDataRepository<T extends DescribableEntity>
        extends AbstractRepository<T>, EntityGraphQueryByExampleExecutor<T> {

    default boolean exists(Specification<T> spcification) {
        return findOne(spcification).isPresent();
    }

    default T getInstance(T entity) {
        return entity.getId() != null ? findById(entity.getId()).orElse(null)
                : findByIdentifier(entity.getIdentifier()).orElse(null);
    }

}
