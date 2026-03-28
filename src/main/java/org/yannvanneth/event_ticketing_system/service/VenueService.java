package org.yannvanneth.event_ticketing_system.service;

import org.yannvanneth.event_ticketing_system.model.entity.VenueModel;
import org.yannvanneth.event_ticketing_system.model.request.VenueRequest;

import java.util.List;

public interface VenueService {
    List<VenueModel> getAllVenues(Integer page, Integer size);
    VenueModel getVenueById(Long id);
    VenueModel saveVenue(VenueRequest request);
    VenueModel updateVenueById(Long id, VenueRequest request);
    Void deleteVenueById(Long id);
}
