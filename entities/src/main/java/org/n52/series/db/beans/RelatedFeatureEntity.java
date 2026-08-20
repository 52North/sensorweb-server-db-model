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

import java.io.Serial;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import org.n52.series.db.beans.HibernateRelations.HasFeature;
import org.n52.series.db.beans.HibernateRelations.HasOfferings;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * @since 1.0.0
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.RelatedFeatureEntity")
@Table(name = "related_feature", indexes = @Index(name = "idx_related_feature_feature", columnList = "fk_feature_id"))
// table comment: Storage of relations between offerings and features. This table is used by the SOS to
// fulfill the standard.
@AttributeOverride(name = "id", column = @Column(name = "related_feature_id"))
public class RelatedFeatureEntity extends IdEntity implements Serializable, HasFeature, HasOfferings {
    public static final String PROPERTY_SERVICE = "service";
    @Serial
    private static final long serialVersionUID = -8143897383050691280L;

    @Transient
    private ServiceEntity service;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_feature_id", nullable = false, foreignKey = @ForeignKey(name = "fk_related_feature"))
    private AbstractFeatureEntity<?> feature;

    @Column(name = "role", nullable = false)
    // @Comment("The role of the related feature.")
    private String role;

    @ManyToMany(mappedBy = OfferingEntity.RELATED_FEATURES, fetch = FetchType.LAZY)
    private Set<OfferingEntity> offerings;

    public RelatedFeatureEntity() {
    }

    @Override
    public AbstractFeatureEntity<?> getFeature() {
        return this.feature;
    }

    @Override
    public void setFeature(AbstractFeatureEntity<?> feature) {
        this.feature = feature;
    }

    public String getRole() {
        return this.role;
    }

    public RelatedFeatureEntity setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public Set<OfferingEntity> getOfferings() {
        return this.offerings;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void setOfferings(final Object offerings) {
        if (offerings instanceof Set<?>) {
            this.offerings = (Set<OfferingEntity>) offerings;
        } else {
            getOfferings().add((OfferingEntity) offerings);
        }
    }

    @Override
    public boolean isSetOfferings() {
        return getOfferings() != null && !getOfferings().isEmpty();
    }

    public ServiceEntity getService() {
        return service;
    }

    public RelatedFeatureEntity setService(ServiceEntity service) {
        this.service = service;
        return this;
    }

}
