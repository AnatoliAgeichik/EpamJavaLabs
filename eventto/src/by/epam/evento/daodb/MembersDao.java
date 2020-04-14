package by.epam.evento.daodb;

import by.epam.evento.entity.Comment;
import by.epam.evento.entity.Members;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MembersDao extends Dao<Members> {


    {
        setTableName("Members");
        setInsertSql("INSERT INTO MEMBERS " +
                "(event_id, email, status)" +
                "VALUES(?,?,?)");
        setDeleteSql("DELETE FROM Members WHERE member_id = ");
    }
    @Override
    public Members makeEntity(ResultSet sqlResponse) {
        Members members = new Members();
        try {
            members.setEmail(sqlResponse.getString("email").trim());
            members.setEventId(sqlResponse.getLong("event_id"));
            members.setStatus(sqlResponse.getString("status").trim());
            members.setMemberId(sqlResponse.getLong("member_id"));

        }catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Members members) {
        try {


            preparedStatement.setLong(1,members.getEventId());
            preparedStatement.setString(2,members.getEmail().trim());
            preparedStatement.setString(3,members.getStatus().trim());


        } catch (SQLException e) {

            log.error(e.getMessage());
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public String makeUpdateQuery(Members members) {
        String str;
        str = "UPDATE members ";
        str += "set email = '" + members.getEmail() + "',";
        str += "event_id = " + members.getEventId() + ",";
        str += "status = '" + members.getStatus() + "'";
        str += "WHERE member_id = " + members.getMemberId();
        return str;

    }


}
