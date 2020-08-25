package com.hutool;

import cn.hutool.http.HttpUtil;

public class HutoolHTTP {
    public static void main(String[] args) {

        String s = HttpUtil.get("https://www.baidu.com");
        System.out.println(s);
    }
}
