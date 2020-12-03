package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.items.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemCrudRepository extends CrudRepository<Item, Integer> {

}
