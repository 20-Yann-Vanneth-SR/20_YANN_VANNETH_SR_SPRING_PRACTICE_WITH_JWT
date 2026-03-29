package org.yannvanneth.event_ticketing_system.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.yannvanneth.event_ticketing_system.exception.BadRequestException;
import org.yannvanneth.event_ticketing_system.exception.NotFoundException;
import org.yannvanneth.event_ticketing_system.model.entity.VenueModel;
import org.yannvanneth.event_ticketing_system.model.request.VenueRequest;
import org.yannvanneth.event_ticketing_system.repository.VenueRepository;
import org.yannvanneth.event_ticketing_system.service.VenueService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService {

    private final VenueRepository venueRepository;

    @Override
    public List<VenueModel> getAllVenues(Integer page, Integer size) {
        return venueRepository.getAllVenues(page, size);
    }

    @Override
    public VenueModel getVenueById(Long id) {

        VenueModel venue = venueRepository.getVenueById(id);

        if (venue == null) {
            throw new NotFoundException("Venue with id " + id + " not found.");
        }

        return venue;
    }

    @Override
    public VenueModel saveVenue(VenueRequest request) {
        return venueRepository.saveVenue(request);
    }

    @Override
    public VenueModel updateVenueById(Long id, VenueRequest request) {

        VenueModel venue = venueRepository.updateVenueById(id, request);

        if (venue == null) {
            throw new NotFoundException("Venue with id " + id + " not found.");
        }

        return venue;
    }

    @Override
    public Void deleteVenueById(Long id) {

        VenueModel venue = venueRepository.deleteVenueById(id);

        if (venue == null) {
            throw new NotFoundException("Venue with id " + id + " not found.");
        }

        return null;
    }
}
