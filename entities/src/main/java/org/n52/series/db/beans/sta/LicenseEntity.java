/*
 * Copyright (C) 2018-2020 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.sta;

import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.HibernateRelations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@SequenceGenerator(name = "license_seq", allocationSize = 1)
@Table(name = "license")
public class LicenseEntity implements HibernateRelations.HasId, HibernateRelations.HasName,
        HibernateRelations.HasAbstractDatasets, HibernateRelations.HasStaIdentifier {

    public static final String PROPERTY_DATASETS = "datasets";
    public static final String PROPERTY_DEFINITION = "definition";
    public static final String PROPERTY_LOGO = "logo";

    @Id
    @Column(nullable = false, name = "license_id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "license_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = STA_IDENTIFIER, unique = true)
    private String staIdentifier;

    @Column(name = NAME, nullable = false)
    private String name;

    @Column(name = PROPERTY_DEFINITION, nullable = false)
    private String definition;

    @Column(name = PROPERTY_LOGO)
    private String logo;

    @OneToMany(mappedBy = AbstractDatasetEntity.PROPERTY_LICENSE)
    private Set<AbstractDatasetEntity> datasets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStaIdentifier() {
        return staIdentifier;
    }

    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }
}
