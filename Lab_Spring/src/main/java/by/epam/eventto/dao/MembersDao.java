package by.epam.eventto.dao;

import by.epam.eventto.entity.Address;
import by.epam.eventto.entity.Comment;
import by.epam.eventto.entity.Members;
import by.epam.eventto.mapper.CommentsMapper;
import by.epam.eventto.mapper.MembersMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Repository
public class MembersDao implements DAO<Members, Long> {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;

    private SessionFactory sessionFactory;

    @Override
    public void create(Members members) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(members);
//        final String INSERT = "INSERT INTO MEMBERS ( email, event_id, status) VALUES (?,?,?)";
//        return jdbcTemplate.update(INSERT,
//                members.getEmail(),
//                members.getEventId(),
//                members.getStatus())>0;
    }

    @Override
    public Optional<Members> get(Long key) {
        Session session = sessionFactory.getCurrentSession();
        return session.byId(Members.class).loadOptional(key);
//        final String GET_ONE = "SELECT * FROM MEMBERS WHERE MEMBERS_ID = ?";
//        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new MembersMapper());
    }

    @Override
    public List<Members> getAll(Integer page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Members ");
        query.setFirstResult((page - 1)*10);
        query.setMaxResults(page*10);
        return (List<Members>) ((org.hibernate.query.Query) query).list();
        //        final String GET_ALL = "SELECT * FROM MEMBERS";
//        return  jdbcTemplate.query(GET_ALL, new MembersMapper());
    }

    @Override
    public Members update(Members updated) {
        Session session = sessionFactory.getCurrentSession();
        return (Members) session.merge(updated);
//        final String UPDATE = "UPDATE  MEMBERS SET  email=?, event_id=?, status=? WHERE MEMBERS_ID=?";
//        return jdbcTemplate.update(UPDATE,
//                updated.getEmail(),
//                updated.getEventId(),
//                updated.getStatus(),
//                updated.getMemberId())>0;


    }

    @Override
    public void delete(Long key) {
        Session session = sessionFactory.getCurrentSession();
        Members members = session.load(Members.class, key);
        session.delete(members);
//        final String DELETE = "DELETE FROM MEMBERS WHERE MEMBERS_ID=?";
//        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
