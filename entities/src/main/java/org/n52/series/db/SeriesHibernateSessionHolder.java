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

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class SeriesHibernateSessionHolder implements HibernateSessionStore {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeriesHibernateSessionHolder.class);

    @Autowired
    private SessionFactory seriesSessionFactory;

    @Override
    public Session getSession() {
        return seriesSessionFactory.openSession();
    }

    @Override
    public void returnSession(Session session) {
        if (session != null && session.isOpen()) {
            session.clear();
            session.close();
        }
    }

    @Override
    public void shutdown() {
        LOGGER.info("Closing '{}'", getClass().getSimpleName());
        seriesSessionFactory.close();
    }

}
