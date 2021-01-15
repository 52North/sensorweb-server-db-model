/*
 * Copyright 2015-2021 52°North Initiative for Geospatial Open Source
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
package org.n52.series.db.beans.sampling;

import java.io.Serializable;
import java.util.Set;
import java.util.stream.Collectors;

public class SamplingProfileDatasetEntity implements Serializable {

    public static final String PROPERTY_SAMPLINGS = "samplings";
    public static final String PROPERTY_MEASURING_PROGRAMS = "measuringPrograms";

    private static final long serialVersionUID = -6526107787041904177L;

    private Set<SamplingEntity> samplings;

    private Set<MeasuringProgramEntity> measuringPrograms;

    public Set<SamplingEntity> getSamplings() {
        return samplings;
    }

    public SamplingProfileDatasetEntity setSamplings(Set<SamplingEntity> samplings) {
        this.samplings = samplings;
        return this;
    }

    public boolean hasSamplings() {
        return getSamplings() != null && !getSamplings().isEmpty();
    }

    public Set<MeasuringProgramEntity> getMeasuringPrograms() {
        return measuringPrograms;
    }

    public SamplingProfileDatasetEntity setMeasuringPrograms(Set<MeasuringProgramEntity> measuringPrograms) {
        this.measuringPrograms = measuringPrograms;
        return this;
    }

    public boolean hasMeasuringPrograms() {
        return getMeasuringPrograms() != null && !getMeasuringPrograms().isEmpty();
    }

    public SamplingProfileDatasetEntity copy(SamplingProfileDatasetEntity samplingDataset) {
        if (samplingDataset.hasSamplings()) {
            setSamplings(samplingDataset.getSamplings().stream().collect(Collectors.toSet()));
        }
        if (samplingDataset.hasMeasuringPrograms()) {
            setMeasuringPrograms(samplingDataset.getMeasuringPrograms().stream().collect(Collectors.toSet()));
        }
        return this;
    }
}
