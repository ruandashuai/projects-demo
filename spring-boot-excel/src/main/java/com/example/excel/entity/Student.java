package com.example.excel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @ExcelProperty("学号")
    private Integer id;
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("年龄")
    private Integer age;
    @ExcelProperty("出生日期")
    private Date birthday;
}
