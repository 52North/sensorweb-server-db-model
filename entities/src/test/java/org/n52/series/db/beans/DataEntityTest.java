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

        dataEntity.setPhenomenonTimeStart(timestamp);
        Timestamp timestart = (Timestamp) dataEntity.getPhenomenonTimeStart();
        MatcherAssert.assertThat(timestart.getNanos(), is(timestamp.getNanos()));
    }

    @Test
    public void when_settingTimeendWithNanos_then_nanosAvailableOnGetting() {
        DataEntity<Object> dataEntity = createDataDummy();
        Timestamp timestamp = createTimestamp("2015-07-17T21:14:35.022+02", 321);

        dataEntity.setPhenomenonTimeEnd(timestamp);
        Timestamp timeend = (Timestamp) dataEntity.getPhenomenonTimeEnd();
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
