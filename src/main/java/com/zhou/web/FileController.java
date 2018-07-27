package com.zhou.web;

import com.alibaba.fastjson.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;


@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    @ResponseBody
    public JSONObject fileupload(@RequestParam("file") MultipartFile multipartFile, HttpSession session){
        JSONObject jsonObject = new JSONObject();
        if(!StringUtils.isEmpty(multipartFile)||multipartFile.getSize()>0){
            String originalFilename = multipartFile.getOriginalFilename();
            String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
            System.out.println(suffix);

            if (originalFilename.endsWith("jpg")||originalFilename.endsWith("png")){
                String realPath = session.getServletContext().getRealPath("/")+"/file/"+new Date().getTime()+"."+suffix;
                File file = new File(realPath);
                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                jsonObject.put("code",1);
                jsonObject.put("msg","文件上传成功");
            }else{
                jsonObject.put("code",2);
                jsonObject.put("msg","文件不匹配");
            }
        }else{
            jsonObject.put("code",0);
            jsonObject.put("msg","文件不存在");
        }
        return jsonObject;
    }


}
