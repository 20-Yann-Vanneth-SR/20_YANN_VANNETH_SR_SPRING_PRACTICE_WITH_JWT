package org.yannvanneth.event_ticketing_system.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventRequest {
    @NotBlank(message = "Event name cannot be blank")
    @JsonProperty(required = true)
    private String eventName;

    @JsonProperty(required = true)
    @Future(message = "Event date must be in the future")
    @NotNull(message = "Event Date cannot be null")
    private LocalDate eventDate;

    @JsonProperty(required = true)
    private Long venueId;

    @JsonProperty(required = true)
    private List<Long> attendeeIds;
}
