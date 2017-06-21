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

import java.util.Date;
import java.util.Locale;
import java.util.Set;

import org.n52.series.db.beans.parameter.Parameter;

import com.vividsolutions.jts.geom.Geometry;

/**
 * Interfaces that entities can implement to share constants and to make clear
 * which entities have which relations. Allows to throw compile time errors for
 * non existing relations.
 *
 * @author Christian Autermann <c.autermann@52north.org>
 * @since 4.0.0
 */
public interface HibernateRelations {

   interface HasIdentifier<T> {
       String getDomainId();

       T setDomainId(String domainId);
       
       default boolean isSetDomainId() {
           return getDomainId() != null && !getDomainId().isEmpty();
       }
       
       default String getIdentifier() {
           return getDomainId();
       }

       default T setIdentifier(String identifier) {
           return setDomainId(identifier);
       }

       /**
        * Is identifier set
        *
        * @return <code>true</code>, if identifier is set
        */
       default boolean isSetIdentifier() {
           return isSetDomainId();
       }
    }

    interface HasObservationConstellation {
        String OBSERVATION_CONSTELLATION = "observationConstellation";

        ObservationConstellationEntity getObservationConstellation();

        void setObservationConstellation(
                ObservationConstellationEntity observationConstellation);
    }

    interface HasObservationConstellations {
        String OBSERVATION_CONSTELLATIONS = "observationConstellations";

        Set<ObservationConstellationEntity> getObservationConstellations();

        void setObservationConstellations(
                Set<ObservationConstellationEntity> observationConstellations);
    }

    interface HasDescription<T> {
        String DESCRIPTION = "description";

        String getDescription();

        T setDescription(String description);

        /**
         * Is description set
         *
         * @return <code>true</code>, if description is set
         */
        default boolean isSetDescription() {
            return getDescription() != null && !getDescription().isEmpty();
        }
    }

    interface HasCodespace<T> {
        String CODESPACE = "codespace";

        CodespaceEntity getCodespace();

        T setCodespace(CodespaceEntity codespace);

        default boolean isSetCodespace() {
            return getCodespace() != null && !getCodespace().isSetCodespace();
        }
    }

    interface HasCodespaceName<T> {
        String CODESPACE_NAME = "codespaceName";

        CodespaceEntity getCodespaceName();

        T setCodespaceName(CodespaceEntity codespaceName);

        default boolean isSetCodespaceName() {
            return getCodespaceName() != null && !getCodespaceName().isSetCodespace();
        }
    }

    interface HasDisabledFlag<T> {
        String DIABLED = "disabled";

        T setDisabled(boolean disabled);

        boolean getDisabled();

        boolean isDisabled();
    }

    interface HasDeletedFlag<T> {
        String DELETED = "deleted";

        T setDeleted(boolean deleted);

        boolean getDeleted();

        boolean isDeleted();
    }
    
    interface HasPublishedFlag {
        String PUBLISHED = "published";

        HasPublishedFlag setPublished(boolean published);

        boolean isPublished();
    }

    interface HasFeatureType {
        String FEATURE_OF_INTEREST_TYPE = "featureOfInterestType";

        FeatureTypeEntity getFeatureType();

        void setFeatureType(
                FeatureTypeEntity featureOfInterestType);
    }

    interface HasFeatureTypes<T> {
        String FEATURE__TYPES = "featureTypes";

        Set<FeatureTypeEntity> getFeatureTypes();

        T setFeatureTypes(
                Set<FeatureTypeEntity> featureOfInterestTypes);
        
        default boolean HasFeaturTypes() {
            return getFeatureTypes() != null && !getFeatureTypes().isEmpty();
        }
        
    }

    interface HasFeatureGetter {
        String FEATURE_OF_INTEREST = "featureOfInterest";

        AbstractFeatureEntity getFeature();
    }

    interface HasFeature<T> extends HasFeatureGetter {

        T setFeature(AbstractFeatureEntity feature);
    }

    interface HasReadableObservationContext
            extends HasObservablePropertyGetter,
                    HasProcedureGetter,
                    HasFeatureGetter {
    }

    interface HasWriteableObservationContext<T>
            extends HasReadableObservationContext,
                    HasObservableProperty<T>,
                    HasProcedure<T>,
                    HasFeature<T>,
                    HasOffering<T> {
    }

