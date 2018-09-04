# Additional features

Additional features are modeled to extend the core data model but the core data model does not have any dependency on the additional features.

## Features

- [SOS Transactional](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#sos-transactional)
- [Datatype](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#datatype)
- [Feature types](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#feature-types)
- [Metadata](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#metadata)
- [Hierarchies](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#hierarchies)
- [Procedure history](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#procedure-history)
- [Referenced datasets](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#referenced-datasets)
- [Relations](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#relations)
- [Result templates](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#result-templates)
- [Parameter](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#parameter)
- [Translations](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md#translations)


### SOS Transactional

This extension is necessary to support the full transactional profile of the SOS interface.

#### SOS Transactional tables

- [offering_feature_type](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#offering_feature_type)
- [offering_observation_type](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#offering_observation_type)
- [offering_related_feature](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#offering_related_feature)

### Datatype

The additional datatypes are used to provide complex onbservations like profiles or data arrays.

![additional-datatype](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-datatype.png)

#### Datatype tables

- [composite_observation](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#composite_observation)
- [composite_phenomenon](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#composite_phenomenon)
- [value_blob](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#value_blob)
- [value_data_array](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#value_data_array)
- [value_profile](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#value_profile)

### Feature types

Allows the modeling of feature types that provides additional properties.

![additional-featuretypes](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-featuretypes.png)

#### Feature types tables

Currently not available.

### Metadata

The metadata feature provides additional information (metadata) for datasets.

![additional-metadata](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-metadata.png)

#### Metadta tables

- [dataset_parameter](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#dataset_parameter)
- [parameter](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#parameter)

### Hierarchies

With the hierarchies you can model parent/child relations between objects. For example for features, a town in a country where the country is the parent of the town and the town is the child of the country.

![hierarchies](https://github.com/52North/series-hibernate/blob/develop/docs/images/hierarchies.png)

#### Hierarchies tables

- [feature_hierarchy](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#feature_hierarchy)
- [offering_hierarchy](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#offering_hierarchy)
- [procedure_hierarchy](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#procedure_hierarchy)

### Procedure history

The procedure history feature is mainly required by the SOS interface to support history of procedure description which are update via the  UpdateProcedureDescription operation and can be queried via DescribeSensor operation.

![procedure-history](https://github.com/52North/series-hibernate/blob/develop/docs/images/procedure-history.png)

### Procedure history tables

- [procedure_history](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#procedure_history)

### Referenced datasets

This feature allows to reference datasets in another dataset. For example a water level dataset has the referenced datasets level zero and medium water level.

![reference-datasets](https://github.com/52North/series-hibernate/blob/develop/docs/images/reference-datasets.png)

#### Referenced datasets tables

- [dataset_reference](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#dataset_reference)

### Relations

With the relations feature we can model relations between data/observations. For example a post-processed observation relates on a raw observation which was measured by a sensor.

![relations](https://github.com/52North/series-hibernate/blob/develop/docs/images/relations.png)

#### Relation tables

- [related_dataset](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#related_dataset)
- [related_feature](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#related_feature)
- [related_observation](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#related_observation)

### Result templates

The result template feature is mainly required by the SOS interface to support the result handling operations (Insert-/GerResultTemplate, Insert-/GetResult).

![result-template](https://github.com/52North/series-hibernate/blob/develop/docs/images/result-template.png)

#### Result templates tables

- [result_template](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#result_template)

### Parameter

Allow to provide additional information for features, observations and datasets. This information would be, for example, provided in the om:parameter of an OM_Obseration.

![result-template](https://github.com/52North/series-hibernate/blob/develop/docs/images/parameter.png)

#### Parameter tables

- [dataset_parameter](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#dataset_parameter)
- [feature_parameter](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#feature_parameter)
- [observation_parameter](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#observation_parameter)
- [parameter](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#parameter)

### Translations

With the translations feature the data model can provide internationalized values, for example the name of the feature, procedure or phenomenon.

![translations](https://github.com/52North/series-hibernate/blob/develop/docs/images/translations.png)

#### Translation tables

- [category_i18n](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#category_i18n)
- [feature_i18n](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#feature_i18n)
- [offering_i18n](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#offering_i18n)
- [phenomenon_i18n](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#phenomenon_i18n)
- [procedure_i18n](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#procedure_i18n)
- [unit_i18n](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#unit_i18n)
