package by.epam.eventto.dao;

import by.epam.eventto.entity.Comment;
import by.epam.eventto.entity.Members;
import by.epam.eventto.mapper.CommentsMapper;
import by.epam.eventto.mapper.MembersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class MembersDao implements DAO<Members, Long> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Members members) {
        final String INSERT = "INSERT INTO MEMBERS ( email, event_id, status) VALUES (?,?,?)";
        return jdbcTemplate.update(INSERT,
                members.getEmail(),
                members.getEventId(),
                members.getStatus())>0;
    }

    @Override
    public Members get(Long key) {
        final String GET_ONE = "SELECT * FROM MEMBERS WHERE MEMBERS_ID = ?";
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new MembersMapper());
    }

    @Override
    public List<Members> getAll() {
        final String GET_ALL = "SELECT * FROM MEMBERS";
        return  jdbcTemplate.query(GET_ALL, new MembersMapper());
    }

    @Override
    public boolean update(Members updated) {
        final String UPDATE = "UPDATE  MEMBERS SET  email=?, event_id=?, status=? WHERE MEMBERS_ID=?";
        return jdbcTemplate.update(UPDATE,
                updated.getEmail(),
                updated.getEventId(),
                updated.getStatus(),
                updated.getMemberId())>0;


    }

    @Override
    public boolean delete(Long key) {
        final String DELETE = "DELETE FROM MEMBERS WHERE MEMBERS_ID=?";
        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
