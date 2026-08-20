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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;

import java.io.Serial;

/**
 * Marks entities that have an identifier/name codespace in their schema, as opposed to entities extending
 * {@link DescribableEntity} directly (e.g. CategoryEntity, UnitEntity, TagEntity)
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@MappedSuperclass
public abstract class AbstractCodespaceEntity extends DescribableEntity {

    @Serial
    private static final long serialVersionUID = -3196986792845310821L;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_identifier_codespace_id")
    private CodespaceEntity identifierCodespace;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_name_codespace_id")
    private CodespaceEntity nameCodespace;

    @Override
    public CodespaceEntity getIdentifierCodespace() {
        return identifierCodespace;
    }

    @Override
    public void setIdentifierCodespace(CodespaceEntity identifierCodespace) {
        this.identifierCodespace = identifierCodespace;
    }

    @Override
    public CodespaceEntity getNameCodespace() {
        return nameCodespace;
    }

    @Override
    public void setNameCodespace(CodespaceEntity nameCodespace) {
        this.nameCodespace = nameCodespace;
    }
}
