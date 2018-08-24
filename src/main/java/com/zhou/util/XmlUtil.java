package com.zhou.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlUtil {
    public static Map<String,Object> parseRule(String path) throws IOException {
        Map<String,Object> map = new HashMap<>();
        File file = new File(path);
        Document data  = Jsoup.parse(file,"utf-8");
        Element body = data.body();
        Elements sites = body.getElementsByTag("site");
        for(Element e :sites){
            map.put("name",e.select("name").get(0).html());
            map.put("url",e.select("url").get(0).html());
            map.put("selector",e.select("selector").get(0).html());
        }
        return map;
    }

    public static void main(String[] args) {
        try {
            System.out.println(XmlUtil.parseRule("E:\\java\\ideaProjects\\myShiro\\src\\main\\resources\\parserule.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
