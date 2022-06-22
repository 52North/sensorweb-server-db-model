/*
 * Copyright (C) 2015-2022 52°North Spatial Information Research GmbH
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
package org.n52.series.db.beans.parameter;

import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.DataEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.PhenomenonEntity;
import org.n52.series.db.beans.PlatformEntity;
import org.n52.series.db.beans.ProcedureEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetBooleanParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetCategoryParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetComplexParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetCountParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetJsonParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetQuantityParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetTemporalParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetTextParameterEntity;
import org.n52.series.db.beans.parameter.dataset.DatasetXmlParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureBooleanParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureCategoryParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureComplexParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureCountParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureJsonParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureQuantityParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureTemporalParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureTextParameterEntity;
import org.n52.series.db.beans.parameter.feature.FeatureXmlParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationBooleanParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationCategoryParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationComplexParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationCountParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationJsonParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationQuantityParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationTemporalParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationTextParameterEntity;
import org.n52.series.db.beans.parameter.location.LocationXmlParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationBooleanParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationCategoryParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationComplexParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationCountParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationJsonParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationQuantityParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationTemporalParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationTextParameterEntity;
import org.n52.series.db.beans.parameter.observation.ObservationXmlParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonBooleanParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonCategoryParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonComplexParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonCountParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonJsonParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonQuantityParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonTemporalParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonTextParameterEntity;
import org.n52.series.db.beans.parameter.phenomenon.PhenomenonXmlParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformBooleanParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformCategoryParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformComplexParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformCountParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformJsonParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformQuantityParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformTemporalParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformTextParameterEntity;
import org.n52.series.db.beans.parameter.platform.PlatformXmlParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureBooleanParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureCategoryParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureComplexParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureCountParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureJsonParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureQuantityParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureTemporalParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureTextParameterEntity;
import org.n52.series.db.beans.parameter.procedure.ProcedureXmlParameterEntity;
import org.n52.series.db.beans.sta.LocationEntity;

/**
 * Denotes Classes that can create concrete parameter entities.
 *
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
public class ParameterFactory {

    /**
     * Creates a concrete ParameterEntity based on the type of the Entity and the Parameter
     *
     * @param valueType
     *            type of the value
     * @param entity
     *            the entity
     * @return concrete class
     */
    public static ParameterEntity<?> from(DescribableEntity entity, ValueType valueType) {
        EntityType entityType = null;
        if (entity instanceof PhenomenonEntity) {
            entityType = EntityType.PHENOMENON;
        } else if (entity instanceof ProcedureEntity) {
            entityType = EntityType.PROCEDURE;
        } else if (entity instanceof AbstractDatasetEntity) {
            entityType = EntityType.DATASET;
        } else if (entity instanceof AbstractFeatureEntity) {
            entityType = EntityType.FEATURE;
        } else if (entity instanceof DataEntity) {
            entityType = EntityType.OBSERVATION;
        } else if (entity instanceof LocationEntity) {
            entityType = EntityType.LOCATION;
        } else if (entity instanceof PlatformEntity) {
            entityType = EntityType.PLATFORM;
        }
        if (entityType != null) {
            ParameterEntity<?> e = from(entityType, valueType);
            e.setDescribeableEntity(entity);
            return e;
        }
        return null;
    }

    /**
     * Creates a concrete ParameterEntity based on the type of the Entity and the Parameter
     *
     * @param valueType
     *            type of the value
     * @param entityType
     *            type of the entity
     * @return concrete class
     */
    public static ParameterEntity<?> from(EntityType entityType, ValueType valueType) {
        switch (entityType) {
            case PHENOMENON:
                switch (valueType) {
                    case JSON:
                        return new PhenomenonJsonParameterEntity();
                    case XML:
                        return new PhenomenonXmlParameterEntity();
                    case TEXT:
                        return new PhenomenonTextParameterEntity();
                    case BOOLEAN:
                        return new PhenomenonBooleanParameterEntity();
                    case CATEGORY:
                        return new PhenomenonCategoryParameterEntity();
                    case COUNT:
                        return new PhenomenonCountParameterEntity();
                    case QUANTITY:
                        return new PhenomenonQuantityParameterEntity();
                    case COMPLEX:
                        return new PhenomenonComplexParameterEntity();
                    case TEMPORAL:
                        return new PhenomenonTemporalParameterEntity();
                    default:
                        return null;
                }
            case PROCEDURE:
                switch (valueType) {
                    case JSON:
                        return new ProcedureJsonParameterEntity();
                    case XML:
                        return new ProcedureXmlParameterEntity();
                    case TEXT:
                        return new ProcedureTextParameterEntity();
                    case BOOLEAN:
                        return new ProcedureBooleanParameterEntity();
                    case CATEGORY:
                        return new ProcedureCategoryParameterEntity();
                    case COUNT:
                        return new ProcedureCountParameterEntity();
                    case QUANTITY:
                        return new ProcedureQuantityParameterEntity();
                    case COMPLEX:
                        return new ProcedureComplexParameterEntity();
                    case TEMPORAL:
                        return new ProcedureTemporalParameterEntity();
                    default:
                        return null;
                }
            case PLATFORM:
                switch (valueType) {
                    case JSON:
                        return new PlatformJsonParameterEntity();
                    case XML:
                        return new PlatformXmlParameterEntity();
                    case TEXT:
                        return new PlatformTextParameterEntity();
                    case BOOLEAN:
                        return new PlatformBooleanParameterEntity();
                    case CATEGORY:
                        return new PlatformCategoryParameterEntity();
                    case COUNT:
                        return new PlatformCountParameterEntity();
                    case QUANTITY:
                        return new PlatformQuantityParameterEntity();
                    case COMPLEX:
                        return new PlatformComplexParameterEntity();
                    case TEMPORAL:
                        return new PlatformTemporalParameterEntity();
                    default:
                        return null;
                }
            case DATASET:
                switch (valueType) {
                    case JSON:
                        return new DatasetJsonParameterEntity();
                    case XML:
                        return new DatasetXmlParameterEntity();
                    case TEXT:
                        return new DatasetTextParameterEntity();
                    case BOOLEAN:
                        return new DatasetBooleanParameterEntity();
                    case CATEGORY:
                        return new DatasetCategoryParameterEntity();
                    case COUNT:
                        return new DatasetCountParameterEntity();
                    case QUANTITY:
                        return new DatasetQuantityParameterEntity();
                    case COMPLEX:
                        return new DatasetComplexParameterEntity();
                    case TEMPORAL:
                        return new DatasetTemporalParameterEntity();
                    default:
                        return null;
                }
            case FEATURE:
                switch (valueType) {
                    case JSON:
                        return new FeatureJsonParameterEntity();
                    case XML:
                        return new FeatureXmlParameterEntity();
                    case TEXT:
                        return new FeatureTextParameterEntity();
                    case BOOLEAN:
                        return new FeatureBooleanParameterEntity();
                    case CATEGORY:
                        return new FeatureCategoryParameterEntity();
                    case COUNT:
                        return new FeatureCountParameterEntity();
                    case QUANTITY:
                        return new FeatureQuantityParameterEntity();
                    case COMPLEX:
                        return new FeatureComplexParameterEntity();
                    case TEMPORAL:
                        return new FeatureTemporalParameterEntity();
                    default:
                        return null;
                }
            case OBSERVATION:
                switch (valueType) {
                    case JSON:
                        return new ObservationJsonParameterEntity();
                    case XML:
                        return new ObservationXmlParameterEntity();
                    case TEXT:
                        return new ObservationTextParameterEntity();
                    case BOOLEAN:
                        return new ObservationBooleanParameterEntity();
                    case CATEGORY:
                        return new ObservationCategoryParameterEntity();
                    case COUNT:
                        return new ObservationCountParameterEntity();
                    case QUANTITY:
                        return new ObservationQuantityParameterEntity();
                    case COMPLEX:
                        return new ObservationComplexParameterEntity();
                    case TEMPORAL:
                        return new ObservationTemporalParameterEntity();
                    default:
                        return null;
                }
            case LOCATION:
                switch (valueType) {
                    case JSON:
                        return new LocationJsonParameterEntity();
                    case XML:
                        return new LocationXmlParameterEntity();
                    case TEXT:
                        return new LocationTextParameterEntity();
                    case BOOLEAN:
                        return new LocationBooleanParameterEntity();
                    case CATEGORY:
                        return new LocationCategoryParameterEntity();
                    case COUNT:
                        return new LocationCountParameterEntity();
                    case QUANTITY:
                        return new LocationQuantityParameterEntity();
                    case COMPLEX:
                        return new LocationComplexParameterEntity();
                    case TEMPORAL:
                        return new LocationTemporalParameterEntity();
                    default:
                        return null;
                }
            default:
                return null;
        }
    }

    public enum EntityType {
        PHENOMENON, PROCEDURE, PLATFORM, DATASET, FEATURE, OBSERVATION, LOCATION
    }

    public enum ValueType {
        BOOLEAN, TEXT, JSON, XML, COUNT, CATEGORY, QUANTITY, COMPLEX, TEMPORAL
    }

}
