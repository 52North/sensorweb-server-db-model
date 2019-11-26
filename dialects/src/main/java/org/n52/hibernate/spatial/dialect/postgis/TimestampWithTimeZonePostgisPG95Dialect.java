/*
 * Copyright 2015-2019 52°North Initiative for Geospatial Open Source
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
package org.n52.hibernate.spatial.dialect.postgis;

import java.sql.Types;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.internal.util.StringHelper;
import org.hibernate.mapping.Column;
import org.hibernate.mapping.Index;
import org.hibernate.mapping.Table;

import org.hibernate.spatial.dialect.postgis.PostgisPG95Dialect;

public class TimestampWithTimeZonePostgisPG95Dialect extends PostgisPG95Dialect {

    private static final long serialVersionUID = -3409681181015765469L;

    public TimestampWithTimeZonePostgisPG95Dialect() {
        super();
        registerColumnType(Types.TIMESTAMP, "timestamp with time zone");
    }

    public String buildSqlCreateSpatialIndexString(Index index, String defaultCatalog, String defaultSchema) {
        // http://postgis.net/docs/manual-2.0/using_postgis_dbmanagement.html#idp60795872
        // CREATE INDEX [indexname] ON [tablename] USING GIST ( [geometryfield]
        // );

        String name = index.getName();
        Table table = index.getTable();
        Iterator<Column> columns = index.getColumnIterator();
        Map<Column, String> columnOrderMap = new HashMap<>();
        StringBuilder buf = new StringBuilder("create").append(" index ")
                .append(this.qualifyIndexName() ? name : StringHelper.unqualify(name)).append(" on ")
                .append(table.getQualifiedName(this, defaultCatalog, defaultSchema)).append(" USING GIST")
                .append(" (");
        while (columns.hasNext()) {
            Column column = columns.next();
            buf.append(column.getQuotedName(this));
            if (columnOrderMap.containsKey(column)) {
                buf.append(" ").append(columnOrderMap.get(column));
            }
            if (columns.hasNext()) {
                buf.append(", ");
            }
        }
        buf.append(")");
        return buf.toString();
    }
}
