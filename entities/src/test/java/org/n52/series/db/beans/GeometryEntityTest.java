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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class GeometryEntityTest {

    @Test
    public void geometryToString() throws ParseException {
        GeometryEntity geometryEntity = new GeometryEntity();
        geometryEntity.setGeometry(new WKTReader(new GeometryFactory()).read("Point(52.7 7.52)"));
        Assertions.assertEquals("GeometryEntity [ x: 52.7, y: 7.52 ]", geometryEntity.toString());
    }

    @Test
    public void latLonToString() {
        GeometryEntity geometryEntity = new GeometryEntity();
        geometryEntity.setLat(52.7);
        geometryEntity.setLon(7.52);
        Assertions.assertEquals("GeometryEntity [ latitude: 52.7, longitude: 7.52 ]", geometryEntity.toString());
    }

}
