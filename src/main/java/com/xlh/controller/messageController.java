package com.xlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Xlh
 * @create 2022-06-30 21:48
 */

@Controller
public class messageController {
    @RequestMapping("/message/ge")
    public String goTest(){
        return "reach";
    }

    @RequestMapping("/message/detail/data={userName}")
    public String goDetail(@PathVariable("userName")String data, Model model){
        model.addAttribute("data",data);
        return "detail";
    }

}
