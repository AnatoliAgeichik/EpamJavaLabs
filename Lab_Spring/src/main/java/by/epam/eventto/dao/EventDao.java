package by.epam.eventto.dao;

import by.epam.eventto.entity.Event;
import by.epam.eventto.entity.User;
import by.epam.eventto.mapper.EventMapper;
import by.epam.eventto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventDao implements DAO<Event, Long> {




    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Event event) {
        final String INSERT = "INSERT INTO EVENT (owner_id, name, description, event_date, address_id, max_people) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(INSERT,
                event.getOwnerEmail(),
                event.getName(),
                event.getDescription(),
                event.getDate(),
                event.getAddressId(),
                event.getMaxPeople())>0;
    }

    @Override
    public Event get(Long key) {
        final String GET_ONE = "SELECT * FROM EVENT WHERE EVENT_ID = ?";
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new EventMapper());
    }

    @Override
    public List<Event> getAll() {
        final String GET_ALL = "SELECT * FROM EVENT";
        return  jdbcTemplate.query(GET_ALL, new EventMapper());
    }

    @Override
    public boolean update(Event updated) {

        final String UPDATE = "UPDATE EVENT SET owner_id=?, name=?, description=?, event_date=?, address_id=?, max_people=? WHERE EVENT_ID=?";
        return jdbcTemplate.update(UPDATE,
                updated.getOwnerEmail(),
                updated.getName(),
                updated.getDescription(),
                updated.getDate(),
                updated.getAddressId(),
                updated.getMaxPeople(),
                updated.getEventID())>0;

    }

    @Override
    public boolean delete(Long key) {
        final String DELETE = "DELETE FROM EVENT WHERE EVENT_ID=?";
        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
