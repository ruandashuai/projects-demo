package com.hutool.use;

import cn.hutool.core.lang.Console;
import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.util.List;

public class BiliBili {
    public static void main(String[] args) {
        String page = HttpUtil.get("https://www.bilibili.com/video/BV1Af4y1972o?p=60");
        for (int i = 0; i < 61; i++) {
            Console.log("https://www.bilibili.com/video/BV1Af4y1972o?p={}", i + 1);
        }

    }
}