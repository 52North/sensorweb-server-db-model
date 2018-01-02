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
package org.n52.series.db.beans.feature;

import java.util.Date;

import org.n52.series.db.beans.FeatureEntity;
import org.n52.series.db.beans.UnitEntity;
import org.n52.series.db.common.Utils;
import org.n52.shetland.ogc.gml.AbstractFeature;
import org.n52.shetland.ogc.ows.exception.OwsExceptionReport;

import com.vividsolutions.jts.geom.Geometry;

public class SpecimenEntity extends FeatureEntity {

    private static final long serialVersionUID = -1128862083434595324L;

    private String materialClass;
    private Date samplingTimeStart;
    private Date samplingTimeEnd;
    private String samplingMethod;
    private Double size;
    private UnitEntity sizeUnit;
    private String currentLocation;
    private String specimenType;

    /**
     * @return the materialClass
     */
    public String getMaterialClass() {
        return materialClass;
    }

    /**
     * @param materialClass the materialClass to set
     */
    public void setMaterialClass(String materialClass) {
        this.materialClass = materialClass;
    }

    /**
     * @return the samplingTimeStart
     */
    public Date getSamplingTimeStart() {
        return Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @param samplingTimeStart the samplingTimeStart to set
     */
    public void setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    /**
     * @return the samplingTimeEnd
     */
    public Date getSamplingTimeEnd() {
        return Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    /**
     * @param samplingTimeEnd the samplingTimeEnd to set
     */
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    /**
     * @return the samplingMethod
     */
    public String getSamplingMethod() {
        return samplingMethod;
    }

    /**
     * @param samplingMethod the samplingMethod to set
     */
    public void setSamplingMethod(String samplingMethod) {
        this.samplingMethod = samplingMethod;
    }

    public boolean isSetSamplingMethod() {
        return getSamplingMethod() != null && !getSamplingMethod().isEmpty();
    }

    /**
     * @return the size
     */
    public Double getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(Double size) {
        this.size = size;
    }

    public boolean isSetSize() {
        return getSize() != null;
    }

    public UnitEntity getSizeUnit() {
        return sizeUnit;
    }

    public void setSizeUnit(final UnitEntity sizeUnit) {
        this.sizeUnit = sizeUnit;
    }

    public boolean isSetSizeUnit() {
        return getSizeUnit() != null && getSizeUnit().isSetDomain();
    }

    /**
     * @return the currentLocation
     */
    public String getCurrentLocation() {
        return currentLocation;
    }

    /**
     * @param currentLocation the currentLocation to set
     */
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public boolean isSetCurrentLocation() {
        return getCurrentLocation() != null && !getCurrentLocation().isEmpty();
    }

    /**
     * @return the specimenType
     */
    public String getSpecimenType() {
        return specimenType;
    }

    /**
     * @param specimenType the specimenType to set
     */
    public void setSpecimenType(String specimenType) {
        this.specimenType = specimenType;
    }

    public boolean isSetSpecimenType() {
        return getSpecimenType() != null && !getSpecimenType().isEmpty();
    }

    @Override
    public AbstractFeature accept(FeatureVisitor< ? > visitor) throws OwsExceptionReport {
        return visitor.visit(this);
    }

    @Override
    public Geometry accept(GeometryVisitor visitor) throws OwsExceptionReport {
        return visitor.visit(this);
    }

}
