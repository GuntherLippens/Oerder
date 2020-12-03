package com.switchfully.oerder.demo.business.repositories;

import com.switchfully.oerder.demo.business.entities.items.ItemGroup;
import org.springframework.data.repository.CrudRepository;

public interface ItemGroupCrudRepository extends CrudRepository<ItemGroup, Integer> {
}
