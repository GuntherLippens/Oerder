package com.switchfully.oerder.demo.business.entities.users;

import com.switchfully.oerder.demo.business.entities.Entity;
import com.switchfully.oerder.demo.utilities.Address;

import java.util.UUID;

public class User implements Entity {
    private final String firstName;
    private final String lastName;
    private String emailAddress;
    private String phoneNumber;
    private Address address;
    private final String id;

    public User(String firstName, String lastName, Address address, String emailAddress, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.id = UUID.randomUUID().toString();
    }

    public String getFirstName() {
        return firstName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getLastName() {
        return lastName;
    }


    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getId() {
        return id;
    }


}