    interface HasGeometry {
        String GEOMETRY = "geom";

        Geometry getGeom();

        void setGeom(Geometry geom);

        /**
         * Is geometry set
         *
         * @return <code>true</code>, if geometry is set
         */
        boolean isSetGeometry();
    }

    interface HasHiddenChildFlag<T> {
        String HIDDEN_CHILD = "hiddenChild";

        T setHiddenChild(boolean hiddenChild);

        boolean isHiddenChild();
    }

    interface HasChildFlag {
        String CHILD = "child";
        void setChild(boolean child);
        boolean isChild();
    }

    interface HasParentFlag {
        String PARENT = "parent";
        void setParent(boolean parent);
        boolean isParent();
    }

    interface HasDomainId {
        String IDENTIFIER = "identifier";

        String getIdentifier();

        void setIdentifier(String identifier);

        /**
         * Is identifier set
         *
         * @return <code>true</code>, if identifier is set
         */
        boolean isSetIdentifier();
    }

    interface HasName<T> {
        String NAME = "name";

        String getName();

        T setName(String name);

        default boolean isSetName() {
            return getName() != null && !getName().isEmpty();
        }

    }

    @Deprecated
    interface HasObservation {
        String OBSERVATION = "observation";

        DataEntity<?> getObservation();

        void setObservation(DataEntity<?> observation);
    }

    interface HasObservablePropertyGetter {

        String OBSERVABLE_PROPERTY = "observableProperty";

        PhenomenonEntity getObservableProperty();
    }

    interface HasObservableProperty<T> extends HasObservablePropertyGetter {

        T setObservableProperty(PhenomenonEntity observableProperty);
    }

    interface HasObservationType<T> {
        String OBSERVATION_TYPE = "observationType";

        ObservationTypeEntity getObservationType();

        T setObservationType(ObservationTypeEntity observationType);

        boolean isSetObservationType();
    }

    interface HasObservationTypes<T> {
        String OBSERVATION_TYPES = "observationTypes";

        Set<ObservationTypeEntity> getObservationTypes();

        T setObservationTypes(Set<ObservationTypeEntity> observationTypes);
        
        default boolean hasObservationTypes() {
            return getObservationTypes() != null && !getObservationTypes().isEmpty();
        }
    }

    interface HasOffering<T> {
        String OFFERING = "offering";

        T setOffering(OfferingEntity offering);

        OfferingEntity getOffering();
        
        boolean isSetOffering();
    }

    interface HasPhenomenonTime<T> {

        String PHENOMENON_TIME_START = "phenomenonTimeStart";

        String PHENOMENON_TIME_END = "phenomenonTimeEnd";

        /**
         * Get the start phenomenon time
         *
         * @return Start phenomenon time
         */
        Date getPhenomenonTimeStart();

        /**
         * Set the start phenomenon time
         *
         * @param phenomenonTimeStart
         *                            Start phenomenon time to set
         */
        T setPhenomenonTimeStart(Date phenomenonTimeStart);
        
        default boolean hasPhenomenonTimeStart() {
            return getPhenomenonTimeStart() != null;
        }

        /**
         * Get the end phenomenon time
         *
         * @return End phenomenon time
         */
        Date getPhenomenonTimeEnd();

        /**
         * Set the end phenomenon time
         *
         * @param phenomenonTimeEnd
         *                          End phenomenon time to set
         */
        T setPhenomenonTimeEnd(Date phenomenonTimeEnd);
        
        default boolean hasPhenomenonTimeEnd() {
            return getPhenomenonTimeEnd() != null;
        }
    }

    interface HasResultTimes<T> {

        String PHENOMENON_TIME_START = "resultTimeStart";

        String PHENOMENON_TIME_END = "resultTimeEnd";

        /**
         * Get the start result time
         *
         * @return Start result time
         */
        Date getResultTimeStart();

        /**
         * Set the start result time
         *
         * @param resultTimeStart
         *                            Start result time to set
         */
        T setResultTimeStart(Date resultTimeStart);
        
        default boolean hasResultTimeStart() {
            return getResultTimeStart() != null;
        }

        /**
         * Get the end result time
         *
         * @return End result time
         */
        Date getResultTimeEnd();

