package by.epam.eventto.dao;

import by.epam.eventto.entity.Address;
import by.epam.eventto.entity.Event;
import by.epam.eventto.entity.User;
import by.epam.eventto.mapper.EventMapper;
import by.epam.eventto.mapper.UserMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class EventDao implements DAO<Event, Long> {




    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SessionFactory sessionFactory;

    @Override
    public void create(Event event) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(event);
//        final String INSERT = "INSERT INTO EVENT (owner_id, name, description, event_date, address_id, max_people) VALUES (?,?,?,?,?,?)";
//        return jdbcTemplate.update(INSERT,
//                event.getOwnerEmail(),
//                event.getName(),
//                event.getDescription(),
//                event.getDate(),
//                event.getAddressId(),
//                event.getMaxPeople())>0;
    }

    @Override
    public Optional<Event> get(Long key) {
        Session session = sessionFactory.getCurrentSession();
        return session.byId(Event.class).loadOptional(key);
//        final String GET_ONE = "SELECT * FROM EVENT WHERE EVENT_ID = ?";
//        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new EventMapper());
    }

    @Override
    public List<Event> getAll(Integer page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Event ");
        query.setFirstResult((page - 1)*10);
        query.setMaxResults(page*10);
        return (List<Event>) ((org.hibernate.query.Query) query).list();
//        final String GET_ALL = "SELECT * FROM EVENT";
//        return  jdbcTemplate.query(GET_ALL, new EventMapper());
    }

    @Override
    public Event update(Event updated) {
        Session session = sessionFactory.getCurrentSession();
        return (Event) session.merge(updated);
//
//        final String UPDATE = "UPDATE EVENT SET owner_id=?, name=?, description=?, event_date=?, address_id=?, max_people=? WHERE EVENT_ID=?";
//        return jdbcTemplate.update(UPDATE,
//                updated.getOwnerEmail(),
//                updated.getName(),
//                updated.getDescription(),
//                updated.getDate(),
//                updated.getAddressId(),
//                updated.getMaxPeople(),
//                updated.getEventID())>0;

    }

    @Override
    public void delete(Long key) {
        Session session = sessionFactory.getCurrentSession();
        Event event = session.load(Event.class, key);
        session.delete(event);
//        final String DELETE = "DELETE FROM EVENT WHERE EVENT_ID=?";
//        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
