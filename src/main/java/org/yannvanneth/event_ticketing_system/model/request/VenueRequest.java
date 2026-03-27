package org.yannvanneth.event_ticketing_system.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VenueRequest {
    private String venueName;
    private String location;
}
