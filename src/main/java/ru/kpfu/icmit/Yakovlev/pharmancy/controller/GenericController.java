package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.kpfu.icmit.Yakovlev.pharmancy.model.BaseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public interface GenericController<T extends BaseEntity> {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String openAll(ModelMap modelMap);

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String edit(@PathVariable("id") String id,
                       ModelMap modelMap);

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String editPost(@PathVariable("id") String id,
                           @Valid T t);

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String add(ModelMap modelMap);

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPost(@Valid T t);

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable("id") String id);

    @RequestMapping(value = "/done", method = RequestMethod.GET)
    public String done(ModelMap modelMap);

    @RequestMapping(value = "/tofile", method = RequestMethod.GET)
    public String toFile();

    @RequestMapping(value = "/fromfile", method = RequestMethod.GET)
    public String fromFile(ArrayList<T> list);

}
