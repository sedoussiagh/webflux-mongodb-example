package org.webflux.repository;

import org.webflux.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepo extends MongoRepository<Item, Integer>{
}
