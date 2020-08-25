package com.hutool;

import cn.hutool.core.io.IoUtil;
import sun.nio.ch.IOUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * 测试hutool的IO操作
 */
public class TestIOUtil {

    public static void main(String[] args) {
        try {
            //原始文件位置
            FileInputStream inputStream = new FileInputStream(new File("E:\\WorkSpace\\idea\\projects-demo\\hutool-play\\src\\main\\resources\\aaa.txt"));
            FileOutputStream outputStream = new FileOutputStream("E:\\WorkSpace\\idea\\projects-demo\\hutool-play\\src\\main\\resources\\bbb.txt");
            //不指定缓冲区大小
            long copy1 = IoUtil.copy(inputStream, outputStream);
            System.out.println(copy1);
            //指定缓冲区大小
            long copy = IoUtil.copy(inputStream, outputStream, 1024);
            System.out.println(copy);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
