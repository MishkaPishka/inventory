package com.example.inventory;

import com.example.inventory.exceptions.ItemNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HtmlController {
    @Autowired
    private InventoryService inventoryService;

    @RequestMapping("")
//    @ResponseBody
    public String getHomepage(Model model){
        List<Item> items = inventoryService.all();

        model.addAttribute("itemsList",items);
        return "main";
//        List<JSONObject> p = new ArrayList<JSONObject>();
//
//
//
//        items.stream().forEach((c) ->p.add(c.toJsonObject()));
////        Map<Long, Item> map = items.stream()
////                .collect(Collectors.toMap(Item::getId, item -> item));
//        ModelAndView modelAndView = new ModelAndView( "main" );
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        System.out.println(p);
//        modelAndView.addObject("itemsList",items.get(0));
//        return modelAndView;

//        throw new ItemNotFoundException("WWW");
//        try {
//
//
//        }
//        catch(ItemNotFoundException e) {
//            modelAndView.setViewName("project_explanation");
//        }
//        return modelAndView;
    }


//    @GetMapping("error")
//    @ResponseBody
//    public ModelAndView errorPage() {
//        ModelAndView modelAndView = new ModelAndView();
////         modelAndView.setViewName("errors/error");
//         modelAndView.setViewName("error");
//
//        return modelAndView;
//    }



    /*
    EXCEPTION HANDLER -- DESIGNED FOR UI PURPOSES
     */
    @ExceptionHandler({ ItemNotFoundException.class })
    public ModelAndView handleException(ItemNotFoundException e) {
        ModelAndView modelAndView = new ModelAndView();
//         modelAndView.setViewName("errors/error");
        modelAndView.setViewName("errors/item-not-found-error");
        modelAndView.addObject("error",e.getLocalizedMessage());

        return modelAndView;
    }

    //TODO --> ITEM PAGE
    @GetMapping("/item/{id:[0-9]+}")
    public String getItemPage(@PathVariable Long id,Model model) {
        //get item
        //if not exist -- redirect to error page
        //if exists then
        Item item = inventoryService.getItem(id);
        model.addAttribute("item",item);
     return "itemPage";

    }
//    @RequestMapping("/item/{id:(?:[0-9]+)}")
    @RequestMapping("/item/{id:[^0-9]+}")
    public String redirectEverythingOtherThanTest(@PathVariable String id){
        throw new ItemNotFoundException(id);
    }


}
