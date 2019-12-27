package ru.kpfu.icmit.Yakovlev.pharmancy.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Purchase;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Supplier;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.SupplierService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/supplier")
public class SupplierController extends AbstractController<Supplier, SupplierService> {

    protected SupplierController(SupplierService service) {
        super(service, "supplier");
    }

    @Override
    public String fromFile(ArrayList<Supplier> list) {
        Gson gson = new Gson();
        File file = new File(entityName + "_in.txt");
        try{
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            java.lang.reflect.Type typeToken = new TypeToken<ArrayList<Supplier>>(){}.getType();
            list = gson.fromJson(fileReader, typeToken);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.fromFile(list);
    }

}
