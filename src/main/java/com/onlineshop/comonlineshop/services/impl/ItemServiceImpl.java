package com.onlineshop.comonlineshop.services.impl;

import com.onlineshop.comonlineshop.model.Item;
import com.onlineshop.comonlineshop.repositories.ItemRepository;
import com.onlineshop.comonlineshop.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;

    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAllItems() {
        return itemRepository.findAll();
    }

    @Override
    public Item getItemById(int id) {
     return   itemRepository.findById(id).orElseThrow(() -> new RuntimeException("Item not found"));
    }


    @Override
    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void deleteItem(int id) {
    itemRepository.deleteById(id);
    }
}
