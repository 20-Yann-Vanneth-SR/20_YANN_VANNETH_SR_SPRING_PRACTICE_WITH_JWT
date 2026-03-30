package org.yannvanneth.event_ticketing_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yannvanneth.event_ticketing_system.exception.ConflictException;
import org.yannvanneth.event_ticketing_system.exception.NotFoundException;
import org.yannvanneth.event_ticketing_system.model.entity.EventModel;
import org.yannvanneth.event_ticketing_system.model.request.EventRequest;
import org.yannvanneth.event_ticketing_system.repository.EventAttendeeRepository;
import org.yannvanneth.event_ticketing_system.repository.EventRepository;
import org.yannvanneth.event_ticketing_system.service.AttendeeService;
import org.yannvanneth.event_ticketing_system.service.EventService;
import org.yannvanneth.event_ticketing_system.service.VenueService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;
    private final EventAttendeeRepository eventAttendeeRepository;
    private final VenueService venueService;
    private final AttendeeService attendeeService;

    @Override
    public List<EventModel> getAllEvents(Integer page, Integer size) {
        return eventRepository.getAllEvents((page-1) * size, size);
    }

    @Override
    public EventModel getEventById(Long id) {

        EventModel event = eventRepository.getEventById(id);

        if (event == null) {
            throw new NotFoundException("Event with id " + id + " not found.");
        }

        return event;
    }

    @Transactional
    @Override
    public EventModel saveEvent(EventRequest request) {

        Boolean isExist = eventRepository.getEventByNameAndDate(request.getEventName(), request.getEventDate());

        if (isExist) {
            throw new ConflictException("Event name already exists on this date");
        }

        venueService.getVenueById(request.getVenueId());

        EventModel event = eventRepository.saveEvent(request);

        for(Long attendeeId : request.getAttendeeIds()){
            attendeeService.getAttendeeById(attendeeId);
            eventAttendeeRepository.save(attendeeId, event.getEventId());
        }

        return this.getEventById(event.getEventId());
    }

    @Transactional
    @Override
    public EventModel updateEventById(Long id, EventRequest request) {

        Boolean isExist = eventRepository.getEventByNameAndDate(request.getEventName(), request.getEventDate());

        if (isExist) {
            throw new ConflictException("Event name already exists on this date");
        }

        EventModel event = this.getEventById(id);

        eventAttendeeRepository.deleteAllByEventId(event.getEventId());

        event = eventRepository.updateEventById(id, request);

        for(Long attendeeId : request.getAttendeeIds()){
            eventAttendeeRepository.save(event.getEventId(), attendeeId);
        }

        return this.getEventById(event.getEventId());
    }

    @Override
    public Void deleteEventById(Long id) {

        EventModel event = eventRepository.deleteEventById(id);

        if (event == null) {
            throw new NotFoundException("Event with id " + id + " not found.");
        }

        return null;
    }
}
