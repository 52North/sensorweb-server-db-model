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

import java.util.Properties;
import java.util.TimeZone;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

public class SeriesLocalSessionFactoryBean extends LocalSessionFactoryBean implements ResourceLoaderAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeriesLocalSessionFactoryBean.class);

    private static final String DEFAULT_TIMEZONE = "UTC";

    private static final String JDBC_TIME_ZONE = "jdbc.time.zone";

    @Override
    protected SessionFactory buildSessionFactory(LocalSessionFactoryBuilder sfb) {
        Properties properties = sfb.getProperties();
        sfb.registerTypeOverride(createZonalTimestampType(properties));
        return super.buildSessionFactory(sfb);
    }

    private ZonalTimestampType createZonalTimestampType(Properties properties) {
        return new ZonalTimestampType(createTimeZone(properties));
    }

    private TimeZone createTimeZone(Properties properties) {
        String zone = properties.containsKey(JDBC_TIME_ZONE)
                ? properties.getProperty(JDBC_TIME_ZONE)
                : DEFAULT_TIMEZONE;
        try {
            LOGGER.info("Configure timezone for JDBC layer: " + zone);
            return TimeZone.getTimeZone(zone);
        } catch (Throwable e) {
            LOGGER.warn("Could not configure timezone for JDBC layer: " + zone);
            return TimeZone.getTimeZone(DEFAULT_TIMEZONE);
        }
    }
}
