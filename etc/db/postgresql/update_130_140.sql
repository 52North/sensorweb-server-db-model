-- update feature table
alter table public.feature add column sta_identifier varchar(255);
update public.feature set sta_identifier = feature_id;
alter table public.feature alter column sta_identifier set not null;

-- update datastream table
alter table public.datastream add column sta_identifier varchar(255);
update public.datastream set sta_identifier = datastream_id;
alter table public.datastream alter column sta_identifier set not null;

-- update location table
alter table public.location add column sta_identifier varchar(255);
update public.location set sta_identifier = location_id;
alter table public.location alter column sta_identifier set not null;

-- update historical_location table
alter table public.historical_location add column sta_identifier varchar(255);
update public.historical_location set sta_identifier = historical_location_id;;
alter table public.historical_location alter column sta_identifier set not null;

-- update observation table
alter table public.observation add column sta_identifier varchar(255);
update public.observation set sta_identifier = observation_id;
alter table public.observation alter column sta_identifier set not null;

-- update platform table
alter table public.platform add column sta_identifier varchar(255);
update public.platform set sta_identifier = platform_id;
alter table public.platform alter column sta_identifier set not null;

-- update procedure table
alter table public.procedure add column sta_identifier varchar(255);
update public.procedure set sta_identifier = procedure_id;
alter table public.procedure alter column sta_identifier set not null;