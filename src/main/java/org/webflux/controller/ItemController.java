package org.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.webflux.service.ItemService;
import reactor.core.publisher.Flux;
import org.webflux.entity.Item;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public Flux<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping("/items")
    public Flux<Item> saveItem(@RequestBody Item item) {
        return itemService.saveItem(item);
    }
}
