package com.example.utils;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class JsonResult implements Serializable {
    private String msg;
    private Object data;
    private Integer code;
}
