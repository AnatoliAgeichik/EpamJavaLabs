package by.epam.eventto.entity;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table
public class Event extends EntityT {
    @Id
    @Column(name = "EVENT_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long eventID;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "Address_id")
    private long addressId;

    @Column(name = "EVENT_DATE")
    private Date date;

    @Column(name = "Owner_id")
    private String ownerEmail;

    @Column(name = "MAX_PEOPLE")
    private int maxPeople;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "EVENT")
//    private List<Comment> eventComments;
//
//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "EVENT")
//    private List<Members> eventMembers;


    public Event() {
    }

    public Event(String ownerEmail, String name, String description, Date date, long addressId, int maxPeople) {
        this.name = name;
        this.description = description;
        this.addressId = addressId;
        this.date = date;
        this.ownerEmail = ownerEmail;
        this.maxPeople = maxPeople;
    }

    public Event(long eventID, String ownerEmail,  String name, String description,  Date date, long addressId,int maxPeople) {
        this.name = name;
        this.description = description;
        this.addressId = addressId;
        this.date = date;
        this.ownerEmail = ownerEmail;
        this.eventID = eventID;
        this.maxPeople = maxPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getOwnerEmail() {
        return ownerEmail;
    }

    public void setOwnerEmail(String ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    public long getEventID() {
        return eventID;
    }

    public void setEventID(long eventID) {
        this.eventID = eventID;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Event{");
        sb.append("eventID=").append(eventID);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", addressId=").append(addressId);
        sb.append(", date=").append(date);
        sb.append(", ownerEmail='").append(ownerEmail).append('\'');
        sb.append(", maxPeople=").append(maxPeople);
        sb.append('}');
        return sb.toString();
    }
}




















