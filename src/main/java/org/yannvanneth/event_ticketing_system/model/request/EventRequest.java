package org.yannvanneth.event_ticketing_system.model.request;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class EventRequest {
    private String eventName;
    private LocalDateTime eventDate;
    private Long venueId;
    private List<Long> attendeeIds;
}
