package com.switchfully.oerder.demo.business.entities.users;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="address_id")
    private int address_id;

    @JsonProperty("street")
    @Column(name="street")
    private String street;

    @JsonProperty("streetNumber")
    @Column(name="street_number")
    private String streetNumber;

    @JsonProperty("city")
    @Column(name="city")
    private String city;

    @JsonProperty("postalCode")
    @Column(name="postal_code")
    private String postalCode;

    public Address() {
    }

    public Address(String street, String streetNumber, String city, String postalCode) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.city = city;
        isPostalCodeValid(postalCode);
    }

    public Address(String city, String postalCode) {
        this.street = "NOT PROVIDED";
        this.streetNumber = "NOT PROVIDED";
        this.city = city;
        isPostalCodeValid(postalCode);
    }

    private void isPostalCodeValid(String postalCode){
        if(postalCode.toString().length() != 4){
            throw new IllegalArgumentException("Postal code exist of 4 digits");
        } this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(street + " " + streetNumber)
                .append(System.lineSeparator())
                .append(postalCode + " " + city);
        return stringBuilder.toString();
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public int getAddress_id() {
        return address_id;
    }
}
