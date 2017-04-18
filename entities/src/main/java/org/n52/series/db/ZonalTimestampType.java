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

import java.util.Comparator;
import java.util.Date;
import java.util.TimeZone;

import org.hibernate.HibernateException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.type.AbstractSingleColumnStandardBasicType;
import org.hibernate.type.LiteralType;
import org.hibernate.type.TimestampType;
import org.hibernate.type.VersionType;
import org.hibernate.type.descriptor.java.JdbcTimestampTypeDescriptor;

/**
 * A type that maps between {@link java.sql.Types#TIMESTAMP TIMESTAMP} and {@link java.sql.Timestamp}.
 * Delegates to Hibernate's TimestampType, but specifies ZonalTimestampTypeDescriptor as the SqlTypeDescriptor
 * so that times from the database can be configured to have a specific timezone.
 *
 * @see <a href="http://stackoverflow.com/a/3430957/2299448"> http://stackoverflow.com/a/3430957/2299448</a>
 */
public class ZonalTimestampType extends AbstractSingleColumnStandardBasicType<Date> implements
        VersionType<Date>,
        LiteralType<Date> {

    private static final long serialVersionUID = 1425445989380765998L;

    /**
     * Creates with timezone UTC.
     */
    public ZonalTimestampType() {
        // the only actual overriding is the descriptor
        this(TimeZone.getTimeZone("UTC"));
    }

    /**
     * Creates an instance handling timestamps under given Timezone.
     *
     * @param zone
     *        the time zone timestamps shall be handled in.
     */
    public ZonalTimestampType(TimeZone zone) {
        // the only actual overriding is the descriptor
        super(ZonalTimestampTypeDescriptor.getInstance(zone), JdbcTimestampTypeDescriptor.INSTANCE);
    }

    @Override
    public String getName() {
        return TimestampType.INSTANCE.getName();
    }

    @Override
    public String[] getRegistrationKeys() {
        return TimestampType.INSTANCE.getRegistrationKeys();
    }

    @Override
    public Date next(Date current, SessionImplementor session) {
        return TimestampType.INSTANCE.next(current, session);
    }

    @Override
    public Date seed(SessionImplementor session) {
        return TimestampType.INSTANCE.seed(session);
    }

    @Override
    public Comparator<Date> getComparator() {
        return TimestampType.INSTANCE.getComparator();
    }

    @Override
    public String objectToSQLString(Date value, Dialect dialect) throws Exception {
        return TimestampType.INSTANCE.objectToSQLString(value, dialect);
    }

    @Override
    public Date fromStringValue(String xml) throws HibernateException {
        return TimestampType.INSTANCE.fromStringValue(xml);
    }
}
