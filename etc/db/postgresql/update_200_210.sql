-- update - drop not null
ALTER TABLE public.result_template ALTER COLUMN structure DROP NOT NULL;
ALTER TABLE public.result_template ALTER COLUMN encoding DROP NOT NULL;
-- add columns
ALTER TABLE public.result_template ADD COLUMN observation_structure text;
ALTER TABLE public.result_template ADD COLUMN observation_encoding text;