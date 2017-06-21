/**
 * Copyright (C) 2012-2017 52°North Initiative for Geospatial Open Source
 * Software GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.series.db.beans;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import org.n52.series.db.beans.HibernateRelations.HasFeature;
import org.n52.series.db.beans.HibernateRelations.HasOfferings;
import org.n52.series.db.beans.HibernateRelations.HasRelatedFeatureRoles;
import org.n52.series.db.beans.AbstractFeatureEntity;

/**
 * @since 4.0.0
 * 
 */
public class RelatedFeatureEntity extends PkidEntity implements Serializable, 
HasFeature<RelatedFeatureEntity>, 
HasRelatedFeatureRoles<RelatedFeatureEntity>, 
HasOfferings<RelatedFeatureEntity> {

    private static final long serialVersionUID = -8143897383050691280L;

    private AbstractFeatureEntity featureOfInterest;

    private Set<RelatedFeatureRoleEntity> relatedFeatureRoles = new HashSet<RelatedFeatureRoleEntity>(0);

    private Set<OfferingEntity> offerings = new HashSet<OfferingEntity>(0);
    
    public RelatedFeatureEntity() {
    }

    @Override
    public AbstractFeatureEntity getFeature() {
        return this.featureOfInterest;
    }

    @Override
    public RelatedFeatureEntity setFeature(AbstractFeatureEntity featureOfInterest) {
        this.featureOfInterest = featureOfInterest;
        return this;
    }

    @Override
    public Set<RelatedFeatureRoleEntity> getRelatedFeatureRoles() {
        return this.relatedFeatureRoles;
    }

    @Override
    public RelatedFeatureEntity setRelatedFeatureRoles(Set<RelatedFeatureRoleEntity> relatedFeatureRoles) {
        this.relatedFeatureRoles = relatedFeatureRoles;
        return this;
    }

    @Override
    public Set<OfferingEntity> getOfferings() {
        return this.offerings;
    }

    @SuppressWarnings("unchecked")
    @Override
    public RelatedFeatureEntity setOfferings(final Object offerings) {
        if (offerings instanceof Set<?>) {
            this.offerings = (Set<OfferingEntity>) offerings; 
        } else {
            getOfferings().add((OfferingEntity)offerings);
        }
        return this;
    }
    
    @Override
    public boolean isSetOfferings() {
        return getOfferings() != null && !getOfferings().isEmpty();
    }
    
}
