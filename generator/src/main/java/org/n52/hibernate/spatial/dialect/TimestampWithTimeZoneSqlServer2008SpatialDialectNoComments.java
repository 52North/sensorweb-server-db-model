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
package org.n52.hibernate.spatial.dialect;

import org.n52.hibernate.spatial.dialect.sqlserver.TimestampWithTimeZoneSqlServer2008SpatialDialect;

public class TimestampWithTimeZoneSqlServer2008SpatialDialectNoComments
        extends TimestampWithTimeZoneSqlServer2008SpatialDialect {

    private static final long serialVersionUID = 4504714178692811427L;

    public TimestampWithTimeZoneSqlServer2008SpatialDialectNoComments() {
        super();
    }

    @Override
    public boolean supportsCommentOn() {
        return false;
    }

}
