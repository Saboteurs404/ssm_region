package com.xlh.controller;

import com.xlh.entity.Userinfo;
import com.xlh.service.UserinfoService;
import com.xlh.util.Encryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Xlh
 * @create 2022-07-06 22:07
 */
@Controller
public class userController {
    @Autowired
    private UserinfoService userService;

    @RequestMapping(value = "/user/register",method = RequestMethod.GET)
    public String register(){
        return "register";
    }

    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public String addUser(@ModelAttribute Userinfo, Model model){
        Userinfo record=new Userinfo();
        record.setName(user.getName());
        List<Userinfo> list=userService.selectSelective(record);
        if(list.size()==0){
            user.setCreatetime(new Date());
            user.setPw(Encryption.MD5(user.getPw()));
            if(userService.insert(user)==1){
                model.addAttribute("status",0);
            }else{
                model.addAttribute("status",1);
            }
        }else{
            model.addAttribute("status",2);
        }
        return "register"
    }
}































