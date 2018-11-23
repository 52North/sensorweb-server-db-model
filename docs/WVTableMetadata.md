# Database table/column description
This page describes the tables and columns in the database.
The *SQL type* column in the tables is generated for Hibernate dialect: *TimestampWithTimeZonePostgisPG95Dialect*

## Tables
- [category](#category)
- [category_i18n](#category_i18n)
- [codespace](#codespace)
- [composite_observation](#composite_observation)
- [dataset](#dataset)
- [dataset_i18n](#dataset_i18n)
- [dataset_reference](#dataset_reference)
- [feature](#feature)
- [feature_i18n](#feature_i18n)
- [format](#format)
- [measuring_program](#measuring_program)
- [measuring_program_dataset](#measuring_program_dataset)
- [measuring_program_i18n](#measuring_program_i18n)
- [observation](#observation)
- [observation_i18n](#observation_i18n)
- [offering](#offering)
- [offering_feature_type](#offering_feature_type)
- [offering_i18n](#offering_i18n)
- [offering_observation_type](#offering_observation_type)
- [phenomenon](#phenomenon)
- [phenomenon_i18n](#phenomenon_i18n)
- [platform](#platform)
- [platform_i18n](#platform_i18n)
- [procedure](#procedure)
- [procedure_i18n](#procedure_i18n)
- [sampling](#sampling)
- [sampling_dataset](#sampling_dataset)
- [sampling_i18n](#sampling_i18n)
- [unit](#unit)
- [unit_i18n](#unit_i18n)
- [value_profile](#value_profile)

### category
**Description**: Storage of the categories.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| category_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the category which can be used for filtering. | true | - | varchar(255) | string | 
| name | The human readable name of the category. | false | - | varchar(255) | string | 
| description | A short description of the category | false | - | varchar(255) | string | 

[top](#Tables)

### category_i18n
**Description**: Storage for internationalizations of categories.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| category_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_category_id | Reference to the category table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.CategoryEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the category | false | - | varchar(255) | string | 
| description | Locale/language specific description of the category | false | - | varchar(255) | string | 

[top](#Tables)

### codespace
**Description**: Storage of codespaces which can be domain specific.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| codespace_id | PK column of the table | true | - | int8 | long | 
| name | Name/definition of the codespace, e.g. of a domain | true | - | varchar(255) | string | 

[top](#Tables)

### composite_observation
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_parent_observation_id | - | true | - | int8 | long | 
| fk_child_observation_id | - | true | - | int8 | org.n52.series.db.beans.DataEntity | 

[top](#Tables)

### dataset
**Description**: Storage of the dataset, the core table of the whole database model.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| dataset_id | PK column of the table | true | - | int8 | long | 
| dataset_type | Indicator whether the dataset provides individual observations, timeseries, profiles or trajectories. | true | - | varchar(255) | org.hibernate.type.EnumType | 
| aggregation_type | Indicator whether the dataset observations are aggregated to profiles, trajectories, timeseries, ...  | true | - | varchar(255) | org.hibernate.type.EnumType | 
| value_type | Indicator of the type of the single values. | true | - | varchar(255) | org.hibernate.type.EnumType | 
| fk_procedure_id | Reference to the procedure that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_phenomenon_id | Reference to the phenomenon that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| fk_offering_id | Reference to the offering that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| fk_category_id | Reference to the category that belongs that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.CategoryEntity | 
| fk_feature_id | Reference to the feature that belongs that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.FeatureEntity | 
| fk_platform_id | Reference to the platform that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.PlatformEntity | 
| fk_format_id | Reference to the observationType in the format table. Required by the SOS to persist the valid observationType for the dataset. | false | - | int8 | org.n52.series.db.beans.FormatEntity | 
| fk_unit_id | Reference to the unit of the data/observations that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.UnitEntity | 
| is_deleted | Flag that indicates if this dataset is deleted | true | 0 | int2 | small_boolean | 
| is_disabled | Flag that indicates if this dataset is disabled for insertion of new data | true | 0 | int2 | small_boolean | 
| is_published | Flag that indicates if this dataset should be published | true | 1 | int2 | small_boolean | 
| is_mobile | Flag that indicates if the procedure is mobile (1/true) or stationary (0/false). | false | 0 | int2 | small_boolean | 
| is_insitu | Flag that indicates if the procedure is insitu (1/true) or remote (0/false). | false | 1 | int2 | small_boolean | 
| is_hidden | Flag that indicates if this dataset should be hidden, e.g. for sub-datasets of a complex datasets | true | 0 | int2 | small_boolean | 
| origin_timezone | Define the origin timezone of the dataset timestamps. Possible values are offset (+02:00), id (CET) or full name (Europe/Berlin) | false | - | varchar(255) | string | 
| first_time | The timestamp of the temporally first data/observation that belongs to this dataset. | false | - | timestamp with time zone | timestamp | 
| last_time | The timestamp of the temporally last data/observation that belongs to this dataset. | false | - | timestamp with time zone | timestamp | 
| first_value | The value of the temporally first data/observation that belongs to this dataset. | false | - | numeric(19, 2) | big_decimal | 
| last_value | The value of the temporally last quantity data/observation that belongs to this dataset. | false | - | numeric(19, 2) | big_decimal | 
| fk_first_observation_id | Reference to the temporally first data/observation in the observation table that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.DataEntity | 
| fk_last_observation_id | Reference to the temporally last data/observation in the observation table that belongs to this dataset. | false | - | int8 | org.n52.series.db.beans.DataEntity | 
| decimals | Number of decimals that should be present in the data/observation values | false | - | int4 | integer | 
| identifier | Unique identifier of the dataset which can be used for filtering, e.g. GetObservationById in the SOS | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the dataset identifier, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the dataset. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the dataset name, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the dataset | false | - | varchar(255) | string | 

[top](#Tables)

### dataset_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| dataset_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_dataset_id | Reference to the dataset table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the data entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the data entity | false | - | varchar(255) | string | 

[top](#Tables)

### dataset_reference
**Description**: Storage of referenced datasets, e.g. level zero, medium water level,etc. for water level 

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_dataset_id_from | Reference to the dataset that has referenced datasets | true | - | int8 | long | 
| sort_order | Provides the sort order for the referenced datasets. | true | - | int4 | integer | 
| fk_dataset_id_to | Reference to the dataset that is the reference | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 

[top](#Tables)

### feature
**Description**: Storage of the features (OfInterest).

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| feature_id | PK column of the table | true | - | int8 | long | 
| discriminator | Indicator used by Hibernate to map value specific entities. | false | - | varchar(255) | string | 
| fk_format_id | Reference to the featureType in the format table. Required by the SOS to identify the typ of the feature, e.g. http://www.opengis.net/def/samplingFeatureType/OGC-OM/2.0/SF_SamplingPoint. | true | - | int8 | org.n52.series.db.beans.FormatEntity | 
| identifier | Unique identifier of the feature which can be used for filtering, e.g. in the SOS. | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the feature identifier, reference to the codespace table. Can be empty. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the feature. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the feature name, reference to the codespace table. Can be empty. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the feature | false | - | varchar(255) | string | 
| geom | The geometry/location of feature | false | - | GEOMETRY | jts_geometry | 

[top](#Tables)

### feature_i18n
**Description**: Storage for internationalizations of features.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| feature_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_feature_id | Reference to the feature table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.FeatureEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the feature | false | - | varchar(255) | string | 
| description | Locale/language specific description of the feature | false | - | varchar(255) | string | 

[top](#Tables)

### format
**Description**: Storage of types (feature, observation) and formats (procedure)., e.g. http://www.opengis.net/def/observationType/OGC-OM/2.0/OM_Measurement and http://www.opengis.net/sensorml/2.0

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| format_id | PK column of the table | true | - | int8 | long | 
| definition | The definition of the format. | true | - | varchar(255) | string | 

[top](#Tables)

### measuring_program
**Description**: Storage of the measuring program.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| measuring_program_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the measuring program which would be the ORDER_ID. | true | - | varchar(255) | string | 
| name | The human readable name or lable of the sampling. | false | - | varchar(255) | string | 
| description | A short description of the measuring program | false | - | varchar(255) | string | 
| producer | The producer of the measuring program. | false | - | varchar(255) | string | 
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
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the data entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the data entity | false | - | varchar(255) | string | 

[top](#Tables)

### observation
**Description**: Storage of the data/observation values.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| observation_id | PK column of the table | true | - | int8 | long | 
| value_type | Indicator used by Hibernate to map value specific entities. | true | - | varchar(255) | string | 
| fk_dataset_id | Reference to the dataset to which this data/observation belongs. | true | - | int8 | org.n52.series.db.beans.DatasetEntity | 
| sampling_time_start | The timestamp when the observation period has started. | true | - | timestamp with time zone | timestamp | 
| sampling_time_end | The timestamp when the measurement period has finished or the observation took place. | true | - | timestamp with time zone | timestamp | 
| result_time | The timestamp when the observation was published. | true | - | timestamp with time zone | timestamp | 
| identifier | Unique identifier of the data/observation which can be for used filtering, e.g. GetObservationById in the SOS | false | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the data/observation identifier, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the data/observation. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the data/observation name, reference to the codespace table. Can be null. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the data/observation | false | - | varchar(255) | string | 
| is_deleted | Flag that indicates if this data/observation is deleted | true | 0 | int2 | small_boolean | 
| valid_time_start | The timestamp from when the obervation is valid, e.g. forcasting | false | NULL | timestamp with time zone | timestamp | 
| valid_time_end | The timestamp until when the obervation is valid, e.g. forcasting | false | NULL | timestamp with time zone | timestamp | 
| is_child | Flag that indicates if this data/observation is a child observation. Required for composite observation like Complex- or ProfileObservation | true | 0 | int2 | small_boolean | 
| is_parent | Flag that indicates if this data/observation is a parent observation. Required for composite observation like Complex- or ProfileObservation | true | 0 | int2 | small_boolean | 
| sampling_geometry | The geometry that represents the location where the observation was observed, e.g. mobile observations where this geometry is different from the feature geometry. | false | - | GEOMETRY | jts_geometry | 
| value_identifier | Identifier of the value. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| value_name | Identifier of the name. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| value_description | Identifier of the description. E.g. used in OGC SWE encoded values like SweText | false | - | varchar(255) | string | 
| vertical_from | The start level of a vertical observation, e.g. profiles | true | -99999.00 | numeric(20, 10) | big_decimal | 
| vertical_to | The end level or the level of a vertical observation, e.g. profiles | true | -99999.00 | numeric(20, 10) | big_decimal | 
| detection_limit_flag | Flag that indicates if measured value lower/higher of the detection limit. | false | - | int2 | short | 
| detection_imit | The detection limit | false | - | numeric(19, 2) | big_decimal | 
| fk_sampling_id | The id of the sampling this observation belongs to. | false | - | int8 | org.n52.series.db.beans.sampling.SamplingEntity | 
| value_quantity | The quantity value of an observation (Measruement) | false | - | numeric(19, 2) | big_decimal | 
| orientation | The "orientation" of the vertical values, e.g. depth or height | false | - | varchar(255) | string | 
| vertical_from_name | The name of the vertical from values, e.g. from or depthFrom | false | - | varchar(255) | string | 
| vertical_to_name | The name of the vertical from values, e.g. to or depthTo | false | - | varchar(255) | string | 
| fk_vertical_unit_id | The unit of the vertical value, e.g. m | true | - | int8 | org.n52.series.db.beans.UnitEntity | 

[top](#Tables)

### observation_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| data_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_data_id | Reference to the data table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.DataEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the data entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the data entity | false | - | varchar(255) | string | 

[top](#Tables)

### offering
**Description**: Storage of the offerings.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| offering_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the offering which can be used for filtering, e.g. in the SOS. | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the offering identifier, reference to the codespace table. Can be empty. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the offering. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the offering name, reference to the codespace table. Can be empty. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the offering | false | - | varchar(255) | string | 
| sampling_time_start | The minimum samplingTimeStart of all observation that belong to this offering | false | - | timestamp with time zone | timestamp | 
| sampling_time_end | The maximum samplingTimeStart of all observation that belong to this offering | false | - | timestamp with time zone | timestamp | 
| result_time_start | The minimum resultTimeStart of all observation that belong to this offering | false | - | timestamp with time zone | timestamp | 
| result_time_end | The maximum resultTimeEnd of all observation that belong to this offering | false | - | timestamp with time zone | timestamp | 
| valid_time_start | The minimum validTimeStart of all observation that belong to this offering | false | - | timestamp with time zone | timestamp | 
| valid_time_end | The maximum validTimeEnd of all observation that belong to this offering | false | - | timestamp with time zone | timestamp | 
| geom | The envelope/geometry of all features or samplingGeometries of observations that belong to this offering | false | - | GEOMETRY | jts_geometry | 

[top](#Tables)

### offering_feature_type
**Description**: Relation to store the valid  featureTypes for the offering. Required for SOS support.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_format_id | The reference of the related featureType from the format table | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

[top](#Tables)

### offering_i18n
**Description**: Storage for internationalizations of offerings.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| offering_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_offering_id | Reference to the offering table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the offering | false | - | varchar(255) | string | 
| description | Locale/language specific description of the offering | false | - | varchar(255) | string | 

[top](#Tables)

### offering_observation_type
**Description**: Relation to store the valid observationTypes for the offering. Required for SOS support.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_offering_id | The related offering | true | - | int8 | long | 
| fk_format_id | The reference of the related observationType from the format table | true | - | int8 | org.n52.series.db.beans.FormatEntity | 

[top](#Tables)

### phenomenon
**Description**: Storage of the phenomenon/observableProperties

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| phenomenon_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the phenomenon which can be used for filtering, e.g. in the SOS. | true | - | varchar(255) | string | 
| fk_identifier_codespace_id | The codespace of the phenomenon identifier, reference to the codespace table. Can be empty.Can be empty. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| name | The human readable name of the phenomenon. | false | - | varchar(255) | string | 
| fk_name_codespace_id | The codespace of the phenomenon name, reference to the codespace table. Can be empty. | false | - | int8 | org.n52.series.db.beans.CodespaceEntity | 
| description | A short description of the phenomenon | false | - | varchar(255) | string | 

[top](#Tables)

### phenomenon_i18n
**Description**: Storage for internationalizations of phenomenon.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| phenomenon_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_phenomenon_id | Reference to the phenomenon table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the phenomenon | false | - | varchar(255) | string | 
| description | Locale/language specific description of the phenomenon | false | - | varchar(255) | string | 

[top](#Tables)

### platform
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| platform_id | - | true | - | int8 | long | 
| identifier | Unique identifier of the platform which can be used for filtering. | false | - | varchar(255) | string | 
| name | The human readable name of the platform. | false | - | varchar(255) | string | 
| description | A short description of the platform | false | - | varchar(255) | string | 

[top](#Tables)

### platform_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| platform_i18n_id | - | true | - | int8 | long | 
| fk_platform_id | - | true | - | int8 | org.n52.series.db.beans.PlatformEntity | 
| locale | - | true | - | varchar(255) | string | 
| name | - | false | - | varchar(255) | string | 
| description | - | false | - | varchar(255) | string | 
| short_name | - | false | - | varchar(255) | string | 
| long_name | - | false | - | varchar(255) | string | 

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
| description | - | false | - | varchar(255) | string | 
| is_deleted | - | true | 0 | int2 | small_boolean | 
| is_reference | - | false | 0 | int2 | small_boolean | 
| is_aggregation | - | false | 1 | int2 | small_boolean | 

[top](#Tables)

### procedure_i18n
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| procedure_i18n_id | - | true | - | int8 | long | 
| fk_procedure_id | - | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| locale | - | true | - | varchar(255) | string | 
| name | - | false | - | varchar(255) | string | 
| description | - | false | - | varchar(255) | string | 
| short_name | - | false | - | varchar(255) | string | 
| long_name | - | false | - | varchar(255) | string | 

[top](#Tables)

### sampling
**Description**: Storage of the samplings.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| sampling_id | PK column of the table | true | - | int8 | long | 
| fk_measuring_program_id | Reference to the measuring program to which this sampling belongs. | true | - | int8 | org.n52.series.db.beans.sampling.MeasuringProgramEntity | 
| identifier | The identifier of the sampling. | false | - | varchar(255) | string | 
| name | The human readable name or the label of the sampling. | false | - | varchar(255) | string | 
| description | A short description or the COMMENT of the sampling | false | - | varchar(255) | string | 
| sampler | The sampler who take the sample. | false | - | varchar(255) | string | 
| sampling_method | The sampling method used to take the sample | false | - | varchar(255) | string | 
| environmental_conditions | The environmental conditions when the sample was made. | false | - | varchar(255) | string | 
| sampling_time_start | The timestamp when the observation period has started. | true | - | timestamp with time zone | timestamp | 
| sampling_time_end | The timestamp when the measurement period has finished or the observation took place. | true | - | timestamp with time zone | timestamp | 

[top](#Tables)

### sampling_dataset
**Description**: Storage of relations between dataset and related samplings

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
| locale | Locale/language specification for this entry | true | - | varchar(255) | string | 
| name | Locale/language specific name of the data entity | false | - | varchar(255) | string | 
| description | Locale/language specific description of the data entity | false | - | varchar(255) | string | 

[top](#Tables)

### unit
**Description**: Storage of the units of measurement

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| unit_id | PK column of the table | true | - | int8 | long | 
| symbol | The symbol of the unit, e.g. °C or m. | true | - | varchar(255) | string | 
| name | Human readable name of the unit. | false | - | varchar(255) | string | 
| link | Reference to a description of the unit. | false | - | varchar(255) | string | 

[top](#Tables)

### unit_i18n
**Description**: Storage for internationalizations of units.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| unit_i18n_id | PK column of the table | true | - | int8 | long | 
| fk_unit_id | Reference to the unit table this internationalization belongs to. | true | - | int8 | org.n52.series.db.beans.UnitEntity | 
| locale | Locale/language specification for this unit | true | - | varchar(255) | string | 
| name | Locale/language specific name of the unit | false | - | varchar(255) | string | 

[top](#Tables)

### value_profile
**Description**: -

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| fk_observation_id | Reference to the data/observation | true | - | int8 | long | 
| orientation | The "orientation" of the vertical values, e.g. depth or height | false | - | varchar(255) | string | 
| vertical_from_name | The name of the vertical from values, e.g. from or depthFrom | false | - | varchar(255) | string | 
| vertical_to_name | The name of the vertical from values, e.g. to or depthTo | false | - | varchar(255) | string | 
| fk_vertical_unit_id | The unit of the vertical value, e.g. m | true | - | int8 | org.n52.series.db.beans.UnitEntity | 

[top](#Tables)


*Creation date: 2018-11-23 14:47:29 +01:00*
