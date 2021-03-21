package com.example.inventory;

import com.example.inventory.exceptions.ItemNotFoundException;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.io.IOException;

@Controller
public class HtmlController {
    @Autowired
    private InventoryService inventoryService;
    @Autowired
    private ImageService imageService;
    @RequestMapping("")
//    @ResponseBody
    public String getHomepage(Model model){
        List<Item> items = inventoryService.all();
        model.addAttribute("itemsList",items);
        return "main";

    }




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
        Image img = imageService.getImageByItemID(id.intValue());

        String b64 = img == null? imageService.B64_DEFAULT_IMAGE : img.getData();
        model.addAttribute("img",b64);

        return "itemPage";

    }
//    @RequestMapping("/item/{id:(?:[0-9]+)}")
    @RequestMapping("/item/{id:[^0-9]+}")
    public String redirectEverythingOtherThanTest(@PathVariable String id){
        throw new ItemNotFoundException(id);
    }




    @GetMapping(value = "/item/{itemID}/image",  produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody String getImageByItemID(@PathVariable int itemID) throws IOException {
            Image f =  imageService.getImageByItemID(itemID);
            if (f==null) {
                return null;
            }
            else return f.getData();

    }


    @PostMapping(value = "/item/uplodadImage/{itemID}",  consumes = {"multipart/form-data"})
    @ResponseBody
    public boolean uploadImage(@PathVariable int itemID, @RequestParam MultipartFile imageFile) throws IOException {
        System.out.println("itemID:"+itemID);


        try {
            imageService.createNewImageFromMultipartFileAndItemIDAndSave(itemID, imageFile);

        }
        catch (Exception e ) {
            System.out.println("File exception:"+e.toString());
            return false;
        }
        return true;



    }
}
