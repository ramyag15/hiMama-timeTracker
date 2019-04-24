//Users: id, username, first name, last username
//Events: Log in, Log out
//User Events: userid, event_type, date time


create database timetrackerdb;
create table timetrackerdb.users (
  id bigserial primary key,
  username varchar(255) not null,
  first_name varchar(255) not null,
  last_name varchar(255) not null
);

create table events (
  id bigserial primary key,
  event_type varchar(10) not null
);

create table user_events(
 id bigserial primary key,
 user_id bigint references users(id),
 event_id bigint references events(id),
 event_time datetime not null default now(),
);

create unique index ue_idx on user_events (user_id, event_id, event_time);
create unique index uname on users (username);