        /**
         * Set the end result time
         *
         * @param resultTimeEnd
         *                          End result time to set
         */
        T setResultTimeEnd(Date resultTimeEnd);
        
        default boolean hasResultTimeEnd() {
            return getResultTimeEnd() != null;
        }
    }

    
    interface HasProcedureGetter {
        String PROCEDURE = "procedure";

        ProcedureEntity getProcedure();
    }

    interface HasProcedure<T> extends HasProcedureGetter {

        T setProcedure(ProcedureEntity procedure);
    }
    
    interface HasProcedureDescriptionFormat<T> {
        String PROCEDURE_DESCRIPTION_FORMAT = "procedureDescriptionFormat";

        ProcedureDescriptionFormatEntity getProcedureDescriptionFormat();

        T setProcedureDescriptionFormat(
                ProcedureDescriptionFormatEntity procedureDescriptionFormat);
    }

    interface HasRelatedFeatureRoles<T> {
        String RELATED_FEATURE_ROLES = "relatedFeatureRoles";

        Set<RelatedFeatureRoleEntity> getRelatedFeatureRoles();

        T setRelatedFeatureRoles(Set<RelatedFeatureRoleEntity> relatedFeatureRoles);
    }

    interface HasRelatedFeatures<T> {
        String RELATED_FEATURES = "relatedFeatures";

        Set<RelatedFeatureEntity> getRelatedFeatures();

        T setRelatedFeatures(Set<RelatedFeatureEntity> relatedFeatures);
        
        default boolean hasRelatedFeatures() {
            return getRelatedFeatures() != null && !getRelatedFeatures().isEmpty();
        }
    }

    interface HasResultEncoding {
        String RESULT_ENCODING = "resultEncoding";

        String getResultEncoding();

        void setResultEncoding(String resultEncoding);

        boolean isSetResultEncoding();
    }

    interface HasResultStructure {
        String RESULT_STRUCTURE = "resultStructure";

        String getResultStructure();

        void setResultStructure(String resultStructure);

        boolean isSetResultStructure();
    }

    interface HasResultTime {

        String RESULT_TIME = "resultTime";

        /**
         * Get the result time
         *
         * @return Result time
         */
        Date getResultTime();

        /**
         * Set the result time
         *
         * @param resultTime
         *                   Result tiem to set
         */
        void setResultTime(Date resultTime);
    }

    interface HasUnit {
        String UNIT = "unit";

        UnitEntity getUnit();

        void setUnit(UnitEntity unit);

        /**
         * Is unit set
         *
         * @return <code>true</code>, if unit is set
         */
        boolean isSetUnit();
    }

    interface HasValidTime {

        String VALID_TIME_START = "validTimeStart";

        String VALID_TIME_END = "validTimeEnd";

        /**
         * Get the start valid time
         *
         * @return Start valid time
         */
        Date getValidTimeStart();

        /**
         * Set the start valid time
         *
         * @param validTimeStart
         *                       Start valid time to set
         */
        void setValidTimeStart(Date validTimeStart);

        /**
         * Get the end valid time
         *
         * @return End valid time
         */
        Date getValidTimeEnd();

        /**
         * Set the end valid time
         *
         * @param validTimeEnd
         *                     End valid time to set
         */
        void setValidTimeEnd(Date validTimeEnd);

        boolean isSetValidTime();
    }

    interface HasUrl {
        String URL = "url";

        String getUrl();

        void setUrl(String url);
        
        boolean isSetUrl();
    }
    
    
    interface GetStringValue {

        boolean isSetValue();

        String getValueAsString();

    }

    interface HasValue<T> extends GetStringValue {
        String VALUE = "value";

        T getValue();

        void setValue(T value);

    }

    interface HasUnitValue<T> extends HasUnit, HasValue<T> {}

    interface HasOfferings<T> {
        String OFFERINGS = "offerings";

        Set<OfferingEntity> getOfferings();

//        Object getOffering();
        T setOfferings(Object offerings);
        
        boolean isSetOfferings();

    }
    
    interface HasParameters {
        String PARAMETERS = "parameters";

        Set<Parameter<?>> getParameters();

        void setParameters(Object parameters);
        
        boolean hasParameters();

    }
    
