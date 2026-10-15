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
package org.n52.series.db.beans.parameter.platform;

import java.io.Serial;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import org.n52.series.db.beans.parameter.TemporalParameterEntity;
import org.n52.series.db.beans.parameter.TimeRange;

@Entity(name = "org.n52.series.db.beans.parameter.platform.PlatformTemporalParameterEntity")
@DiscriminatorValue("temporal")
public class PlatformTemporalParameterEntity extends PlatformParameterEntity<TimeRange>
        implements TemporalParameterEntity {

    @Serial
    private static final long serialVersionUID = 668796579118721620L;

    @Embedded
    @AttributeOverride(name = "from", column = @Column(name = "value_temporal_from"))
    @AttributeOverride(name = "to", column = @Column(name = "value_temporal_to"))
    private TimeRange value;

    @Override
    public TimeRange getValue() {
        return value;
    }

    @Override
    public void setValue(TimeRange value) {
        this.value = value;
    }

}
