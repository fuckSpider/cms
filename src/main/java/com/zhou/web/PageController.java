package com.zhou.web;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class PageController {
    @RequestMapping(value = {"/","/login"},method = RequestMethod.GET)
    public String login(HttpSession session){
        if(StringUtils.isEmpty(session.getAttribute("username"))){
            return "pages/login";
        }else{
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/register")
    public String register(){
        return "pages/register";
    }

    @RequestMapping(value = "/index")
    public String index(){
        return "pages/index";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        return "pages/login";
    }

    @RequestMapping(value = "/nopermission")
    public String nopermission(){
        return "pages/nopermission";
    }

    @RequestMapping(value = "/system/test")
    public String test(){
        return "pages/test";
    }

    @RequestMapping(value = "/page/error")
    public String pageError(){
        return "pages/error";
    }

    @RequestMapping(value = "/normal/fileupload")
    public String fileupload(){
        return "pages/fileupload";
    }

}
