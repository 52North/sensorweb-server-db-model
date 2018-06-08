/*
 * Copyright 2015-2018 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.dataset;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.CategoryEntity;
import org.n52.series.db.beans.CodespaceEntity;
import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.FormatEntity;
import org.n52.series.db.beans.OfferingEntity;
import org.n52.series.db.beans.PhenomenonEntity;
import org.n52.series.db.beans.PlatformEntity;
import org.n52.series.db.beans.ProcedureEntity;
import org.n52.series.db.beans.RelatedDatasetEntity;
import org.n52.series.db.beans.UnitEntity;
import org.n52.series.db.beans.data.Data;
import org.n52.series.db.beans.parameter.Parameter;

public interface Dataset {

    String DEFAULT_VALUE_TYPE = "quantity";

    CategoryEntity getCategory();

    void setCategory(CategoryEntity category);

    PhenomenonEntity getPhenomenon();

    DatasetEntity setPhenomenon(PhenomenonEntity phenomenon);

    PhenomenonEntity getObservableProperty();

    DatasetEntity setObservableProperty(PhenomenonEntity phenomenon);

    ProcedureEntity getProcedure();

    DatasetEntity setProcedure(ProcedureEntity procedure);

    OfferingEntity getOffering();

    DatasetEntity setOffering(OfferingEntity offering);

    boolean isSetOffering();

    AbstractFeatureEntity getFeature();

    void setFeature(AbstractFeatureEntity feature);

    boolean isSetFeature();

    PlatformEntity getPlatform();

    void setPlatform(PlatformEntity platform);

    Boolean isPublished();

    void setPublished(boolean published);

    boolean isDeleted();

    DatasetEntity setDeleted(boolean deleted);

    boolean getDeleted();

    DatasetEntity setDisabled(boolean diabled);

    boolean getDisabled();

    boolean isDisabled();

    boolean isSetObservationType();

    Date getFirstValueAt();

    void setFirstValueAt(Date valueAt);

    boolean isSetFirstValueAt();

    Date getLastValueAt();

    void setLastValueAt(Date valueAt);

    boolean isSetLastValueAt();

    Data getFirstObservation();

    void setFirstObservation(Data observation);

    Data getLastObservation();

    void setLastObservation(Data observation);

    BigDecimal getFirstQuantityValue();

    void setFirstQuantityValue(BigDecimal value);

    BigDecimal getLastQuantityValue();

    void setLastQuantityValue(BigDecimal value);

    String getValueType();

    void setValueType(String valueType);

    Set<Date> getResultTimes();

    void setResultTimes(Set<Date> resultTimes);

    UnitEntity getUnit();

    void setUnit(UnitEntity unit);

    boolean hasUnit();

    void setObservationCount(long observationCount);

    long getObservationCount();

    boolean isHidden();

    DatasetEntity setHidden(boolean hidden);

    FormatEntity getObservationType();

    DatasetEntity setObservationType(FormatEntity observationType);

    boolean isSetObservationtype();

    Set<RelatedDatasetEntity> getRelatedDatasets();

    void setRelatedObservations(Set<RelatedDatasetEntity> relatedDatasets);

    boolean hasRelatedDatasets();

    Long getId();

    void setId(Long id);

    String getIdentifier();

    void setIdentifier(String identifier);

    CodespaceEntity getIdentifierCodespace();

    void setIdentifierCodespace(CodespaceEntity codespace);

    String getName();

    void setName(String name);

    CodespaceEntity getNameCodespace();

    void setNameCodespace(CodespaceEntity codespace);

    String getDescription();

    void setDescription(String description);

    Set<Parameter< ? >> getParameters();

    default boolean hasParameters() {
        return getParameters() != null;
    }

    void setParameters(Set<Parameter< ? >> parameters);

    void copy(Dataset series);

    default String getDefaultDatasetType() {
        return DEFAULT_VALUE_TYPE;
    }

}
