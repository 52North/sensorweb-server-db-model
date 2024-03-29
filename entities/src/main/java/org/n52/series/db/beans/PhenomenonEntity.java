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

import org.n52.series.db.beans.HibernateRelations.IsStaEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Objects;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public class PhenomenonEntity extends HierarchicalEntity<PhenomenonEntity>
        implements HibernateRelations.HasAbstractDatasets, IsStaEntity {

    private static final long serialVersionUID = 2302654989683191424L;

    private Set<AbstractDatasetEntity> datasets;

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datastreams) {
        this.datasets = datastreams;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStaIdentifier());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PhenomenonEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
