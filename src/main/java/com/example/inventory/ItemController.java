package com.example.inventory;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;


import com.example.inventory.exceptions.InvalidQuantityChangeException;
import com.example.inventory.exceptions.ItemNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@Controller
@RequestMapping("/api")
@Api(value = "Items Controller")
public class ItemController {

//    private final ItemRepository repository;
//
//    ItemController(ItemRepository repository) {
//        this.repository = repository;
//    }

    @Autowired
    private InventoryService inventoryService;




    @PostMapping("/bulk-update")
    @ApiOperation(value = "Bulk change of an Item")
    Item updateItemFields(@RequestParam long itemId, @RequestParam Map<String,String> allRequestParams ) throws InvalidQuantityChangeException, SQLException {
        JSONObject js = new JSONObject(allRequestParams.get("allRequestParams"));
        Item x = inventoryService.changeItemFeildsByMap(itemId,js.toMap());
        return x;
    }

    @GetMapping("get-inventory-list")
    @ApiOperation(value="Get Items List")
    List<Item> all() {
        return inventoryService.all();
    }

    @PostMapping("/change-quantity")
    @ApiOperation(value = "Change Quantity of an Item")
    Item changeQuantity(@RequestParam long itemId, @RequestParam int quantity) throws InvalidQuantityChangeException {
        return inventoryService.changeQuantity(itemId,quantity);

    }


    @GetMapping("/get-item-by-name/{name}")
    @ApiOperation(value = "Get Item by Name")
    Item getItemByName(@PathVariable String name) {
        Item t =  inventoryService.getItemByName(name);
        if (t==null)     throw new ItemNotFoundException("name:"+name);
        return t;
    }



    @PostMapping("/add")
    @ApiOperation(value = "Add New Item")
    Item addNewItem(@RequestBody Item newItem) {

        return inventoryService.addNewItem(newItem);
    }

    @GetMapping("/items/{id}")
    @ApiOperation(value = "Get Item by ID")
    Item getItem(@PathVariable Long id)  {
        return  inventoryService.getItem(id);

    }






    @DeleteMapping("/delete/{id}")
    @ApiOperation(value = "Delete Item by ID")
    void deleteItem(@PathVariable String id) {
        long id_ = new Long(id);

         inventoryService.deleteItem(id_);


    }



//        @DeleteMapping("/delete/{id}")
//    @ApiOperation(value = "Delete Item by ID")
//        boolean deleteItem(    @PathVariable String id) {
//        long id_ = Long.parseLong(id);
//        return inventoryService.deleteItem(id_);
//
//
//    }
}
