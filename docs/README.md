# Data Model Documentation
Documentaion resources reside within this directory. It
gives a coarse overview and shows how optional features
can be applied to extend the core.

## Overview

This overview shows the whole data model consisting of the [core](#core) and [additional features](#additional-features).

![overview](https://github.com/52North/series-hibernate/blob/develop/docs/images/overview.png)

## Core

The core data model provices all necessary tables which are required to provide data via the REST-API or the SOS interface.

![core](https://github.com/52North/series-hibernate/blob/develop/docs/images/core.png)



## Additional features

Additional features are modeled to extend the core data model but the core data model does not have any dependency on the additional features.

### Datatype



![additional-datatype](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-datatype.png)

### Feature types



![additional-featuretypes](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-featuretypes.png)

### Metadata

The metadata feature provides additional information (metadata) for datasets.

![additional-metadata](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-metadata.png)

### Hierarchies



![hierarchies](https://github.com/52North/series-hibernate/blob/develop/docs/images/hierarchies.png)

### Procedure history

The procedure history feature is mainly required by the SOS interface to support history of procedure description which are update via the  UpdateProcedureDescription operation and can be queried via DescribeSensor operation.

![procedure-history](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-datatype.png)

### Referenced datasets

This feature allows to reference datasets in another dataset. For example a water level dataset has the referenced datasets level zero and medium water level.

![reference-datasets](https://github.com/52North/series-hibernate/blob/develop/docs/images/procedure-history.png)

### Relations

With the relations feature we can model relations between data/observations. For example a post-processed observation relates on a raw observation which was measured by a sensor.

![relations](https://github.com/52North/series-hibernate/blob/develop/docs/images/relations.png)

### Result templates

The result template feature is mainly required by the SOS interface to support the result handling operations (Insert-/GerResultTemplate, Insert-/GetResult).

![result-template](https://github.com/52North/series-hibernate/blob/develop/docs/images/result-template.png)

### Translations

With the translations feature the data model can provide internationalized values, for example the name of the feature, procedure or phenomenon.

![translations](https://github.com/52North/series-hibernate/blob/develop/docs/images/translations.png)


## Tables and columns

The tables and columns are described here: [Tables and columns description](https://github.com/52North/series-hibernate/blob/develop/docs/tableMetadata.md)

### Conventions

| convention | description | example |
| --- | --- | --- |
| name | _ between words | sampling_time_end |
| primary key column | table name + _id | dataset_id |
| foreign key column | fk_ + ( additional information +) referenced table name + _id | fk_unit_id, fk_first_observation_id |
| index | idx_ + column name | idx_sampling_time_end |
| unique constraint | un_ + table name + column name/postfix | un_feature_identifier, un_dataset_identity (multiple columns) |


**Note**: Documentation is in progress. `graphml` files can
be view with [`yed`-Editor](https://www.yworks.com/products/yed)
