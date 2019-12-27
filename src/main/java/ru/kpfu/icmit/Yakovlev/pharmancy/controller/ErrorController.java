package ru.kpfu.icmit.Yakovlev.pharmancy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ErrorController {

    @ExceptionHandler(Exception.class)
    public String error(ModelMap modelMap, Exception e) {
        modelMap.addAttribute("message", e.getLocalizedMessage());
        return "/error";
    }
}
