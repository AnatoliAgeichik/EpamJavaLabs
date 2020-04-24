package by.epam.eventto.entity;

import by.epam.eventto.collection.Gender;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class User extends Entity{
    private String email;
    private String firstName;
    private String lastName;
    private byte age;
    private Gender gender;
    private int rating;

    public User() {
    }

    public User(String email, String firstName, String lastName, byte age, String gender, int rating) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.rating = rating;
        this.gender = Gender.valueOf(gender);

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public byte getAge() {
        return age;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public String getGender() {
        return gender.toString();
    }

    public void setGender(String gender) {

        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", rating=" + rating +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

}
