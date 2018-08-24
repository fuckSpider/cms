package com.zhou.web;

import com.zhou.annotation.Excel;
import com.zhou.entity.User;
import com.zhou.util.ExcelUtil;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestExcel {
    /**
     * 测试解析excel
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        try {
            FileInputStream fileInputStream  = new FileInputStream(new File("E:\\java\\ideaProjects\\myShiro\\src\\main\\java\\com\\zhou\\web\\test.xlsx"));
            ExcelUtil<User> excelUtil = new ExcelUtil(User.class);

            List<User> maps = excelUtil.importExcel("sheet1", fileInputStream);
            System.out.println(maps);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 测试导出excel
     */
    @Test
    public void test2(){
        User user= new User();
        user.setId("1");
        user.setUsername("张三");
        user.setPassword("123");
        User user1= new User();
        user1.setId("1");
        user1.setUsername("李四");
        user1.setPassword("123");
        List<User> lists= new ArrayList<>();
        lists.add(user);
        lists.add(user1);
        ExcelUtil<User> excelUtil = new ExcelUtil(User.class);
        excelUtil.exportExcel(lists,"sheet1");
    }

    @Test
    public void test3(){
        Field[] allFields = User.class.getDeclaredFields();
        for(Field field:allFields){
            field.setAccessible(true);
            System.out.println(field.isAnnotationPresent(Excel.class));
        }
    }
}
