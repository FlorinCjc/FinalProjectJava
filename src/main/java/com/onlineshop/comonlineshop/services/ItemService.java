package com.onlineshop.comonlineshop.services;

import com.onlineshop.comonlineshop.model.Item;

import java.util.List;

public interface ItemService {
    List<Item> getAllItems();

    Item getItemById(int id);

    Item createItem(Item item);

    Item updateItem(Item item);

    void deleteItem(int id);
}
