# Database table/column description
This page describes the tables and columns in the database.
The *SQL type* column in the tables is generated for Hibernate dialect: *TimestampWithTimeZonePostgisPG95Dialect*

## Tables
- [category](#category)
- [category_i18n](#category_i18n)
- [codespace](#codespace)
- [composite_phenomenon](#composite_phenomenon)
- [dataset](#dataset)
- [dataset_i18n](#dataset_i18n)
- [dataset_parameter](#dataset_parameter)
- [dataset_reference](#dataset_reference)
- [datastream](#datastream)
- [datastream_dataset](#datastream_dataset)
- [datastream_i18n](#datastream_i18n)
- [feature](#feature)
- [feature_hierarchy](#feature_hierarchy)
- [feature_i18n](#feature_i18n)
- [feature_parameter](#feature_parameter)
- [format](#format)
- [historical_location](#historical_location)
- [location](#location)
- [location_historical_location](#location_historical_location)
- [location_i18n](#location_i18n)
- [measuring_program](#measuring_program)
- [measuring_program_dataset](#measuring_program_dataset)
- [measuring_program_i18n](#measuring_program_i18n)
- [observation](#observation)
- [observation_i18n](#observation_i18n)
- [observation_parameter](#observation_parameter)
- [offering](#offering)
- [offering_feature_type](#offering_feature_type)
- [offering_hierarchy](#offering_hierarchy)
- [offering_i18n](#offering_i18n)
- [offering_observation_type](#offering_observation_type)
- [offering_related_feature](#offering_related_feature)
- [parameter](#parameter)
- [phenomenon](#phenomenon)
- [phenomenon_i18n](#phenomenon_i18n)
- [platform](#platform)
- [platform_i18n](#platform_i18n)
- [platform_parameter](#platform_parameter)
- [procedure](#procedure)
- [procedure_hierarchy](#procedure_hierarchy)
- [procedure_history](#procedure_history)
- [procedure_i18n](#procedure_i18n)
- [related_dataset](#related_dataset)
- [related_feature](#related_feature)
- [related_observation](#related_observation)
- [result_template](#result_template)
- [sampling](#sampling)
- [sampling_dataset](#sampling_dataset)
- [sampling_i18n](#sampling_i18n)
- [service](#service)
- [thing_location](#thing_location)
- [unit](#unit)
- [unit_i18n](#unit_i18n)
- [value_blob](#value_blob)
- [value_profile](#value_profile)
- [value_profile_i18n](#value_profile_i18n)

### category
**Description**: Storage of the categories which should be used to group the data (e.g. grouping of phemomenon).

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| category_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the category which can be used for filtering. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321 | true | - | varchar(255) | string | 
| name | The human readable name of the category. | false | - | varchar(255) | string | 
| description | A short description of the category | false | - | text | text | 

[top](#Tables)

### category_i18n
**Description**: Storage for internationalizations of categories.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| category_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_category_id | Reference to the category table this internationalization belongs to. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | int8 | org.n52.series.db.beans.CategoryEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the category | false | - | varchar(255) | string | 
| description | Locale/language specific description of the category | false | - | text | text | 

[top](#Tables)

### codespace
**Description**: Storage of codespaces which can be domain specific.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| codespace_id | PK column of the table | true | - | int8 | long | 
| name | Name/definition of the codespace, e.g. of a domain | true | - | varchar(255) | string | 

[top](#Tables)

### composite_phenomenon
**Description**: Storage of hierarchies between phenomenon, e.g. for composite phenomenon like weather with temperature, windspeed, ...

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_phenomenon_id | Reference to the child phenomenon in phenomenon table. | true | - | int8 | long | 
| fk_parent_phenomenon_id | Reference to the parent phenomenon in phenomenon table. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 

[top](#Tables)

### dataset
**Description**: Storage of the dataset, the core table of the whole database model.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| dataset_id | PK column of the table | true | - | int8 | long | 
| dataset_type | Indicator whether the dataset provides individualObservation (individual observations), timeseries (timeseries obervations) or trajectories (trajectory observations). | true | 'not_initialized' | varchar(255) | org.hibernate.type.EnumType | 
| observation_type | Indicator whether the dataset observations are of type simple (a simple observation, e.g. a scalar value like the temperature) or profile (profile observations) | true | 'not_initialized' | varchar(255) | org.hibernate.type.EnumType | 
| value_type | Indicator of the type of the single values. Valid values are quantity (scalar values), count (integer values), text (textual values), category (categorical values), bool (boolean values), reference (references, e.g. link to a source, photo, video) | true | 'not_initialized' | varchar(255) | org.hibernate.type.EnumType | 
| fk_procedure_id | Reference to the procedure that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_phenomenon_id | Reference to the phenomenon that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| fk_offering_id | Reference to the offering that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| fk_category_id | Reference to the category that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.CategoryEntity | 
| fk_feature_id | Reference to the feature that belongs that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.FeatureEntity | 
| fk_platform_id | Reference to the platform that belongs that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.PlatformEntity | 
| fk_format_id | Reference to the observationType in the format table. Required by the SOS to persist the valid observationType for the dataset. | false | - | int8 | org.n52.series.db.beans.FormatEntity | 
| fk_unit_id | Reference to the unit of the observations that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.UnitEntity | 
| is_deleted | Flag that indicates if this dataset is deleted | true | 0 | int2 | small_boolean | 
| is_disabled | Flag that indicates if this dataset is disabled for insertion of new data | true | 0 | int2 | small_boolean | 
| is_published | Flag that indicates if this dataset should be published | true | 1 | int2 | small_boolean | 
| is_mobile | Flag that indicates if the procedure is mobile (1/true) or stationary (0/false). | false | 0 | int2 | small_boolean | 
| is_insitu | Flag that indicates if the procedure is insitu (1/true) or remote (0/false). | false | 1 | int2 | small_boolean | 
| is_hidden | Flag that indicates if this dataset should be hidden, e.g. for sub-datasets of a complex datasets | true | 0 | int2 | small_boolean | 
| origin_timezone | Define the origin timezone of the dataset timestamps. Possible values are offset (+02:00), id (CET) or full name (Europe/Berlin). It no time zone is defined, UTC would be used as default. | false | - | varchar(40) | string | 
| first_time | The timestamp of the temporally first observation that belongs to this dataset. | false | - | timestamp with time zone | timestamp | 
| last_time | The timestamp of the temporally last observation that belongs to this dataset. | false | - | timestamp with time zone | timestamp | 
| first_value | The value of the temporally first observation that belongs to this dataset. | false | - | numeric(20, 10) | big_decimal | 
| last_value | The value of the temporally last quantity observation that belongs to this dataset. | false | - | numeric(20, 10) | big_decimal | 
| fk_first_observation_id | Reference to the temporally first observation in the observation table that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.DataEntity | 
| fk_last_observation_id | Reference to the temporally last observation in the observation table that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.DataEntity | 
| decimals | Number of decimals that should be present in the output of the observation values. If no value is set, all decimals would be present. | false | - | int4 | integer | 
| identifier | Unique identifier of the dataset which can be used for filtering, e.g. GetObservationById in the SOS and can be encoded in WaterML 2.0 oder TimeseriesML 1.0 outputs. | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the dataset identifier, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the dataset. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the dataset name, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the dataset | false | - | text | text | 
| fk_value_profile_id | Reference to the vertical metadata that belongs to this profile dataset. | false | - | int8 | org.n52.series.db.beans.VerticalMetadataEntity | 

[top](#Tables)

### dataset_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| dataset_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_dataset_id | Reference to the dataset table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the dataset entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the dataset entity | false | - | text | text | 

[top](#Tables)

### dataset_parameter
**Description**: Storage of relations between dataset and related parameter

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id | The reference to the dataset in the dataset table | true | - | int8 | long | 
| fk_parameter_id | The reference to the parameter in the dataset parameter | true | - | int8 | org.n52.series.db.beans.parameter.ParameterEntity | 

[top](#Tables)

### dataset_reference
**Description**: Storage of reference datasets, e.g. level zero, medium water level,etc. for water level.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id_from | Reference to the dataset that has reference datasets | true | - | int8 | long | 
| sort_order | Provides the sort order for the reference datasets. | true | - | int4 | integer | 
| fk_dataset_id_to | Reference to the dataset that belongs to another dataset and provides values like level zero, medium water level,etc. for water level. | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 

[top](#Tables)

### datastream
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| datastream_id | - | true | - | int8 | long | 
| name | - | true | - | varchar(255) | string | 
| description | - | true | - | text | text | 
| identifier | Unique identifier of the datastream. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321. | true | - | varchar(255) | string | 
| observed_area | - | false | - | GEOMETRY | jts_geometry | 
| result_time_start | - | false | NULL | timestamp with time zone | timestamp | 
| result_time_end | - | false | NULL | timestamp with time zone | timestamp | 
| phenomenon_time_start | - | false | NULL | timestamp with time zone | timestamp | 
| phenomenon_time_end | - | false | NULL | timestamp with time zone | timestamp | 
| fk_format_id | - | true | - | int8 | org.n52.series.db.beans.FormatEntity | 
| fk_unit_id | - | false | - | int8 | org.n52.series.db.beans.UnitEntity | 
| fk_thing_id | - | true | - | int8 | org.n52.series.db.beans.PlatformEntity | 
| fk_procedure_id | - | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_phenomenon_id | - | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 

[top](#Tables)

### datastream_dataset
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_datastream_id | - | true | - | int8 | long | 
| fk_dataset_id | - | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 

[top](#Tables)

### datastream_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| datastream_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_datastream_id | Reference to the feature table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.sta.DatastreamEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the datastream | false | - | varchar(255) | string | 
| description | Locale/language specific description of the datastream | false | - | text | text | 

[top](#Tables)

### feature
**Description**: Storage of the features (OfInterest). A feature represents the observed location, route, or area. As examples, the location of the weather station or the water level location, a ferry (Cuxhaven-Helgoland) or a lake of interest.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| feature_id | PK column of the table | true | - | int8 | long | 
| discriminator | Indicator used by Hibernate to map value specific entities (e.g. of a WaterML 2.0 MonitoringPoint) which are stored in separate tables. | false | - | varchar(255) | string | 
| fk_format_id | Reference to the featureType in the format table. Required by the SOS to identify the typ of the feature, e.g. http://www.opengis.net/def/samplingFeatureType/OGC-OM/2.0/SF_SamplingPoint. | true | - | int8 | org.n52.series.db.beans.FormatEntity | 
| identifier | Unique identifier of the feature which is used for filtering. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321 | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the feature identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the feature. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the feature name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the feature | false | - | text | text | 
| xml | The XML encoded representation of the feature. | false | - | text | text | 
| url | Optional URL to an external resource that describes the feature, e.g. a WFS | false | - | varchar(255) | string | 
| geom | The geometry/location of feature | false | - | GEOMETRY | jts_geometry | 

[top](#Tables)

### feature_hierarchy
**Description**: Storage of hierarchies between features

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_feature_id | Reference to the child feature in feature table. | true | - | int8 | long | 
| fk_parent_feature_id | Reference to the parent feature in feature table. | true | - | int8 | org.n52.series.db.beans.AbstractFeatureEntity | 

[top](#Tables)

### feature_i18n
**Description**: Storage for internationalizations of features.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| feature_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_feature_id | Reference to the feature table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.FeatureEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the feature | false | - | varchar(255) | string | 
| description | Locale/language specific description of the feature | false | - | text | text | 

[top](#Tables)

### feature_parameter
**Description**: Storage of relations between feature and related parameter

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_feature_id | The reference to the feature in the feature table | true | - | int8 | long | 
| fk_parameter_id | The reference to the parameter in the feature parameter | true | - | int8 | org.n52.series.db.beans.parameter.ParameterEntity | 

[top](#Tables)

### format
**Description**: Storage of types (feature, observation) and formats (procedure)., e.g. http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement and http://www.opengis.net/sensorml/2.0

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| format_id | PK column of the table | true | - | int8 | long | 
| definition | The definition of the format. | true | - | varchar(255) | string | 

[top](#Tables)

### historical_location
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| historical_location_id | - | true | - | int8 | long | 
| identifier | Unique identifier of the HistoricalLocation. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321. | true | - | varchar(255) | string | 
| fk_thing_id | - | true | - | int8 | org.n52.series.db.beans.PlatformEntity | 
| time | - | true | - | timestamp with time zone | timestamp | 

[top](#Tables)

### location
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| location_id | - | true | - | int8 | long | 
| identifier | Unique identifier of the location. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321. | true | - | varchar(255) | string | 
| name | - | true | - | varchar(255) | string | 
| description | - | true | - | text | text | 
| location | - | false | - | text | text | 
| geom | - | false | - | GEOMETRY | jts_geometry | 
| fk_format_id | - | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

[top](#Tables)

### location_historical_location
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_location_id | - | true | - | int8 | long | 
| fk_historical_location_id | - | true | - | int8 | org.n52.series.db.beans.sta.HistoricalLocationEntity | 

[top](#Tables)

### location_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| location_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_location_id | Reference to the feature table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.sta.LocationEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the location | false | - | varchar(255) | string | 
| description | Locale/language specific description of the location | false | - | text | text | 
| location | Locale/language specific location property of the location | false | - | text | text | 

[top](#Tables)

### measuring_program
**Description**: Storage of the measuring program which describes a measurement campaign and summarizes all sampling, time series, etc.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| measuring_program_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the measuring program which would be the ORDER_ID in the output of the REST API. | true | - | varchar(255) | string | 
| name | The human readable name or label of the sampling. | false | - | varchar(255) | string | 
| description | A short description of the measuring program | false | - | text | text | 
| producer | The producer of the measuring program, e.g. name of a person or an organization | false | - | varchar(255) | string | 
| measuring_time_start | The timestamp when the measuring program period has started. | true | - | timestamp with time zone | timestamp | 
| measuring_time_end | The timestamp when the measuring program period has finished. | false | - | timestamp with time zone | timestamp | 

[top](#Tables)

### measuring_program_dataset
**Description**: Storage of relations between dataset and related measuring programs

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id | The reference to the dataset in the dataset table | true | - | int8 | long | 
| fk_measuring_program_id | The reference to the measuring program in the dataset measuring program | true | - | int8 | org.n52.series.db.beans.sampling.MeasuringProgramEntity | 

[top](#Tables)

### measuring_program_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| measuring_program_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_measuring_program_id | Reference to the measuring program table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.sampling.MeasuringProgramEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the measuring program entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the measuring program entity | false | - | text | text | 

[top](#Tables)

### observation
**Description**: Storage of the observation values with the timestamp and additional metadata. The metadata are height/depth values for profile observation and sampling geometries for trajectory observations. In each observation entry only one value_... column should be filled with a value!

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| observation_id | PK column of the table | true | - | int8 | long | 
| value_type | Indicator used by Hibernate to map value specific entities. Valid values are quantity (scalar values in value_quantity), count (integer values in value_count), text (textual values in value_text), category (categorical values in value_category), bool (boolean values in value_boolean), reference (references in value_reference, e.g. link to a source, photo, video) | true | - | varchar(255) | string | 
| fk_dataset_id | Reference to the dataset to which this observation belongs. | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| sampling_time_start | The timestamp when the observation period has started or the observation took place. In the the latter, sampling_time_start and sampling_time_end are equal. | true | - | timestamp with time zone | timestamp | 
| sampling_time_end | The timestamp when the measurement period has finished or the observation took place. In the the latter, sampling_time_start and sampling_time_end are equal. | true | - | timestamp with time zone | timestamp | 
| result_time | The timestamp when the observation was published. Might be identical with sampling_time_start and sampling_time_end. | true | - | timestamp with time zone | timestamp | 
| identifier | Unique identifier of the observation which can be for used filtering, e.g. GetObservationById in the SOS. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321 | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the data/observation identifier, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the observation. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the data/observation name, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the observation | false | - | text | text | 
| is_deleted | Flag that indicates if this observation is deleted | true | 0 | int2 | small_boolean | 
| valid_time_start | The timestamp from when the obervation is valid, e.g. forcaste observations | false | NULL | timestamp with time zone | timestamp | 
| valid_time_end | The timestamp until when the obervation is valid, e.g. forcaste observations | false | NULL | timestamp with time zone | timestamp | 
| sampling_geometry | The geometry that represents the location where the observation was observed, e.g. mobile observations (trajectories) where this geometry is different from the feature geometry. | false | - | GEOMETRY | jts_geometry | 
| value_identifier | Identifier of the value. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| value_name | Identifier of the name. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| value_description | Identifier of the description. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| vertical_from | The start level of a vertical observation, required for profile observations | true | 0 | numeric(20, 10) | big_decimal | 
| vertical_to | The end level or the level of a vertical observation, required for profile observations | true | 0 | numeric(20, 10) | big_decimal | 
| fk_parent_observation_id | Reference to the parent observation in the case of complex observations like profiles, complex or swedataarray observations. | false | - | int8 | long | 
| fk_sampling_id | The id of the sampling this observation belongs to. | false | - | int8 | org.n52.series.db.beans.sampling.SamplingEntity | 
| value_quantity | The quantity value of an observation (Measurement) | false | - | numeric(20, 10) | big_decimal | 
| detection_limit_flag | Flag that indicates if measured value lower/higher of the detection limit. | false | - | int2 | short | 
| detection_limit | The detection limit | false | - | numeric(20, 10) | big_decimal | 
| value_text | The textual value of an observation (TextObservation)) | false | - | varchar(255) | string | 
| value_reference | The reference value (URI) of an observation (ReferenceObservation) | false | - | varchar(255) | string | 
| value_count | The count/integer value of an observation (CountObservation) | false | - | int4 | integer | 
| value_boolean | The boolean value of an observation (Boolean/TruthObservation) | false | - | int2 | small_boolean | 
| value_category | The categorical value of an observation (CategoryObervation) | false | - | varchar(255) | string | 
| value_geometry | The geometry value of an observation (GeometryObservation) | false | - | GEOMETRY | geolatte_geometry | 
| value_array | The textual value of an observation (SweDataArrayObservation)) | false | - | text | text | 
| fk_result_template_id | Reference to the result template which holds the structure and encoding. | false | - | int8 | org.n52.series.db.beans.ResultTemplateEntity | 
| value | The blob value of an observation | false | - | oid | blob | 

[top](#Tables)

### observation_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| observation_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_observation_id | Reference to the data table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.DataEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the data entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the data entity | false | - | text | text | 
| value_name | Locale/language specific name of the data entity | false | - | varchar(255) | string | 
| value_description | Locale/language specific description of the data entity | false | - | varchar(255) | string | 

[top](#Tables)

### observation_parameter
**Description**: Storage of relations between data/observation and related parameter

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | The reference to the data/observation in the observation table | true | - | int8 | long | 
| fk_parameter_id | The reference to the parameter in the data/observation parameter | true | - | int8 | org.n52.series.db.beans.parameter.ParameterEntity | 

[top](#Tables)

### offering
**Description**: Storage of the offerings which is required by the SOS. An offering is used in SOS to group records according to specific criteria. In the INSPIRE context, an offering is an "INSPRE spatial dataset," an identifiable collection of spatial data.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| offering_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the offering which can be used for filtering. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321. | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the offering identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the offering. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the offering name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the offering | false | - | text | text | 
| sampling_time_start | The minimum samplingTimeStart of all observation that belong to this offering. If the column is empty, the information is calculated during the cache update and stored locally. Used for the capabilities of the SOS. | false | - | timestamp with time zone | timestamp | 
| sampling_time_end | The maximum samplingTimeStart of all observation that belong to this offering. If the column is empty, the information is calculated during the cache update and stored locally. Used for the capabilities of the SOS. | false | - | timestamp with time zone | timestamp | 
| result_time_start | The minimum resultTimeStart of all observation that belong to this offering. If the column is empty, the information is calculated during the cache update and stored locally. Used for the capabilities of the SOS. | false | - | timestamp with time zone | timestamp | 
| result_time_end | The maximum resultTimeEnd of all observation that belong to this offering. If the column is empty, the information is calculated during the cache update and stored locally. Used for the capabilities of the SOS. | false | - | timestamp with time zone | timestamp | 
| valid_time_start | The minimum validTimeStart of all observation that belong to this offering. If the column is empty, the information is calculated during the cache update and stored locally. Used for the capabilities of the SOS. | false | - | timestamp with time zone | timestamp | 
| valid_time_end | The maximum validTimeEnd of all observation that belong to this offering. If the column is empty, the information is calculated during the cache update and stored locally. Used for the capabilities of the SOS. | false | - | timestamp with time zone | timestamp | 
| geom | The envelope/geometry of all features or samplingGeometries of observations that belong to this offering. If the column is empty, the information is calculated during the cache update and stored locally. Used for the capabilities of the SOS. | false | - | GEOMETRY | jts_geometry | 

[top](#Tables)

### offering_feature_type
**Description**: Relation to store the valid  featureTypes for the offering

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_format_id | The reference of the related featureType from the format table | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

[top](#Tables)

### offering_hierarchy
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_offering_id | Reference to the child offering in offering table. | true | - | int8 | long | 
| fk_parent_offering_id | Reference to the parent offering in offering table. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 

[top](#Tables)

### offering_i18n
**Description**: Storage for internationalizations of offerings.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| offering_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_offering_id | Reference to the offering table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the offering | false | - | varchar(255) | string | 
| description | Locale/language specific description of the offering | false | - | text | text | 

[top](#Tables)

### offering_observation_type
**Description**: Relation to store the valid observationTypes for the offering

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_format_id | The reference of the related observationType from the format table | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

[top](#Tables)

### offering_related_feature
**Description**: Storage tfor the relation between offering and relatedFeature

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_related_feature_id | The reference to the relatedFeature from the relatedFeature table | true | - | int8 | org.n52.series.db.beans.RelatedFeatureEntity | 

[top](#Tables)

### parameter
**Description**: Storage for additional information for features, observations or datasets

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| parameter_id | PK column of the table | true | - | int8 | long | 
| type | Indicator used by Hibernate to map value specific entities. | true | - | varchar(255) | string | 
| name | The name of the parameter | true | - | varchar(255) | string | 
| last_update | Timestamp that provides the time of the last modification of this entry | false | - | timestamp with time zone | timestamp | 
| domain | The domain this parameter belongs to. | false | - | varchar(255) | string | 
| value_boolean | Storage of a boolean parameter value. | false | - | int2 | small_boolean | 
| value_category | Storage of a categorical parameter value. | false | - | varchar(255) | string | 
| fk_unit_id | Reference to the unit of this value in the unit table | false | - | int8 | org.n52.series.db.beans.UnitEntity | 
| value_count | Storage of a count parameter value. | false | - | int4 | integer | 
| value_quantity | Storage of a quantity parameter value. | false | - | numeric(19, 2) | big_decimal | 
| value_text | Storage of a textual parameter value. | false | - | varchar(255) | string | 
| value_xml | Storage of a XML encoded parameter value. | false | - | text | text | 
| value_json | Storage of a JSON encoded parameter value. | false | - | text | text | 

[top](#Tables)

### phenomenon
**Description**: Storage of the phenomenon/observableProperties, e.g. air temperature, water temperature, ...

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| phenomenon_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the phenomenon which can be used for filtering. Should be a URI (reference to a vacabulary entry), UUID. E.g. http://www.example.org/123, 123-321 | true | - | varchar(255) | string | 
| sta_identifier | Unique identifier used by SensorThingsAPI for addressing the entity. Should be a URI (reference to a vacabulary entry), UUID. E.g. http://www.example.org/123, 123-321 | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the phenomenon identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the phenomenon. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the phenomenon name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the phenomenon | false | - | text | text | 

[top](#Tables)

### phenomenon_i18n
**Description**: Storage for internationalizations of phenomenon.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| phenomenon_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_phenomenon_id | Reference to the phenomenon table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the phenomenon | false | - | varchar(255) | string | 
| description | Locale/language specific description of the phenomenon | false | - | text | text | 

[top](#Tables)

### platform
**Description**: Storage of the platforms. With a platform several procedures can be grouped or in the case of citizen science the platform can be the camera or mobile phone. An example of a platform is a vessel that has multiple sensors (Procedure). In most cases, the platform is the same as the feature or procedure, such as a weather station or a water level location.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| platform_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the platform which can be used for filtering. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321 | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the platform identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the platform. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the platform name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the platform | false | - | text | text | 
| properties | - | false | - | text | text | 

[top](#Tables)

### platform_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| platform_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_platform_id | Reference to the feature table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.PlatformEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the platform | false | - | varchar(255) | string | 
| description | Locale/language specific description of the platform | false | - | text | text | 

[top](#Tables)

### platform_parameter
**Description**: Storage of relations between platform and related parameter

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_platform_id | The reference to the platform in the observation table | true | - | int8 | long | 
| fk_parameter_id | The reference to the parameter in the platform parameter | true | - | int8 | org.n52.series.db.beans.parameter.ParameterEntity | 

[top](#Tables)

### procedure
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| procedure_id | - | true | - | int8 | long | 
| identifier | - | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | - | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | - | false | - | varchar(255) | string | 
| fk_name_codespace_id | - | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | - | false | - | text | text | 
| description_file | - | false | - | text | text | 
| is_reference | - | false | 0 | int2 | small_boolean | 
| fk_type_of_procedure_id | - | false | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| is_aggregation | - | false | 1 | int2 | small_boolean | 
| fk_format_id | - | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

[top](#Tables)

### procedure_hierarchy
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_procedure_id | - | true | - | int8 | long | 
| fk_parent_procedure_id | - | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 

[top](#Tables)

### procedure_history
**Description**: Storage of historical procedure descriptions as XML encoded text with period of validity.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| procedure_history_id | PK column of the table | true | - | int8 | long | 
| fk_procedure_id | Reference to the procedure this entry belongs to. | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_format_id | Reference to the format of the procedure description, e.g. SensorML 2.0 | true | - | int8 | org.n52.series.db.beans.FormatEntity | 
| valid_from | The timestamp from which this procedure description is valid. | true | - | timestamp with time zone | timestamp | 
| valid_to | The timestamp until this procedure description is valid. If null, this procedure description is currently valid | false | NULL | timestamp with time zone | timestamp | 
| xml | XML representation of this procedure description | true | - | text | text | 

[top](#Tables)

### procedure_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| procedure_i18n_id | - | true | - | int8 | long | 
| fk_procedure_id | - | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| locale | - | true | - | varchar(255) | string | 
| name | - | false | - | varchar(255) | string | 
| description | - | false | - | text | text | 
| short_name | - | false | - | varchar(255) | string | 
| long_name | - | false | - | varchar(255) | string | 

[top](#Tables)

### related_dataset
**Description**: Store the relation of two datasets, e.g. one dataset depends on other datasets to provide context

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id | The reference to the dataset that has a related dataset | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| fk_related_dataset_id | The reference to the related dataset | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| role | Definition of the role of the relation | false | - | varchar(255) | string | 
| url | URL that point to external information | false | - | varchar(255) | string | 

[top](#Tables)

### related_feature
**Description**: Storage of relations between offerings and features. This table is used by the SOS to fulfill the standard.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| related_feature_id | PK column of the table | true | - | int8 | long | 
| fk_feature_id | Reference to the feature that is related to the offering. | true | - | int8 | org.n52.series.db.beans.AbstractFeatureEntity | 
| role | The role of the related feature. | true | - | varchar(255) | string | 

[top](#Tables)

### related_observation
**Description**: Store the relation of two observation, e.g. one observation depends on other observations to provide context

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | The reference to the dataset that has a related data/observation | true | - | int8 | org.n52.series.db.beans.DataEntity | 
| fk_related_observation_id | The reference to the related data/observation | true | - | int8 | org.n52.series.db.beans.DataEntity | 
| role | Definition of the role of the relation | false | - | varchar(255) | string | 
| url | URL that point to external information | false | - | varchar(255) | string | 

[top](#Tables)

### result_template
**Description**: Storage of templates for the result handling operations

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| result_template_id | PK column of the table | true | - | int8 | long | 
| fk_offering_id | The offering that is associated with the result template | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| fk_phenomenon_id | The phenomenon that is associated with the result template | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| fk_procedure_id | The procedure that is associated with the result template. Can be null if the feature is defined in the structure. | false | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_feature_id | The feature that is associated with the result template. Can be null if the feature is defined in the structure. | false | - | int8 | org.n52.series.db.beans.AbstractFeatureEntity | 
| identifier | Unique identifier of the result template used for insertion operation | true | - | varchar(255) | string | 
| structure | The structure of the result template, should be a XML encoded swe:DataRecord | true | - | text | text | 
| encoding | The encding of the result template, should be a XML encoded swe:TextEncoding | true | - | text | text | 

[top](#Tables)

### sampling
**Description**: Storage of the Description of a sampling that was performed in a measuring program.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| sampling_id | PK column of the table | true | - | int8 | long | 
| fk_measuring_program_id | Reference to the measuring program to which this sampling belongs. | true | - | int8 | org.n52.series.db.beans.sampling.MeasuringProgramEntity | 
| identifier | The identifier of the sampling. Should be a URI, UUID. E.g. http://www.example.org/123, 123-321 | false | - | varchar(255) | string | 
| name | The human readable name or the label of the sampling. | false | - | varchar(255) | string | 
| description | A short description or the COMMENT of the sampling | false | - | text | text | 
| sampler | The sampler (e.g. name of a person or an organization) who take the sample. | false | - | varchar(255) | string | 
| sampling_method | The sampling method used to take the sample | false | - | varchar(255) | string | 
| environmental_conditions | The environmental conditions when the sample was made, e.g. sunny, dry, hot | false | - | varchar(255) | string | 
| sampling_time_start | The timestamp when the sampling period has started. | true | - | timestamp with time zone | timestamp | 
| sampling_time_end | The timestamp when the sampling period has finished. | true | - | timestamp with time zone | timestamp | 

[top](#Tables)

### sampling_dataset
**Description**: Storage of relations between datasets and related samplings

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id | The reference to the dataset in the dataset table | true | - | int8 | long | 
| fk_sampling_id | The reference to the sampling in the dataset sampling | true | - | int8 | org.n52.series.db.beans.sampling.SamplingEntity | 

[top](#Tables)

### sampling_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| sampling_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_sampling_id | Reference to the sampling table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.sampling.SamplingEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the sampling entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the sampling entity | false | - | text | text | 
| sampling_method | Locale/language specific sampling method of the sampling entity | false | - | varchar(255) | string | 
| environmental_conditions | Locale/language specific environmental conditions of the sampling entity | false | - | varchar(255) | string | 

[top](#Tables)

### service
**Description**: Storage of the service.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| service_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the service. | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the service identifier, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the service. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the service name, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the service | false | - | text | text | 
| url | The url of the service | false | - | text | text | 
| type | The type of the service | false | - | varchar(255) | string | 
| version | The version of the service | false | - | varchar(255) | string | 
| connector | The connector of the service. | false | - | varchar(255) | string | 
| is_supports_first_last | Flag that indicates if this service supports first/last observation queries | true | 1 | int2 | small_boolean | 
| metadata | The metadata of the service | false | - | text | text | 
| format | The format of the service, e.g. application/json, application/xml | false | - | varchar(255) | string | 

[top](#Tables)

### thing_location
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_location_id | - | false | - | int8 | long | 
| fk_thing_id | - | true | - | int8 | org.n52.series.db.beans.PlatformEntity | 

[top](#Tables)

### unit
**Description**: Storage of the units of measurement of the observation values. These may be °C or m as the unit for depth/height information.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| unit_id | PK column of the table | true | - | int8 | long | 
| symbol | The symbol of the unit, e.g. °C or m. | true | - | varchar(255) | string | 
| name | Human readable name of the unit, e.g degree celsius or meter | false | - | varchar(255) | string | 
| link | Link/reference to an external description of the unit, e.g. to a vocabulary.. | false | - | varchar(255) | string | 

[top](#Tables)

### unit_i18n
**Description**: Storage for internationalizations of units.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| unit_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_unit_id | Reference to the unit table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.UnitEntity | 
| locale | Locale/language specification for this unit. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| name | Locale/language specific name of the unit | false | - | varchar(255) | string | 

[top](#Tables)

### value_blob
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | Reference to the data/observation in the observation table | true | - | int8 | long | 
| value | The blob value of an observation | false | - | oid | blob | 

[top](#Tables)

### value_profile
**Description**: Storage of meta-information about a profile measurement. These are the orientation (height/depth) and name of the depth/height value as they should be named in the output and the unit of the depth/height value. A value_profile must be defined for each dataset containing profile data.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| value_profile_id | PK column of the table | true | - | int8 | long | 
| orientation | The "orientation" of the vertical values as integer. 1 => above verticalOriginName and -1 => below verticalOriginName | false | - | int2 | short | 
| vertical_origin_name | The vertical origin name of the vertical values, e.g. water surface | false | - | varchar(255) | string | 
| vertical_from_name | The name of the vertical from values, e.g. from or depthFrom | false | - | varchar(255) | string | 
| vertical_to_name | The name of the vertical from values, e.g. to or depthTo | false | - | varchar(255) | string | 
| fk_vertical_unit_id | The unit of the vertical value, e.g. m | true | - | int8 | org.n52.series.db.beans.UnitEntity | 

[top](#Tables)

### value_profile_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| value_profile_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_value_profile_id | Reference to the value_profile table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.VerticalMetadataEntity | 
| locale | Locale/language specification for this entry. ISO 639 Codes (http://www.loc.gov/standards/iso639-2/php/code_list.php) | true | - | varchar(255) | string | 
| vertical_origin_name | Locale/language specific vertical origin name of the vertical metadata entity | false | - | varchar(255) | string | 
| vertical_from_name | Locale/language specific verticalTo name of the vertical metadata entity | false | - | varchar(255) | string | 
| vertical_to_name | Locale/language specific verticalTo name of the vertical metadata entity | false | - | varchar(255) | string | 

[top](#Tables)


*Creation date: 2020-03-05 12:12:42 +01:00*