    interface HasRelatedObservations {
        String PARAMETERS = "relatedObservations";

        Set<RelatedDataEntity> getRelatedObservations();

        void setRelatedObservations(Set<RelatedDataEntity> relatedObservations);
        
        boolean hasRelatedObservations();

    }

    interface HasObservableProperties {
        String OBSERVABLE_PROPERTIES = "observableProperties";

        Set<PhenomenonEntity> getObservableProperties();

        void setObservableProperties(
                Set<PhenomenonEntity> observableProperties);
    }

    interface GeoColumnsId {
        String COORD_DIMENSION = "coordDimension";

        String SRID = "srid";

        String TABLE_CATALOG = "FTableCatalog";

        String TABLE_NAME = "FTableName";

        String TABLE_SCHEMA = "FTableSchema";

        String TYPE = "type";

        Integer getCoordDimension();

        void setCoordDimension(Integer coordDimension);

        String getFTableCatalog();

        void setFTableCatalog(String fTableCatalog);

        String getFTableName();

        void setFTableName(String fTableName);

        String getFTableSchema();

        void setFTableSchema(String fTableSchema);

        Integer getSrid();

        void setSrid(Integer srid);

        String getType();

        void setType(String type);
    }

    interface HasSrid {
        String SRID = "srid";

        int getSrid();

        HasSrid setSrid(int srid);

        /**
         * Is srid set
         *
         * @return <code>true</code>, if srid is set
         */
        boolean isSetSrid();
    }

    interface HasCoordinate extends HasSrid {
        String LONGITUDE = "longitude";

        String LATITUDE = "latitude";

        String ALTITUDE = "altitude";

        Object getLongitude();

        HasCoordinate setLongitude(Object longitude);

        Object getLatitude();

        HasCoordinate setLatitude(Object latitude);

        /**
         * Are longitude and latitude set
         *
         * @return <code>true</code>, if longitude and latitude are set
         */
        boolean isSetLongLat();

        Object getAltitude();

        HasCoordinate setAltitude(Object altitude);

        /**
         * Is altitude set
         *
         * @return <code>true</code>, if altitude is set
         */
        boolean isSetAltitude();

        boolean isSpatial();
    }

    interface HasValidProcedureTimes {
        String VALID_PROCEDURE_TIMES = "validProcedureTimes";

        Set<ValidProcedureTimeEntity> getValidProcedureTimes();

        void setValidProcedureTimes(
                Set<ValidProcedureTimeEntity> validProcedureTimes);
    }

    interface HasParentChilds<T> {
        String PARENTS = "parents";

        String CHILDS = "childs";

        Set<T> getParents();

        void setParents(Set<T> parents);

        void addParent(T parent);
        
        boolean hasParents();

        Set<T> getChilds();

        void setChilds(Set<T> childs);

        void addChild(T child);
        
        boolean hasChilds();
    }

    interface HasObservationId {
        String OBS_ID = "observationId";

        /**
         * Get the observation id
         *
         * @return Observation id
         */
        long getObservationId();

        /**
         * Set the observation id
         *
         * @param observationId
         *                      Observation id to set
         */
        void setObservationId(final long observationId);
    }
    
    
    interface HasLocale {
        String LOCALE = "locale";

        Locale getLocale();

        void setLocale(Locale locale);

        boolean isSetLocale();
    }

    interface HasSamplingGeometry {

        String SAMPLING_GEOMETRY = "samplingGeometry";

        Geometry getSamplingGeometry();

        void setSamplingGeometry(Geometry samplingGeometry);

        boolean hasSamplingGeometry();

    }
    
    interface HasDescriptionXml<T> {
        
        String DESCRIPTION_XML = "descriptionXml";

        String getDescriptionXml();

        T setDescriptionXml(String descriptionXml);

        default boolean isSetDescriptionXml() {
            return getDescriptionXml() != null && !getDescriptionXml().isEmpty();
        }
    }

    interface HasRemarks<T> {
        /**
         * @return the remarks
         */
        String getRemarks();

        /**
         * @param remarks
         *            the remarks to set
         */
        T setRemarks(String remarks);

        default boolean isSetRemarks() {
            return getRemarks() != null && !getRemarks().isEmpty();
        }
    }
}
