package com.hutool;

import cn.hutool.core.util.IdUtil;

public class HutoolUUID {
    public static void main(String[] args) {
        System.out.println(IdUtil.randomUUID());
        System.out.println(IdUtil.simpleUUID());
        System.out.println(IdUtil.fastUUID());
        System.out.println(IdUtil.createSnowflake(10L, 5L));
    }
}
