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

package org.n52.series.db.beans;

import org.locationtech.jts.geom.Geometry;
import org.n52.series.db.beans.i18n.I18nEntity;
import org.n52.series.db.beans.parameter.ParameterEntity;
import org.n52.series.db.beans.sta.AbstractObservationEntity;
import org.n52.series.db.common.LocaleHelper;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Interfaces that entities can implement to share constants and to make clear which entities have which
 * relations. Allows to throw compile time errors for non existing relations.
 *
 * @author <a href="mailto:c.autermann@52north.org">Christian Autermann</a>
 * @since 1.0.0
 */
public interface HibernateRelations {

    String SRID = "srid";

    String GEOMETRY_ENTITY = "geometryEntity";

    String P = "parents";

    String C = "children";

    interface HasId {
        Long getId();

        void setId(Long id);
    }

    interface HasIdentifier {

        String IDENTIFIER = "identifier";

        String getIdentifier();

        default void setIdentifier(String identifier) {
            setIdentifier(identifier, false);
        }

        void setIdentifier(String identifier, boolean staSupportsUrls);

        default boolean isSetIdentifier() {
            return (getIdentifier() != null) && !getIdentifier().isEmpty();
        }

        default String getDomain() {
            return getIdentifier();
        }

        default void setDomain(String domain) {
            setIdentifier(domain);
        }

        /**
         * Is identifier set
         *
         * @return <code>true</code>, if identifier is set
         */
        default boolean isSetDomain() {
            return isSetIdentifier();
        }
    }

    interface HasStaIdentifier extends HasIdentifier {

        String STA_IDENTIFIER = "staIdentifier";

        String getStaIdentifier();

        void setStaIdentifier(String staIdentifier);

        default boolean isSetStaIdentifier() {
            return (getStaIdentifier() != null) && !getStaIdentifier().isEmpty();
        }

        default String generateUUID() {
            return UUID.randomUUID().toString();
        }

        default String processIdentifierForSta(String identifier) {
            if (identifier == null || identifier.isEmpty()) {
                return generateUUID();
            } else {
                if (identifier.contains("/")) {
                    try {
                        URI uri = URI.create(identifier.trim());
                        StringBuffer buffer = new StringBuffer("urn");
                        addValue(buffer, uri.getScheme());
                        addHost(buffer, uri.getHost());
                        addPort(buffer, uri.getPort());
                        addPath(buffer, uri.getPath());
                        addFragment(buffer, uri.getFragment());
                        return buffer.toString();
                    } catch (Exception e) {
                        try {
                            return UUID.nameUUIDFromBytes(identifier.trim().getBytes("UTF8")).toString();
                        } catch (UnsupportedEncodingException e1) {
                            return generateUUID();
                        }
                    }
                }
            }
            return identifier.trim();
        }

        default void addValue(StringBuffer buffer, String value) {
            addValue(buffer, value, true);
        }

        default void addValue(StringBuffer buffer, String value, boolean addEmpty) {
            if (value != null && ((addEmpty && value.isEmpty()) || !value.isEmpty())) {
                buffer.append(":").append(value);
            }
        }

        default void addHost(StringBuffer buffer, String value) {
            if (value != null) {
                addValues(value, ".", buffer);
            }
        }

        default void addPort(StringBuffer buffer, int value) {
            if (value >= 0) {
                addValue(buffer, Integer.toString(value));
            }
        }

        default void addPath(StringBuffer buffer, String value) {
            if (value != null) {
                addValues(value, "/", buffer);
            }
        }

        default void addFragment(StringBuffer buffer, String value) {
            if (value != null) {
                buffer.append("#").append(value);
            }
        }

        default void addValues(String value, String splitChar, StringBuffer buffer) {
            if (!value.contains(splitChar)) {
                addValue(buffer, value);
            } else {
                Arrays.asList(value.split(Pattern.quote(splitChar))).stream().forEach(v -> addValue(buffer, v, false));
            }
        }

    }

    interface IsStaEntity {

    }

    interface HasDomainId {
        String IDENTIFIER = HasIdentifier.IDENTIFIER;

        String getIdentifier();

