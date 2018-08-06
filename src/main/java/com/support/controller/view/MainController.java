package com.support.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String emptyRootGet() {
        return "redirect:/";
    }

    @RequestMapping("/")
    public String rootGet(Model model) {
        return "main";
    }

}
