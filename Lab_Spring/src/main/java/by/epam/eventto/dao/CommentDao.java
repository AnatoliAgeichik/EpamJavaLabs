package by.epam.eventto.dao;

import by.epam.eventto.entity.Comment;
import by.epam.eventto.entity.User;
import by.epam.eventto.mapper.CommentsMapper;
import by.epam.eventto.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class CommentDao implements DAO<Comment, Long> {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean create(Comment comment) {
        final String INSERT = "INSERT INTO COMMENT (event_id, email, content, likes) VALUES (?,?,?,?)";
        return jdbcTemplate.update(INSERT,
                comment.getEventID(),
                comment.getUserEmail(),
                comment.getContent(),
                comment.getLikes())>0;
    }

    @Override
    public Comment get(Long key) {
        final String GET_ONE = "SELECT * FROM COMMENTS WHERE COMMENT_ID = ?";
        return jdbcTemplate.queryForObject(GET_ONE, new Object[]{key}, new CommentsMapper());
    }

    @Override
    public List<Comment> getAll() {
        final String GET_ALL = "SELECT * FROM COMMENTS";
        return  jdbcTemplate.query(GET_ALL, new CommentsMapper());
    }

    @Override
    public boolean update(Comment updated) {
        final String UPDATE = "UPDATE  COMMENTS SET event_id=?, email=?, content=?, likes=? WHERE COMMENT_ID=?";
        return jdbcTemplate.update(UPDATE,
                updated.getEventID(),
                updated.getUserEmail(),
                updated.getContent(),
                updated.getLikes(),
                updated.getCommentId())>0;

    }

    @Override
    public boolean delete(Long key) {
        final String DELETE = "DELETE FROM COMMENTS WHERE COMMENT_ID=?";
        return jdbcTemplate.update(DELETE, key) > 0;
    }
}
