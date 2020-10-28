package com.switchfully.oerder.demo.service.mappers;

import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.service.dtos.users.CustomerDTO;
import com.switchfully.oerder.demo.utilities.Address;

public class CustomerMapper {
    public Customer toEntity (CustomerDTO customerDTO){
        Address address = new Address(
                customerDTO.getStreet(),
                customerDTO.getStreetNumber(),
                customerDTO.getCity(),
                customerDTO.getAddress().getPostalCode()
        );
        Customer result = new Customer(
                customerDTO.getFirstName(),
                customerDTO.getLastName(),
                customerDTO.getAddress(),
                customerDTO.getEmailAddress(),
                customerDTO.getPhoneNumber()
        );

        return result;
    }

    public CustomerDTO toDTO(Customer customer){
        CustomerDTO result = new CustomerDTO();
        result.setId(customer.getId());
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setEmailAddress(customer.getEmailAddress());
        result.setStreet(customer.getAddress().getStreet());
        result.setStreetNumber(customer.getAddress().getStreetNumber());
        result.setCity(customer.getAddress().getCity());
        result.setPostalCode(customer.getAddress().getPostalCode());


        return result;
    }

    public CustomerDTO toRestrictedDTO(Customer customer){
        CustomerDTO result = new CustomerDTO();
        result.setId(customer.getId());
        result.setFirstName(customer.getFirstName());
        result.setLastName(customer.getLastName());
        result.setEmailAddress(customer.getEmailAddress());
        result.setStreet(customer.getAddress().getStreet());
        result.setStreetNumber(customer.getAddress().getStreetNumber());
        result.setCity(customer.getAddress().getCity());
        result.setPostalCode(customer.getAddress().getPostalCode());


        return result;
    }
}
