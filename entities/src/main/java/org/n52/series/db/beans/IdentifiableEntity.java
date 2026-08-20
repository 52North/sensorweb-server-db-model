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
import jakarta.persistence.MappedSuperclass;
import org.n52.series.db.beans.HibernateRelations.HasIdentifier;
import org.n52.series.db.beans.HibernateRelations.HasStaIdentifier;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;

import java.io.Serial;
import java.util.Objects;

/**
 * Layer between {@link IdEntity} and {@link DescribableEntity} for entities that carry an
 * {@code identifier}/{@code sta_identifier} but no {@code name}/{@code description}
 */
@MappedSuperclass
public abstract class IdentifiableEntity extends IdEntity implements HasIdentifier, HasStaIdentifier {

    public static final String PROPERTY_IDENTIFIER = IDENTIFIER;
    public static final String PROPERTY_STA_IDENTIFIER = STA_IDENTIFIER;

    @Serial
    private static final long serialVersionUID = 1394251295016960903L;

    @Column(name = "identifier")
    private String identifier;

    @Column(name = "sta_identifier")
    private String staIdentifier;

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier, boolean staSupportsUrls) {
        this.identifier = identifier;
        if (!isSetStaIdentifier()) {
            setStaIdentifier(staSupportsUrls ? identifier : processIdentifierForSta(identifier));
        }
    }

    @Override
    public String getStaIdentifier() {
        return staIdentifier;
    }

    @Override
    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getIdentifier(), this instanceof IsStaEntity ? getStaIdentifier() : "");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof IdentifiableEntity)) {
            return false;
        }
        IdentifiableEntity other = (IdentifiableEntity) obj;
        return super.equals(other) && Objects.equals(getIdentifier(), other.getIdentifier())
                && (this instanceof IsStaEntity ? Objects.equals(getStaIdentifier(), other.getStaIdentifier()) : true);
    }
}
