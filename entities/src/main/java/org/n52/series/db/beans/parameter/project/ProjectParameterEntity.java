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
package org.n52.series.db.beans.parameter.project;

import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.plus.PartyEntity;
import org.n52.series.db.beans.sta.plus.ProjectEntity;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public abstract class ProjectParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_PROJECT = "project";
    public static final String PROP_PROJECT_ID = "projectId";

    private ProjectEntity project;
    private long projectId;

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        throw new RuntimeException("not implemented yet!");
    }
}
