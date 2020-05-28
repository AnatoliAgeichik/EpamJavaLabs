package by.epam.eventto.entity;


import javax.persistence.*;

import java.util.List;
import java.util.Objects;



@javax.persistence.Entity
@Table(name = "ADDRESS")
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADDRESS_ID")
    private long addressId;

    @Column(name = "COUNTRY")
    private String country;

    @Column(name = "TOWN")
    private String town;

    @Column(name = "STREET")
    private String street;

    @Column(name = "HOUSE")
    private String house;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ADDRESS")
//    private List<Event> addressEvents;


    public Address() {
    }

    public Address(long addressId, String country, String town, String street, String house) {
        this.addressId = addressId;
        this.country = country;
        this.town = town;
        this.street = street;
        this.house = house;
    }

    public long getAddressId() {
        return addressId;
    }

    public Address(String country, String town, String street, String house) {
        this.country = country;
        this.town = town;
        this.street = street;
        this.house = house;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getTown() {
        return town;
    }

    public String getStreet() {
        return street;
    }

    public String getHouse() {
        return house;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Address{");
        sb.append("country='").append(country).append('\'');
        sb.append(", town='").append(town).append('\'');
        sb.append(", street='").append(street).append('\'');
        sb.append(", house='").append(house).append('\'');
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addressId == address.addressId &&
                Objects.equals(country, address.country) &&
                Objects.equals(town, address.town) &&
                Objects.equals(street, address.street) &&
                Objects.equals(house, address.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId);
    }
}
