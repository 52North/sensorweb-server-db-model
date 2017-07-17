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
package org.n52.series.db.beans;

import static org.hamcrest.CoreMatchers.is;

import java.sql.Timestamp;
import java.util.Collection;

import org.hamcrest.MatcherAssert;
import org.joda.time.DateTime;
import org.junit.Test;

public class DataEntityTest {

    @Test
    public void when_settingTimestartWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setTimestart(timestamp);
        Timestamp timestart = (Timestamp) dataEntity.getTimestart();
        MatcherAssert.assertThat(timestart.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingTimeendWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setTimeend(timestamp);
        Timestamp timeend = (Timestamp) dataEntity.getTimeend();
        MatcherAssert.assertThat(timeend.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingResulttimeWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setResultTime(timestamp);
        Timestamp resulttime = (Timestamp) dataEntity.getResultTime();
        MatcherAssert.assertThat(resulttime.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingTimestampWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setTimestamp(timestamp);
        Timestamp timestamp2 = (Timestamp) dataEntity.getTimestamp();
        MatcherAssert.assertThat(timestamp2.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingValidTimeStartWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setValidTimeStart(timestamp);
        Timestamp validTimestart = (Timestamp) dataEntity.getValidTimeStart();
        MatcherAssert.assertThat(validTimestart.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingValidTimeEndWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setValidTimeEnd(timestamp);
        Timestamp validTimeend = (Timestamp) dataEntity.getValidTimeEnd();
        MatcherAssert.assertThat(validTimeend.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingTimestamp_then_timeendIsSet() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp now = new Timestamp(System.currentTimeMillis());

        dataEntity.setTimestamp(now);
        Timestamp timeend = (Timestamp) dataEntity.getTimeend();
        MatcherAssert.assertThat(timeend, is(now));
    }

    private DataEntity<Object> createDataDummy() {
        DataEntity<Object> dataEntity = new DataEntity<Object>() {
            @Override
            public boolean isNoDataValue(Collection<String> noDataValues) {
                // TODO Auto-generated method stub
                return false;
            }
        };
        return dataEntity;
    }

    private Timestamp createTimestamp(String date, int nanos) {
        DateTime timeValue = DateTime.parse(date);
        Timestamp timestamp = new Timestamp(timeValue.getMillis());
        timestamp.setNanos(nanos);
        return timestamp;
    }
}
