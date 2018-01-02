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

import org.n52.series.db.beans.feature.FeatureVisitor;
import org.n52.series.db.beans.feature.GeometryVisitor;
import org.n52.shetland.ogc.gml.AbstractFeature;
import org.n52.shetland.ogc.ows.exception.OwsExceptionReport;

import com.vividsolutions.jts.geom.Geometry;

public class FeatureEntity extends AbstractFeatureEntity<FeatureEntity> {

    private static final long serialVersionUID = 3926633318714623558L;

    @Override
    public AbstractFeature accept(FeatureVisitor< ? > visitor) throws OwsExceptionReport {
        return visitor.visit(this);
    }

    @Override
    public Geometry accept(GeometryVisitor visitor) throws OwsExceptionReport {
        return visitor.visit(this);
    }
}
