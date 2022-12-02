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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.ServiceEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ParameterServiceRepository<T extends DescribableEntity>
        extends ParameterDataRepository<T>, NameRepository<T> {

    default Optional<T> findByIdentifierAndService(T entity) {
        return findOne(createExample(entity, createMatcher()));
    }

    @Override
    default T getInstance(T entity) {
        return findByIdentifierAndService(createIdentifierServiceExample(entity)).orElse(null);
    }

    default Example<T> createExample(T entity, ExampleMatcher matcher) {
        return Example.<T> of(entity, matcher);
    }

    default ExampleMatcher createMatcher() {
        return ExampleMatcher.matching().withIgnorePaths(getMatcherIgnorePaths().toArray(new String[0]))
                .withMatcher(DescribableEntity.PROPERTY_IDENTIFIER, GenericPropertyMatchers.exact())
                .withMatcher(DescribableEntity.PROPERTY_SERVICE + "." + DescribableEntity.PROPERTY_IDENTIFIER,
                        GenericPropertyMatchers.exact());
    }

    default Set<String> getMatcherIgnorePaths() {
        Set<String> paths = new HashSet<>();
        paths.add(DescribableEntity.PROPERTY_ID);
        paths.add(DescribableEntity.STA_IDENTIFIER);
        return paths;
    }

    default <T extends DescribableEntity> T createIdentifierServiceExample(T entity) {
        try {
            DescribableEntity example = entity.getClass().newInstance();
            example.setIdentifier(entity.getIdentifier());
            example.setService(entity.getService());
            return (T) example;
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | SecurityException e) {
            return entity;
        }
    }

    List<T> findByService(ServiceEntity service);

    default List<T> findByService(T entity, ServiceEntity service) {
        entity.setService(service);
        return findAll(createExample(entity, createMatcher()));
    }

    default void deleteByService(ServiceEntity service) {
        deleteAll(findByService(service));
    }

}
