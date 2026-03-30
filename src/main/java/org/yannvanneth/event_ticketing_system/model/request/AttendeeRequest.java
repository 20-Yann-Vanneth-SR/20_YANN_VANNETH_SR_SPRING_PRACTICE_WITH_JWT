package org.yannvanneth.event_ticketing_system.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AttendeeRequest {
    @NotBlank(message = "Attendee name cannot be blank")
    @Size(min = 4, max = 50, message = "Attendee name must be between 4 and 50 characters")
    @JsonProperty(required = true)
    private String attendeeName;

    @Email
    @Size(min = 4, max = 50, message = "email must be between 4 and 50 characters")
    @JsonProperty(required = true)
    private String email;
}
