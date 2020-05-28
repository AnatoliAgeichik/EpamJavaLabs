package by.epam.eventto.entity;


import org.hibernate.envers.Audited;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Table(name = "COMMENTS")
public class Comment {

    @Id
    @Column(name = "COMMENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long commentId;


    @Column(name = "Email")
    private String userEmail;

    @Column
    private String content;

    @Column(name = "Event_id")
    private long eventID;

    @Column
    private int likes;


    public Comment() {
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public long getCommentId() {
        return commentId;
    }

    public void setCommentId(long commentId) {
        this.commentId = commentId;
    }

    public Comment(String userEmail, String content, int eventID, int likes) {
        this.userEmail = userEmail;
        this.content = content;
        this.eventID = eventID;
        this.likes = likes;
    }

    public Comment(String userEmail, String content, int eventID, int likes, long commentId) {
        this.userEmail = userEmail;
        this.content = content;
        this.eventID = eventID;
        this.likes = likes;
        this.commentId = commentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(commentId, comment.commentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commentId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Comment{");
        sb.append("userEmail='").append(userEmail).append('\'');
        sb.append(", content='").append(content).append('\'');
        sb.append(", eventID=").append(eventID);
        sb.append(", likes=").append(likes);
        sb.append(", commentId=").append(commentId);
        sb.append('}');
        return sb.toString();
    }
}