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

import org.n52.series.db.beans.HibernateRelations.HasDescription;
import org.n52.series.db.beans.HibernateRelations.HasIdentifier;
import org.n52.series.db.beans.HibernateRelations.HasIdentifierCodespace;
import org.n52.series.db.beans.HibernateRelations.HasName;
import org.n52.series.db.beans.HibernateRelations.HasNameCodespace;
import org.n52.series.db.beans.HibernateRelations.HasStaIdentifier;

/**
 * @author Christian Autermann
 */
public interface IdentifierNameDescriptionEntity
        extends HasIdentifier, HasStaIdentifier, HasIdentifierCodespace, HasName, HasNameCodespace, HasDescription {

}
