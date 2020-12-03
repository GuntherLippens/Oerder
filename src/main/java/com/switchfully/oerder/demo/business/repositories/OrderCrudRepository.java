package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.items.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderCrudRepository extends CrudRepository<Order, Integer> {
}
