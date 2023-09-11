/*
 * Copyright (C) 2015-2023 52°North Spatial Information Research GmbH
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DescribableEntityTest {

    private DescribableEntity entity = new DescribableEntity() {
        private static final long serialVersionUID = 2075113368317218591L;
    };

    @Test
    public void test_urn_mailto() {
        String processIdentifierForSta = entity.processIdentifierForSta("mailto:java-net@java.sun.com");
        Assertions.assertEquals("mailto:java-net@java.sun.com", processIdentifierForSta);
    }

    @Test
    public void test_urn_news() {
        String processIdentifierForSta = entity.processIdentifierForSta("news:comp.lang.java");
        Assertions.assertEquals("news:comp.lang.java", processIdentifierForSta);
    }

    @Test
    public void test_urn_isbn() {
        String processIdentifierForSta = entity.processIdentifierForSta("urn:isbn:096139210x");
        Assertions.assertEquals("urn:isbn:096139210x", processIdentifierForSta);
    }

    @Test
    public void test_url_http() {
        String processIdentifierForSta = entity.processIdentifierForSta("http://java.sun.com/j2se/1.3/");
        Assertions.assertEquals("urn:http:java:sun:com:j2se:1.3", processIdentifierForSta);
    }

    @Test
    public void test_url_docs() {
        String processIdentifierForSta = entity.processIdentifierForSta("docs/guide/collections/designfaq.html#28");
        Assertions.assertEquals("urn:docs:guide:collections:designfaq.html#28", processIdentifierForSta);
    }

    @Test
    public void test_url_file() {
        String processIdentifierForSta = entity.processIdentifierForSta("file:///~/calendar");
        Assertions.assertEquals("urn:file:~:calendar", processIdentifierForSta);
    }

    @Test
    public void test_id() {
        String processIdentifierForSta = entity.processIdentifierForSta("123");
        Assertions.assertEquals("123", processIdentifierForSta);
    }

}
