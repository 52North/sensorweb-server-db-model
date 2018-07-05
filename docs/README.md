# Data Model Documentation
Documentaion resources reside within this directory. It
gives a coarse overview and shows how optional features
can be applied to extend the core.

## Overview


![overview](https://github.com/52North/series-hibernate/blob/develop/docs/images/overview.png)

## Additional features

### Datatype

![additional-datatype](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-datatype.png)

### Feature types

![additional-featuretypes](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-featuretypes.png)

### Metadata

![additional-metadata](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-metadata.png)

### Hierarchies

![hierarchies](https://github.com/52North/series-hibernate/blob/develop/docs/images/hierarchies.png)

### Procedure history

![procedure-history](https://github.com/52North/series-hibernate/blob/develop/docs/images/additional-datatype.png)

### Referenced datasets

![reference-datasets](https://github.com/52North/series-hibernate/blob/develop/docs/images/procedure-history.png)

### Relations

![relations](https://github.com/52North/series-hibernate/blob/develop/docs/images/relations.png)

### Result templates

![result-template](https://github.com/52North/series-hibernate/blob/develop/docs/images/result-template.png)

### Translations

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
