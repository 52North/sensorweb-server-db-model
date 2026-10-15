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
package org.n52.series.db.beans.parameter.location;

import java.io.Serial;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import org.n52.series.db.beans.parameter.XmlParameterEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity(name = "org.n52.series.db.beans.parameter.location.LocationXmlParameterEntity")
@DiscriminatorValue("xml")
public class LocationXmlParameterEntity extends LocationParameterEntity<String> implements XmlParameterEntity {

    @Serial
    private static final long serialVersionUID = 1209102870245642049L;

    @Column(name = "value_xml")
    private String value;

    @Override
    public String getValueAsString() {
        return getValue();
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

}
