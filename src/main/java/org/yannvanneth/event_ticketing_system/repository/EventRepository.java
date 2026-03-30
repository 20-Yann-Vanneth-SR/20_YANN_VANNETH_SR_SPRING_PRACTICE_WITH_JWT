package org.yannvanneth.event_ticketing_system.repository;

import org.apache.ibatis.annotations.*;
import org.yannvanneth.event_ticketing_system.model.entity.EventModel;
import org.yannvanneth.event_ticketing_system.model.request.EventRequest;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EventRepository {
    @Results(id = "eventMapper", value = {
            @Result(property = "eventId", column = "event_id"),
            @Result(property = "eventName", column = "event_name"),
            @Result(property = "eventDate", column = "event_Date"),
            @Result(property = "venue", column = "venue_id",
                    one = @One(select = "org.yannvanneth.event_ticketing_system.repository.VenueRepository.getVenueById")),
            @Result(property = "attendees", column = "event_id",
                    many = @Many(select = "org.yannvanneth.event_ticketing_system.repository.EventAttendeeRepository.getAttendeesByEventId"))
    })
    @Select("""
        select event_id, event_name, event_date, venue_id from events limit #{size} offset #{page}
    """)
    List<EventModel> getAllEvents(Integer page, Integer size);

    @ResultMap("eventMapper")
    @Select("select event_id, event_name, event_date, venue_id from events where event_id = #{id}")
    EventModel getEventById(Long id);

    @Select("""
      select exists(select event_name, event_date from events
          where lower(event_name) = lower(#{eventName})
          and event_date = #{eventDate})
    """)
    Boolean getEventByNameAndDate(String eventName, LocalDate eventDate);

    @ResultMap("eventMapper")
    @Select("""
      insert into events values (default, #{req.eventName}, #{req.eventDate}, #{req.venueId})
      returning event_id, event_name, event_date, venue_id
    """)
    EventModel saveEvent(@Param("req") EventRequest request);

    @ResultMap("eventMapper")
    @Select("""
      update events set
          event_name = #{req.eventName},
          event_date = #{req.eventDate},
          venue_id = #{req.venueId}
      where event_id = #{id}
      returning event_id, event_name, event_date, venue_id
    """)
    EventModel updateEventById(Long id,@Param("req") EventRequest request);

    @ResultMap("eventMapper")
    @Select("""
      delete from events where event_id = #{id}
      returning event_id, event_name, event_date, venue_id
    """)
    EventModel deleteEventById(Long id);
}
