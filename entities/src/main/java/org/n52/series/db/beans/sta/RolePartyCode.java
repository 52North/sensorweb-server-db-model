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
package org.n52.series.db.beans.sta;

import java.util.Collection;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public enum RolePartyCode {
    individual, institution;

    public static Set<RolePartyCode> convert(Collection<String> values) {
        if (values != null) {
            return values.stream().map(at -> RolePartyCode.getIgnoreCase(at)).filter(Objects::nonNull)
                    .collect(Collectors.toSet());
        }
        return null;
    }

    private static RolePartyCode getIgnoreCase(String value) {
        for (RolePartyCode rpc : values()) {
            if (rpc.name().equalsIgnoreCase(value)) {
                return rpc;
            }
        }
        return null;
    }
}
