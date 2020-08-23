package com.example.excel.utils;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.read.builder.ExcelReaderBuilder;
import com.alibaba.excel.read.builder.ExcelReaderSheetBuilder;
import com.alibaba.excel.read.listener.ReadListener;
import com.example.excel.entity.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

/**
 * Excel工具类
 */
@Slf4j
public class ExcelUtils {
    /**
     * Excel上传解析
     *
     * @param inputStream 文件流对象
     */
    public static List upload(InputStream inputStream, Class entityType, ReadListener readListener) {
        try {
            System.out.println(entityType);
            return EasyExcelFactory.read(inputStream, entityType, readListener).sheet().doReadSync();
        } catch (Exception e) {
            log.error("出现IO异常！", e);
            return null;
        }
    }

}
