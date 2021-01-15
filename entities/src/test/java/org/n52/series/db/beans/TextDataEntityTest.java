/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.Test;

public class TextDataEntityTest {

    @Test
    public void when_noDataCollectionContainsValue_then_detectNoDataValue() {
        Collection<String> noDataValues = Arrays.asList(new String[] { "blubb", "-9999.9" });
        TextDataEntity entity = new TextDataEntity();
        entity.setValue("blubb");
        assertTrue(entity.isNoDataValue(noDataValues));
    }
}
