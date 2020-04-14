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
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Timestamp;
import java.util.Collection;

import org.hamcrest.MatcherAssert;
import org.joda.time.DateTime;
import org.junit.jupiter.api.Test;

public class DataEntityTest {

    @Test
    public void when_settingTimestartWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setSamplingTimeStart(timestamp);
        Timestamp timestart = (Timestamp) dataEntity.getSamplingTimeStart();
        MatcherAssert.assertThat(timestart.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingTimeendWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setSamplingTimeEnd(timestamp);
        Timestamp timeend = (Timestamp) dataEntity.getSamplingTimeEnd();
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
    public void when_empty_then_equal() {
        DataEntity<Object> dataEntity = createDataDummy();
        DataEntity<Object> other = createDataDummy();
        assertTrue(dataEntity.equals(other));
    }

    @Test
    public void when_empty_then_hascodeIsEqual() {
        DataEntity<Object> dataEntity = createDataDummy();
        DataEntity<Object> other = createDataDummy();
        assertEquals(dataEntity.hashCode(), other.hashCode());
    }

    @Test
    public void when_identifierNotNull_then_notEqual() {
        DataEntity<Object> dataEntity = createDataDummy();
        dataEntity.setIdentifier("test");
        DataEntity<Object> other = createDataDummy();
        assertFalse(dataEntity.equals(other));
    }

    @Test
    public void when_identifierNotNull_then_hascodeIsnotEqual() {
        DataEntity<Object> dataEntity = createDataDummy();
        dataEntity.setIdentifier("test");
        DataEntity<Object> other = createDataDummy();
        assertNotEquals(dataEntity.hashCode(), other.hashCode());
    }

    private DataEntity<Object> createDataDummy() {
        DataEntity<Object> dataEntity = new DataEntity<Object>() {
            private static final long serialVersionUID = 410887669441410239L;

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
