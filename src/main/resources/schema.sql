create table public.book(
id integer primary key generated always as identity,
name varchar(100),
author varchar(50),
primary key(id)
);

ALTER TABLE IF EXISTS public.book
    OWNER to postgres;