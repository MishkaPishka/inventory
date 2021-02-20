package com.example.inventory;

import com.example.inventory.errors.InvalidQuantityChangeException;
import com.example.inventory.errors.ItemNotFoundException;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;


import java.util.List;

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
                    if (checkQuantityUpdatePossible(item.getAmount(),quantity)) {
                        item.setAmount(item.getAmount() + quantity);
                    }
                    else throw new InvalidQuantityChangeException(quantity,item.getAmount(),item.getId());
                    return repository.save(item);
                }).orElseThrow(() -> new ItemNotFoundException(itemId));

    }





    Item addNewItem( Item newItem) {
        //TODO
        return repository.save(newItem);

    }



    Item getItem( Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
    }

//    @PutMapping("/items/{id}")
//    Item replaceEmployee(@RequestBody Item newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }



    void deleteItem( Long id) {
        repository.deleteById(id);

    }


    private static boolean checkQuantityUpdatePossible(int amount, int quantity) {
        return  ((amount + quantity) >= 0);

    }
}
