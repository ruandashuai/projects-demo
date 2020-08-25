package com.example.excel.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.excel.entity.Student;
import com.example.excel.listener.ExcelListener;
import com.example.excel.utils.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import sun.rmi.runtime.Log;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 */
@RestController
@Slf4j
public class StudentController {

    @RequestMapping("/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile file) {
        ExcelReader excelReader = null;
        List<Student> studentList = null;
        try {
            /**
             * 1、拿到excel对象（输入流、行的实体类型class，监听器），业务操作可以放到监听器中进行
             * 2、sheet()：获取第一个sheet
             * 3、进行读操作
             */
            /*
            EasyExcel.read(file.getInputStream(), Student.class, new ExcelListener())
                    .sheet()
                    .doRead();
            */

            /** 返回Excel所有的行，装到一个List中 */
            studentList = EasyExcel.read(file.getInputStream(), Student.class, new ExcelListener()).doReadAllSync();
            for (int i = 0; i < studentList.size(); i++) {
                System.out.println(studentList.get(i));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return new JsonResult().setCode(1).setMessage("上传成功！").setData(studentList);
    }


    @RequestMapping("/easyexcel/download")
    public JsonResult download(HttpServletResponse response) throws IOException {

        log.info("---下载开始---{}", new Date());
/*        ServletOutputStream out = response.getOutputStream();
        ExcelWriter excelWriter = new ExcelWriter(out, ExcelTypeEnum.XLS, true);
        String excelName = "学生表";
        WriteSheet sheet = new WriteSheet();
        sheet.setSheetName("学生表-模块1");
        excelWriter.write(getStudentList(), sheet);
        excelWriter.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + excelName + ".xls");*/
        String fileName = URLEncoder.encode("学生表", "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Student.class)
                .excelType(ExcelTypeEnum.XLS)
                .sheet("sheet1")
                .doWrite(getStudentList());
        log.info("---下载结束---{}", new Date());
        return new JsonResult().setCode(1).setMessage("下载成功！").setData(null);
    }

    private List getStudentList() {
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Student student = new Student(i, "名字" + i, i, new Date());
            students.add(student);
        }
        return students;
    }
}
