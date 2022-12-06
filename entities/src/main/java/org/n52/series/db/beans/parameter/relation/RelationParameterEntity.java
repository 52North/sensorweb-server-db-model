/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.parameter.relation;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.RelationEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
public abstract class RelationParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_GROUP = "group";
    public static final String PROP_GROUP_ID = "groupId";
    public static final String PROPERTY_RELATION_ID = "relationId";
    private static final long serialVersionUID = 1123453212836718013L;

    private RelationEntity relation;
    private Long relationId;

    public RelationEntity getRelation() {
        return relation;
    }

    public void setRelation(RelationEntity relation) {
        this.relation = relation;
    }

    public Long getRelationId() {
        return relationId;
    }

    public void setRelationId(Long relationId) {
        this.relationId = relationId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setRelation((RelationEntity) entity);
    }
}
