create table venues(
    venue_id serial primary key,
    venue_name varchar(60) not null,
    location varchar(120) not null
);

create table attendees(
    attendee_id serial primary key,
    attendee_name varchar(60) not null,
    email varchar(30) not null
);

create table events(
    event_id serial primary key,
    event_name varchar(120) not null,
    event_date date not null,
    venue_id integer references venues(venue_id)
);

create table event_attendee(
    attendee_id integer not null,
    event_id integer not null,
    primary key (attendee_id, event_id),
    foreign key (attendee_id) references attendees(attendee_id) on delete cascade,
    foreign key (event_id) references events(event_id) on delete cascade
);
--
-- drop table event_attendee;
-- drop table events;
-- drop table attendees;
-- drop table venues;
