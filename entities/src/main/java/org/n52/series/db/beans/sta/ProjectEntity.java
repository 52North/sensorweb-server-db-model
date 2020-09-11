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
import java.util.Date;
import java.util.Set;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@SequenceGenerator(name = "project_seq", allocationSize = 1)
@Table(name = "project")
public class ProjectEntity
        implements HibernateRelations.HasId, HibernateRelations.HasName, HibernateRelations.HasDescription,
        HibernateRelations.HasAbstractDatasets, HibernateRelations.HasStaIdentifier {

    public static final String PROPERTY_DATASTREAMS = "datasets";
    public static final String PROPERTY_URL = "url";
    public static final String PROPERTY_RUNTIME_START = "runtimeStart";
    public static final String PROPERTY_RUNTIME_END = "runtimeEnd";

    @Id
    @Column(nullable = false, name = "project_id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = STA_IDENTIFIER, unique = true)
    private String staIdentifier;

    @Column(name = NAME, nullable = false)
    private String name;

    @Column(name = DESCRIPTION, nullable = false)
    private String description;

    @Column(name = PROPERTY_RUNTIME_START, length = 29, nullable = false)
    private Date runtimeStart;

    @Column(name = PROPERTY_RUNTIME_END, length = 29, nullable = false)
    private Date runtimeEnd;

    @Column(name = PROPERTY_URL)
    private String url;

    @OneToMany(mappedBy = AbstractDatasetEntity.PROPERTY_PROJECT)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getRuntimeStart() {
        return runtimeStart;
    }

    public void setRuntimeStart(Date runtimeStart) {
        this.runtimeStart = runtimeStart;
    }

    public Date getRuntimeEnd() {
        return runtimeEnd;
    }

    public void setRuntimeEnd(Date runtimeEnd) {
        this.runtimeEnd = runtimeEnd;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Set<AbstractDatasetEntity> getDatasets() {
        return datasets;
    }

    @Override
    public void setDatasets(Set<AbstractDatasetEntity> datasets) {
        this.datasets = datasets;
    }
}
