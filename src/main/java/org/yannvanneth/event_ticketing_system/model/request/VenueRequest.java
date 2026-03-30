package org.yannvanneth.event_ticketing_system.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VenueRequest {
    @NotBlank(message = "Venue name cannot be blank")
    @Size(min = 4, max = 50, message = "Venue name must be between 4 and 50 characters")
    @JsonProperty(required = true)
    private String venueName;

    @NotBlank(message = "location cannot be blank")
    @Size(min = 4, max = 80, message = "Location must be between 4 and 80 characters")
    @JsonProperty(required = true)
    private String location;
}
