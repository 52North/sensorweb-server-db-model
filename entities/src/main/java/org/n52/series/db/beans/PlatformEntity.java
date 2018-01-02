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

import java.util.Set;

import org.n52.series.db.beans.parameter.Parameter;

import com.vividsolutions.jts.geom.Geometry;

public class PlatformEntity extends DescribableEntity {

    public static final String PROPERTY_INSITU = "insitu";

    public static final String PROPERTY_MOBILE = "mobile";

    private static final long serialVersionUID = 3615089936334873353L;

    private boolean insitu = true;

    private boolean mobile;

    private Geometry geometry;

    private Set<Parameter< ? >> parameters;

    public boolean isMobile() {
        return mobile;
    }

    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    public boolean isInsitu() {
        return insitu;
    }

    public void setInsitu(boolean insitu) {
        this.insitu = insitu;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    @Override
    public Set<Parameter< ? >> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Set<Parameter< ? >> parameters) {
        this.parameters = parameters;
    }

    @Override
    public boolean hasParameters() {
        return getParameters() != null && !getParameters().isEmpty();
    }

}
