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
package org.n52.series.db.beans;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

import java.io.Serial;

@Entity(name = "org.n52.series.db.beans.FormatEntity")
@Table(name = "format",
        uniqueConstraints = @UniqueConstraint(name = "un_format_definition", columnNames = { "definition" }))
@AttributeOverride(name = "id", column = @Column(name = "format_id"))
public class FormatEntity extends IdEntity {

    public static final String FORMAT = "format";
    public static final String PROPERTY_DEFINITION = "definition";

    @Serial
    private static final long serialVersionUID = -8428858401445365107L;

    @Column(name = PROPERTY_DEFINITION, nullable = false)
    // @Comment("The definition of the format.")
    private String format;

    public String getFormat() {
        return this.format;
    }

    public FormatEntity setFormat(String format) {
        this.format = format;
        return this;
    }

    public boolean isSetFormat() {
        return getFormat() != null && !getFormat().isEmpty();
    }
}
