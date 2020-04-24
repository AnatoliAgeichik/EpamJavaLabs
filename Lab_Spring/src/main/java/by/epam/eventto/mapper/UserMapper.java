package by.epam.eventto.mapper;


import by.epam.eventto.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        User user = new User();
        user.setEmail(rs.getString("EMAIL").trim());
        user.setFirstName(rs.getString("FIRSTNAME").trim());
        user.setLastName(rs.getString("LASTNAME").trim());
        user.setGender(rs.getString("GENDER").trim());
        user.setRating(rs.getInt("RATING"));
        user.setAge((byte)rs.getInt("AGE"));

        return user;

    }
}