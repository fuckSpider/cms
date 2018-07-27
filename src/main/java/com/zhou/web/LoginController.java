package com.zhou.web;

import com.zhou.dao.UserMapper;
import com.zhou.entity.User;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    private Logger logger = Logger.getLogger(LoginController.class);

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, Model model, HttpSession session){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,password);

        try{
            subject.login(usernamePasswordToken);
            session.setAttribute("username",subject.getPrincipal());
        }catch ( UnknownAccountException unknownAccountException){
            unknownAccountException.printStackTrace();
            model.addAttribute("message","账号不存在");
            return "pages/login";
        }catch (LockedAccountException lockedAccountException){
            lockedAccountException.printStackTrace();
            model.addAttribute("message","账号被锁定");
            return "pages/login";
        }catch (IncorrectCredentialsException incorrectCredentialsException){
            incorrectCredentialsException.printStackTrace();
            model.addAttribute("message","密码错误");
            return "pages/login";
        }
        logger.info("=======登录成功========");
        return "redirect:/index";
    }
}
