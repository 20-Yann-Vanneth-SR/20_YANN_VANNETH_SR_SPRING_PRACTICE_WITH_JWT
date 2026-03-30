package org.yannvanneth.event_ticketing_system.service;

import jakarta.validation.Valid;
import org.yannvanneth.event_ticketing_system.model.entity.AttendeeModel;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeRequest;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeUpdateRequest;

import java.util.List;

public interface AttendeeService {
    List<AttendeeModel> getAllAttendees(Integer page, Integer size);

    AttendeeModel getAttendeeById(Long id);

    AttendeeModel saveAttendee(@Valid AttendeeRequest request);

    AttendeeModel updateAttendeeById(Long id, @Valid AttendeeUpdateRequest request);

    Void deleteAttendeeById(Long id);
}
