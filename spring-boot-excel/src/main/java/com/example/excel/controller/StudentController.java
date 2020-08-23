package com.example.excel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.example.excel.entity.Student;
import com.example.excel.listener.ExcelListener;
import com.example.excel.utils.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 */
@RestController
public class StudentController {

    @RequestMapping("/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        ExcelReader excelReader = null;
        try {
            /**
             * 1、拿到excel对象（输入流、行的实体类型class，监听器），业务操作可以放到监听器中进行
             * 2、sheet()：获取第一个sheet
             * 3、进行读操作
             */

            EasyExcel.read(file.getInputStream(), Student.class, new ExcelListener())
                    .sheet()
                    .doRead();

            /**
             * 返回Excel所有的行，装到一个List中
             */
            List<Student> studentList = EasyExcel.read(file.getInputStream(), Student.class, new ExcelListener()).doReadAllSync();
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println(studentList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return new JsonResult().setCode(1).setMessage("上传成功！").setData(null);
    }


}
