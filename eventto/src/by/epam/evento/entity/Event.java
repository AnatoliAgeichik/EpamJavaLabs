package by.epam.evento.entity;

import java.util.Date;

public class Event extends Entity {
    private String name;
    private String description;
    private long addressId;
    private Date date;
    private String ownerEmail;
    private long eventID;
    private int maxPeople;

    public Event() {
    }

    public Event(String name, String description, long addressId, Date date, String ownerEmail, int maxPeople) {
        this.name = name;
        this.description = description;
        this.addressId = addressId;
        this.date = date;
        this.ownerEmail = ownerEmail;
        this.maxPeople = maxPeople;
    }

    public Event(long eventID, String name, String description, long addressId, Date date, String ownerEmail, int maxPeople) {
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
        sb.append("name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", addressId=").append(addressId);
        sb.append(", date=").append(date);
        sb.append(", ownerEmail='").append(ownerEmail).append('\'');
        sb.append(", eventID=").append(eventID);
        sb.append(", maxPeople=").append(maxPeople);
        sb.append('}');
        return sb.toString();
    }
}




















