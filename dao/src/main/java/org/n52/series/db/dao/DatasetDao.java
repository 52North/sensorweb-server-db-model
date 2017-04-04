/*
 * Copyright (C) 2015-2017 52°North Initiative for Geospatial Open Source
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
 * if the distribution is compliant with both the GNU General Public License
 * version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 */

package org.n52.series.db.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.n52.series.db.DataAccessException;
import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.FeatureEntity;
import org.n52.series.db.beans.I18nFeatureEntity;
import org.n52.series.db.beans.I18nOfferingEntity;
import org.n52.series.db.beans.I18nPhenomenonEntity;
import org.n52.series.db.beans.I18nProcedureEntity;
import org.n52.series.db.beans.OfferingEntity;
import org.n52.series.db.beans.PhenomenonEntity;
import org.n52.series.db.beans.PlatformEntity;
import org.n52.series.db.beans.ProcedureEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@SuppressWarnings("rawtypes")
public class DatasetDao<T extends DatasetEntity> extends AbstractDao<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DatasetDao.class);

    private static final String COLUMN_PKID = "pkid";

    private final Class<T> entityType;

    public DatasetDao(Session session, Class<T> clazz) {
        super(session);
        this.entityType = clazz;
    }

    @SuppressWarnings("unchecked")
    public DatasetDao(Session session) {
        super(session);
        this.entityType = (Class<T>) DatasetEntity.class;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> find(DbQuery query) {
        LOGGER.debug("find entities: {}", query);

        List<T> series = new ArrayList<>();
        String searchTerm = "%" + query.getSearchTerm() + "%";

        /*
         * Timeseries labels are constructed from labels of related feature and phenomenon. Therefore we have
         * to join both tables and search for given pattern on any of the stored labels.
         */
        Criteria criteria = addIgnoreUnpublishedSeriesTo(getDefaultCriteria("s"), "s");

        Criteria featureCriteria = criteria.createCriteria(DatasetEntity.PROPERTY_FEATURE,
                                                           JoinType.LEFT_OUTER_JOIN);
        featureCriteria = i18n(I18nFeatureEntity.class, featureCriteria, query);
        featureCriteria.add(Restrictions.ilike(FeatureEntity.PROPERTY_NAME, searchTerm));
        series.addAll(featureCriteria.list());

        Criteria procedureCriteria = criteria.createCriteria(DatasetEntity.PROPERTY_PROCEDURE,
                                                             JoinType.LEFT_OUTER_JOIN);
        procedureCriteria = i18n(I18nProcedureEntity.class, procedureCriteria, query);
        procedureCriteria.add(Restrictions.ilike(ProcedureEntity.PROPERTY_NAME, searchTerm));
        series.addAll(procedureCriteria.list());

        Criteria offeringCriteria = criteria.createCriteria(DatasetEntity.PROPERTY_OFFERING,
                                                            JoinType.LEFT_OUTER_JOIN);
        offeringCriteria = i18n(I18nOfferingEntity.class, offeringCriteria, query);
        offeringCriteria.add(Restrictions.ilike(OfferingEntity.PROPERTY_NAME, searchTerm));
        series.addAll(offeringCriteria.list());

        Criteria phenomenonCriteria = criteria.createCriteria(DatasetEntity.PROPERTY_PHENOMENON,
                                                              JoinType.LEFT_OUTER_JOIN);
        phenomenonCriteria = i18n(I18nPhenomenonEntity.class, phenomenonCriteria, query);
        phenomenonCriteria.add(Restrictions.ilike(PhenomenonEntity.PROPERTY_NAME, searchTerm));
        series.addAll(phenomenonCriteria.list());

        return series;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAllInstances(DbQuery parameters) throws DataAccessException {
        LOGGER.debug("get all instances: {}", parameters);
        Criteria criteria = getDefaultCriteria();
        Criteria procedureCreateria = criteria.createCriteria(DatasetEntity.PROPERTY_PROCEDURE);
        procedureCreateria.add(Restrictions.eq("reference", false));
        return (List<T>) parameters.addFilters(criteria, getDatasetProperty())
                                   .list();
    }

    @SuppressWarnings("unchecked")
    public List<T> getInstancesWith(FeatureEntity feature) {
        LOGGER.debug("get instance for feature '{}'", feature);
        Criteria criteria = getDefaultCriteria().createCriteria(DatasetEntity.PROPERTY_FEATURE,
                                                                JoinType.LEFT_OUTER_JOIN)
                                                .add(Restrictions.eq(COLUMN_PKID, feature.getPkid()));
        return (List<T>) criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<T> getInstancesWith(PlatformEntity platform) {
        LOGGER.debug("get instance for platform '{}'", platform);
        Criteria criteria = getDefaultCriteria().createCriteria(DatasetEntity.PROPERTY_PROCEDURE,
                                                                JoinType.LEFT_OUTER_JOIN)
                                                .add(Restrictions.eq(COLUMN_PKID, platform.getPkid()));
        return (List<T>) criteria.list();
    }

    @Override
    protected Class<T> getEntityClass() {
        return entityType;
    }

    @Override
    protected String getDatasetProperty() {
        // self has no property
        return "";
    }

    @Override
    protected Criteria getDefaultCriteria() {
        // declare explicit alias here
        return getDefaultCriteria(DatasetEntity.ENTITY_ALIAS);
    }

    @Override
    protected Criteria getDefaultCriteria(String alias) {
        Criteria criteria = entityType != null
                ? super.getDefaultCriteria(alias)
                : session.createCriteria(DatasetEntity.class, alias);
        addIgnoreUnpublishedSeriesTo(criteria, alias);
        return criteria;
    }

    private Criteria addIgnoreUnpublishedSeriesTo(Criteria criteria, String alias) {
        criteria.add(Restrictions.and(createNotNullFirstLastValueRestriction(alias),
                                      createPublishedAndNotDeletedRestriction(alias)));
        return criteria;
    }

    private Criterion createPublishedAndNotDeletedRestriction(String alias) {
        return Restrictions.and(Restrictions.eq(QueryUtils.createAssociation(alias, "published"), true),
                                Restrictions.eqOrIsNull(QueryUtils.createAssociation(alias, "deleted"), false));
    }

    private LogicalExpression createNotNullFirstLastValueRestriction(String alias) {
        return Restrictions.and(Restrictions.isNotNull(QueryUtils.createAssociation(alias, "firstValueAt")),
                                Restrictions.isNotNull(QueryUtils.createAssociation(alias, "lastValueAt")));
    }
}
