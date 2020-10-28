package com.switchfully.oerder.demo.utilities;

public class Address {

    private String street;
    private String streetNumber;
    private String city;

    private String postalCode;

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
}
