package org.webflux.service;

import org.springframework.stereotype.Service;
import org.webflux.entity.Item;
import org.webflux.repository.ItemRepo;
import reactor.core.publisher.Flux;

@Service
public class ItemService {

    private final ItemRepo itemRepo;

    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Flux<Item> getItems() {
        return Flux.fromIterable(itemRepo.findAll());
    }

    public Flux<Item> saveItem(Item item) {
        itemRepo.save(item);
        return Flux.fromIterable(itemRepo.findAll());
    }
}
