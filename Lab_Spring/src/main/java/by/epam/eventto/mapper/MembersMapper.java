package by.epam.eventto.mapper;

import by.epam.eventto.entity.Members;
import by.epam.eventto.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MembersMapper implements RowMapper<Members> {
    @Override
    public Members mapRow(ResultSet rs, int rowNum) throws SQLException {
        Members members = new Members();
        members.setMemberId(rs.getLong("MEMBER_ID"));
        members.setEmail(rs.getString("EMAIL").trim());
        members.setEventId(rs.getLong("EVENT_ID"));
        members.setStatus(rs.getString("STATUS").trim());
        return members;
    }
}
