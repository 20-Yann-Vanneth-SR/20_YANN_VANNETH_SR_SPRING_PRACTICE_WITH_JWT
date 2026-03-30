package org.yannvanneth.event_ticketing_system.repository;

import org.apache.ibatis.annotations.*;
import org.yannvanneth.event_ticketing_system.model.entity.AttendeeModel;
import org.yannvanneth.event_ticketing_system.model.request.AttendeeRequest;

import java.util.List;

@Mapper
public interface AttendeeRepository {
    @Results(id = "attendeeMapper", value = {
            @Result(property = "attendeeId", column = "attendee_id"),
            @Result(property = "attendeeName", column = "attendee_name"),
    })
    @Select("select attendee_id, attendee_name, email from attendees limit #{size} offset #{page}")
    List<AttendeeModel> getAllAttendees(Integer page, Integer size);

    @Result(property = "attendeeName", column = "attendee_name")
    @Select("""
        select attendee_name from attendees
         where lower(attendee_name) = lower(#{name})
    """)
    String getAttendeeByName(String name);

    @Select("""
        select email from attendees
         where lower(email) = lower(#{email})
    """)
    String getAttendeeByEmail(String email);

    @ResultMap("attendeeMapper")
    @Select("select attendee_id, attendee_name, email from attendees where attendee_id = #{id}")
    AttendeeModel getAttendeeById(Long id);

    @ResultMap("attendeeMapper")
    @Select("""
       insert into attendees values (default, #{req.attendeeName}, #{req.email})
       returning attendee_id, attendee_name, email;
    """)
    AttendeeModel saveAttendee(@Param("req") AttendeeRequest request);

    @ResultMap("attendeeMapper")
    @Select("""
       update attendees set attendee_name = #{req.attendeeName},
                         email = #{req.email}
                     where attendee_id = #{id}
       returning attendee_id, attendee_name, email;
    """)
    AttendeeModel updateAttendeeById(Long id,@Param("req") AttendeeRequest request);

    @ResultMap("attendeeMapper")
    @Select("""
       delete from attendees where attendee_id = #{id}
       returning attendee_id, attendee_name, email;
    """)
    AttendeeModel deleteAttendeeById(Long id);
}
