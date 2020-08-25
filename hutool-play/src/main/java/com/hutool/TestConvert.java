package com.hutool;

import cn.hutool.core.convert.Convert;

/**
 * 测试 HuTool 中的类型转换
 */
public class TestConvert {
    public static void main(String[] args) {
        int a = 111;
        System.out.println(Convert.toStr(a));

        long[] b = {1, 5, 6, 4, 88, 7};
        System.out.println(Convert.toStr(b));

        String c = "2020-08-25";
        System.out.println(Convert.toDate(c));

    }
}
