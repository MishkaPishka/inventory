package com.example.inventory;

import com.example.inventory.exceptions.InvalidCreatingException;
import com.example.inventory.exceptions.InvalidQuantityChangeException;
import com.example.inventory.exceptions.ItemExistsException;
import com.example.inventory.exceptions.ItemNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {
    @Autowired
    private final ItemRepository repository;

    InventoryService(ItemRepository repository) {
        this.repository = repository;
    }

    List<Item> all() {
        return repository.findAll();
    }

    Item changeQuantity(long itemId, int quantity) {
        //TODO
        return repository.findById(itemId)
                .map(item -> {
                    if (checkQuantityUpdatePossible(item.getQuantity(),quantity)) {
                        item.setQuantity(item.getQuantity() + quantity);
                        return repository.save(item);
                    }
                    else throw new InvalidQuantityChangeException(quantity,item.getQuantity(),item.getId());
                }).orElseThrow(() -> new ItemNotFoundException(" "+itemId));

    }






    Item addNewItem( Item newItem) throws ItemExistsException, InvalidCreatingException {
        //TODO
        if (newItem.getQuantity()<0)  throw new  InvalidCreatingException(newItem.getName(),newItem.getQuantity());
        if (newItem.getName() == null || newItem.getName().length()== 0) {throw new InvalidCreatingException(newItem.getName() );};
        if (newItem.getId()!=null) {
            repository.findById(newItem.getId())
                    .ifPresent(item -> {
                                throw new  ItemExistsException("Item with same id already exists.");
                            }
                    );
        }


        if (repository.getItemByName(newItem.getName() )!= null)   throw new  ItemExistsException("Item with name:"+newItem.getName()+" already exists.");
        Object x = repository.getItemByInventoryCode(newItem.getInventoryCode());
        if (repository.getItemByInventoryCode(newItem.getInventoryCode()) != null)   throw new ItemExistsException("Item with inventoryCode:"+newItem.getInventoryCode()+" already exists.");


        return repository.save(newItem);
    }



    Item getItem( Long id) throws ItemNotFoundException{

        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id.toString()));
    }



//throws EmptyResultDataAccessException
    boolean deleteItem(Long id) throws  EmptyResultDataAccessException{
        try {
            repository.deleteById(id);
            return true;
        }
        catch (EmptyResultDataAccessException e) {
            System.out.println("delete item error:"+e.toString());
            throw new ItemNotFoundException(Long.toString(id));

        }
    }


    private static boolean checkQuantityUpdatePossible(int amount, int quantity) {
        return  ((amount + quantity) >= 0);

    }

    public Item getItemByName(String name) {
        return repository.getItemByName(name);
    }

//    public boolean delete(Long id) {
//
//        var isRemoved = this.posts.removeIf(post -> post.getId().equals(id));
//
//        return isRemoved;
//    }
}
