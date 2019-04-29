package com.coding.temp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Zhang Yongei
 * @version 1.0
 * @date 2019-04-29
 */
@Controller
@RequestMapping("recording")
public class HouseController {

    @RequestMapping
    public String recording(){
        return "recording/index";
    }
}
