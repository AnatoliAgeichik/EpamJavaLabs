package by.epam.eventto.dao;

import by.epam.eventto.entity.Address;
import by.epam.eventto.entity.Comment;
import by.epam.eventto.entity.Members;
import by.epam.eventto.entity.User;
import by.epam.eventto.hibernateFactory.HibernateSessionFactory;
import by.epam.eventto.mapper.CommentsMapper;
import by.epam.eventto.mapper.MembersMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.envers.Audited;
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
    }

    @Override
    public Optional<Members> get(Long key) {
        Session session = sessionFactory.getCurrentSession();
        return session.byId(Members.class).loadOptional(key);
    }

    @Override
    public List<Members> getAll(Integer page) {
        return (List<Members>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("from Members").list();
        //        final String GET_ALL = "SELECT * FROM MEMBERS";
//        return  jdbcTemplate.query(GET_ALL, new MembersMapper());
    }

    @Override
    public Members update(Members updated) {
        Session session = sessionFactory.getCurrentSession();
        return (Members) session.merge(updated);
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
