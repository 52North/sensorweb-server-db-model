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

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.TimeZone;

import org.hibernate.type.descriptor.ValueBinder;
import org.hibernate.type.descriptor.ValueExtractor;
import org.hibernate.type.descriptor.WrapperOptions;
import org.hibernate.type.descriptor.java.JavaTypeDescriptor;
import org.hibernate.type.descriptor.sql.BasicBinder;
import org.hibernate.type.descriptor.sql.BasicExtractor;
import org.hibernate.type.descriptor.sql.TimestampTypeDescriptor;

/**
 * Hibernate TypeDescriptor which forces all Timestamps queried from/inserted to the database to use a
 * configurable TimeZone instead of the JVM's timezone.
 *
 * @author <a href="mailto:h.bredel@52north.org">Henning Bredel</a>
 * @since 2.0.0
 */
public final class ZonalTimestampTypeDescriptor extends TimestampTypeDescriptor {

    private static final long serialVersionUID = -7983231403900402497L;

    private static final TimeZone DEFAULT_ZONE = TimeZone.getTimeZone("UTC");

    private static ZonalTimestampTypeDescriptor instance;

    private static Calendar zonalCalendar = Calendar.getInstance(DEFAULT_ZONE);

    private ZonalTimestampTypeDescriptor() {
        this(DEFAULT_ZONE);
    }

    private ZonalTimestampTypeDescriptor(TimeZone zone) {
        if (zone != null) {
            zonalCalendar = Calendar.getInstance(zone);
        }
    }

    public static ZonalTimestampTypeDescriptor getInstance() {
        if (instance == null) {
            instance = new ZonalTimestampTypeDescriptor();
        }
        return instance;
    }

    public static ZonalTimestampTypeDescriptor getInstance(TimeZone zone) {
        if (instance != null) {
            final String calendar = zonalCalendar.toString();
            throw new IllegalStateException("Configured already: '" + calendar + "'");
        }
        return new ZonalTimestampTypeDescriptor(zone);
    }

    @Override
    public <X> ValueBinder<X> getBinder(final JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicBinder<X>(javaTypeDescriptor, this) {
            @Override
            protected void doBind(PreparedStatement st, X value, int index, WrapperOptions opts)
                    throws SQLException {
                final Timestamp unwrapped = javaTypeDescriptor.unwrap(value, Timestamp.class, opts);
                st.setTimestamp(index, unwrapped, zonalCalendar);
            }
        };
    }

    @Override
    public <X> ValueExtractor<X> getExtractor(final JavaTypeDescriptor<X> javaTypeDescriptor) {
        return new BasicExtractor<X>(javaTypeDescriptor, this) {
            @Override
            protected X doExtract(ResultSet rs, String name, WrapperOptions opts) throws SQLException {
                if (rs.getObject(name) != null) {
                    return javaTypeDescriptor.wrap(rs.getTimestamp(name, zonalCalendar), opts);
                }
                return null;
            }

            @Override
            protected X doExtract(CallableStatement statement, int index, WrapperOptions opts)
                    throws SQLException {
                return javaTypeDescriptor.wrap(statement.getTimestamp(index, zonalCalendar), opts);
            }

            @Override
            protected X doExtract(CallableStatement statement, String name, WrapperOptions opts)
                    throws SQLException {
                return javaTypeDescriptor.wrap(statement.getTimestamp(name, zonalCalendar), opts);
            }
        };
    }

}
