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

import org.hamcrest.MatcherAssert;
import org.joda.time.DateTime;
import org.junit.Test;

public class OfferingEntityTest {

    @Test
    public void when_settingPhenomenonTimeStartWithNanos_then_nanosAvailableOnGetting() {
        OfferingEntity entity = new OfferingEntity();
        Timestamp expected = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        entity.setPhenomenonTimeStart(expected);
        Timestamp actual = (Timestamp) entity.getPhenomenonTimeStart();
        MatcherAssert.assertThat(actual.getNanos(), is(expected.getNanos()));
    }

    @Test
    public void when_settingPhenomenonTimeEndWithNanos_then_nanosAvailableOnGetting() {
        OfferingEntity entity = new OfferingEntity();
        Timestamp expected = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        entity.setPhenomenonTimeEnd(expected);
        Timestamp actual = (Timestamp) entity.getPhenomenonTimeEnd();
        MatcherAssert.assertThat(actual.getNanos(), is(expected.getNanos()));
    }

    @Test
    public void when_settingResultTimeStartWithNanos_then_nanosAvailableOnGetting() {
        OfferingEntity entity = new OfferingEntity();
        Timestamp expected = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        entity.setResultTimeStart(expected);
        Timestamp actual = (Timestamp) entity.getResultTimeStart();
        MatcherAssert.assertThat(actual.getNanos(), is(expected.getNanos()));
    }

    @Test
    public void when_settingResultTimeEndWithNanos_then_nanosAvailableOnGetting() {
        OfferingEntity entity = new OfferingEntity();
        Timestamp expected = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        entity.setResultTimeEnd(expected);
        Timestamp actual = (Timestamp) entity.getResultTimeEnd();
        MatcherAssert.assertThat(actual.getNanos(), is(expected.getNanos()));
    }

    private Timestamp createTimestamp(String date, int nanos) {
        DateTime timeValue = DateTime.parse(date);
        Timestamp timestamp = new Timestamp(timeValue.getMillis());
        timestamp.setNanos(nanos);
        return timestamp;
    }
}
