package org.yannvanneth.event_ticketing_system.repository;

import org.apache.ibatis.annotations.*;
import org.yannvanneth.event_ticketing_system.model.entity.AttendeeModel;

import java.util.List;

@Mapper
public interface EventAttendeeRepository {

    @Insert("""
      insert into event_attendee values (#{attendeeId}, #{eventId})
    """)
    void save(Long attendeeId, Long eventId);


    @Delete("""
      delete from event_attendee
      where event_id = #{eventId}
    """)
    void deleteAllByEventId(Long eventId);

    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
    })
    @Select("""
       select a.* from attendees a
          join event_attendee ea on a.attendee_id = ea.attendee_id
          where ea.event_id = #{eventId}
    """)
    List<AttendeeModel> getAttendeesByEventId(Long eventId);
}
