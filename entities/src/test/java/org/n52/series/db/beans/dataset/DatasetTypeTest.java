/*
 * Copyright 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.dataset;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class DatasetTypeTest {

    @Test
    public void convert() {
        HashSet<String> set = new HashSet<>();
        set.add("individualObservation");
        Set<DatasetType> convert = DatasetType.convert(set);
        assertEquals(1, convert.size());
        assertEquals(DatasetType.individualObservation, convert.iterator().next());
    }

    @Test
    public void convertWithInvalidValue() {
        HashSet<String> set = new HashSet<>();
        set.add("individualObervation");
        Set<DatasetType> convert = DatasetType.convert(set);
        assertEquals(0, convert.size());
    }

}
