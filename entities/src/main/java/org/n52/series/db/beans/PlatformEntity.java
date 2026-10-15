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

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.persistence.UniqueConstraint;
import org.hibernate.annotations.SQLRestriction;
import org.n52.series.db.beans.HibernateRelations.IsStaEntity;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.i18n.I18nPlatformEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformParameterEntity;
import org.n52.series.db.beans.sta.HistoricalLocationEntity;
import org.n52.series.db.beans.sta.LocationEntity;
import org.n52.series.db.beans.sta.PartyEntity;
import org.n52.series.db.beans.sta.StaRelations;
import org.n52.series.db.beans.sta.StaRelations.HasLocations;

import java.io.Serial;
import java.util.LinkedHashSet;
import java.util.Set;

@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.PlatformEntity")
@Table(name = "platform",
        indexes = { @Index(name = "idx_platform_identifier", columnList = "identifier"),
                @Index(name = "idx_platform_staIdentifier", columnList = "sta_identifier"),
                @Index(name = "idx_platform_identifier_codespace", columnList = "fk_identifier_codespace_id"),
                @Index(name = "idx_platform_name_codespace", columnList = "fk_name_codespace_id") },
        uniqueConstraints = { @UniqueConstraint(name = "un_platform_identifier", columnNames = { "identifier" }),
                @UniqueConstraint(name = "un_platform_staIdentifier", columnNames = { "sta_identifier" }) })
@AttributeOverride(name = "id", column = @Column(name = "platform_id"))
public class PlatformEntity extends AbstractCodespaceEntity implements HasLocations<PlatformEntity>, IsStaEntity,
        HibernateRelations.HasAbstractDatasets, HibernateRelations.IsProcessed, HibernateRelations.HasParameters,
        HibernateRelations.HasNetwork, HibernateRelations.HasAssessmentType, StaRelations.HasParty<PlatformEntity> {

    public static final String PROPERTY_LOCATIONS = "locations";
    public static final String PROPERTY_PROPERTIES = "properties";
    public static final String PROPERTY_HISTORICAL_LOCATIONS = "historicalLocations";
    public static final String PROPERTY_DATASETS = "datasets";

    @Serial
    private static final long serialVersionUID = 3615089936334873353L;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "platform_location",
            joinColumns = @JoinColumn(name = "fk_platform_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_platform_location")),
            inverseJoinColumns = @JoinColumn(name = "fk_location_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_location_platform")))
    private Set<LocationEntity> locations;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "historical_location",
            joinColumns = @JoinColumn(name = "fk_platform_id", nullable = false,
                    foreignKey = @ForeignKey(name = "fk_platform_historical_location")),
            inverseJoinColumns = @JoinColumn(name = "historical_location_id", nullable = false))
    private Set<HistoricalLocationEntity> historicalLocations;

    @OneToMany(mappedBy = DatasetEntity.PROPERTY_PLATFORM, fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = true)
    private Set<AbstractDatasetEntity> datasets;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "fk_assessment_type_id", foreignKey = @ForeignKey(name = "fk_sp_assessment_type"))
    @Transient
    // not supported yet
    private AssessmentTypeEntity assessmentType;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "fk_network_id", foreignKey = @ForeignKey(name = "fk_sp_network"))
    @Transient
    // not supported yet
    private NetworkEntity network;

    @Transient
    // not supported yet
    private PartyEntity party;

    @Transient
    // not supported yet
    private boolean processed;

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = PlatformParameterEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_platform_id", nullable = false, foreignKey = @ForeignKey(name = "fk_param_platform_id"))
    @SQLRestriction("fk_parent_parameter_id is null")
    public Set<ParameterEntity<?>> getParameters() {
        return super.getParameters();
    }

    @Override
    @Access(AccessType.PROPERTY)
    @OneToMany(targetEntity = I18nPlatformEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_platform_id", nullable = false, foreignKey = @ForeignKey(name = "fk_platform"))
    public Set<I18nEntity<? extends Describable>> getTranslations() {
        return super.getTranslations();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof PlatformEntity)) {
            return false;
        }
        return super.equals(obj);
    }

    public Set<HistoricalLocationEntity> getHistoricalLocations() {
        return historicalLocations;
    }

    public PlatformEntity setHistoricalLocations(Set<HistoricalLocationEntity> historicalLocations) {
        this.historicalLocations = historicalLocations;
        return this;
    }

    public PlatformEntity addHistoricalLocation(HistoricalLocationEntity historicalLocation) {
        if (historicalLocations == null) {
            historicalLocations = new LinkedHashSet<>();
        }
        historicalLocations.add(historicalLocation);
        return this;
    }

    public boolean hasHistoricalLocations() {
        return getHistoricalLocations() != null && !getHistoricalLocations().isEmpty();
    }

    @Override
    public boolean isProcessed() {
        return processed;
    }

    @Override
    public void setProcessed(boolean processsed) {
        this.processed = processsed;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public Set<LocationEntity> getLocations() {
        return locations;
    }

    @Override
    public PlatformEntity setLocations(Set<LocationEntity> locations) {
        this.locations = locations;
        return this;
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }

    @Override
    public AssessmentTypeEntity getAssessmentType() {
        return assessmentType;
    }

    @Override
    public PlatformEntity setAssessmentType(AssessmentTypeEntity type) {
        this.assessmentType = type;
        return this;
    }

    @Override
    public boolean isSetAssessmentType() {
        return getAssessmentType() != null && getAssessmentType().isSetAssessmentType();
    }

    @Override
    public NetworkEntity getNetwork() {
        return network;
    }

    @Override
    public PlatformEntity setNetwork(NetworkEntity network) {
        this.network = network;
        return this;
    }

    @Override
    public boolean isSetNetwork() {
        return getNetwork() != null;
    }

    @Override
    public PartyEntity getParty() {
        return party;
    }

    @Override
    public PlatformEntity setParty(PartyEntity party) {
        this.party = party;
        return this;
    }
}
