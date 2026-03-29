-- Venues
insert into venues (venue_name, location) values
                                              ('Phnom Penh Hall', 'Phnom Penh'),
                                              ('Siem Reap Center', 'Siem Reap'),
                                              ('Battambang Club', 'Battambang');

-- Attendees
insert into attendees (attendee_name, email) values
                                                 ('Sok Dara', 'sokdara@gmail.com'),
                                                 ('Chantha Rith', 'chantha@gmail.com'),
                                                 ('Vanna Kim', 'vanna@gmail.com'),
                                                 ('Srey Pov', 'sreypov@gmail.com'),
                                                 ('Dara Sok', 'darasok@gmail.com');

-- Events
insert into events (event_name, event_date, venue_id) values
                                                          ('Khmer New Year Party', '2026-04-14', 1),
                                                          ('Water Festival Meetup', '2026-11-10', 2),
                                                          ('Pchum Ben Gathering', '2026-10-05', 3);

-- Event_Attendee
insert into event_attendee (attendee_id, event_id) values
                                                       (1, 1),
                                                       (2, 1),
                                                       (3, 2),
                                                       (4, 2),
                                                       (5, 3),
                                                       (1, 3);


