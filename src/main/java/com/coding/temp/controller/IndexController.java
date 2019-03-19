package com.coding.temp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zhangyongwei
 */
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping
    public String index(Model model){
        model.addAttribute("host","zhangyongwei");
        return "index";
    }

}
