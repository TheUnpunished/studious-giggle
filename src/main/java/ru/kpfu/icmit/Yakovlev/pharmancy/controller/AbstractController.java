package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.BaseEntity;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.IdEntity;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.CrudService;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AbstractController <T extends BaseEntity, R extends CrudService<T>>  implements GenericController<T>{

    protected final R service;
    protected final String entityName;

    @Autowired
    protected AbstractController(R service, String entityName){
        this.service = service;
        this.entityName = entityName;
    }

    @Override
    public String openAll(ModelMap modelMap) {
        List<T> tList = service.getAll();
        System.out.println(tList);
        modelMap.addAttribute(entityName + "_list", tList);
        return entityName + "/list";
    }

    @Override
    public String edit(String id, ModelMap modelMap) {
        T t;
        Long parsed_id = Long.parseLong(id);
        Optional<T> tOptional = service.getOneById(parsed_id);
        if (tOptional.isPresent()){
            t = tOptional.get();
        }
        else {
            t = null;
        }
        modelMap.addAttribute(entityName, t);
        return entityName + "/edit";
    }

    @Override
    public String editPost(String id, T t) {
        IdEntity idEntity = (IdEntity) t;
        Long parsed_id = Long.parseLong(id);
        idEntity.setId(parsed_id);
        T t1 = (T) idEntity;
        service.update(t1);
        return "redirect:/" + entityName + "/done";
    }

    @Override
    public String add(ModelMap modelMap) {
        return entityName + "/add";
    }

    @Override
    public String addPost(T t) {
        service.add(t);
        return "redirect:/" + entityName + "/done";
    }

    @Override
    public String delete(String id) {
        Long id_Long = Long.parseLong(id);
        service.deleteById(id_Long);
        return "redirect:/" + entityName + "/done";
    }

    @Override
    public String done(ModelMap modelMap) {
        modelMap.addAttribute(entityName);
        return "/done";
    }

    @Override
    public String toFile() {
        ArrayList<T> list = (ArrayList<T>) service.getAll();
        File file = new File(entityName + "_out.txt");
        try(FileWriter fileWriter = new FileWriter(file, true)) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(list, new TypeToken<ArrayList<T>>() {}.getType(), fileWriter);
       } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/" + entityName + "/done";
    }

    @Override
    public String fromFile(ArrayList<T> list) {
        service.deleteAll();
        for(T t: list){
            service.add(t);
        }
        return "redirect:/" + entityName + "/done";
    }

}
