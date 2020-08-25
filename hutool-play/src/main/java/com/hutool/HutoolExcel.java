package com.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;

import java.util.List;

public class HutoolExcel {
    /**
     * Hutool操作Excel
     * 需要在pom文件中添加poi-ooxml依赖
     *
     * @param args
     */
    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("E:\\WorkSpace\\idea\\projects-demo\\学生表.xls"));
        List<List<Object>> list = reader.read();
        List<Object> objects = list.get(0);
        System.out.println(objects);
        for (List<Object> row : list) {
            Console.log("{}  {}   {}   {}", row.get(0), row.get(1), row.get(2), row.get(3));
        }
    }
}
