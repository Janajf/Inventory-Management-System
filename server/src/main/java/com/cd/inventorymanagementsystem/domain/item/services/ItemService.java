package com.cd.inventorymanagementsystem.domain.item.services;

import com.cd.inventorymanagementsystem.domain.item.exceptions.ItemException;
import com.cd.inventorymanagementsystem.domain.item.models.Item;

import java.util.List;

public interface ItemService {
    Item createItem(Item item);
    Item getItemById(Integer itemId) throws ItemException;
    Item getItemByName(String name) throws ItemException;
    List<Item> getAllItems();
    Item updateUserById(Integer itemId, Item item) throws ItemException;
    Boolean deleteItemById(Integer itemId) throws ItemException;

}
