package com.zhou.web;
import com.alibaba.fastjson.JSONObject;
import com.zhou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public List<Map<String,Object>> getMenuList() {
        return menuService.getMenus();
    }


    @RequestMapping(value = "/list/all",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject getAllMenu(@RequestParam("page")Integer page,@RequestParam("limit")Integer limit) {
        JSONObject jsonObject = new JSONObject();
        List<Map<String,Object>> data = menuService.getAllMenus1();
        jsonObject.put("data",data);
        jsonObject.put("count",data.size());
        jsonObject.put("code",0);
        jsonObject.put("msg","加载成功");
        return jsonObject;
    }

}
