package org.yannvanneth.event_ticketing_system.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttendeeUpdateRequest {
    @NotBlank(message = "Attendee name must contain only letters and spaces")
    @JsonProperty(required = true)
    private String attendeeName;
}
