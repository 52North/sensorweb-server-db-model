# Database table/column description
This page describes the tables and columns in the database.
The *SQL type* column in the tables is generated for Hibernate dialect: *PostgisPG95Dialect*

## Tables
- [category](#category)
- [category_i18n](#category_i18n)
- [codespace](#codespace)
- [dataset](#dataset)
- [dataset_reference](#dataset_reference)
- [feature](#feature)
- [feature_i18n](#feature_i18n)
- [format](#format)
- [observation](#observation)
- [offering](#offering)
- [offering_i18n](#offering_i18n)
- [phenomenon](#phenomenon)
- [phenomenon_i18n](#phenomenon_i18n)
- [procedure](#procedure)
- [procedure_i18n](#procedure_i18n)
- [unit](#unit)
- [unit_i18n](#unit_i18n)

### category
**Description**: Storage of the categories.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| category_id | PK column of the table | true | - | int8 | long | 
| identifier | Unique identifier of the category which can be for filtering, e.g. in the SOS. | true | - | varchar(255) | string | 
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

### dataset
**Description**: Storage of the dataset, the core table of the whole database model.

| column | comment | NOT-NULL | default | SQL type | Java type |
| --- | --- | --- | --- | --- | --- |
| dataset_id | PK column of the table | true | - | int8 | long | 
| value_type | Indicator used by Hibernate to map value specific entities. | true | - | varchar(255) | string | 
| fk_procedure_id | Reference to the procedure that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.ProcedureEntity | 
| fk_phenomenon_id | Reference to the phenomenon that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.PhenomenonEntity | 
| fk_offering_id | Reference to the offering that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.OfferingEntity | 
| fk_category_id | Reference to the category that belongs that belongs to this dataset. | true | - | int8 | org.n52.series.db.beans.CategoryEntity | 
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

[top](#Tables)

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

[top](#Tables)

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


*Creation date: 2018-07-06 09:33:57 +02:00*
