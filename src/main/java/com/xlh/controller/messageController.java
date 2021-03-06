package com.xlh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Xlh
 * @create 2022-06-30 21:48
 */

@Controller
public class messageController {
    @RequestMapping("/message/ge")
    public String goTest(){
        return "register";
    }

    @RequestMapping("/message/detail/data={username}")
    public String goDetail(@PathVariable("username")String data, Model model){
        model.addAttribute("data",data);
        return "detail";
    }

    //数据报表页展示
    @RequestMapping(value = "/message/report1",method = RequestMethod.GET)
    public String reportGet(@RequestParam("begin") String begin,
                            @RequestParam("end") String end,Model model){
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("formType","GET");
        return "report";
    }
    @RequestMapping(value = "/message/report2",method = RequestMethod.POST)
    public String reportPost(@RequestParam("begin") String begin,
                            @RequestParam("end") String end,Model model){
        model.addAttribute("begin",begin);
        model.addAttribute("end",end);
        model.addAttribute("formType","POST");
        return "report";
    }

}
