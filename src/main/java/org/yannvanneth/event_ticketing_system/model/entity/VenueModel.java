package org.yannvanneth.event_ticketing_system.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VenueModel {
    private Long venueId;
    private String venueName;
    private String location;
}
