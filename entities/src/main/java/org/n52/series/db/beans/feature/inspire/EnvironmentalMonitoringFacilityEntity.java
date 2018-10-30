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

package org.n52.series.db.beans.feature.inspire;

import org.n52.series.db.beans.FeatureEntity;

public class EnvironmentalMonitoringFacilityEntity extends FeatureEntity {

    private static final long serialVersionUID = -6086090544397897675L;

    private MediaMonitored mediaMonitored;

    private String measurementRegime;

    private boolean mobile;

    /**
     * @return the mediaMonitored
     */
    public MediaMonitored getMediaMonitored() {
        return mediaMonitored;
    }

    /**
     * @param mediaMonitored the mediaMonitored to set
     */
    public void setMediaMonitored(MediaMonitored mediaMonitored) {
        this.mediaMonitored = mediaMonitored;
    }

    /**
     * @return the measurementRegime
     */
    public String getMeasurementRegime() {
        return measurementRegime;
    }

    /**
     * @param measurementRegime the measurementRegime to set
     */
    public void setMeasurementRegime(String measurementRegime) {
        this.measurementRegime = measurementRegime;
    }

    /**
     * @return the mobile
     */
    public boolean isMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(boolean mobile) {
        this.mobile = mobile;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof EnvironmentalMonitoringFacilityEntity)) {
            return false;
        }
        return super.equals(obj);
    }

}
