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
package org.n52.series.db.beans.feature.gmd;

import org.n52.series.db.beans.feature.NilReasonEntity;

/**
 * Hibernate entity for role.
 *
 * @author <a href="mailto:c.hollmann@52north.org">Carsten Hollmann</a>
 * @since 1.0.0
 */
public class RoleEntity extends NilReasonEntity {

    private static final long serialVersionUID = -1503660379060188778L;

    private String codeList;
    private String codeListValue;

    /**
     * @return the codeList
     */
    public String getCodeList() {
        return codeList;
    }

    /**
     * @param codeList
     *            the codeList to set
     */
    public void setCodeList(String codeList) {
        this.codeList = codeList;
    }

    /**
     * @return the codeListValue
     */
    public String getCodeListValue() {
        return codeListValue;
    }

    /**
     * @param codeListValue
     *            the codeListValue to set
     */
    public void setCodeListValue(String codeListValue) {
        this.codeListValue = codeListValue;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof RoleEntity)) {
            return false;
        }
        return super.equals(obj);
    }
}
