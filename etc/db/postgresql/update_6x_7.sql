-- Hibernate 6 uses a pooled sequence - adjust existing sequences appropriately
  -- dataset_parameter
  CREATE SEQUENCE IF NOT EXISTS dataset_parameter_SEQ;
  SELECT setval('dataset_parameter_SEQ', COALESCE((SELECT MAX(parameter_id) FROM dataset_parameter), 0) + 1, false);

  -- feature_parameter
  CREATE SEQUENCE IF NOT EXISTS feature_parameter_SEQ;
  SELECT setval('feature_parameter_SEQ', COALESCE((SELECT MAX(parameter_id) FROM feature_parameter), 0) + 1, false);

  -- location_parameter
  CREATE SEQUENCE IF NOT EXISTS location_parameter_SEQ;
  SELECT setval('location_parameter_SEQ', COALESCE((SELECT MAX(parameter_id) FROM location_parameter), 0) + 1, false);

  -- observation_parameter
  CREATE SEQUENCE IF NOT EXISTS observation_parameter_SEQ;
  SELECT setval('observation_parameter_SEQ', COALESCE((SELECT MAX(parameter_id) FROM observation_parameter), 0) + 1, false);

  -- phenomenon_parameter
  CREATE SEQUENCE IF NOT EXISTS phenomenon_parameter_SEQ;
  SELECT setval('phenomenon_parameter_SEQ', COALESCE((SELECT MAX(parameter_id) FROM phenomenon_parameter), 0) + 1, false);

  -- platform_parameter
  CREATE SEQUENCE IF NOT EXISTS platform_parameter_SEQ;
  SELECT setval('platform_parameter_SEQ', COALESCE((SELECT MAX(parameter_id) FROM platform_parameter), 0) + 1, false);

  -- procedure_parameter
  CREATE SEQUENCE IF NOT EXISTS procedure_parameter_SEQ;
  SELECT setval('procedure_parameter_SEQ', COALESCE((SELECT MAX(parameter_id) FROM procedure_parameter), 0) + 1, false);

  DO $$
  DECLARE
      seq RECORD;
  BEGIN
      FOR seq IN
          SELECT sequence_schema, sequence_name
          FROM information_schema.sequences
          WHERE sequence_schema = 'public'
      LOOP
          EXECUTE format('ALTER SEQUENCE %I.%I INCREMENT BY 50', seq.sequence_schema, seq.sequence_name);
      END LOOP;
  END $$;


-- convert all boolean columns previously encoded as SMALLINT into real boolean columns
-- required for Hibernate6 as it emits invalid SQL otherwise

drop index if exists idx_dataset_ts_s_cq;

alter table dataset drop constraint if exists dataset_is_deleted_check;
alter table dataset drop constraint if exists dataset_is_disabled_check;
alter table dataset drop constraint if exists dataset_is_hidden_check;
alter table dataset drop constraint if exists dataset_is_insitu_check;
alter table dataset drop constraint if exists dataset_is_mobile_check;
alter table dataset drop constraint if exists dataset_is_published_check;
alter table observation drop constraint if exists observation_is_deleted_check;
alter table "procedure" drop constraint if exists procedure_is_aggregation_check;
alter table "procedure" drop constraint if exists procedure_is_reference_check;

alter table dataset alter column is_deleted drop default;
alter table dataset alter column is_disabled drop default;
alter table dataset alter column is_hidden drop default;
alter table dataset alter column is_insitu drop default;
alter table dataset alter column is_mobile drop default;
alter table dataset alter column is_published drop default;
alter table observation alter column is_deleted drop default;
alter table "procedure" alter column is_aggregation drop default;
alter table "procedure" alter column is_reference drop default;

alter table dataset alter column is_deleted type boolean using is_deleted <> 0;
alter table dataset alter column is_disabled type boolean using is_disabled <> 0;
alter table dataset alter column is_hidden type boolean using is_hidden <> 0;
alter table dataset alter column is_insitu type boolean using is_insitu <> 0;
alter table dataset alter column is_mobile type boolean using is_mobile <> 0;
alter table dataset alter column is_published type boolean using is_published <> 0;
alter table observation alter column is_deleted type boolean using is_deleted <> 0;
alter table observation alter column value_boolean type boolean using value_boolean <> 0;
alter table "procedure" alter column is_aggregation type boolean using is_aggregation <> 0;
alter table "procedure" alter column is_reference type boolean using is_reference <> 0;
alter table dataset_parameter alter column value_boolean type boolean using value_boolean <> 0;
alter table feature_parameter alter column value_boolean type boolean using value_boolean <> 0;
alter table location_parameter alter column value_boolean type boolean using value_boolean <> 0;
alter table observation_parameter alter column value_boolean type boolean using value_boolean <> 0;
alter table phenomenon_parameter alter column value_boolean type boolean using value_boolean <> 0;
alter table platform_parameter alter column value_boolean type boolean using value_boolean <> 0;
alter table procedure_parameter alter column value_boolean type boolean using value_boolean <> 0;

alter table dataset alter column is_deleted set default false;
alter table dataset alter column is_disabled set default false;
alter table dataset alter column is_hidden set default false;
alter table dataset alter column is_insitu set default true;
alter table dataset alter column is_mobile set default false;
alter table dataset alter column is_published set default true;
alter table observation alter column is_deleted set default false;
alter table "procedure" alter column is_aggregation set default true;
alter table "procedure" alter column is_reference set default false;

create index idx_dataset_ts_s_cq on dataset
  using btree (dataset_type, observation_type, value_type, is_deleted, is_published, first_time, last_time)
  where (not is_deleted
     and is_published
     and first_time is not null
     and last_time is not null
     and (dataset_type)::text = 'timeseries'::text
     and (observation_type)::text = 'simple'::text
     and (value_type)::text = any (array[('count'::character varying)::text, ('quantity'::character varying)::text]));