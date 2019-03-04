create TABLE IF NOT EXISTS production_errors(
id uuid primary key,
problem varchar(256),
service varchar(64),
external_service varchar(64),
start_time timestamp with time zone,
end_time timestamp with time zone,
summary text,
rca varchar(256));