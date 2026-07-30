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

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.n52.series.db.beans.HibernateRelations.HasIdentifierCodespace;

import java.io.Serial;
import java.io.Serializable;

/**
 * @since 1.0.0
 */
@Entity(name = "org.n52.series.db.beans.CodespaceEntity")
@Table(name = "codespace",
        uniqueConstraints = @UniqueConstraint(name = "un_codespace_codespace", columnNames = { "name" }))
public class CodespaceEntity extends IdEntity implements Serializable {

    public static final String PROPERTY_CODESPACE = HasIdentifierCodespace.IDENTIFIER_CODESPACE;

    public static final String PROPERTY_NAME = "name";

    @Serial
    private static final long serialVersionUID = 8795086004488469603L;

    @Column(name = PROPERTY_NAME, nullable = false)
    // @Comment("Name/definition of the codespace, e.g. of a domain")
    private String name;

    public String getName() {
        return this.name;
    }

    public CodespaceEntity setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isSetName() {
        return getName() != null && !getName().isEmpty();
    }
}
