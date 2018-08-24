package com.zhou.util;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

/**
 * 操作excel的工具类
 * 负责xlsx,和xls
 * 解析和生成
 * //待完成
 */
public class ExcelUtil1 {
    public static List<Map<String,Object>> parse(String path) throws IOException {
        InputStream is = new FileInputStream(new File(path));
        Workbook hssfWorkbook = null;
        if (path.endsWith("xlsx")){
            hssfWorkbook = new XSSFWorkbook(is);//Excel 2007
        }else if (path.endsWith("xls")){
            hssfWorkbook = new HSSFWorkbook(is);//Excel 2003
        }

        //获取列名
        List<String> rowname = new ArrayList<>();
        Sheet hssfSheet1 = hssfWorkbook.getSheetAt(0);
        Row row = hssfSheet1.getRow(0);

        Iterator<Cell> cellIterator = row.cellIterator();
        if(cellIterator.hasNext()){
            Cell cell = cellIterator.next();
            rowname.add(cell.toString());
        }

        for (int numSheet = 0; numSheet <hssfWorkbook.getNumberOfSheets(); numSheet++) {
            //HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            Sheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
        }
        return null;
    }


}



