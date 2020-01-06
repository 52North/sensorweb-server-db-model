/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans;

import static org.hamcrest.CoreMatchers.is;

import java.sql.Timestamp;

import org.hamcrest.MatcherAssert;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

public class OfferingEntityTest {

    @Test
    public void when_settingSamplingTimeStartWithNanos_then_nanosAvailableOnGetting() {
        OfferingEntity entity = new OfferingEntity();
        Timestamp expected = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        entity.setSamplingTimeStart(expected);
        Timestamp actual = (Timestamp) entity.getSamplingTimeStart();
        MatcherAssert.assertThat(actual.getNanos(), is(expected.getNanos()));
    }

    @Test
    public void when_settingSamplingTimeEndWithNanos_then_nanosAvailableOnGetting() {
        OfferingEntity entity = new OfferingEntity();
        Timestamp expected = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        entity.setSamplingTimeEnd(expected);
        Timestamp actual = (Timestamp) entity.getSamplingTimeEnd();
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
