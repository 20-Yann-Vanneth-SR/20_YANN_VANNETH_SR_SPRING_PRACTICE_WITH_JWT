package org.yannvanneth.event_ticketing_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yannvanneth.event_ticketing_system.model.entity.EventModel;
import org.yannvanneth.event_ticketing_system.model.request.EventRequest;
import org.yannvanneth.event_ticketing_system.model.response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
public class EventController {
    @GetMapping
    public ResponseEntity<ApiResponse<List<EventModel>>> getEvents() {
        return null;
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<ApiResponse<EventModel>> getEventById(@PathVariable("eventId") Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EventModel>> saveevent(@RequestBody EventRequest request) {
        return null;
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<ApiResponse<EventModel>> updateeventById(@PathVariable("eventId") Long id,  @RequestBody EventRequest request) {
        return null;
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<ApiResponse<Void>> deleteeventById(@PathVariable("eventId") Long id) {
        return null;
    }
}
