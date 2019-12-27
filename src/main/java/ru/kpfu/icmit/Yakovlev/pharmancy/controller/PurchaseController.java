package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Product;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Purchase;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.ProductService;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.PurchaseService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/purchase")
public class PurchaseController extends AbstractController<Purchase, PurchaseService> {

    protected PurchaseController(PurchaseService service) {
        super(service, "purchase");
    }

    @Autowired
    private ProductService productService;

    @Override
    public String add(ModelMap modelMap) {
        List<Product> product_List = productService.getAll();
        modelMap.addAttribute("product_list", product_List);
        return "/purchase/add";
    }

    @Override
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        Long parsed_id = Long.parseLong(id);
        Purchase purchase;
        List<Product> product_list = productService.getAll();
        Optional<Purchase> optionalPurchase = service.getOneById(parsed_id);
        if(optionalPurchase.isPresent()){
            purchase = optionalPurchase.get();
        }
        else {
            purchase = null;
        }
        modelMap.addAttribute("purchase", purchase);
        modelMap.addAttribute("product_list", product_list);
        return "/purchase/edit";
    }

    @Override
    public String fromFile(ArrayList<Purchase> list) {
        Gson gson = new Gson();
        File file = new File(entityName + "_in.txt");
        try{
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            java.lang.reflect.Type typeToken = new TypeToken<ArrayList<Purchase>>(){}.getType();
            list = gson.fromJson(fileReader, typeToken);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.fromFile(list);
    }
}
