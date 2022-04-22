/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.hibernate.spatial.dialect.mysql;

import java.sql.Types;

import org.hibernate.HibernateException;
import org.hibernate.spatial.dialect.mysql.MySQL8SpatialDialect;

public class TimestampMySQL8SpatialDialect extends MySQL8SpatialDialect {

    private static final long serialVersionUID = -8145146230035810465L;
    private static final String TIMESTAMP = "timestamp";

    public TimestampMySQL8SpatialDialect() {
        super();
        registerColumnType(Types.TIMESTAMP, TIMESTAMP);
    }

    @Override
    public String getTypeName(int code, long length, int precision, int scale) throws HibernateException {
        if (Types.TIMESTAMP == code) {
            return TIMESTAMP;
        }
        return super.getTypeName(code, length, precision, scale);
    }

    @Override
    public String getTypeName(int code) throws HibernateException {
        if (Types.TIMESTAMP == code) {
            return TIMESTAMP;
        }
        return super.getTypeName(code);
    }

    @Override
    public String getNullColumnString() {
        return " NULL";
    }
}
