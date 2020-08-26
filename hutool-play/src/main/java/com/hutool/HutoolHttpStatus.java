package com.hutool;

import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpStatus;

/**
 * HTTP状态码
 */
public class HutoolHttpStatus {
    public static void main(String[] args) {
        Console.log("{}  {}  {}", HttpStatus.HTTP_OK, HttpStatus.HTTP_NOT_FOUND, HttpStatus.HTTP_BAD_GATEWAY);
    }
}
