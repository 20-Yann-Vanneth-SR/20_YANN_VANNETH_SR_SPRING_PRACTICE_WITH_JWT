package org.yannvanneth.event_ticketing_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yannvanneth.event_ticketing_system.exception.BadRequestException;
import org.yannvanneth.event_ticketing_system.exception.NotFoundException;
import org.yannvanneth.event_ticketing_system.model.entity.AttendeeModel;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeRequest;
import org.yannvanneth.event_ticketing_system.repository.AttendeeRepository;
import org.yannvanneth.event_ticketing_system.service.AttendeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Override
    public List<AttendeeModel> getAllAttendees(Integer page, Integer size) {

        return attendeeRepository.getAllAttendees(page, size);
    }

    @Override
    public AttendeeModel getAttendeeById(Long id) {

        AttendeeModel attendee = attendeeRepository.getAttendeeById(id);

        if (attendee == null) {
            throw new NotFoundException("Attendee with id " + id + " not found.");
        }

        return attendee;
    }

    @Override
    public AttendeeModel saveAttendee(AttendeeRequest request) {
        return attendeeRepository.saveAttendee(request);
    }

    @Override
    public AttendeeModel updateAttendeeById(Long id, AttendeeRequest request) {

        AttendeeModel attendee = attendeeRepository.updateAttendeeById(id, request);

        if (attendee == null) {
            throw new NotFoundException("Attendee with id " + id + " not found.");
        }

        return attendee;
    }

    @Override
    public Void deleteAttendeeById(Long id) {

        AttendeeModel attendee = attendeeRepository.deleteAttendeeById(id);

        if (attendee == null) {
            throw new NotFoundException("Attendee with id " + id + " not found.");
        }

        return null;
    }
}
