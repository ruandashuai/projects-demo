package com.hutool;

import cn.hutool.core.io.FileUtil;
import cn.hutool.extra.qrcode.QrCodeUtil;

import java.io.File;

/**
 * 生成二维码
 */
public class HutoolQrCode {
    public static void main(String[] args) {
        // 生成指定url对应的二维码到文件，宽和高都是300像素,创建File对象
        File file = QrCodeUtil.generate("https://hutool.cn/", 300, 300, FileUtil.file("二维码.jpg"));
        System.out.println(file);
    }
}
