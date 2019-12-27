package ru.kpfu.icmit.Yakovlev.pharmancy.controller;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Shop;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Worker;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.ShopService;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.WorkerService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/worker")
public class WorkerController extends AbstractController<Worker, WorkerService> {

    @Autowired
    private ShopService shopService;

    @Override
    public String edit(@PathVariable("id") String id, ModelMap modelMap) {
        List<Shop> shop_list = shopService.getAll();
        System.out.println(id);
        Long parsed_id = Long.parseLong(id);
        Optional<Worker> optionalWorker = service.getOneById(parsed_id);
        Worker worker;
        if(optionalWorker.isPresent()){
            worker = optionalWorker.get();
        }
        else {
            worker = null;
        }
        modelMap.addAttribute("shop_list", shop_list);
        modelMap.addAttribute("worker", worker);
        return "/worker/edit";
    }

    @Override
    public String add(ModelMap modelMap) {
        List<Shop> shop_list = shopService.getAll();
        modelMap.addAttribute("shop_list", shop_list);
        return "/worker/add";
    }

    @Override
    public String fromFile(ArrayList<Worker> list) {
        Gson gson = new Gson();
        File file = new File(entityName + "_in.txt");
        try{
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            Type typeToken = new TypeToken<ArrayList<Worker>>(){}.getType();
            list = gson.fromJson(fileReader, typeToken);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.fromFile(list);
    }

    protected WorkerController(WorkerService service) {
        super(service, "worker");
    }
}
