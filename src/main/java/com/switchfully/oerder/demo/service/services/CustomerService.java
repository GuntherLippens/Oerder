package com.switchfully.oerder.demo.service.services;

import com.switchfully.oerder.demo.business.entities.users.Customer;
import com.switchfully.oerder.demo.business.repositories.CustomerRepository;
import com.switchfully.oerder.demo.service.dtos.users.CustomerDTO;
import com.switchfully.oerder.demo.service.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    @Autowired
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public CustomerDTO save(CustomerDTO customerDTO){
        Customer customer = customerRepository.save(customerMapper.toEntity(customerDTO));

        return customerMapper.toDTO(customer);
    }

    public List<CustomerDTO> getAllCustomers() {
        return customerRepository.getCustomers().stream()
                .map(customerMapper::toDTO)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomer(String id) {
        return customerMapper.toDTO(customerRepository.getCustomerById(id));

    }
}
