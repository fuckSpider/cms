package com.zhou.web;

import com.zhou.entity.User;
import com.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/finduser")
    @ResponseBody
    public String findById(@RequestParam("id") String id){
        try{
            User u = userService.findById(id);
            return  "ok";
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }
}
