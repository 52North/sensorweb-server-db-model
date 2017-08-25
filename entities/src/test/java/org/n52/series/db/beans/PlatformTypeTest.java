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

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PlatformTypeTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void when_mobileInsituString_then_recognizeType() {
        Assert.assertThat(PlatformType.toInstance("mobile_insitu"), Matchers.is(PlatformType.MOBILE_INSITU));
    }

    @Test
    public void when_mobileRemoteString_then_recognizeType() {
        Assert.assertThat(PlatformType.toInstance("mobile_remote"), Matchers.is(PlatformType.MOBILE_REMOTE));
    }

    @Test
    public void when_stationaryInsituString_then_recognizeType() {
        Assert.assertThat(PlatformType.toInstance("stationary_insitu"), Matchers.is(PlatformType.STATIONARY_INSITU));
    }

    @Test
    public void when_stationaryRemoteString_then_recognizeType() {
        Assert.assertThat(PlatformType.toInstance("stationary_remote"), Matchers.is(PlatformType.STATIONARY_REMOTE));
    }

    @Test
    public void when_unknownType_then_throwException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage("no type for 'does not exist'.");
        PlatformType.toInstance("does not exist");
    }

    @Test
    public void when_extractingId_then_typePrefixGone() {
        Assert.assertThat(PlatformType.extractId("mobile_insitu_foobar"), Matchers.is("foobar"));
    }

    @Test
    public void when_extractingWithInvalidPrefix_then_expectIdentity() {
        Assert.assertThat(PlatformType.extractId("invalid_prefix"), Matchers.is("invalid_prefix"));
    }

    @Test
    public void when_stationaryOnlyPrefix_then_expectIdentity() {
        Assert.assertThat(PlatformType.extractId("stationary"), Matchers.is("stationary"));
    }

    @Test
    public void when_mobileOnlyPrefix_then_expectIdentity() {
        Assert.assertThat(PlatformType.extractId("mobile"), Matchers.is("mobile"));
    }

    @Test
    public void when_idWithStationaryPrefix_then_detectType() {
        Assert.assertTrue(PlatformType.isStationaryId("stationary_remote_something"));
    }

    @Test
    public void when_idWithMobilePrefix_then_detectType() {
        Assert.assertTrue(PlatformType.isMobileId("mobile_insitu_something"));
    }

    @Test
    public void when_idWithInsituSuffix_then_detectType() {
        Assert.assertTrue(PlatformType.isInsituId("mobile_insitu_10"));
    }

}
