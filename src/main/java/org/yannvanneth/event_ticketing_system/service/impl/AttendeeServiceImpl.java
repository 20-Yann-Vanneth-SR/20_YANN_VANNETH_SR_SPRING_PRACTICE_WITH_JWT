package org.yannvanneth.event_ticketing_system.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yannvanneth.event_ticketing_system.exception.ConflictException;
import org.yannvanneth.event_ticketing_system.exception.NotFoundException;
import org.yannvanneth.event_ticketing_system.model.entity.AttendeeModel;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeRequest;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeUpdateRequest;
import org.yannvanneth.event_ticketing_system.repository.AttendeeRepository;
import org.yannvanneth.event_ticketing_system.service.AttendeeService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendeeServiceImpl implements AttendeeService {

    private final AttendeeRepository attendeeRepository;

    @Override
    public List<AttendeeModel> getAllAttendees(Integer page, Integer size) {

        return attendeeRepository.getAllAttendees((page - 1) * size, size);
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

        String email = attendeeRepository.getAttendeeByEmail(request.getEmail());
        String name = attendeeRepository.getAttendeeByName(request.getAttendeeName());

        if (name != null) {
            throw new ConflictException("Attendee with name " + request.getAttendeeName() + " already exists.");
        }

        if (email != null) {
            throw new ConflictException("Attendee with email " + email + " already exists.");
        }

        return attendeeRepository.saveAttendee(request);
    }

    @Transactional
    @Override
    public AttendeeModel updateAttendeeById(Long id, AttendeeUpdateRequest request) {

        String name = attendeeRepository.getAttendeeByName(request.getAttendeeName());

        if(name != null) {
            throw new ConflictException("Attendee with name " + request.getAttendeeName() + " already exists.");
        }

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
