package com.hutool;

import cn.hutool.core.io.resource.ResourceUtil;

/**
 * 资源工具
 */
public class HutoolResource {
    public static void main(String[] args) {
        /**
         * 假设我们的文件存放在src/resources/config目录下，则读取改为：
         */
        String str = ResourceUtil.readUtf8Str("config/ccc.txt");
        System.out.println(str);
    }
}
