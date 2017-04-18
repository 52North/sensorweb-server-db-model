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

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

public class ServiceEntityTest {

    private ServiceEntity serviceInfo;

    @Before
    public void setUp() {
        serviceInfo = new ServiceEntity();
    }

    public void shouldNotFailWhenSettingInvalidNoDataValues() {
        TextDataEntity entity = new TextDataEntity();
        serviceInfo.setNoDataValues("4.3,9,no-data");
        entity.setValue("no-data");
        MatcherAssert.assertThat(serviceInfo.isNoDataValue(entity), is(true));
    }

    @Test
    public void shouldTreatNullAsNoDataValue() {
        MeasurementDataEntity entity = new MeasurementDataEntity();
        entity.setValue(null);
        MatcherAssert.assertThat(serviceInfo.isNoDataValue(entity), Is.is(true));
    }

    @Test
    public void shouldTreatNaNAsNoDataValue() {
        MeasurementDataEntity entity = new MeasurementDataEntity();
        MatcherAssert.assertThat(serviceInfo.isNoDataValue(entity), Is.is(true));
    }

    @Test
    public void shouldHandleDoubleValues() {
        serviceInfo.setNoDataValues("4.3,9,foo");
        MeasurementDataEntity entity = new MeasurementDataEntity();
        entity.setValue(new Double(9));
        MatcherAssert.assertThat(serviceInfo.isNoDataValue(entity), Is.is(true));

        entity.setValue(4.30);
        MatcherAssert.assertThat(serviceInfo.isNoDataValue(entity), Is.is(true));
    }
}
