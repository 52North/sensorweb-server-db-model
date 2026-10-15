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
package org.n52.series.db.beans.parameter.feature;

import jakarta.persistence.Access;
import jakarta.persistence.AccessType;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.Index;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.DescribableEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.io.Serial;

/**
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@SuppressFBWarnings({ "EI_EXPOSE_REP", "EI_EXPOSE_REP2" })
@Entity(name = "org.n52.series.db.beans.parameter.feature.FeatureParameterEntity")
@Table(name = "feature_parameter",
        indexes = { @Index(name = "idx_feature_param_name", columnList = "name"),
                @Index(name = "idx_feature_parameter", columnList = "fk_feature_id"),
                @Index(name = "idx_feature_parent_parameter", columnList = "fk_parent_parameter_id"),
                @Index(name = "idx_feature_parameter_unit", columnList = "fk_unit_id") })
// table comment: Storage for additional information for features
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class FeatureParameterEntity<T> extends ParameterEntity<T> {

    public static final String PROP_FEATURE = "feature";
    public static final String PROP_FEATURE_ID = "featureId";

    @Serial
    private static final long serialVersionUID = 1123453212836718013L;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_feature_id", nullable = false, insertable = false, updatable = false,
            foreignKey = @ForeignKey(name = "fk_param_feature_id"))
    private AbstractFeatureEntity feature;

    public AbstractFeatureEntity getFeature() {
        return feature;
    }

    public void setFeature(AbstractFeatureEntity feature) {
        this.feature = feature;
    }

    @Override
    @Access(AccessType.PROPERTY)
    @ManyToOne(targetEntity = FeatureParameterEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_parent_parameter_id", foreignKey = @ForeignKey(name = "fk_param_feature_parent_id"))
    public ParameterEntity<?> getParent() {
        return super.getParent();
    }

    @Override
    public void setDescribeableEntity(DescribableEntity entity) {
        setFeature((AbstractFeatureEntity) entity);
    }
}
