package by.epam.evento.daodb;
import by.epam.evento.entity.Event;
import oracle.sql.DATE;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EventDao extends Dao<Event> {
    {
        setTableName("Event");
        setInsertSql("INSERT INTO EVENT " +
                "(address_id, name, description, event_date, owner_id,  max_people)" +
                "VALUES(?,?,?,?,?,?)");
        setDeleteSql("DELETE FROM EVENT WHERE event_id = ");
    }
    @Override
    public Event makeEntity(ResultSet sqlResponse) {
        Event event = new Event();
        try {
            event.setAddressId(sqlResponse.getLong("address_id"));
            event.setName(sqlResponse.getString("name").trim());
            event.setDescription(sqlResponse.getString("description").trim());
            event.setDate(sqlResponse.getDate("event_date"));
            event.setOwnerEmail(sqlResponse.getString("owner_id").trim());
            event.setEventID(sqlResponse.getLong("event_id"));
            event.setMaxPeople(sqlResponse.getInt("max_people"));

        }catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return event;
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Event event) {
        try {
            preparedStatement.setLong(1,event.getAddressId());
            preparedStatement.setString(2,event.getName());
            preparedStatement.setString(3,event.getDescription());
            preparedStatement.setDate(4, (Date) event.getDate());
            preparedStatement.setString(5,event.getOwnerEmail());
            preparedStatement.setInt(6,event.getMaxPeople());

        } catch (SQLException e) {

            log.error(e.getMessage());
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public String makeUpdateQuery(Event event) {
        String str;
        str = "UPDATE event ";
        str += "set address_id = " + event.getAddressId() + ",";
        str += "name = '" + event.getName() + "',";
        str += "description = '" + event.getDescription() + "',";
        str += "event_date = " + event.getDate() + ",";
        str += "owner_id = '" + event.getOwnerEmail() + "',";
        str += "max_people = " + event.getMaxPeople() + " ";
        str += "WHERE event_id = " + event.getEventID();
        return str;
    }
}


