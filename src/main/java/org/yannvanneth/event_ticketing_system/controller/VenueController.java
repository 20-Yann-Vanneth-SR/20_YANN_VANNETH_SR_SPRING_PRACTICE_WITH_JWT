package org.yannvanneth.event_ticketing_system.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yannvanneth.event_ticketing_system.model.entity.VenueModel;
import org.yannvanneth.event_ticketing_system.model.request.VenueRequest;
import org.yannvanneth.event_ticketing_system.model.response.ApiResponse;
import org.yannvanneth.event_ticketing_system.service.VenueService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
@RequiredArgsConstructor
public class VenueController {

    private final VenueService venueService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueModel>>>  getVenues(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size) {

        List<VenueModel> venues = venueService.getAllVenues(page, size);

        ApiResponse<List<VenueModel>> response = ApiResponse.success("Retrieved venues successfully", venues);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{venueId}")
    public ResponseEntity<ApiResponse<VenueModel>> getVenueById(@PathVariable("venueId") Long id) {

        ApiResponse<VenueModel> response = ApiResponse.success(String.format("Retrieved venue with id %d successfully", id), venueService.getVenueById(id));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VenueModel>> saveVenue(@Valid @RequestBody VenueRequest request) {

        ApiResponse<VenueModel> response = ApiResponse.created("Created venue successfully", venueService.saveVenue(request));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{venueId}")
    public ResponseEntity<ApiResponse<VenueModel>> updateVenueById(@PathVariable("venueId") Long id,@Valid  @RequestBody VenueRequest request) {

        ApiResponse<VenueModel> response = ApiResponse.success(String.format("Updated venue with id %d successfully", id), venueService.updateVenueById(id, request));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{venueId}")
    public ResponseEntity<ApiResponse<Void>> deleteVenueById(@PathVariable("venueId") Long id) {

        ApiResponse<Void> response = ApiResponse.success(String.format("Deleted venue with id %d successfully", id), venueService.deleteVenueById(id));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
