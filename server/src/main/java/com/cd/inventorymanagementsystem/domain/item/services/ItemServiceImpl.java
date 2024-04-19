package com.cd.inventorymanagementsystem.domain.item.services;

import com.cd.inventorymanagementsystem.domain.item.exceptions.ItemException;
import com.cd.inventorymanagementsystem.domain.item.models.Item;
import com.cd.inventorymanagementsystem.domain.item.repos.ItemRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ItemServiceImpl implements ItemService{

    private static Logger logger = LoggerFactory.getLogger(ItemService.class);
    private ItemRepo itemRepo;

    @Autowired
    public ItemServiceImpl(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    @Override
    public Item createItem(Item item) {
        Item savedItem = itemRepo.save(item);
        return savedItem;
    }

    @Override
    public Item getItemById(Integer itemId) throws ItemException {
        return null;
    }

    @Override
    public Item getItemByName(String name) throws ItemException {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public Item updateUserById(Integer itemId, Item item) throws ItemException {
        return null;
    }

    @Override
    public Boolean deleteItemById(Integer itemId) throws ItemException {
        return null;
    }
}
