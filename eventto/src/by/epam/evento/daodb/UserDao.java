package by.epam.evento.daodb;

import by.epam.evento.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao extends Dao<User> {
    {
        setTableName("Users");
        setInsertSql("INSERT INTO USERS " +
                "(email, gender, rating, firstname, lastname, age)" +
                "VALUES(?,?,?,?,?,?)");
        setDeleteSql("DELETE FROM USERS WHERE email = ");
    }
    @Override
    public User makeEntity(ResultSet sqlResponse) {
        User user = new User();
        try {
            user.setAge((byte)sqlResponse.getInt("age"));
            user.setFirstName(sqlResponse.getString("firstname").trim());
            user.setLastName(sqlResponse.getString("lastname").trim());
            user.setEmail(sqlResponse.getString("email").trim());
            user.setRating(sqlResponse.getInt("rating"));
            user.setGender(sqlResponse.getString("gender").trim());
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, User user) {
        try {
            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setString(2, user.getGender());
            preparedStatement.setInt(3, user.getRating());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setInt(6, user.getAge());
        } catch (SQLException e) {
            e.printStackTrace();
            //добавить лог
        }
        return preparedStatement;
    }

    @Override
    public String makeUpdateQuery(User user) {
        String str;
        str = "UPDATE users ";
        str += "set firstname = '" + user.getFirstName() + "',";
        str += "lastname = '" + user.getLastName() + "',";
        str += "gender = '" + user.getGender() + "',";
        str += "age = " + user.getAge() + ",";
        str += "rating = " + user.getRating() + " ";
        str += "WHERE email = '" + user.getEmail() + "'";
        return str;
    }
}

