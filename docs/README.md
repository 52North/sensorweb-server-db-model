# Data Model Documentation
Documentaion resources reside within this directory. It
gives a coarse overview and shows how optional features
can be applied to extend the core.

## Overview

This overview shows the whole data model consisting of the [core](#core) and [additional features](#additional-features).

![overview](https://github.com/52North/series-hibernate/blob/develop/docs/images/overview.png)

## Core

The core data model provides all necessary tables which are required to provide data via the REST-API or the SOS interface.

![core](https://github.com/52North/series-hibernate/blob/develop/docs/images/core.png)

### Core tables

- [category](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#category)
- [codespace](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#codespace)
- [dataset](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#dataset)
- [feature](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#feature)
- [format](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#format)
- [observation](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#observation)
- [offering](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#offering)
- [phenomenon](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#phenomenon)
- [procedure](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#procedure)
- [unit](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md#unit)

## Additional Features

The additional features are defined here: [Additional Features ](https://github.com/52North/series-hibernate/blob/develop/docs/AdditionalFeatures.md)

## Tables and columns

The tables and columns are described here: [Tables and columns description](https://github.com/52North/series-hibernate/blob/develop/docs/TableMetadata.md)

### Conventions

| convention | description | example |
| --- | --- | --- |
| name | _ between words | sampling_time_end |
| primary key column | table name + _id | dataset_id |
| foreign key column | fk_ + ( additional information +) referenced table name + _id | fk_unit_id, fk_first_observation_id |
| index | idx_ + column name | idx_sampling_time_end |
| unique constraint | un_ + table name + column name/postfix | un_feature_identifier, un_dataset_identity (multiple columns) |
| not-null columns | columns marked as not null are required and should be mapped as formula or the property | observation.vertical_from, observation.vertical_to |
| sqmpling_time properties | if only one timestamp column is available, you can map the properties to one column with insert/update=false for one property |


**Note**: Documentation is in progress. `graphml` files can
be view with [`yed`-Editor](https://www.yworks.com/products/yed)
