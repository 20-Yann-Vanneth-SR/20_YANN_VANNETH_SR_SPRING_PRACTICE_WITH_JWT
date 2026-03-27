package org.yannvanneth.event_ticketing_system.controller;

import org.apache.ibatis.annotations.Delete;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yannvanneth.event_ticketing_system.model.entity.VenueModel;
import org.yannvanneth.event_ticketing_system.model.request.VenueRequest;
import org.yannvanneth.event_ticketing_system.model.response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/venues")
public class VenueController {

    @GetMapping
    public ResponseEntity<ApiResponse<List<VenueModel>>>  getVenues() {
        return null;
    }

    @GetMapping("/{venueId}")
    public ResponseEntity<ApiResponse<VenueModel>> getVenueById(@PathVariable("venueId") Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<VenueModel>> saveVenue(@RequestBody VenueRequest request) {
        return null;
    }

    @PutMapping("/{venueId}")
    public ResponseEntity<ApiResponse<VenueModel>> updateVenueById(@PathVariable("venueId") Long id,  @RequestBody VenueRequest request) {
        return null;
    }

    @DeleteMapping("/{venueId}")
    public ResponseEntity<ApiResponse<Void>> deleteVenueById(@PathVariable("venueId") Long id) {
        return null;
    }
}
