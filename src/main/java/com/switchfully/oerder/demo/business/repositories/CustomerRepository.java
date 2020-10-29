package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.exceptions.customers.CustomerAlreadyExistsException;
import com.switchfully.oerder.demo.exceptions.customers.CustomerNotFoundException;
import com.switchfully.oerder.demo.utilities.Address;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CustomerRepository {
    private final Map<String, Customer> customers;

    public CustomerRepository() {
        this.customers = new HashMap<>();
        addFirstCustomer();
    }
    
    public Customer save(Customer customer) {
        if (customers.containsValue(customer))
            throw new CustomerAlreadyExistsException(
                            "Customer "
                            + customer.getFirstName()
                            + " "
                            + customer.getLastName()
                            + " already exists.");
        customers.put(customer.getItemId(), customer);

        return customer;
    }

    public void addFirstCustomer(){
        Customer customer = new Customer (
                "Jan",
                "Thefirst",
                 new Address("Cow street","45b","Gent","9000"),
                "+32456987521",
                "jan@beingfirstisgood.be");
        customers.put(customer.getItemId(), customer);
    }

    public Customer getCustomerById(String id) {
        if (Objects.isNull(getCustomerMap().get(id))){
            throw new CustomerNotFoundException(id);
        }
        return getCustomerMap().get(id);
    }

    public List<Customer> getCustomers() {
        return new ArrayList<>(customers.values());
    }

    public Map<String,Customer> getCustomerMap() {
        return customers;
    }
}
