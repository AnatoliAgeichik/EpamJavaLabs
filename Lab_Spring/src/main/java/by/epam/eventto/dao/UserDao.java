package by.epam.eventto.dao;

import by.epam.eventto.entity.User;
import by.epam.eventto.mapper.UserMapper;
import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao implements DAO<User, String> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(User user) {
        final String INSERT = "INSERT INTO USERS (email, firstname, lastname, gender, rating, age) VALUES (?,?,?,?,?,?)";
        return jdbcTemplate.update(INSERT,
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getGender(),
                user.getRating(),
                user.getAge()) > 0;
    }

    @Override
    public User get(String key) {
        final String GET_ONE = "SELECT * FROM USERS WHERE trim(EMAIL) = ?";
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new UserMapper());
    }

    @Override
    public List<User> getAll() {
        final String GET_ALL = "SELECT * FROM USERS";
        return  jdbcTemplate.query(GET_ALL, new UserMapper());
    }

    @Override
    public boolean update(User updated) {
        final String UPDATE = "UPDATE USERS SET FIRSTNAME=?, LASTNAME=?, GENDER=?, RATING=?, AGE=? WHERE trim(EMAIL)=?";
        return jdbcTemplate.update(UPDATE,
                updated.getFirstName(),
                updated.getLastName(),
                updated.getGender(),
                updated.getRating(),
                updated.getAge(),
                updated.getEmail()) > 0;
    }

    @Override
    public boolean delete(String key) {
        final String DELETE = "DELETE FROM USERS WHERE trim(EMAIL)=?";
        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
