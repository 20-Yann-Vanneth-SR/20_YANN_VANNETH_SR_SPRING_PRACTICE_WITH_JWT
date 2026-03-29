package org.yannvanneth.event_ticketing_system.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.yannvanneth.event_ticketing_system.model.entity.AttendeeModel;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeRequest;
import org.yannvanneth.event_ticketing_system.model.response.ApiResponse;
import org.yannvanneth.event_ticketing_system.service.AttendeeService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/attendees")
@RequiredArgsConstructor
@Validated
public class AttendeeController {

    private final AttendeeService attendeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<AttendeeModel>>> getAttendees(
             @RequestParam(defaultValue = "1") @Positive(message = "page must be greater than 0") Integer page,
             @RequestParam(defaultValue = "10") @Positive(message = "size must be greater than 0") Integer size) {

        List<AttendeeModel> attendees = attendeeService.getAllAttendees(page, size);

        ApiResponse<List<AttendeeModel>> response = ApiResponse.success("Retrieved attendees successfully", attendees);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<AttendeeModel>> getAttendeeById(@PathVariable("attendeeId") Long id) {

        ApiResponse<AttendeeModel> response = ApiResponse.success(String.format("Retrieved attendee with id %d successfully", id), attendeeService.getAttendeeById(id));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<AttendeeModel>> saveAttendee(@Valid @RequestBody AttendeeRequest request) {

        ApiResponse<AttendeeModel> response = ApiResponse.created("Created attendee successfully", attendeeService.saveAttendee(request));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<AttendeeModel>> updateAttendeeById(@PathVariable("attendeeId") Long id,@Valid  @RequestBody AttendeeRequest request) {

        ApiResponse<AttendeeModel> response = ApiResponse.success(String.format("Updated attendee with id %d successfully", id), attendeeService.updateAttendeeById(id, request));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{attendeeId}")
    public ResponseEntity<ApiResponse<Void>> deleteAttendeeById(@PathVariable("attendeeId") Long id) {

        ApiResponse<Void> response = ApiResponse.success(String.format("Deleted attendee with id %d successfully", id), attendeeService.deleteAttendeeById(id));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
