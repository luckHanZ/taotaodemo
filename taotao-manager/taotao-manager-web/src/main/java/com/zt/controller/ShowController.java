package com.zt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShowController {
    @RequestMapping("/")
    public String index(){
        return  "index";
    }
    @RequestMapping("/{page}")
    public String showPage(@PathVariable String page){
        return  page;
    }
}
