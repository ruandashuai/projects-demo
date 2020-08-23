package com.example.excel.controller;

import com.example.excel.entity.Student;
import com.example.excel.utils.ExcelUtils;
import com.example.excel.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class StudentController {

    @RequestMapping("/upload")
    public JsonResult upload(@RequestParam("file") MultipartFile file, HttpServletResponse response) {
        List<Student> studentList = null;
        try {
            studentList = ExcelUtils.upload(file.getInputStream(), Student.class, null);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Student student : studentList) {
            System.out.println(student);
        }
        return new JsonResult().setCode(1).setMessage("上传成功！").setData(studentList);
    }
}
