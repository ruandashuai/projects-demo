package com.example.excel.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.excel.entity.Student;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class ExcelListener extends AnalysisEventListener<Student> {
    public ExcelListener() {
        log.info("----开始解析Excel----");
    }

    @Override
    public void invoke(Student data, AnalysisContext context) {
        log.info("每解析一行数据，就会执行一次监听器的invoke()方法，可以将业务逻辑放在此处：{}", data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        log.info("----数据解析完毕----");
    }
}
