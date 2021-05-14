package com.tts.ItemsSpringBoot.repository;

import com.tts.ItemsSpringBoot.model.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item,Long> {
    List<Item> findByType(String type);
    //List<Item> findByName(String name);
   // Optional<Item> findById(Long id);
   // List<Item> getItems();
}
