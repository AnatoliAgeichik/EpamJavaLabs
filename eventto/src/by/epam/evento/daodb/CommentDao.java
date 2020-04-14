package by.epam.evento.daodb;

import by.epam.evento.entity.Comment;
import by.epam.evento.entity.Event;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentDao extends Dao<Comment> {
    {
        setTableName("Comments");
        setInsertSql("INSERT INTO COMMENTS " +
                "(content, event_id, likes, email)" +
                "VALUES(?,?,?,?)");
        setDeleteSql("DELETE FROM COMMENTS WHERE comment_id = ");
    }
    @Override
    public Comment makeEntity(ResultSet sqlResponse) {
        Comment comment = new Comment();
        try {

            comment.setCommentId(sqlResponse.getLong("comment_id"));
            comment.setEventID(sqlResponse.getLong("event_id"));
            comment.setLikes(sqlResponse.getInt("likes"));
            comment.setContent(sqlResponse.getString("content").trim());
            comment.setUserEmail(sqlResponse.getString("email").trim());

        }catch (SQLException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return comment;
    }

    @Override
    public PreparedStatement prepareInsert(PreparedStatement preparedStatement, Comment comment) {
        try {


            preparedStatement.setString(1,comment.getContent().trim());
            preparedStatement.setLong(2,comment.getEventID());
            preparedStatement.setInt(3,comment.getLikes());
            preparedStatement.setString(4,comment.getUserEmail().trim());


        } catch (SQLException e) {

            log.error(e.getMessage());
            e.printStackTrace();
        }
        return preparedStatement;
    }

    @Override
    public String makeUpdateQuery(Comment comment) {
        String str;
        str = "UPDATE comments ";
        str += "set content = '" + comment.getContent() + "',";
        str += "likes = " + comment.getLikes() + ",";
        str += "email = '" + comment.getUserEmail() + "',";
        str += "event_id = " + comment.getEventID();
        str += "WHERE comment_id = " + comment.getCommentId();
        return str;
    }
}