        void setIdentifier(String identifier);

        /**
         * Is identifier set
         *
         * @return <code>true</code>, if identifier is set
         */
        boolean isSetIdentifier();
    }

    interface HasDescription {
        String DESCRIPTION = "description";

        String PROPERTY_DESCRIPTION = DESCRIPTION;

        String getDescription();

        void setDescription(String description);

        /**
         * Is description set
         *
         * @return <code>true</code>, if description is set
         */
        default boolean isSetDescription() {
            return (getDescription() != null) && !getDescription().isEmpty();
        }
    }

    interface HasIdentifierCodespace {
        String IDENTIFIER_CODESPACE = "identifierCodespace";

        CodespaceEntity getIdentifierCodespace();

        void setIdentifierCodespace(CodespaceEntity codespace);

        default boolean isSetIdentifierCodespace() {
            return (getIdentifierCodespace() != null) && !getIdentifierCodespace().isSetName();
        }
    }

    interface HasNameCodespace {

        String NAME_CODESPACE = "nameCodespace";

        String PROPERTY_NAME_CODESPACE = NAME_CODESPACE;

        String PROPERTY_CODESPACE_NAME = PROPERTY_NAME_CODESPACE;

        CodespaceEntity getNameCodespace();

        void setNameCodespace(CodespaceEntity codespaceName);

        default boolean isSetNameCodespace() {
            return (getNameCodespace() != null) && !getNameCodespace().isSetName();
        }
    }

    interface HasDisabledFlag {
        String DIABLED = "disabled";

        void setDisabled(boolean disabled);

        boolean getDisabled();

        boolean isDisabled();
    }

    interface HasDeletedFlag {
        String DELETED = "deleted";

        void setDeleted(boolean deleted);

        boolean getDeleted();

        boolean isDeleted();
    }

    interface HasPublishedFlag {
        String PUBLISHED = "published";

        HasPublishedFlag setPublished(boolean published);

        boolean isPublished();
    }

    interface HasFeatureType {
        String FEATURE_OF_INTEREST_TYPE = "featureType";

        FormatEntity getFeatureType();

        void setFeatureType(FormatEntity featureOfInterestType);
    }

    interface HasFeatureTypes {
        String FEATURE__TYPES = "featureTypes";

        Set<FormatEntity> getFeatureTypes();

        void setFeatureTypes(Set<FormatEntity> featureOfInterestTypes);

        default boolean hasFeatureTypes() {
            return (getFeatureTypes() != null) && !getFeatureTypes().isEmpty();
        }

    }

    interface HasFeatureGetter {
        String FEATURE_OF_INTEREST = "feature";

        AbstractFeatureEntity<?> getFeature();
    }

    interface HasFeature extends HasFeatureGetter {

        void setFeature(AbstractFeatureEntity<?> feature);

        default boolean hasFeature() {
            return getFeature() != null;
        }
    }

    interface HasReadableObservationContext extends HasObservablePropertyGetter, HasProcedureGetter, HasFeatureGetter {
    }

    interface HasWriteableObservationContext
            extends HasReadableObservationContext, HasObservableProperty, HasProcedure, HasFeature, HasOffering {
    }

    interface HasGeometry {
        String GEOMETRY = GEOMETRY_ENTITY;

        GeometryEntity getGeometryEntity();

        void setGeometry(Geometry geometry);

        void setGeometryEntity(GeometryEntity geometryEntity);

        default Geometry getGeometry() {
            return getGeometryEntity() != null ? getGeometryEntity().getGeometry() : null;
        }

        default boolean isSetGeometry() {
            return getGeometryEntity() != null;
        }
    }

    interface HasHiddenChildFlag {
        String HIDDEN_CHILD = "hiddenChild";

        void setHiddenChild(boolean hiddenChild);

        boolean isHiddenChild();
    }

    interface HasChildFlag {
        String CHILD = C;

        void setChild(boolean child);

        boolean isChild();
    }

    interface HasParentFlag {
        String PARENT = P;

        void setParent(boolean parent);

        boolean isParent();
    }

    interface HasName {

