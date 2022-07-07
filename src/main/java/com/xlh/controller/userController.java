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

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Date;
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
    public String addUser(@ModelAttribute Userinfo user, Model model){
        Userinfo record=new Userinfo();
        record.setUsername(record.getUsername());
        List<Userinfo> list=userService.selectSelective(record);
        if(list.size()==0){
            record.setCreatetime(new Date());
            record.setPassword(Encryption.MD5(record.getPassword()));
            if(userService.insert(record)==1){
                model.addAttribute("status",0);
            }else{
                model.addAttribute("status",1);
            }
        }else{
            model.addAttribute("status",2);
        }
        return "register";
    }

    @RequestMapping(value="/user/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public String loginValidate(HttpSession session, Model model, @ModelAttribute Userinfo user) {
        List<Userinfo> list = new ArrayList<Userinfo>();
        Userinfo record  = new Userinfo();
        record.setUsername(user.getUsername());
        list = userService.selectSelective(record);
        if (list.size() == 0) {
            model.addAttribute("status", 1);
        } else {
            record.setPassword(Encryption.MD5(user.getPassword()));
            list = userService.selectSelective(record);
            if (list.size() == 0) {
                model.addAttribute("status", 2);
            }
            record = list.get(0);
            session.setAttribute("userinfo", record);
            model.addAttribute("status", 0);
        }

        return "login";
    }


    @RequestMapping(value = "user/userinfo",method = RequestMethod.GET)
    public String userinfo(Model model,HttpSession session){
        Userinfo user=(Userinfo)session.getAttribute("userinfo");
        if(user!=null){
            model.addAttribute("user",user);
        }
        return "userinfo";
    }
    @RequestMapping(value = "/user/logout",method=RequestMethod.GET)
    public String logout(HttpSession session){
        session.invalidate();
        //session.removeAttributr("user);
        return "login";
    }
}































