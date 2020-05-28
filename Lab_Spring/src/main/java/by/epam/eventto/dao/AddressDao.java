package by.epam.eventto.dao;

import by.epam.eventto.entity.Address;
import by.epam.eventto.entity.Event;
import by.epam.eventto.entity.User;
import by.epam.eventto.hibernateFactory.HibernateSessionFactory;
import by.epam.eventto.mapper.AddressMapper;
import by.epam.eventto.mapper.EventMapper;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;


@Repository
public class AddressDao implements DAO<Address, Long> {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    private SessionFactory sessionFactory;

    @Override
    public void create(Address address) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(address);
        tx1.commit();
        session.close();
//        Session session = sessionFactory.getCurrentSession();
//        session.persist(address);
        //        final String INSERT = "INSERT INTO  ADDRESS(country, town, street, house) VALUES (?,?,?,?)";
//        return jdbcTemplate.update(INSERT,
//                address.getCountry(),
//                address.getTown(),
//                address.getStreet(),
//                address.getHouse())>0;

    }

    @Override
    public Optional<Address> get(Long key) {
        Session session = sessionFactory.getCurrentSession();
        return session.byId(Address.class).loadOptional(key);
        //        final String GET_ONE = "SELECT * FROM ADDRESS WHERE ADDRESS_ID = ?";
//        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new AddressMapper());
    }

    @Override
    public List<Address> getAll(Integer page) {
        List<Address> addresses = (List<Address>) HibernateSessionFactory
                .getSessionFactory()
                .openSession()
                .createQuery("from Address").list();
        return addresses;
//        final String GET_ALL = "SELECT * FROM ADDRESS";
//        return  jdbcTemplate.query(GET_ALL, new AddressMapper());
    }

    @Override
    public Address update(Address updated) {
        Session session = sessionFactory.getCurrentSession();
        return (Address) session.merge(updated);
//        final String UPDATE = "UPDATE  ADDRESS SET country=?, town=?, street=?, house=? WHERE ADDRESS_ID=?";
//        return jdbcTemplate.update(UPDATE,
//                updated.getCountry(),
//                updated.getTown(),
//                updated.getStreet(),
//                updated.getHouse(),
//                updated.getAddressId())>0;

    }

    @Override
    public void delete(Long key) {
        Session session = sessionFactory.getCurrentSession();
        Address address = session.load(Address.class, key);
        session.delete(address);
//        final String DELETE = "DELETE FROM Address WHERE ADDRESS_ID=?";
//        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
