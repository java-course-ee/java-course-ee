package edu.javacourse.hibernate;

import java.io.Serializable;

@Entity
@Table(name = "jc_address")
public class User implements Serializable {

    @EmbeddedId
    private UserId userId;
    @Column(name = "middle_name", nullable = true)
    private String middleName;

    @Embedded
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public UserId getUserId() {
        return userId;
    }

    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return userId + " " + middleName;
    }


}

@Embeddable
class UserId implements Serializable {

    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;

    public UserId() {
    }

    public UserId(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }


}