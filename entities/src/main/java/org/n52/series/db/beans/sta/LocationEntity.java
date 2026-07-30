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
package org.n52.series.db.beans.sta;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.SQLRestriction;
import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.Describable;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.FormatEntity;
import org.n52.series.db.beans.GeometryEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.HibernateRelations.HasGeometry;
import org.n52.series.db.beans.PlatformEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.i18n.I18nLocationEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationParameterEntity;

import java.io.Serial;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author <a href="mailto:s.drost@52north.org">Sebastian Drost</a>
 */

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.sta.LocationEntity")
@Table(name = "location",
        indexes = { @Index(name = "idx_location_identifier", columnList = "identifier"),
                @Index(name = "idx_location_staIdentifier", columnList = "sta_identifier"),
                @Index(name = "idx_location_format", columnList = "fk_format_id") },
        uniqueConstraints = { @UniqueConstraint(name = "un_location_identifier", columnNames = { "identifier" }),
                @UniqueConstraint(name = "un_location_staIdentifier", columnNames = { "sta_identifier" }) })
@AttributeOverride(name = "id", column = @Column(name = "location_id"))
public class LocationEntity extends DescribableEntity implements Serializable, HasGeometry, HibernateRelations.HasName,
        HibernateRelations.HasDescription, HibernateRelations.IsProcessed, StaRelations.HasPlatforms<LocationEntity>,
        StaRelations.HasHistoricalLocations<LocationEntity> {

    public static final String PROPERTY_NAME = NAME;
    public static final String PROPERTY_DESCRIPTION = DESCRIPTION;
    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";
    public static final String PROPERTY_LOCATION_ENCODING = "locationEncoding";

    @Serial
    private static final long serialVersionUID = -8201429072560300649L;

    @Column(name = "location", columnDefinition = "text")
    private String location;

    @Embedded
    private GeometryEntity geometryEntity;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_format_id", nullable = false, foreignKey = @ForeignKey(name = "fk_location_format"))
    private FormatEntity locationEncoding;

    @ManyToMany(fetch = FetchType.LAZY)
    // TODO mappedBy = "<owning field on the other entity>"
    private Set<PlatformEntity> platforms;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "location_historical_location",
            joinColumns = @JoinColumn(name = "fk_location_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_location_historical_loc")),
            inverseJoinColumns = @JoinColumn(name = "fk_historical_location_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_historical_loc_location")))
    private Set<HistoricalLocationEntity> historicalLocations;

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = LocationParameterEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_location_id", nullable = false, foreignKey = @ForeignKey(name = "fk_param_location_id"))
    @SQLRestriction("fk_parent_parameter_id is null")
    public Set<ParameterEntity<?>> getParameters() {
        return super.getParameters();
    }

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = I18nLocationEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_location_id", nullable = false, foreignKey = @ForeignKey(name = "fk_location"))
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return super.getTranslations();
    }

    private boolean processed;

    public FormatEntity getLocationEncoding() {
        return locationEncoding;
    }

    public LocationEntity setLocationEncoding(FormatEntity locationEncoding) {
        this.locationEncoding = locationEncoding;
        return this;
    }

    public String getLocation() {
        return location;
    }

    public LocationEntity setLocation(String location) {
        this.location = location;
        return this;
    }

    public boolean hasLocation() {
        return getLocation() != null && !getLocation().isEmpty();
    }

    @Override
    public GeometryEntity getGeometryEntity() {
        return geometryEntity;
    }

    @Override
    public void setGeometry(Geometry geometry) {
        this.geometryEntity = new GeometryEntity();
        this.geometryEntity.setGeometry(geometry);
        this.geometryEntity.setSrid(geometry.getSRID());
    }

    @Override
    public void setGeometryEntity(GeometryEntity geometryEntity) {
        this.geometryEntity = geometryEntity;
    }

    public Set<PlatformEntity> getPlatforms() {
        return platforms;
    }

    public LocationEntity setPlatforms(Set<PlatformEntity> platformEntities) {
        this.platforms = platformEntities;
        return this;
    }

    public boolean hasPlatforms() {
        return getPlatforms() != null && !getPlatforms().isEmpty();
    }

    @Deprecated
    public Set<PlatformEntity> getThings() {
        return getPlatforms();
    }

    @Deprecated
    public LocationEntity setThings(Set<PlatformEntity> platformEntities) {
        return setPlatforms(platformEntities);
    }

    @Deprecated
    public boolean hasThings() {
        return hasPlatforms();
    }

    public Set<HistoricalLocationEntity> getHistoricalLocations() {
        return historicalLocations;
    }

    public LocationEntity setHistoricalLocations(Set<HistoricalLocationEntity> historicalLocationEntities) {
        this.historicalLocations = historicalLocationEntities;
        return this;
    }

    public LocationEntity addHistoricalLocation(HistoricalLocationEntity historicalLocationEntity) {
        if (historicalLocations == null) {
            historicalLocations = new LinkedHashSet<>();
        }
        historicalLocations.add(historicalLocationEntity);
        return this;
    }

    public boolean hasHistoricalLocations() {
        return getHistoricalLocations() != null && !getHistoricalLocations().isEmpty();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof LocationEntity)) {
            return false;
        }
        return super.equals(obj);
    }

    @Override
    public boolean isProcessed() {
        return this.processed;
    }

    @Override
    public void setProcessed(boolean processsed) {
        this.processed = processsed;
    }
}
