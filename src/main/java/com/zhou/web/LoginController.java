package com.zhou.web;

import com.zhou.dao.UserMapper;
import com.zhou.entity.User;
import com.zhou.util.CodeUtil;
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
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

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


    @RequestMapping("/getCode")
    public void getKaptcha(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Map<String, Object> map = CodeUtil.generateCodeAndPic();
        req.getSession().setAttribute("code",map.get("code"));

        System.out.println("登录时候的验证码为===>"+map.get("code"));
        BufferedImage image = (BufferedImage) map.get("codePic");
        resp.setContentType("image/jpeg");
        OutputStream os = resp.getOutputStream();
        ImageIO.write(image, "jpeg", os);
    }
}
