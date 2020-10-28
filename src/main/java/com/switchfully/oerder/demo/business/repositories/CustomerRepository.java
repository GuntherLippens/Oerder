package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.exceptions.EntityAlreadyExistsException;
import com.switchfully.oerder.demo.utilities.Address;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    private final Map<String, Customer> customers;

    public CustomerRepository() {
        this.customers = new HashMap<>();
        addFirstCustomer();
    }
    
    public Customer save(Customer customer) {
        if (customers.containsValue(customer))
            throw new EntityAlreadyExistsException();
        customers.put(customer.getId(), customer);

        return customer;
    }

    public void addFirstCustomer(){
        Customer customer = new Customer (
                "Jan",
                "Thefirst",
                 new Address("Cow street","45b","Gent","9000"),
                "+32456987521",
                "jan@firstisgood.be");
        customers.put(customer.getId(), customer);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }
}
