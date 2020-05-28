package by.epam.eventto.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "MEMBERS")
public class Members extends EntityT {

    @Id
    @Column(name = "MEMBERS_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long memberId;

    @Column
    private long eventId;

    @Column
    private String email;

    @Column(name = "STATUS")
    private String status;

    public Members() {
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Members members = (Members) o;
        return memberId == members.memberId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Members{");
        sb.append("memberId=").append(memberId);
        sb.append(", eventId=").append(eventId);
        sb.append(", email='").append(email).append('\'');
        sb.append(", status='").append(status).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
