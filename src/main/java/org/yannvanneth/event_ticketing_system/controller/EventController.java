package org.yannvanneth.event_ticketing_system.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.yannvanneth.event_ticketing_system.model.entity.EventModel;
import org.yannvanneth.event_ticketing_system.model.request.EventRequest;
import org.yannvanneth.event_ticketing_system.model.response.ApiResponse;
import org.yannvanneth.event_ticketing_system.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@Validated
public class EventController {

    private final EventService eventService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EventModel>>> getEvents(
            @RequestParam(defaultValue = "1") @Positive(message = "page must be greater than 0") Integer page,
            @RequestParam(defaultValue = "10") @Positive(message = "size must be greater than 0") Integer size) {

        List<EventModel> events = eventService.getAllEvents(page, size);

        ApiResponse<List<EventModel>> response = ApiResponse.success("Retrieved events successfully", events);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<ApiResponse<EventModel>> getEventById(@PathVariable("eventId") Long id) {

        ApiResponse<EventModel> response = ApiResponse.success(String.format("Retrieved event with id %d successfully", id), eventService.getEventById(id));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EventModel>> saveEvent(@Valid @RequestBody EventRequest request) {

        ApiResponse<EventModel> response = ApiResponse.created("Created event successfully", eventService.saveEvent(request));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{eventId}")
    public ResponseEntity<ApiResponse<EventModel>> updateEventById(@PathVariable("eventId") Long id,@Valid  @RequestBody EventRequest request) {

        ApiResponse<EventModel> response = ApiResponse.success(String.format("Updated event with id %d successfully", id), eventService.updateEventById(id, request));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{eventId}")
    public ResponseEntity<ApiResponse<Void>> deleteEventById(@PathVariable("eventId") Long id) {

        ApiResponse<Void> response = ApiResponse.success(String.format("Deleted event with id %d successfully", id), eventService.deleteEventById(id));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
