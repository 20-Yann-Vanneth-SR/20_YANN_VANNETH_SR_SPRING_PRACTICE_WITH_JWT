package org.yannvanneth.event_ticketing_system.repository;

import org.apache.ibatis.annotations.*;
import org.yannvanneth.event_ticketing_system.model.entity.VenueModel;
import org.yannvanneth.event_ticketing_system.model.request.VenueRequest;

import java.util.List;

@Mapper
public interface VenueRepository {

    @Results(id = "venueMapper", value = {
            @Result(property = "venueId", column = "venue_id"),
            @Result(property = "venueName", column = "venue_name"),
    })
    @Select("select venue_id, venue_name, location from venues limit #{size} offset #{page}")
    List<VenueModel> getAllVenues(Integer page, Integer size);

    @ResultMap("venueMapper")
    @Select("select venue_id, venue_name, location from venues where venue_id = #{id}")
    VenueModel getVenueById(Long id);

    @Result(property = "venueName", column = "venue_name")
    @Select("select venue_name from venues where lower(venue_name) = lower(#{name})")
    String getVenueByName(String name);

    @ResultMap("venueMapper")
    @Select("""
       insert into venues values (default, #{req.venueName}, #{req.location})
       returning venue_id, venue_name, location;
    """)
    VenueModel saveVenue(@Param("req") VenueRequest request);

    @ResultMap("venueMapper")
    @Select("""
       update venues set venue_name = #{req.venueName},
                         location = #{req.location}
                     where venue_id = #{id}
       returning venue_id, venue_name, location;
    """)
    VenueModel updateVenueById(Long id,@Param("req") VenueRequest request);

    @ResultMap("venueMapper")
    @Select("""
       delete from venues where venue_id = #{id}
       returning venue_id, venue_name, location;
    """)
    VenueModel deleteVenueById(Long id);
}
