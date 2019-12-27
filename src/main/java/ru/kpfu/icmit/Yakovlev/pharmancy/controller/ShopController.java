package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Purchase;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Shop;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.ShopService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/shop")
public class ShopController extends AbstractController<Shop, ShopService> {

    protected ShopController(ShopService service) {
        super(service, "shop");
    }

    @Override
    public String fromFile(ArrayList<Shop> list) {
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
