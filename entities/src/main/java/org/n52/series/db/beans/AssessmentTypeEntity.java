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

import java.io.Serializable;

public class AssessmentTypeEntity implements Serializable {

    public static final String PROPERTY_ID = "assessmentType";

    public static final String PROPERTY_ASSESSMENT_TYPE = PROPERTY_ID;

    private static final long serialVersionUID = 1721670905098408954L;

    private String assessmentType;

    private String uri;

    /**
     * @return the assessmentType
     */
    public String getAssessmentType() {
        return assessmentType;
    }

    /**
     * @param assessmentType
     *            the assessmentType to set
     * @return this
     */
    public AssessmentTypeEntity setAssessmentType(String assessmentType) {
        this.assessmentType = assessmentType;
        return this;
    }

    /**
     * @return the uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * @param uri
     *            the uri to set
     * @return this
     */
    public AssessmentTypeEntity setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public boolean isSetAssessmentType() {
        return getAssessmentType() != null && !getAssessmentType().isEmpty();
    }

    public boolean isSetUri() {
        return getUri() != null && !getUri().isEmpty();
    }
}
