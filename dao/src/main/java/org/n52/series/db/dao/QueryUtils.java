/*
 * Copyright (C) 2015-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public License
 * version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */

package org.n52.series.db.dao;

import java.util.Set;
import java.util.stream.Collectors;

import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;

public class QueryUtils {

    static final String PROPERTY_PKID = "pkid";

    public static String createAssociation(String alias, String property) {
        return alias != null && !alias.isEmpty()
                ? alias + "." + property
                : property;
    }

    public static Set<Long> parseToIds(Set<String> ids) {
        return ids.stream()
                  .map(e -> parseToId(e))
                  .collect(Collectors.toSet());
    }

    public static SimpleExpression matchesPkid(String pkid) {
        return Restrictions.eq(PROPERTY_PKID, QueryUtils.parseToId(pkid));
    }

    /**
     * @param id
     *        the id string to parse.
     * @return the long value of given string or {@link Long#MIN_VALUE} if string could not be parsed to type
     *         long.
     */
    public static Long parseToId(String id) {
        try {
            return Long.parseLong(id);
        } catch (NumberFormatException e) {
            return Long.MIN_VALUE;
        }
    }

}
