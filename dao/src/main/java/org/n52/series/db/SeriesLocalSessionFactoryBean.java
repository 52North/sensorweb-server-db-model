/*
 * Copyright (C) 2015-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public License
 * version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */
package org.n52.series.db;

import java.util.Properties;
import java.util.TimeZone;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;

public class SeriesLocalSessionFactoryBean extends LocalSessionFactoryBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(SeriesLocalSessionFactoryBean.class);

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
            : "UTC";
        try {
            LOGGER.info("Configure timezone for JDBC layer: " + zone);
            return TimeZone.getTimeZone(zone);
        } catch (Throwable e) {
            LOGGER.warn("Could not configure timezone for JDBC layer: " + zone);
            return TimeZone.getTimeZone("UTC");
        }
    }
}
