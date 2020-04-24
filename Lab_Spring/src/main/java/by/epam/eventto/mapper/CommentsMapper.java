package by.epam.eventto.mapper;

import by.epam.eventto.entity.Comment;
import by.epam.eventto.entity.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentsMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentId(rs.getLong("COMMENT_ID"));
        comment.setEventID(rs.getLong("EVENT_ID"));
        comment.setUserEmail(rs.getString("EMAIL").trim());
        comment.setContent(rs.getString("CONTENT").trim());
        comment.setLikes(rs.getInt("LIKES"));
        return comment;
    }
}
