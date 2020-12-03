package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.business.repositories.CustomerCrudRepository;
import com.switchfully.oerder.demo.exceptions.customers.CustomerNotFoundException;
import com.switchfully.oerder.demo.service.dtos.users.CustomerDTO;
import com.switchfully.oerder.demo.service.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerCrudRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerCrudRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO save(CustomerDTO customerDTO){
        Customer customer = customerRepository.save(customerMapper.toEntity(customerDTO));

        return customerMapper.toDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {

        return ((List<Customer>) customerRepository.findAll()).stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomer(int id) {
        if (customerRepository.findById(id).isEmpty()) {
            throw new CustomerNotFoundException("No customer exists with id = "  + id);
        }
        return customerMapper.toDTO(customerRepository.findById(id).get());

    }
}
