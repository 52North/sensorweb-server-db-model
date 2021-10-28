/*
 * Copyright 2015-2021 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans;

import java.io.Serializable;

public class ServiceMetadataEntity implements Serializable {

    private static final long serialVersionUID = -7921433199814370067L;
    private String metadata;
    private String format;

    public String getMetadata() {
        return metadata;
    }

    public ServiceMetadataEntity setMetadata(String metadata) {
        this.metadata = metadata;
        return this;
    }

    public boolean isSetMetadata() {
        return getMetadata() != null && !getMetadata().isEmpty();
    }

    public String getFormat() {
        return format;
    }

    public ServiceMetadataEntity setFormat(String format) {
        this.format = format;
        return this;
    }

    public boolean isSetFormat() {
        return getFormat() != null && !getFormat().isEmpty();
    }

}