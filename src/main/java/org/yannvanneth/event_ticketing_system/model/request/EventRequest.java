package org.yannvanneth.event_ticketing_system.model.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    @NotBlank(message = "Event name cannot be blank")
    @Size(min = 4, max = 50, message = "Event name must be between 4 and 50 characters")
    private String eventName;

    @Future(message = "Event date must be in the future")
    private Date eventDate;

    private Long venueId;

    private List<Long> attendeeIds;
}
