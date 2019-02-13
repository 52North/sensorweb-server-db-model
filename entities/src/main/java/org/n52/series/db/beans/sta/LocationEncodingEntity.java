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
package org.n52.series.db.beans.sta;

import java.io.Serializable;
import java.util.Objects;

import org.n52.series.db.beans.IdEntity;

/**
 *
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */
public class LocationEncodingEntity extends IdEntity implements AbstractStaEntity, Serializable {

    public static final String PROPERTY_ENCODING_TYPE = "encodingType";
    public static final String PROPERTY_LOCATION = "location";

    private static final long serialVersionUID = 656748116995263897L;

    private String encodingType;

    public String getEncodingType() {
        return encodingType;
    }

    public void setEncodingType(String encodingType) {
        this.encodingType = encodingType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getEncodingType());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IdEntity)) {
            return false;
        }
        LocationEncodingEntity other = (LocationEncodingEntity) obj;
        return super.equals(other) && Objects.equals(getEncodingType(), other.getEncodingType());
    }

}
