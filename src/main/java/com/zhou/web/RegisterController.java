package com.zhou.web;

import com.alibaba.fastjson.JSONObject;
import com.zhou.entity.User;
import com.zhou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegisterController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public JSONObject register(User user){
        JSONObject jsonObject = new JSONObject();
        int count = userService.saveUser(user);
        if(count==1){
            jsonObject.put("code",1);
            jsonObject.put("msg","注册成功");
        } else if(count ==-1){
            jsonObject.put("code",-1);
            jsonObject.put("msg","用户名已被使用");
        }
        else{
            jsonObject.put("code",2);
            jsonObject.put("msg","注册失败,请联系管理员");
        }

        return jsonObject;
    }



}
