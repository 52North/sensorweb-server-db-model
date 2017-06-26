/*
 * Copyright 2015-2017 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DatasetEntity<T extends DataEntity< ? >> extends DescribableEntity {

    public static final String DEFAULT_DATASET_TYPE = "measurement";

    public static final String ENTITY_ALIAS = "dataset";

    public static final String PROPERTY_OBSERVATION_CONSTELLATION = "observationConstellation";
    public static final String PROPERTY_PROCEDURE = "procedure";
    public static final String PROPERTY_CATEGORY = "category";
    public static final String PROPERTY_PHENOMENON = "phenomenon";
    public static final String PROPERTY_FEATURE = "feature";
    public static final String PROPERTY_OFFERING = "offering";
    public static final String PROPERTY_PLATFORM = "platform";
    public static final String PROPERTY_DATASET_TYPE = "datasetType";
    public static final String PROPERTY_OBSERVATION_TYPE = "observationType";
    public static final String PROPERTY_FIRST_VALUE_AT = "firstValueAt";
    public static final String PROPERTY_LAST_VALUE_AT = "lastValueAt";
    public static final String PROPERTY_PUBLISHED = "published";
    public static final String PROPERTY_DELETED = "deleted";

    private static final long serialVersionUID = -7491530543976690237L;

    private ObservationConstellationEntity observationConstellation;

    private FeatureEntity feature;

    private CategoryEntity category;

    private PlatformEntity platform;

    private Boolean published = Boolean.TRUE;

    private Boolean deleted = Boolean.FALSE;

    private List<T> observations;

    private String datasetType;

    private Set<Date> resultTimes;

    private Date firstValueAt;

    private Date lastValueAt;

    private UnitEntity unit;

    private long observationCount = -1;

    public DatasetEntity() {
        this.observations = new ArrayList<>();
    }

    public DatasetEntity(String type) {
        this.observations = new ArrayList<>();
        this.datasetType = type;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public ObservationConstellationEntity getObservationConstellation() {
        return observationConstellation;
    }

    public void setObservationConstellation(ObservationConstellationEntity observationConstellation) {
        this.observationConstellation = observationConstellation;
    }

    public PhenomenonEntity getPhenomenon() {
        return getObservationConstellation().getObservableProperty();
    }

    public void setPhenomenon(PhenomenonEntity phenomenon) {
        existsOrCreateObservationConstellation().setObservableProperty(phenomenon);
    }

    private ObservationConstellationEntity existsOrCreateObservationConstellation() {
        if (getObservationConstellation() == null) {
            setObservationConstellation(new ObservationConstellationEntity());
        }
        return getObservationConstellation();
    }

    public ProcedureEntity getProcedure() {
        return getObservationConstellation().getProcedure();
    }

    public void setProcedure(ProcedureEntity procedure) {
        existsOrCreateObservationConstellation().setProcedure(procedure);
    }

    public OfferingEntity getOffering() {
        return getObservationConstellation().getOffering();
    }

    public void setOffering(OfferingEntity offering) {
        existsOrCreateObservationConstellation().setOffering(offering);
    }

    public FeatureEntity getFeature() {
        return feature;
    }

    public void setFeature(FeatureEntity feature) {
        this.feature = feature;
    }

    public PlatformEntity getPlatform() {
        return platform;
    }

    public void setPlatform(PlatformEntity platform) {
        this.platform = platform;
    }

    public List<T> getObservations() {
        return observations;
    }

    public void setObservations(List<T> observations) {
        this.observations = observations;
    }

    public Boolean isPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Date getFirstValueAt() {
        return firstValueAt != null
                ? new Timestamp(firstValueAt.getTime())
                : null;
    }

    public void setFirstValueAt(Date firstValueAt) {
        this.firstValueAt = firstValueAt != null
                ? new Timestamp(firstValueAt.getTime())
                : null;
    }

    public Date getLastValueAt() {
        return lastValueAt != null
                ? new Timestamp(lastValueAt.getTime())
                : null;
    }

    public void setLastValueAt(Date lastValueAt) {
        this.lastValueAt = lastValueAt != null
                ? new Timestamp(lastValueAt.getTime())
                : null;
    }

    public String getDatasetType() {
        return datasetType == null || datasetType.isEmpty()
                // backward compatible
                ? DEFAULT_DATASET_TYPE
                : datasetType;
    }

    public void setDatasetType(String datasetType) {
        this.datasetType = datasetType;
    }

    /**
     * @return a list of result times
     * @since 2.0.0
     */
    public Set<Date> getResultTimes() {
        Set<Date> unmodifiableResultTimes = wrapToUnmutables(resultTimes);
        return unmodifiableResultTimes != null
                ? Collections.unmodifiableSet(unmodifiableResultTimes)
                : null;
    }

    /**
     * @param resultTimes
     *        a list of result times
     * @since 2.0.0
     */
    public void setResultTimes(Set<Date> resultTimes) {
        this.resultTimes = wrapToUnmutables(resultTimes);
    }

    private Set<Date> wrapToUnmutables(Set<Date> dates) {
        return dates != null
                ? dates.stream()
                       .map(d -> d != null
                               ? new Timestamp(d.getTime())
                               : null)
                       .collect(Collectors.toSet())
                : null;
    }

    public UnitEntity getUnit() {
        return unit;
    }

    public void setUnit(UnitEntity unit) {
        this.unit = unit;
    }

    public boolean hasUnit() {
        return unit != null;
    }

    public String getUnitI18nName(String locale) {
        String name = null;
        if (unit != null) {
            name = unit.getNameI18n(locale);
        }
        return name;
    }

    public void setObservationCount(long count) {
        this.observationCount = count;
    }

    public long getObservationCount() {
        return observationCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getClass().getSimpleName())
                 .append(" [")
                 .append(" id: ")
                 .append(getPkid())
                 .append(" , category: ")
                 .append(category)
                 .append(" , phenomenon: ")
                 .append(getPhenomenon())
                 .append(" , procedure: ")
                 .append(getProcedure())
                 .append(" , offering: ")
                 .append(getOffering())
                 .append(" , feature: ")
                 .append(feature)
                 .append(" , service: ")
                 .append(getService())
                 .append(" , #observations: ")
                 .append(getObservationCount() >= 0
                         ? getObservationCount()
                         : observations.size())
                 .append(" ]")
                 .toString();
    }

}
