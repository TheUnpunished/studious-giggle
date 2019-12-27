package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.*;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.ProductService;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.ShopService;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.SupplierService;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.TypeService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/product")
public class ProductController extends AbstractController<Product, ProductService> {

    protected ProductController(ProductService service) {
        super(service, "product");
    }

    @Autowired
    private ShopService shopService;

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private TypeService typeService;

    @Override
    public String add(ModelMap modelMap) {
        List<Shop> shopList = shopService.getAll();
        List<Supplier> supplierList = supplierService.getAll();
        List<Type> typeList = typeService.getAll();
        modelMap.addAttribute("shop_list", shopList);
        modelMap.addAttribute("supplier_list", supplierList);
        modelMap.addAttribute("type_list", typeList);
        return "/product/add";
    }

    @Override
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        Product product;
        Long parsed_id = Long.parseLong(id);
        Optional<Product> tOptional = service.getOneById(parsed_id);
        if (tOptional.isPresent()){
            product = tOptional.get();
        }
        else {
            product = null;
        }
        List<Shop> shopList = shopService.getAll();
        List<Supplier> supplierList = supplierService.getAll();
        List<Type> typeList = typeService.getAll();
        modelMap.addAttribute("shop_list", shopList);
        modelMap.addAttribute("supplier_list", supplierList);
        modelMap.addAttribute("type_list", typeList);
        modelMap.addAttribute("product", product);
        return "/product/edit";
    }

    @Override
    public String fromFile(ArrayList<Product> list) {
        Gson gson = new Gson();
        File file = new File(entityName + "_in.txt");
        try{
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            java.lang.reflect.Type typeToken = new TypeToken<ArrayList<Product>>(){}.getType();
            list = gson.fromJson(fileReader, typeToken);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.fromFile(list);
    }
}
