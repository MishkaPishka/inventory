package com.example.inventory;

import java.util.List;


import com.example.inventory.errors.InvalidQuantityChangeException;
import com.example.inventory.errors.ItemNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@Controller
@RequestMapping("/items")
@Api(value = "ItemController", description = "Shows inventory")
public class ItemController {

//    private final ItemRepository repository;
//
//    ItemController(ItemRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    private InventoryService inventoryService;

    //list of all item
    //get item details
    //withdrawal quantity
    //deposit quantity
    //add item
    //delete item


    // Aggregate root
    // tag::get-aggregate-root[]
    @GetMapping("/main")
    public ModelAndView getHomepage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        return modelAndView;
    }


    @GetMapping("")
    @ApiOperation(value="Get Item List")
    List<Item> all() {
        return inventoryService.all();
    }
    // end::get-aggregate-root[]

    @PostMapping("/change-quantity")
    @ApiOperation(value = "Change Quantity of an Item")
    Item changeQuantity(@RequestParam long itemId, @RequestParam int quantity) throws InvalidQuantityChangeException {
        return inventoryService.changeQuantity(itemId,quantity);
        //TODO
//        return repository.findById(itemId)
//                .map(item -> {
//                    if (checkQuantityUpdatePossible(item.getAmount(),quantity)) {
//                        item.setAmount(item.getAmount() + quantity);
//                    }
//                    else throw new InvalidQuantityChangeException(quantity,item.getAmount(),item.getId());
//                    return repository.save(item);
//                }).orElseThrow(() -> new ItemNotFoundException(itemId));

    }



    @PostMapping("")
    @ApiOperation(value = "Add New Item")

    Item addNewItem(@RequestBody Item newItem) {
        //TODO
        return inventoryService.addNewItem(newItem);

    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Item by ID")

    Item getItem(@PathVariable Long id) throws ItemNotFoundException {
        return inventoryService.getItem(id);

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

    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete Item by ID")

    void deleteItem(@PathVariable  Long id) {
         inventoryService.deleteItem(id);

    }


}
