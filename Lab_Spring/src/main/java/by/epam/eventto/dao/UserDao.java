package by.epam.eventto.dao;

import by.epam.eventto.entity.Members;
import by.epam.eventto.entity.User;
import by.epam.eventto.hibernateFactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao implements DAO<User, Integer> {

//    @Autowired
//    private JdbcTemplate jdbcTemplate;
    private SessionFactory sessionFactory;

    @Override
    public void create(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(user);
//        final String INSERT = "INSERT INTO USERS (email, firstname, lastname, gender, rating, age) VALUES (?,?,?,?,?,?)";
//        return jdbcTemplate.update(INSERT,
//                user.getEmail(),
//                user.getFirstName(),
//                user.getLastName(),
//                user.getGender(),
//                user.getRating(),
//                user.getAge()) > 0;
    }

    @Override
    public Optional<User> get(Integer key) {
        return HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .byId(User.class).loadOptional(key);
    }

    @Override
    public List<User> getAll(Integer page) {
        return (List<User>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("from User").list();
//        final String GET_ALL = "SELECT * FROM USERS";
//        return  jdbcTemplate.query(GET_ALL, new UserMapper());
    }

    @Override
    public User update(User updated) {
        Session session = sessionFactory.getCurrentSession();
        return (User) session.merge(updated);
//        final String UPDATE = "UPDATE USERS SET FIRSTNAME=?, LASTNAME=?, GENDER=?, RATING=?, AGE=? WHERE trim(EMAIL)=?";
//        return jdbcTemplate.update(UPDATE,
//                updated.getFirstName(),
//                updated.getLastName(),
//                updated.getGender(),
//                updated.getRating(),
//                updated.getAge(),
//                updated.getEmail()) > 0;
    }

    @Override
    public void delete(Integer key) {
        Session session = sessionFactory.getCurrentSession();
        User user = session.load(User.class, key);
        session.delete(user);

//        final String DELETE = "DELETE FROM USERS WHERE trim(EMAIL)=?";
//        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
