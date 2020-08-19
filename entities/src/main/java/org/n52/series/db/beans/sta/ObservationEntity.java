/*
 * Copyright 2015-2020 52°North Initiative for Geospatial Open Source
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

package org.n52.series.db.beans.sta;

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.AbstractDatasetEntity;
import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.common.Utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

/**
 * Represents a SensorThingsAPI Observation. Uses Javax Annotations to use @AttributeOverride
 *
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@SequenceGenerator(name = "observation_seq", allocationSize = 1)
@Table(name = "observation",
        uniqueConstraints = { @UniqueConstraint(columnNames = { "sampling_time_start", "sampling_time_end",
                "result_time", "fk_dataset_id", "value_type" }, name = "un_observation_identity") },
        indexes = { @Index(name = "idx_sampling_time_start", columnList = "sampling_time_start"),
                @Index(name = "idx_sampling_time_end", columnList = "sampling_time_end"),
                @Index(name = "idx_result_time", columnList = "result_time") })
@DiscriminatorColumn(name = "value_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ObservationEntity<T> extends AbstractObservationEntity<T> implements Comparable<ObservationEntity<T>> {

    public static final String PROPERTY_ID = "id";
    public static final String PROPERTY_IDENTIFIER = "identifier";
    public static final String PROPERTY_STA_IDENTIFIER = "staIdentifier";
    public static final String PROPERTY_RESULT_TIME = "resultTime";
    public static final String PROPERTY_SAMPLING_TIME_START = "samplingTimeStart";
    public static final String PROPERTY_SAMPLING_TIME_END = "samplingTimeEnd";
    public static final String PROPERTY_VALID_TIME_START = "validTimeStart";
    public static final String PROPERTY_VALID_TIME_END = "validTimeEnd";
    public static final String PROPERTY_GEOMETRY_ENTITY = "geometryEntity";
    public static final String PROPERTY_DATASET = "dataset";
    public static final String PROPERTY_VALUE = "value";
    public static final String PROPERTY_VALUE_BOOLEAN = "valueBoolean";
    public static final String PROPERTY_VALUE_TEXT = "valueText";
    public static final String PROPERTY_VALUE_QUANTITY = "valueQuantity";
    public static final String PROPERTY_VALUE_CATEGORY = "valueCategory";
    public static final String PROPERTY_VALUE_COUNT = "valueCount";
    public static final String PROPERTY_PARAMETERS = "parameters";

    private static final long serialVersionUID = -4720091385202877301L;

    /**
     * Identification of the entity without special chars.
     */
    @Id
    @Column(nullable = false, name = "observation_id", unique = true)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "observation_seq")
    private Long id;

    /**
     * Identification for SensorThings API of the entity without special chars.
     */
    @Column(nullable = false, name = "sta_identifier", unique = true)
    private String staIdentifier;

    /**
     * Identification of entity used by SOS.
     */
    @Column(nullable = false, name = "identifier", unique = true)
    private String identifier;

    /**
     * Name of the entity.
     */
    @Column(name = "name")
    private String name;

    /**
     * Description of the entity.
     */
    @Column(name = "description")
    private String description;

    @Column(name = "sampling_time_start", length = 29, nullable = false)
    private Date samplingTimeStart;

    @Column(name = "sampling_time_end", length = 29, nullable = false)
    private Date samplingTimeEnd;

    // This is overwritten by all subclasses
    @Transient
    private T value;

    @Column(name = "value_boolean", nullable = true, insertable = false, updatable = false)
    private Boolean valueBoolean;

    @Column(name = "value_text", nullable = true, insertable = false, updatable = false)
    private String valueText;

    @Column(name = "value_quantity", nullable = true, insertable = false, updatable = false)
    private BigDecimal valueQuantity;

    @Column(name = "value_category", nullable = true, insertable = false, updatable = false)
    private String valueCategory;

    @Column(name = "value_count", nullable = true, insertable = false, updatable = false)
    private Integer valueCount;

    @Column(name = "sampling_geometry", columnDefinition = "geometry")
    private Geometry samplingGeometry;

    @Column(name = "valid_time_start", length = 29, columnDefinition = "timestamp default NULL")
    private Date validTimeStart;

    @Column(name = "valid_time_end", length = 29, columnDefinition = "timestamp default NULL")
    private Date validTimeEnd;

    @Column(name = "result_time", nullable = true, length = 29, columnDefinition = "timestamp")
    private Date resultTime;

    // TODO(specki): Check if lazy fetching can be used here
    @ManyToOne(targetEntity = DatasetEntity.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_dataset_id", foreignKey = @ForeignKey(name = "fk_dataset"))
    private DatasetEntity dataset;

    @Column(name = "fk_dataset_id", updatable = false, insertable = false, nullable = false)
    private Long datasetId;

    @ManyToMany(targetEntity = ParameterEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "observation_parameters", inverseForeignKey = @ForeignKey(name = "fk_observation_parameter"),
            joinColumns = { @JoinColumn(name = "fk_observation_id") },
            foreignKey = @ForeignKey(name = "fk_parameter_observation"),
            inverseJoinColumns = { @JoinColumn(name = "fk_parameter_id") })
    private Set<ParameterEntity<?>> parameters;

    @Transient
    private AbstractDatasetEntity datastream;

    @Transient
    private AbstractFeatureEntity<?> featureOfInterest;

    public ObservationEntity() {
    }

    @Override
    public AbstractDatasetEntity getDatastream() {
        return datastream;
    }

    @Override
    public void setDatastream(AbstractDatasetEntity datastream) {
        this.datastream = datastream;
    }

    @Override
    public AbstractFeatureEntity<?> getFeature() {
        return featureOfInterest;
    }

    @Override
    public void setFeature(AbstractFeatureEntity<?> featureOfInterest) {
        this.featureOfInterest = featureOfInterest;
    }

    @Override
    public Date getSamplingTimeStart() {
        return Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    @Override
    public void setSamplingTimeStart(Date samplingTimeStart) {
        this.samplingTimeStart = Utils.createUnmutableTimestamp(samplingTimeStart);
    }

    @Override
    public Date getSamplingTimeEnd() {
        return Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    @Override
    public void setSamplingTimeEnd(Date samplingTimeEnd) {
        this.samplingTimeEnd = Utils.createUnmutableTimestamp(samplingTimeEnd);
    }

    @Override
    public Date getValidTimeStart() {
        return Utils.createUnmutableTimestamp(validTimeStart);
    }

    @Override
    public void setValidTimeStart(Date validTimeStart) {
        this.validTimeStart = Utils.createUnmutableTimestamp(validTimeStart);
    }

    @Override
    public Date getValidTimeEnd() {
        return Utils.createUnmutableTimestamp(validTimeEnd);
    }

    @Override
    public void setValidTimeEnd(Date validTimeEnd) {
    }

    @Override
    public Date getResultTime() {
        return Utils.createUnmutableTimestamp(resultTime);
    }

    @Override
    public void setResultTime(Date resultTime) {
        this.resultTime = Utils.createUnmutableTimestamp(resultTime);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getStaIdentifier() {
        return staIdentifier;
    }

    @Override
    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    @Override
    public Set<ParameterEntity<?>> getParameters() {
        return parameters;
    }

    @Override
    public void setParameters(Set<ParameterEntity<?>> parameters) {
        this.parameters = parameters;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public DatasetEntity getDataset() {
        return dataset;
    }

    @Override
    public void setDataset(DatasetEntity dataset) {
        this.dataset = dataset;
    }

    @Override
    public int compareTo(ObservationEntity<T> other) {
        return Comparator.comparing(ObservationEntity<T>::getSamplingTimeEnd)
                .thenComparing(ObservationEntity::getSamplingTimeStart).thenComparing(ObservationEntity<T>::getId)
                .compare(this, other);
    }

    @Override
    public T getValue() {
        return value;
    }

    @Override
    public ObservationEntity<T> setValue(T value) {
        this.value = value;
        return this;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier, boolean staSupportsUrls) {
        this.identifier = identifier;
        if (!isSetStaIdentifier()) {
            setStaIdentifier(staSupportsUrls ? identifier : processIdentifierForSta(identifier));
        }
    }

    @Override
    public Geometry getSamplingGeometry() {
        return samplingGeometry;
    }

    @Override
    public void setSamplingGeometry(Geometry samplingGeometry) {
        this.samplingGeometry = samplingGeometry;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getStaIdentifier(), getSamplingTimeStart(), getSamplingTimeEnd(),
                getResultTime(), getValue());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ObservationEntity)) {
            return false;
        }
        ObservationEntity other = (ObservationEntity) obj;
        return super.equals(obj) && Objects.equals(getDataset(), other.getDataset())
                && Objects.equals(getStaIdentifier(), other.getStaIdentifier())
                && Objects.equals(getSamplingTimeStart(), other.getSamplingTimeStart())
                && Objects.equals(getSamplingTimeStart(), other.getSamplingTimeStart())
                && Objects.equals(getSamplingTimeEnd(), other.getSamplingTimeEnd())
                && Objects.equals(getResultTime(), other.getResultTime())
                && Objects.equals(getValue(), other.getValue());
    }

}
