package org.yannvanneth.event_ticketing_system.service;

import jakarta.validation.Valid;
import org.yannvanneth.event_ticketing_system.model.entity.EventModel;
import org.yannvanneth.event_ticketing_system.model.request.EventRequest;

import java.util.List;

public interface EventService {
    List<EventModel> getAllEvents(Integer page, Integer size);

    EventModel getEventById(Long id);

    EventModel saveEvent(@Valid EventRequest request);

    EventModel updateEventById(Long id, @Valid EventRequest request);

    Void deleteEventById(Long id);
}
