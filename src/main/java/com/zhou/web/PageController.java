package com.zhou.web;

import com.zhou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.xml.ws.Action;

@Controller
public class PageController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = {"/","/login"},method = RequestMethod.GET)
    public String login(HttpSession session){
        if(StringUtils.isEmpty(session.getAttribute("username"))){
            return "pages/login";
        }else{
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "/register",method = RequestMethod.GET)
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

    @RequestMapping(value = "/system/menu/add")
    public String loadAddMenu(Model model){
        model.addAttribute("parent",menuService.getParentMenu());
        return "pages/iframe/addmenu";
    }

    @RequestMapping(value = "/normal/fileupload")
    public String fileupload(){
        return "pages/fileupload";
    }

    @RequestMapping(value = "/system/menu")
    public String menu(){return "pages/menuManager";}

    @RequestMapping(value = "/normal/excel")
    public String excel(){
        return "pages/excel";
    }

}
