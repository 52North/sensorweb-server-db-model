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
import org.n52.series.db.beans.AbstractFeatureEntity;
import org.n52.series.db.beans.DatasetEntity;
import org.n52.series.db.beans.HibernateRelations;
import org.n52.series.db.beans.IdEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.StaRelations.Datastream;
import org.n52.series.db.common.Utils;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.Set;

/**
 * Represents a SensorThingsAPI Observation.
 * Uses Javax Annotations to use @AttributeOverride
 *
 * @author <a href="mailto:j.speckamp@52north.org">Jan Speckamp</a>
 */
@Entity
@Table(name = "observation",
       uniqueConstraints = {
               @UniqueConstraint(columnNames = {
                       "sampling_time_start", "sampling_time_end",
                       "result_time", "fk_dataset_id", "value_type"
               }, name = "un_observation_identity")
       },
       indexes = {
               @Index(name = "idx_sampling_time_start", columnList = "sampling_time_start"),
               @Index(name = "idx_sampling_time_end", columnList = "sampling_time_end"),
               @Index(name = "idx_result_time", columnList = "result_time")
       })
@DiscriminatorColumn(name = "value_type")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class ObservationEntity<T> extends IdEntity implements Comparable<ObservationEntity<T>>, Serializable,
        HibernateRelations.HasPhenomenonTime, HibernateRelations.IsStaEntity, Datastream<ObservationEntity>,
        HibernateRelations.HasId, HibernateRelations.HasIdentifier, HibernateRelations.HasStaIdentifier {

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
    public static final String PROPERTY_PARAMETERS = "parameters";

    private static final long serialVersionUID = -4720091385202877301L;

    /**
     * Identification of the entity without special chars.
     */
    @Id
    // @SequenceGenerator(name = "sequence_name", sequenceName = "observation_seq")
    @Column(nullable = false, name = "observation_id", unique = true)
    @GeneratedValue
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
    // datasetId is only used as a dummy
    private T value;

    @Column(name = "sampling_geometry", columnDefinition = "geometry")
    private Geometry samplingGeometry;

    @Column(name = "valid_time_start", length = 29, columnDefinition = "timestamp default NULL")
    private Date validTimeStart;

    @Column(name = "valid_time_end", length = 29, columnDefinition = "timestamp default NULL")
    private Date validTimeEnd;

    @Column(name = "result_time", nullable = false, length = 29, columnDefinition = "timestamp")
    private Date resultTime;

    // TODO(specki): Check if lazy fetching can be used here
    @ManyToOne(targetEntity = DatasetEntity.class, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_dataset_id", foreignKey = @ForeignKey(name = "fk_dataset"))
    private DatasetEntity dataset;

    @Column(name = "fk_dataset_id", updatable = false, insertable = false, nullable = false)
    private Long datasetId;

    @ManyToMany(targetEntity = ParameterEntity.class, fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @JoinTable(name = "observation_parameters", inverseForeignKey = @ForeignKey(name = "fk_observation_parameter"),
               joinColumns = {@JoinColumn(name = "fk_observation_id")},
               foreignKey = @ForeignKey(name = "fk_parameter_observation"),
               inverseJoinColumns = {@JoinColumn(name = "fk_parameter_id")})
    private Set<ParameterEntity> parameters;

    @Transient
    private DatastreamEntity datastream;

    @Transient
    private AbstractFeatureEntity<?> featureOfInterest;

    @Transient
    private boolean processed;

    public ObservationEntity() {
    }

    @Override
    public DatastreamEntity getDatastream() {
        return datastream;
    }

    @Override
    public ObservationEntity setDatastream(DatastreamEntity datastream) {
        this.datastream = datastream;
        return this;
    }

    public AbstractFeatureEntity<?> getFeatureOfInterest() {
        return featureOfInterest;
    }

    public void setFeatureOfInterest(AbstractFeatureEntity<?> featureOfInterest) {
        this.featureOfInterest = featureOfInterest;
    }

    public boolean hasFeatureOfInterest() {
        return getFeatureOfInterest() != null;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void setProcessed(boolean processed) {
        this.processed = processed;
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

    public Date getValidTimeStart() {
        return Utils.createUnmutableTimestamp(validTimeStart);
    }

    public void setValidTimeStart(Date validTimeStart) {
        this.validTimeStart = Utils.createUnmutableTimestamp(validTimeStart);
    }

    public Date getValidTimeEnd() {
        return Utils.createUnmutableTimestamp(validTimeEnd);
    }

    public void setValidTimeEnd(Date validTimeEnd) {
        this.validTimeEnd = Utils.createUnmutableTimestamp(validTimeEnd);
    }

    public Date getResultTime() {
        return Utils.createUnmutableTimestamp(resultTime);
    }

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

    public String getStaIdentifier() {
        return staIdentifier;
    }

    public void setStaIdentifier(String staIdentifier) {
        this.staIdentifier = staIdentifier;
    }

    public boolean hasParameters() {
        return getParameters() != null && !getParameters().isEmpty();
    }

    public Set<ParameterEntity> getParameters() {
        return parameters;
    }

    public void setParameters(Set<ParameterEntity> parameters) {
        this.parameters = parameters;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DatasetEntity getDataset() {
        return dataset;
    }

    public void setDataset(DatasetEntity dataset) {
        this.dataset = dataset;
    }

    @Override
    public int compareTo(ObservationEntity<T> other) {
        return Comparator.comparing(ObservationEntity<T>::getSamplingTimeEnd)
                         .thenComparing(ObservationEntity::getSamplingTimeStart)
                         .thenComparing(ObservationEntity<T>::getId)
                         .compare(this, other);
    }

    public boolean isSetValidTime() {
        return isSetValidStartTime() && isSetValidEndTime();
    }

    private boolean isSetValidStartTime() {
        return validTimeStart != null;
    }

    private boolean isSetValidEndTime() {
        return validTimeEnd != null;
    }

    public boolean hasValue() {
        return getValue() != null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String getIdentifier() {
        return identifier;
    }

    @Override
    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Geometry getSamplingGeometry() {
        return samplingGeometry;
    }

    public void setSamplingGeometry(Geometry samplingGeometry) {
        this.samplingGeometry = samplingGeometry;
    }
}
