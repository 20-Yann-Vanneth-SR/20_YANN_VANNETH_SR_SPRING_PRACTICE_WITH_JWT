package org.yannvanneth.event_ticketing_system.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttendeeRequest {
    private String attendeeName;
    private String email;
}
