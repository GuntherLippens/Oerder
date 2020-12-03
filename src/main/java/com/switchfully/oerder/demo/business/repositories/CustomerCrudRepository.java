package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.users.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerCrudRepository extends CrudRepository<Customer, Integer> {

}
