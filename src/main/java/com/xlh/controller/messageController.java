package com.xlh.controller;

import org.springframework.stereotype.Controller;
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

}
