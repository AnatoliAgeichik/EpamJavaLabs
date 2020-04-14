package by.epam.evento.entity;

import java.util.ArrayList;
import java.util.Objects;

public class Members extends Entity {

    private long memberId;
    private long eventId;
    private String email;
    private String status;

    public Members() {
    }

    public Members(long memberId, long eventId, String email, String status) {
        this.memberId = memberId;
        this.eventId = eventId;
        this.email = email;
        this.status = status;
    }

    public Members(long eventId, String email, String status) {
        this.eventId = eventId;
        this.email = email;
        this.status = status;
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
