package com.switchfully.oerder.demo.business.entities.users;

import com.switchfully.oerder.demo.utilities.Address;

public class Admin extends User {
    public Admin(String firstName, String lastName, Address address, String emailAddress, String phoneNumber) {
        super(firstName, lastName, address, emailAddress, phoneNumber);
    }
}
