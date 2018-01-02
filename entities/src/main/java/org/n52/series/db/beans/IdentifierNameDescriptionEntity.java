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
package org.n52.series.db.beans;

import org.n52.series.db.beans.HibernateRelations.HasCodespace;
import org.n52.series.db.beans.HibernateRelations.HasCodespaceName;
import org.n52.series.db.beans.HibernateRelations.HasDescription;
import org.n52.series.db.beans.HibernateRelations.HasIdentifier;
import org.n52.series.db.beans.HibernateRelations.HasName;

/**
 * @author Christian Autermann
 */
public interface IdentifierNameDescriptionEntity<T>
        extends HasIdentifier<T>,
        HasCodespace<T>,
        HasName<T>,
        HasCodespaceName<T>,
        HasDescription<T> {

}
