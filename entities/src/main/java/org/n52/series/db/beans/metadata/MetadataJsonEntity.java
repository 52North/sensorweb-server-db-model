/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans.metadata;

//import com.fasterxml.jackson.annotation.JsonGetter;
//import com.fasterxml.jackson.databind.JsonNode;
//import com.fasterxml.jackson.databind.ObjectMapper;

public class MetadataJsonEntity extends MetadataEntity<String> {

    private static final long serialVersionUID = 3211811882145169931L;

    //    private static final Logger LOGGER = LoggerFactory.getLogger(MetadataJsonEntity.class);
    //
    //    @JsonGetter(value = "value")
    //    public JsonNode getJsonValue() {
    //        ObjectMapper om = new ObjectMapper();
    //        try {
    //            return om.readTree(getValue());
    //        } catch (IOException e) {
    //            LOGGER.error("Could not parse to json ({}): {}", getName(), getValue(), e);
    //            return null;
    //        }
    //    }

}
