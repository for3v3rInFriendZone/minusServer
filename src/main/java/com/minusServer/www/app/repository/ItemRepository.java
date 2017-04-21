package com.minusServer.www.app.repository;

import org.springframework.data.repository.CrudRepository;
import com.minusServer.www.app.model.Item;

public interface ItemRepository extends CrudRepository<Item, Long>{

}
