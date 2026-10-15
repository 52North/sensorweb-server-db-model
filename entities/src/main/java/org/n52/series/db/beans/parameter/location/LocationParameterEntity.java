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
package org.n52.series.db.beans.parameter.location;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.LocationEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.Serial;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.parameter.location.LocationParameterEntity")
@Table(name = "location_parameter",
        indexes = { @Index(name = "idx_location_param_name", columnList = "name"),
                @Index(name = "idx_location_parameter", columnList = "fk_location_id"),
                @Index(name = "idx_location_parent_parameter", columnList = "fk_parent_parameter_id"),
                @Index(name = "idx_location_parameter_unit", columnList = "fk_unit_id") })
// table comment: Storage for additional information for locations
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class LocationParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_LOCATION = "location";
    public static final String PROP_LOCATION_ID = "locationId";

    @Serial
    private static final long serialVersionUID = 8449960591522592006L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_location_id", nullable = false, insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "fk_param_location_id"))
    private LocationEntity location;

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    @Override
    @Access(AccessType.PROPERTY)
    @ManyToOne(targetEntity = LocationParameterEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_parent_parameter_id", foreignKey = @ForeignKey(name = "fk_param_location_parent_id"))
    public ParameterEntity<?> getParent() {
        return super.getParent();
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setLocation((LocationEntity) entity);
    }
}
