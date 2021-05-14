package com.tts.ItemsSpringBoot.controller;

import com.tts.ItemsSpringBoot.model.Item;
import com.tts.ItemsSpringBoot.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
 ItemRepository itemRepository;
    @GetMapping
    public Iterable<Item> getItems(){
        return  itemRepository.findAll();
    }
    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable Long id) {
        return  itemRepository.findById(id);
               // .orElseThrow( ItemNotFoundException::new);
    }
//    @GetMapping("/{name}")
//    public List<Item> findById(@PathVariable String name) {
//        return  itemRepository.findByName(name);
//
//    }
    @GetMapping("/{type}")
    public List<Item> findByType(@PathVariable String type) {
        return  itemRepository.findByType(type);

    }
}

