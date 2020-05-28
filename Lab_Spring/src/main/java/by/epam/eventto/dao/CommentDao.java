package by.epam.eventto.dao;

import by.epam.eventto.entity.Address;
import by.epam.eventto.entity.Comment;
import by.epam.eventto.entity.User;
import by.epam.eventto.hibernateFactory.HibernateSessionFactory;
import by.epam.eventto.mapper.CommentsMapper;
import by.epam.eventto.mapper.UserMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Repository
public class CommentDao implements DAO<Comment, Long> {

    //@Autowired
    //private JdbcTemplate jdbcTemplate;

    private SessionFactory sessionFactory;

    @Override
    public void create(Comment comment) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(comment);
        tx1.commit();
        session.close();
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(comment);
//        final String INSERT = "INSERT INTO COMMENT (event_id, email, content, likes) VALUES (?,?,?,?)";
//        return jdbcTemplate.update(INSERT,
//                comment.getEventID(),
//                comment.getUserEmail(),
//                comment.getContent(),
//                comment.getLikes())>0;
    }

    @Override
    public Optional<Comment> get(Long key) {
        Session session = sessionFactory.getCurrentSession();
        return session.byId(Comment.class).loadOptional(key);
//        final String GET_ONE = "SELECT * FROM COMMENTS WHERE COMMENT_ID = ?";
//        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new CommentsMapper());
    }

    @Override
    public List<Comment> getAll(Integer page) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Comment ");
        query.setFirstResult((page - 1)*10);
        query.setMaxResults(page*10);
        return (List<Comment>) ((org.hibernate.query.Query) query).list();
//        final String GET_ALL = "SELECT * FROM COMMENTS";
//        return  jdbcTemplate.query(GET_ALL, new CommentsMapper());
    }

    @Override
    public Comment update(Comment updated) {
        Session session = sessionFactory.getCurrentSession();
        return (Comment) session.merge(updated);
//        final String UPDATE = "UPDATE  COMMENTS SET event_id=?, email=?, content=?, likes=? WHERE COMMENT_ID=?";
//        return jdbcTemplate.update(UPDATE,
//                updated.getEventID(),
//                updated.getUserEmail(),
//                updated.getContent(),
//                updated.getLikes(),
//                updated.getCommentId())>0;

    }

    @Override
    public void delete(Long key) {
        Session session = sessionFactory.getCurrentSession();
        Comment comment = session.load(Comment.class, key);
        session.delete(comment);
//        final String DELETE = "DELETE FROM COMMENTS WHERE COMMENT_ID=?";
//        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
