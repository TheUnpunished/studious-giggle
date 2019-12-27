package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Purchase;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.Type;
import ru.kpfu.icmit.Yakovlev.pharmancy.service.TypeService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@Controller
@RequestMapping("/type")
public class TypeController extends AbstractController<Type, TypeService> {

    protected TypeController(TypeService service) {
        super(service, "type");
    }

    @Override
    public String fromFile(ArrayList<Type> list) {
        Gson gson = new Gson();
        File file = new File(entityName + "_in.txt");
        try{
            file.createNewFile();
            FileReader fileReader = new FileReader(file);
            java.lang.reflect.Type typeToken = new TypeToken<ArrayList<Type>>(){}.getType();
            list = gson.fromJson(fileReader, typeToken);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return super.fromFile(list);
    }
}