        String NAME = "name";
        String PROPERTY_NAME = NAME;

        String getName();

        void setName(String name);

        default boolean isSetName() {
            return (getName() != null) && !getName().isEmpty();
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

    interface HasObservableProperty extends HasObservablePropertyGetter {

        void setObservableProperty(PhenomenonEntity observableProperty);

        default boolean hasObservableProperty() {
            return getObservableProperty() != null;
        }
    }

    interface HasOMObservationType {
        String OBSERVATION_TYPE = "omObservationType";

        FormatEntity getOMObservationType();

        void setOMObservationType(FormatEntity observationType);

        boolean isSetOMObservationType();
    }

    interface HasObservationTypes {
        String OBSERVATION_TYPES = "omObservationTypes";

        Set<FormatEntity> getObservationTypes();

        void setObservationTypes(Set<FormatEntity> observationTypes);

        default boolean hasObservationTypes() {
            return (getObservationTypes() != null) && !getObservationTypes().isEmpty();
        }
    }

    interface HasOffering {
        String OFFERING = "offering";

        void setOffering(OfferingEntity offering);

        OfferingEntity getOffering();

        boolean isSetOffering();
    }

    interface HasSamplingTime {
        /**
         * @return the samplingTimeStart
         */
        Date getSamplingTimeStart();

        /**
         * @param samplingTimeStart
         *            the samplingTimeStart
         */
        void setSamplingTimeStart(Date samplingTimeStart);

        /**
         * @return the samplingTimeEnd
         */
        Date getSamplingTimeEnd();

        /**
         * @param samplingTimeEnd
         *            the samplingTimeEnd
         */
        void setSamplingTimeEnd(Date samplingTimeEnd);

        default boolean hasSamplingTimeStart() {
            return getSamplingTimeStart() != null;
        }

        default boolean hasSamplingTimeEnd() {
            return getSamplingTimeStart() != null;
        }

        default boolean isSamplingTimePeriod() {
            return hasSamplingTimeStart() && hasSamplingTimeEnd()
                    && !getSamplingTimeStart().equals(getSamplingTimeEnd());
        }
    }

    interface HasPhenomenonTime extends HasSamplingTime {

        /**
         * Get the start phenomenon time
         *
         * @return Start phenomenon time
         * @deprecated use {@link HasPhenomenonTime#getSamplingTimeStart()}
         */
        @Deprecated
        default Date getPhenomenonTimeStart() {
            return getSamplingTimeStart();
        }

        /**
         * Set the start phenomenon time
         *
         * @param phenomenonTimeStart
         *            Start phenomenon time to set
         * @deprecated use {@link HasPhenomenonTime#setSamplingTimeStart(Date)}
         */
        @Deprecated
        default void setPhenomenonTimeStart(Date phenomenonTimeStart) {
            setSamplingTimeStart(phenomenonTimeStart);
        }

        @Deprecated
        default boolean hasPhenomenonTimeStart() {
            return hasSamplingTimeStart();
        }

        /**
         * Get the end phenomenon time
         *
         * @return End phenomenon time
         * @deprecated use {@link HasPhenomenonTime#getSamplingTimeEnd()}
         */
        @Deprecated
        default Date getPhenomenonTimeEnd() {
            return getSamplingTimeEnd();
        }

        /**
         * Set the end phenomenon time
         *
         * @param phenomenonTimeEnd
         *            End phenomenon time to set
         * @deprecated use {@link HasPhenomenonTime#setSamplingTimeEnd(Date)}
         */
        @Deprecated
        default void setPhenomenonTimeEnd(Date phenomenonTimeEnd) {
            setSamplingTimeEnd(phenomenonTimeEnd);
        }

        @Deprecated
        default boolean hasPhenomenonTimeEnd() {
            return hasSamplingTimeEnd();
        }
    }

    interface HasResultTimes {

        String RESULT_TIME_START = "resultTimeStart";

        String RESULT_TIME_END = "resultTimeEnd";

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
         *            Start result time to set
         */
        void setResultTimeStart(Date resultTimeStart);

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
         *            End result time to set
         */
        void setResultTimeEnd(Date resultTimeEnd);

        default boolean hasResultTimeEnd() {
            return getResultTimeEnd() != null;
        }
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
         *            Result tiem to set
         */
        void setResultTime(Date resultTime);

        default boolean hasResultTime() {
            return getResultTime() != null;
        }
    }

    interface HasProcedureGetter {
        String PROCEDURE = "procedure";

        ProcedureEntity getProcedure();
    }

    interface HasProcedure extends HasProcedureGetter {

        void setProcedure(ProcedureEntity procedure);

        default boolean hasProcedure() {
            return getProcedure() != null;
        }
    }

    interface HasProcedureDescriptionFormat {
        String PROCEDURE_DESCRIPTION_FORMAT = "format";

        FormatEntity getFormat();

        void setFormat(FormatEntity procedureDescriptionFormat);
    }

    interface HasRelatedFeatures {
        String RELATED_FEATURES = "relatedFeatures";

        Set<RelatedFeatureEntity> getRelatedFeatures();

        void setRelatedFeatures(Set<RelatedFeatureEntity> relatedFeatures);

        default boolean hasRelatedFeatures() {
            return (getRelatedFeatures() != null) && !getRelatedFeatures().isEmpty();
        }
    }

    interface HasResultEncoding {
        String RESULT_ENCODING = "encoding";

        String getEncoding();

        void setEncoding(String resultEncoding);

        default boolean isSetEncoding() {
            return (getEncoding() != null) && !getEncoding().isEmpty();
        }
    }

    interface HasResultStructure {
        String RESULT_STRUCTURE = "structure";

        String getStructure();

        void setStructure(String resultStructure);

        default boolean isSetStructure() {
            return (getStructure() != null) && !getStructure().isEmpty();
        }
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
        default boolean isSetUnit() {
            return getUnit() != null;
        }
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
         *            Start valid time to set
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
         *            End valid time to set
         */
        void setValidTimeEnd(Date validTimeEnd);

        default boolean isSetValidTime() {
            return isSetValidStartTime() && isSetValidEndTime();
        }

        default boolean isSetValidStartTime() {
            return getValidTimeStart() != null;
        }

        default boolean isSetValidEndTime() {
            return getValidTimeEnd() != null;
        }
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

    interface HasUnitValue<T> extends HasUnit, HasValue<T> {
    }

    interface HasOfferings {
        String OFFERINGS = "offerings";

        Set<OfferingEntity> getOfferings();

        // Object getOffering();
        void setOfferings(Object offerings);

        default boolean isSetOfferings() {
            return hasOfferings();
        }

        default boolean hasOfferings() {
            return (getOfferings() != null) && !getOfferings().isEmpty();
        }

    }

    interface HasParameters {
        String PARAMETERS = "parameters";

        Set<ParameterEntity<?>> getParameters();

        void setParameters(Set<ParameterEntity<?>> parameters);

        void addParameters(Set<ParameterEntity<?>> parameters);

        void addParameter(ParameterEntity<?> parameter);

        default boolean hasParameters() {
            return (getParameters() != null) && !getParameters().isEmpty();
        }

    }

    interface HasRelatedObservations {
        String RELATED_OBSERVATIONS = "related_observations";

        Set<RelatedDataEntity> getRelatedObservations();

        void setRelatedObservations(Set<RelatedDataEntity> relatedObservations);

        default boolean hasRelatedObservations() {
            return (getRelatedObservations() != null) && !getRelatedObservations().isEmpty();
        }

    }

    interface HasObservableProperties {
        String OBSERVABLE_PROPERTIES = "observableProperties";

        Set<PhenomenonEntity> getObservableProperties();

        void setObservableProperties(Set<PhenomenonEntity> observableProperties);
    }

    interface GeoColumnsId {
        String COORD_DIMENSION = "coordDimension";

        String SRID = HibernateRelations.SRID;

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
        String SRID = HibernateRelations.SRID;

        int getSrid();

        void setSrid(int srid);

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

        Object getLon();

        void setLon(Object longitude);

        Object getLat();

        void setLat(Object latitude);

        /**
         * Are longitude and latitude set
         *
         * @return <code>true</code>, if longitude and latitude are set
         */
        default boolean isSetLongLat() {
            return (getLon() != null) && (getLat() != null);
        }

        Object getAlt();

        void setAlt(Object altitude);

        /**
         * Is altitude set
         *
         * @return <code>true</code>, if altitude is set
         */
        default boolean isSetAlt() {
            return getAlt() != null;
        }

        boolean isSpatial();
    }

    interface HasProcedureHistory {
        String VALID_PROCEDURE_TIMES = "procedureGistory";

        Set<ProcedureHistoryEntity> getProcedureHistory();

        void setProcedureHistory(Set<ProcedureHistoryEntity> procedureHistory);

        default boolean hasProcedureHistory() {
            return (getProcedureHistory() != null) && !getProcedureHistory().isEmpty();
        }
    }

    interface HasParentChildren<T> {
        String PARENTS = P;

        String CHILDREN = C;

        Set getParents();

        void setParents(Set parents);

        void addParent(T parent);

        default boolean hasParents() {
            return (getParents() != null) && !getParents().isEmpty();
        }

        Set getChildren();

        void setChildren(Set children);

        void addChild(T child);

        default boolean hasChildren() {
            return (getChildren() != null) && !getChildren().isEmpty();
        }
    }

    interface HasObservationId {
        String OBS_ID = "id";

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
         *            Observation id to set
         */
        void setObservationId(long observationId);
    }

    interface HasLocale {
        String LOCALE = "locale";

        Locale getLocale();

        void setLocale(Locale locale);

        boolean isSetLocale();
    }

    interface HasSamplingGeometry {

        String SAMPLING_GEOMETRY = GEOMETRY_ENTITY;

        Geometry getSamplingGeometry();

        void setSamplingGeometry(Geometry samplingGeometry);

        default boolean hasSamplingGeometry() {
            return (getSamplingGeometry() != null) && !getSamplingGeometry().isEmpty();
        }

    }

    interface HasXml {

        String XML = "xml";

        String getXml();

        void setXml(String xml);

        default boolean isSetXml() {
            return (getXml() != null) && !getXml().isEmpty();
        }
    }

    interface HasRemarks {
        /**
         * @return the remarks
         */
        String getRemarks();

        /**
         * @param remarks
         *            the remarks to set
         */
        void setRemarks(String remarks);

        default boolean isSetRemarks() {
            return (getRemarks() != null) && !getRemarks().isEmpty();
        }
    }

    interface HasDatasetType {

        void setDatasetType(String datasetType);

        String getDatasetType();

        default boolean isSetDatasetType() {
            return (getDatasetType() != null) && !getDatasetType().isEmpty();
        }

    }

    interface HasDataset {

        void setDataset(DatasetEntity dataset);

        DatasetEntity getDataset();

        default boolean isSetDataset() {
            return getDataset() != null;
        }

    }

    interface HasDatasets {

        String DATASETS = "datasets";

        String PROPERTY_DATASETS = DATASETS;

        void setDatasets(Set<DatasetEntity> datasets);

        Set<DatasetEntity> getDatasets();

        default boolean hasDatasets() {
            return getDatasets() != null && !getDatasets().isEmpty();
        }

    }

    interface HasAbstractDatasets {

        void setDatasets(Set<AbstractDatasetEntity> datastreams);

        Set<AbstractDatasetEntity> getDatasets();

        default void addDatastream(AbstractDatasetEntity datastream) {
            if (getDatasets() == null) {
                setDatasets(new LinkedHashSet<>());
            }
            getDatasets().add(datastream);
        }

        default boolean hasDatastreams() {
            return getDatasets() != null && !getDatasets().isEmpty();
        }

    }

    interface HasAbstractDataset {

        void setDataset(AbstractDatasetEntity datastreams);

        AbstractDatasetEntity getDataset();

        default boolean hasDataset() {
            return getDataset() != null;
        }

    }

    interface HasTranslations {

        String TRANSLATIONS = "translations";

        String PROPERTY_TRANSLATIONS = TRANSLATIONS;

        String LOCALE_REGEX = "[-_# ]";

        Set<I18nEntity<? extends Describable>> getTranslations();

        void setTranslations(Set<I18nEntity<? extends Describable>> translations);

        default boolean hasTranslations() {
            return getTranslations() != null && !getTranslations().isEmpty();
        }

        default boolean noTranslationAvailable(String locale) {
            return getTranslations() == null || locale == null || getTranslations().isEmpty() || locale.isEmpty();
        }

        default String getCountryCode(String locale) {
            if (locale != null) {
                return locale.split(LOCALE_REGEX).length > 1 ? locale.split(LOCALE_REGEX)[1]
                        : locale.split(LOCALE_REGEX)[0];
            }
            return "";
        }

        default I18nEntity<? extends Describable> getTranslation(String locale) {
            if (!noTranslationAvailable(locale)) {
                String countryCode = getCountryCode(locale);
                Locale matchingLocale = getMatchingLocale(getTranslations(), locale);
                for (I18nEntity<? extends Describable> translation : getTranslations()) {
                    Locale translatedLocale = LocaleHelper.decode(translation.getLocale());
                    if (translatedLocale.equals(matchingLocale)
                            || translatedLocale.getCountry().equalsIgnoreCase(countryCode)) {
                        return translation;
                    }
                }
            }
            return null;
        }

        default Locale getMatchingLocale(Set<I18nEntity<? extends Describable>> translations, String queriedLocale) {
            List<LanguageRange> localeRange = Locale.LanguageRange.parse(queriedLocale);
            return Locale.lookup(localeRange,
                    translations.stream().map(t -> LocaleHelper.decode(t.getLocale())).collect(Collectors.toSet()));
        }
    }

    public interface HasNameTranslation extends HasName, HasTranslations {
        default boolean isi18nNameAvailable(String locale) {
            return getNameI18n(locale) != null && !getNameI18n(locale).isEmpty();
        }

        default String getNameI18n(String locale) {
            if (noTranslationAvailable(locale)) {
                return getName();
            }
            I18nEntity<? extends Describable> translation = getTranslation(locale);
            return translation != null ? translation.getName() : getName();
        }
    }

    public interface HasDescriptionTranslation extends HasDescription, HasTranslations {

        default String getDescriptionI18n(String locale) {
            if (noTranslationAvailable(locale)) {
                return getDescription();
            }
            I18nEntity<? extends Describable> translation = getTranslation(locale);
            return translation != null ? translation.getDescription() : getDescription();
        }
    }

    interface HasTags {

        String TAGS = "tags";

        String PROPERTY_TAGS = TAGS;

        void setTags(Set<TagEntity> tags);

        Set<TagEntity> getTags();

        default boolean hasTagss() {
            return getTags() != null && !getTags().isEmpty();
        }

    }

    interface IsProcessed {

        boolean isProcessed();

        void setProcessed(boolean processsed);
    }

    interface HasPlatform {

        void setPlatform(PlatformEntity platform);

        PlatformEntity getPlatform();

        default boolean hasPlatform() {
            return getPlatform() != null;
        }

    }

    @Deprecated
    interface HasThing extends HasPlatform {

        default void setThing(PlatformEntity thing) {
            setPlatform(thing);
        }

        default PlatformEntity getThing() {
            return getPlatform();
        }

        default boolean hasThing() {
            return hasPlatform();
        }

    }

    interface HasObservations {

        void setObservations(Set<AbstractObservationEntity> observations);

        Set<AbstractObservationEntity> getObservations();

        default boolean hasObservations() {
            return getObservations() != null;
        }

    }

    interface HasVerticalFromTo {

        BigDecimal getVerticalFrom();

        void setVerticalFrom(BigDecimal validTimeStart);

        BigDecimal getVerticalTo();

        void setVerticalTo(BigDecimal validTimeEnd);

        default boolean isSetVerticalFromTo() {
            return isSetVerticalFrom() && isSetVerticalTo();
        }

        default boolean isSetVerticalFrom() {
            return getVerticalFrom() != null;
        }

        default boolean isSetVerticalTo() {
            return getVerticalTo() != null;
        }
    }
}
