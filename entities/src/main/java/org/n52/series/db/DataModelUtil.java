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
package org.n52.series.db;

import org.hibernate.Criteria;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.loader.criteria.CriteriaJoinWalker;
import org.hibernate.loader.criteria.CriteriaQueryTranslator;
import org.hibernate.persister.entity.OuterJoinLoadable;

public final class DataModelUtil {

    public static String getSqlString(Criteria criteria) {
        CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;
        SessionImplementor session = criteriaImpl.getSession();
        SessionFactoryImplementor factory = extractSessionFactory(criteria);
        CriteriaQueryTranslator translator = new CriteriaQueryTranslator(factory,
                                                                         criteriaImpl,
                                                                         criteriaImpl.getEntityOrClassName(),
                                                                         CriteriaQueryTranslator.ROOT_SQL_ALIAS);
        String[] implementors = factory.getImplementors(criteriaImpl.getEntityOrClassName());

        OuterJoinLoadable joinLoader = (OuterJoinLoadable) factory.getEntityPersister(implementors[0]);
        CriteriaJoinWalker walker = new CriteriaJoinWalker(joinLoader,
                                                           translator,
                                                           factory,
                                                           criteriaImpl,
                                                           criteriaImpl.getEntityOrClassName(),
                                                           session.getLoadQueryInfluencers());

        return walker.getSQLString();
    }

    public static boolean isEntitySupported(Class< ? > clazz, Criteria criteria) {
        SessionFactoryImplementor factory = extractSessionFactory(criteria);

        if (factory != null) {
            return factory.getAllClassMetadata()
                          .keySet()
                          .contains(clazz.getName());
        }
        return false;
    }

    public static SessionFactoryImplementor extractSessionFactory(Criteria criteria) {
        SessionImplementor session = getSessionImplementor(criteria);
        return session != null
                ? session.getFactory()
                : null;
    }

    private static SessionImplementor getSessionImplementor(Criteria criteria) {
        SessionImplementor session = null;
        if (criteria instanceof CriteriaImpl) {
            session = ((CriteriaImpl) criteria).getSession();
        } else if (criteria instanceof CriteriaImpl.Subcriteria) {
            CriteriaImpl temp = (CriteriaImpl) ((CriteriaImpl.Subcriteria) criteria).getParent();
            session = temp.getSession();
        }
        return session;
    }
}
