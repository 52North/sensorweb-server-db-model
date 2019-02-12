/*
 * Copyright 2015, The Querydsl Team (http://www.querydsl.com/team)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.querydsl.jpa.codegen;

import java.util.Map;

import com.google.common.collect.Maps;
import com.mysema.codegen.model.SimpleType;
import com.querydsl.codegen.TypeMappings;

// TODO remove customized versions when querydsl merges PR #2322
// https://github.com/querydsl/querydsl/pull/2322

final class SpatialSupport {

    private static void registerJTSTypes(TypeMappings typeMappings) {
        Map<String, String> additions = Maps.newHashMap();
        additions.put("Geometry", "JTSGeometryPath");
        additions.put("GeometryCollection", "JTSGeometryCollectionPath");
        additions.put("LinearRing", "JTSLinearRingPath");
        additions.put("LineString", "JTSLineStringPath");
        additions.put("MultiLineString", "JTSMultiLineStringPath");
        additions.put("MultiPoint", "JTSMultiPointPath");
        additions.put("MultiPolygon", "JTSMultiPolygonPath");
        additions.put("Point", "JTSPointPath");
        additions.put("Polygon", "JTSPolygonPath");
        for (Map.Entry<String, String> entry : additions.entrySet()) {
            typeMappings.register(
                                  new SimpleType("org.locationtech.jts.geom." + entry.getKey()),
                                  new SimpleType("com.querydsl.spatial.jts." + entry.getValue()));
        }
    }

    public static void addSupport(TypeMappings typeMappings) {
        registerJTSTypes(typeMappings);
    }

    private SpatialSupport() {
    }
}
