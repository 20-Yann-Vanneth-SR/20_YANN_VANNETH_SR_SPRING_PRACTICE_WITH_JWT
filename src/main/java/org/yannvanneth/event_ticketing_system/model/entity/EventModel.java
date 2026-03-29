package org.yannvanneth.event_ticketing_system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventModel {
    private Long eventId;
    private String eventName;
    private Date eventDate;
    private VenueModel venue;
    private List<AttendeeModel> attendees;
}
