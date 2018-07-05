# Database model description
This page describes the tables and columns in the database.
The *SQL type* column in the tables is generated for Hibernate dialect: *PostgisPG95Dialect*

## Tables
- [category](#category)
- [category_i18n](#category_i18n)
- [codespace](#codespace)
- [composite_observation](#composite_observation)
- [composite_phenomenon](#composite_phenomenon)
- [dataset](#dataset)
- [dataset_parameter](#dataset_parameter)
- [dataset_reference](#dataset_reference)
- [feature](#feature)
- [feature_hierarchy](#feature_hierarchy)
- [feature_i18n](#feature_i18n)
- [feature_parameter](#feature_parameter)
- [format](#format)
- [observation](#observation)
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
- [procedure](#procedure)
- [procedure_hierarchy](#procedure_hierarchy)
- [procedure_history](#procedure_history)
- [procedure_i18n](#procedure_i18n)
- [related_dataset](#related_dataset)
- [related_feature](#related_feature)
- [related_observation](#related_observation)
- [result_template](#result_template)
- [service](#service)
- [unit](#unit)
- [unit_i18n](#unit_i18n)
- [value_blob](#value_blob)
- [value_data_array](#value_data_array)
- [value_profile](#value_profile)

### category
**Description**: Storage of the categories.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| category_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the category which can be for filtering, e.g. in the SOS. | true | - | varchar(255) | string | 
| name | The human readable name of the category. | false | - | varchar(255) | string | 
| description | A short description of the category | false | - | varchar(255) | string | 

### category_i18n
**Description**: Storage for internationalizations of categories.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| category_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_category_id | Reference to the category table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.CategoryEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the category | false | - | varchar(255) | string | 
| description | Locale/language specific description of the category | false | - | varchar(255) | string | 

### codespace
**Description**: Storage of codespaces which can be domain specific.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| codespace_id | PK column of the table | true | - | int8 | long | 
| name | Name/definition of the codespace, e.g. of a domain | true | - | varchar(255) | string | 

### composite_observation
**Description**: Storage of the relation of composite data/observation like Complex(Record)-, Profile- or DataArrayObservation 

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_parent_observation_id | Reference to the parent data/observation | true | - | int8 | long | 
| fk_child_observation_id | Reference to the child data/observation | true | - | int8 | org.n52.series.db.beans.DataEntity | 

### composite_phenomenon
**Description**: Storage of hierarchies between phenomenon, e.g. for composite phenomenon like weather with temperature, windspeed, ...

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_phenomenon_id | Reference to the child phenomenon in phenomenon table. | true | - | int8 | long | 
| fk_parent_phenomenon_id | Reference to the parent phenomenon in phenomenon table. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 

### dataset
**Description**: Storage of the dataset, the core table of the whole database model.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| dataset_id | PK column of the table | true | - | int8 | long | 
| value_type | Indicator used by Hibernate to map value specific entities. | true | - | varchar(255) | string | 
| fk_procedure_id | Reference to the procedure that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_phenomenon_id | Reference to the phenomenon that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| fk_offering_id | Reference to the offering that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| fk_category_id | Reference to the category that belongs that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.CategoryEntity | 
| fk_feature_id | Reference to the feature that belongs that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.FeatureEntity | 
| fk_format_id | Reference to the observationType in the format table. Required by the SOS to persist the valid observationType for the dataset. | false | - | int8 | org.n52.series.db.beans.FormatEntity | 
| first_time | The timestamp of the temporally first data/observation that belongs to this dataset. | false | - | timestamp | timestamp | 
| last_time | The timestamp of the temporally last data/observation that belongs to this dataset. | false | - | timestamp | timestamp | 
| first_value | The value of the temporally first data/observation that belongs to this dataset. | false | - | numeric(19, 2) | big_decimal | 
| last_value | The value of the temporally last quantity data/observation that belongs to this dataset. | false | - | numeric(19, 2) | big_decimal | 
| is_deleted | Flag that indicates if this dataset is deleted | true | 0 | int2 | small_boolean | 
| is_disabled | Flag that indicates if this dataset is disabled for insertion of new data | true | 0 | int2 | small_boolean | 
| is_published | Flag that indicates if this dataset should be published | true | 1 | int2 | small_boolean | 
| is_hidden | Flag that indicates if this dataset should be hidden, e.g. for sub-datasets of a complex datasets | true | 0 | int2 | small_boolean | 
| identifier | Unique identifier of the dataset which can be for filtering, e.g. GetObservationById in the SOS | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the dataset identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the dataset. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the dataset name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the dataset | false | - | varchar(255) | string | 
| fk_unit_id | Reference to the unit of the data/observations that belongs to this dataset. | false | - | int8 | long | 
| fk_first_observation_id | Reference to the temporally first data/observation in the observation table that belongs to this dataset. | false | - | int8 | long | 
| fk_last_observation_id | Reference to the temporally last data/observation in the observation table that belongs to this dataset. | false | - | int8 | long | 
| decimals | Number of decimals that should be present in the data/observation values | false | - | int4 | integer | 

### dataset_parameter
**Description**: Storage of relations between dataset and related parameter

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id | The reference to the dataset in the dataset table | true | - | int8 | long | 
| fk_parameter_id | The reference to the parameter in the dataset parameter | true | - | int8 | org.n52.series.db.beans.parameter.Parameter | 

### dataset_reference
**Description**: Storage of referenced datasets, e.g. level zero, medium water level,etc. for water level 

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id_from | Reference to the dataset that has referenced datasets | true | - | int8 | long | 
| sort_order | Provides the sort order for the referenced datasets. | true | - | int4 | integer | 
| fk_dataset_id_to | Reference to the dataset that is the reference | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 

### feature
**Description**: Storage of the features (OfInterest).

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| feature_id | PK column of the table | true | - | int8 | long | 
| discriminator | Indicator used by Hibernate to map value specific entities. | true | - | varchar(255) | string | 
| fk_format_id | Reference to the featureType in the format table. Required by the SOS to identify the typ of the feature, e.g. http://www.opengis.net/def/samplingFeatureType/OGC-OM/2.0/SF_SamplingPoint. | true | - | int8 | org.n52.series.db.beans.FormatEntity | 
| identifier | Unique identifier of the feature which can be for filtering, e.g. in the SOS. | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the feature identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the feature. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the feature name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the feature | false | - | varchar(255) | string | 
| xml | The XML encoded representation of the feature. | false | - | text | text | 
| url | Optional URL to an external resource that describes the feature, e.g. a WFS | false | - | varchar(255) | string | 
| geom | The geometry/location of feature | false | - | GEOMETRY | jts_geometry | 

### feature_hierarchy
**Description**: Storage of hierarchies between features

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_feature_id | Reference to the child feature in feature table. | true | - | int8 | long | 
| fk_parent_feature_id | Reference to the parent feature in feature table. | true | - | int8 | org.n52.series.db.beans.AbstractFeatureEntity | 

### feature_i18n
**Description**: Storage for internationalizations of features.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| feature_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_feature_id | Reference to the feature table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.FeatureEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the feature | false | - | varchar(255) | string | 
| description | Locale/language specific description of the feature | false | - | varchar(255) | string | 

### feature_parameter
**Description**: Storage of relations between feature and related parameter

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_feature_id | The reference to the feature in the feature table | true | - | int8 | long | 
| fk_parameter_id | The reference to the parameter in the feature parameter | true | - | int8 | org.n52.series.db.beans.parameter.Parameter | 

### format
**Description**: Storage of types (feature, observation) and formats (procedure)., e.g. http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement and http://www.opengis.net/sensorml/2.0

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| format_id | PK column of the table | true | - | int8 | long | 
| definition | The definition of the format. | true | - | varchar(255) | string | 

### observation
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| observation_id | PK column of the table | true | - | int8 | long | 
| value_type | Indicator used by Hibernate to map value specific entities. | true | - | varchar(255) | string | 
| fk_dataset_id | Reference to the dataset to which this data/observation belongs. | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| sampling_time_start | The timestamp when the observation period has started. | true | - | timestamp | timestamp | 
| sampling_time_end | The timestamp when the measurement period has finished or the observation took place. | true | - | timestamp | timestamp | 
| result_time | The timestamp when the observation was published. | true | - | timestamp | timestamp | 
| identifier | Unique identifier of the data/observation which can be for filtering, e.g. GetObservationById in the SOS | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the data/observation identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the data/observation. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the data/observation name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the data/observation | false | - | varchar(255) | string | 
| is_deleted | Flag that indicates if this data/observation is deleted | true | 0 | int2 | small_boolean | 
| valid_time_start | The timestamp from when the obervation is valid, e.g. forcasting | false | NULL | timestamp | timestamp | 
| valid_time_end | The timestamp until when the obervation is valid, e.g. forcasting | false | NULL | timestamp | timestamp | 
| is_child | Flag that indicates if this data/observation is a child observation. Required for composite observation like Complex- or ProfileObservation | true | 0 | int2 | small_boolean | 
| is_parent | Flag that indicates if this data/observation is a parent observation. Required for composite observation like Complex- or ProfileObservation | true | 0 | int2 | small_boolean | 
| sampling_geometry | The geometry that represents the location where the observation was observed, e.g. mobile observations where this geometry is different from the feature geometry. | false | - | GEOMETRY | jts_geometry | 
| value_identifier | Identifier of the value. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| value_name | Identifier of the name. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| value_description | Identifier of the description. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| vertical_from | The start level of a vertical observation, e.g. profiles | true | -99999.00 | numeric(20, 10) | big_decimal | 
| vertical_to | The end level or the level of a vertical observation, e.g. profiles | true | -99999.00 | numeric(20, 10) | big_decimal | 
| value_quantity | The quantity value of an observation (Measruement) | false | - | numeric(19, 2) | big_decimal | 
| value_text | The textual value of an observation (TextObservation)) | false | - | varchar(255) | string | 
| value_referenced | The reference value (URI) of an observation (ReferencedObservation) | false | - | varchar(255) | string | 
| value_count | The count/integer value of an observation (CountObservation) | false | - | int4 | integer | 
| value_boolean | The boolean value of an observation (Boolean/TruthObservation) | false | - | int2 | small_boolean | 
| value_category | The categorical value of an observation (CategoryObervation) | false | - | varchar(255) | string | 
| value | The blob value of an observation | false | - | oid | blob | 
| structure | The structure of the data array | true | - | text | text | 
| encoding | The encoding of the data array values | true | - | text | text | 
| vertical_from_name | The name of the vertical from values, e.g. from or depthFrom | false | - | varchar(255) | string | 
| vertical_to_name | The name of the vertical from values, e.g. to or depthTo | false | - | varchar(255) | string | 
| fk_vertical_unit_id | The unit of the vertical value, e.g. m | true | - | int8 | org.n52.series.db.beans.UnitEntity | 

### observation_parameter
**Description**: Storage of relations between data/observation and related parameter

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | The reference to the data/observation in the observation table | true | - | int8 | long | 
| fk_parameter_id | The reference to the parameter in the data/observation parameter | true | - | int8 | org.n52.series.db.beans.parameter.Parameter | 

### offering
**Description**: Storage of the offerings.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| offering_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the offering which can be for filtering, e.g. in the SOS. | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the offering identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the offering. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the offering name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the offering | false | - | varchar(255) | string | 
| sampling_time_start | The minimum samplingTimeStart of all observation that belong to this offering | false | - | timestamp | timestamp | 
| sampling_time_end | The maximum samplingTimeStart of all observation that belong to this offering | false | - | timestamp | timestamp | 
| result_time_start | The minimum resultTimeStart of all observation that belong to this offering | false | - | timestamp | timestamp | 
| result_time_end | The maximum resultTimeEnd of all observation that belong to this offering | false | - | timestamp | timestamp | 
| valid_time_start | The minimum validTimeStart of all observation that belong to this offering | false | - | timestamp | timestamp | 
| valid_time_end | The maximum validTimeEnd of all observation that belong to this offering | false | - | timestamp | timestamp | 
| geom | The envelope/geometry of all features or samplingGeometries of observations that belong to this offering | false | - | GEOMETRY | jts_geometry | 

### offering_feature_type
**Description**: Relation to store the valid  featureTypes for the offering

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_format_id | The reference of the related featureType from the format table | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

### offering_hierarchy
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_offering_id | Reference to the child offering in offering table. | true | - | int8 | long | 
| fk_parent_offering_id | Reference to the parent offering in offering table. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 

### offering_i18n
**Description**: Storage for internationalizations of offerings.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| offering_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_offering_id | Reference to the offering table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the offering | false | - | varchar(255) | string | 
| description | Locale/language specific description of the offering | false | - | varchar(255) | string | 

### offering_observation_type
**Description**: Relation to store the valid observationTypes for the offering

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_format_id | The reference of the related observationType from the format table | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

### offering_related_feature
**Description**: Storage tfor the relation between offering and relatedFeature

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_related_feature_id | The reference to the relatedFeature from the relatedFeature table | true | - | int8 | org.n52.series.db.beans.RelatedFeatureEntity | 

### parameter
**Description**: Storage for additional information for features, observations or datasets

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| parameter_id | PK column of the table | true | - | int8 | long | 
| type | Indicator used by Hibernate to map value specific entities. | true | - | varchar(255) | string | 
| name | The name of the parameter | true | - | varchar(255) | string | 
| last_update | Timestamp that provides the time of the last modification of this entry | false | - | timestamp | timestamp | 
| domain | The domain this parameter belongs to. | false | - | varchar(255) | string | 
| value_boolean | Storage of a boolean parameter value. | false | - | int2 | small_boolean | 
| value_category | Storage of a categorical parameter value. | false | - | varchar(255) | string | 
| fk_unit_id | Reference to the unit of this value in the unit table | false | - | int8 | org.n52.series.db.beans.UnitEntity | 
| value_count | Storage of a count parameter value. | false | - | int4 | integer | 
| value_quantity | Storage of a quantity parameter value. | false | - | numeric(19, 2) | big_decimal | 
| value_text | Storage of a textual parameter value. | false | - | varchar(255) | string | 
| value_xml | Storage of a XML encoded parameter value. | false | - | text | text | 
| value_json | Storage of a JSON encoded parameter value. | false | - | text | text | 

### phenomenon
**Description**: Storage of the phenomenon/observableProperties

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| phenomenon_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the phenomenon which can be for filtering, e.g. in the SOS. | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the phenomenon identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the phenomenon. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the phenomenon name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the phenomenon | false | - | varchar(255) | string | 

### phenomenon_i18n
**Description**: Storage for internationalizations of phenomenon.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| phenomenon_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_phenomenon_id | Reference to the phenomenon table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the phenomenon | false | - | varchar(255) | string | 
| description | Locale/language specific description of the phenomenon | false | - | varchar(255) | string | 

### procedure
**Description**: Storage of the procedure/sensors.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| procedure_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the procedure which can be for filtering, e.g. in the SOS. | true | - | varchar(255) | string | 
| name | The human readable name of the procedure. | false | - | varchar(255) | string | 
| is_mobile | Flag that indicates if the procedure is mobile (1/true) or stationary (0/false). | false | 0 | int2 | small_boolean | 
| is_insitu | Flag that indicates if the procedure is insitu (1/true) or remote (0/false). | false | 1 | int2 | small_boolean | 
| fk_identifier_codespace_id | The codespace of the procedure identifier, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| fk_name_codespace_id | The codespace of the procedure name, reference to the codespace table. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the procedure | false | - | varchar(255) | string | 
| is_deleted | Flag that indicates if the procedure is deleted. | true | 0 | int2 | small_boolean | 
| description_file | Location to or XML encoded description of the procedure. Can be used if procedure history is not supported. | false | - | text | text | 
| is_reference | Flag that indicates if the procedure is a reference. | false | 0 | int2 | small_boolean | 
| fk_type_of_procedure_id | Reference to a procedure this entry is a typeOf. | false | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| is_aggregation | Flag that indicates if the procedure is an aggregated process or a system. | false | 1 | int2 | small_boolean | 
| fk_format_id | Reference to the format of the procedure description, e.g. SensorML 2.0 | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

### procedure_hierarchy
**Description**: Storage of hierarchies between procedures

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_child_procedure_id | Reference to the child procedure in procedure table. | true | - | int8 | long | 
| fk_parent_procedure_id | Reference to the parent procedure in procedure table. | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 

### procedure_history
**Description**: Storage of historical procedure descriptions as XML encoded text with period of validity.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| procedure_history_id | PK column of the table | true | - | int8 | long | 
| fk_procedure_id | Reference to the procedure this entry belongs to. | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_format_id | Reference to the format of the procedure description, e.g. SensorML 2.0 | true | - | int8 | org.n52.series.db.beans.FormatEntity | 
| valid_from | The timestamp from which this procedure description is valid. | true | - | timestamp | timestamp | 
| valid_to | The timestamp until this procedure description is valid. If null, this procedure description is currently valid | false | NULL | timestamp | timestamp | 
| xml | XML representation of this procedure description | true | - | text | text | 

### procedure_i18n
**Description**: Storage for internationalizations of procedures.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| procedure_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_procedure_id | Reference to the procedure table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.PlatformEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the procedure | false | - | varchar(255) | string | 
| description | Locale/language specific description of the procedure | false | - | varchar(255) | string | 
| short_name | Locale/language specific shortname of the procedure | false | - | varchar(255) | string | 
| long_name | Locale/language specific longname of the procedure | false | - | varchar(255) | string | 

### related_dataset
**Description**: Store the relation of two datasets, e.g. one dataset depends on other datasets to provide context

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id | The reference to the dataset that has a related dataset | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| fk_related_dataset_id | The reference to the related dataset | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| role | Definition of the role of the relation | false | - | varchar(255) | string | 
| url | URL that point to external information | false | - | varchar(255) | string | 

### related_feature
**Description**: Storage of relations between offerings and features. This table is used by the SOS to fulfill the standard.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| related_feature_id | PK column of the table | true | - | int8 | long | 
| fk_feature_id | Reference to the feature that is related to the offering. | true | - | int8 | org.n52.series.db.beans.AbstractFeatureEntity | 
| role | The role of the related feature. | true | - | varchar(255) | string | 

### related_observation
**Description**: Store the relation of two observation, e.g. one observation depends on other observations to provide context

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | The reference to the dataset that has a related data/observation | true | - | int8 | org.n52.series.db.beans.DataEntity | 
| fk_related_observation_id | The reference to the related data/observation | true | - | int8 | org.n52.series.db.beans.DataEntity | 
| role | Definition of the role of the relation | false | - | varchar(255) | string | 
| url | URL that point to external information | false | - | varchar(255) | string | 

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

### service
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| service_id | - | true | - | int8 | long | 
| name | - | true | - | varchar(255) | string | 
| description | - | false | - | varchar(255) | string | 
| url | - | false | - | varchar(255) | string | 
| type | - | false | - | varchar(255) | string | 
| version | - | false | - | varchar(255) | string | 

### unit
**Description**: Storage of the units of measurement

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| unit_id | PK column of the table | true | - | int8 | long | 
| symbol | The symbol of the unit, e.g. °C or m. | true | - | varchar(255) | string | 
| name | Human readable name of the unit. | false | - | varchar(255) | string | 
| link | Reference to a description of the unit. | false | - | varchar(255) | string | 

### unit_i18n
**Description**: Storage for internationalizations of units.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| unit_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_unit_id | Reference to the unit table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.UnitEntity | 
| locale | Locale/language specification for this unit | true | - | varchar(255) | string | 
| name | Locale/language specific name of the unit | false | - | varchar(255) | string | 

### value_blob
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | Reference to the data/observation in the observation table | true | - | int8 | long | 
| value | The blob value of an observation | false | - | oid | blob | 

### value_data_array
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | Reference to the data/observation | true | - | int8 | long | 
| structure | The structure of the data array | true | - | text | text | 
| encoding | The encoding of the data array values | true | - | text | text | 

### value_profile
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | Reference to the data/observation | true | - | int8 | long | 
| vertical_from_name | The name of the vertical from values, e.g. from or depthFrom | false | - | varchar(255) | string | 
| vertical_to_name | The name of the vertical from values, e.g. to or depthTo | false | - | varchar(255) | string | 
| fk_vertical_unit_id | The unit of the vertical value, e.g. m | true | - | int8 | org.n52.series.db.beans.UnitEntity | 


*Creation date: 2018-07-05 12:06:38 +02:00*
