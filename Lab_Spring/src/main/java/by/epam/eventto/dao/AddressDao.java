package by.epam.eventto.dao;

import by.epam.eventto.entity.Address;
import by.epam.eventto.entity.Event;
import by.epam.eventto.mapper.AddressMapper;
import by.epam.eventto.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class AddressDao implements DAO<Address, Long> {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Address address) {
        final String INSERT = "INSERT INTO  ADDRESS(country, town, street, house) VALUES (?,?,?,?)";
        return jdbcTemplate.update(INSERT,
                address.getCountry(),
                address.getTown(),
                address.getStreet(),
                address.getHouse())>0;

    }

    @Override
    public Address get(Long key) {
        final String GET_ONE = "SELECT * FROM ADDRESS WHERE ADDRESS_ID = ?";
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new AddressMapper());
    }

    @Override
    public List<Address> getAll() {
        final String GET_ALL = "SELECT * FROM ADDRESS";
        return  jdbcTemplate.query(GET_ALL, new AddressMapper());
    }

    @Override
    public boolean update(Address updated) {
        final String UPDATE = "UPDATE  ADDRESS SET country=?, town=?, street=?, house=? WHERE ADDRESS_ID=?";
        return jdbcTemplate.update(UPDATE,
                updated.getCountry(),
                updated.getTown(),
                updated.getStreet(),
                updated.getHouse(),
                updated.getAddressId())>0;

    }

    @Override
    public boolean delete(Long key) {
        final String DELETE = "DELETE FROM Address WHERE ADDRESS_ID=?";
        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
