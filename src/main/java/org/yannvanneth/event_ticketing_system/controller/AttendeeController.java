package org.yannvanneth.event_ticketing_system.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.yannvanneth.event_ticketing_system.model.entity.AttendeeModel;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeRequest;
import org.yannvanneth.event_ticketing_system.model.response.ApiResponse;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
public class AttendeeController {
    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendeeModel>>> getAttendees() {
        return null;
    }

    @GetMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<AttendeeModel>> getAttendeeById(@PathVariable("attendeeId") Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttendeeModel>> saveAttendee(@RequestBody AttendeeRequest request) {
        return null;
    }

    @PutMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<AttendeeModel>> updateAttendeeById(@PathVariable("attendeeId") Long id,  @RequestBody AttendeeRequest request) {
        return null;
    }

    @DeleteMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<Void>> deleteAttendeeById(@PathVariable("attendeeId") Long id) {
        return null;
    }
}
