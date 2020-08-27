package com.example.controller;

import com.example.utils.JsonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/")
    public JsonResult test() {

        return new JsonResult().setCode(1).setMsg("111").setData(null);
    }
}
