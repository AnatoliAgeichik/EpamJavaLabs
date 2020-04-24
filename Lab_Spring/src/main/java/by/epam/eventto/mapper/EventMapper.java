package by.epam.eventto.mapper;

import by.epam.eventto.entity.Event;
import by.epam.eventto.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class EventMapper implements RowMapper<Event> {
    @Override
    public Event mapRow(ResultSet rs, int rowNum) throws SQLException {
        Event event = new Event();
        event.setEventID(rs.getLong("EVENT_ID"));
        event.setOwnerEmail(rs.getString("OWNER_ID").trim());
        event.setName(rs.getString("NAME").trim());
        event.setDescription(rs.getString("DESCRIPTION").trim());
        event.setDate(rs.getDate("EVENT_DATE"));
        event.setAddressId(rs.getLong("ADDRESS_ID"));
        event.setMaxPeople(rs.getInt("MAX_PEOPLE"));
        return event;
    }
}
