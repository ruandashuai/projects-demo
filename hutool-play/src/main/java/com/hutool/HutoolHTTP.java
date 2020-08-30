package com.hutool;


import cn.hutool.core.io.IoUtil;
import cn.hutool.core.lang.Console;
import cn.hutool.http.HttpUtil;
import org.json.JSONArray;
import org.junit.Test;
import org.json.JSONObject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class HutoolHTTP {
    public static void main(String[] args) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("bilibiliurl0815", "https://www.bilibili.com/video/BV1Af4y1972o?p=1");
        map.put("zengqiang", true);
        String post = HttpUtil.post("https://xbeibeix.com/api/bilibili/", map, -1);
        System.out.println(post);
    }

    @Test
    public void test() throws IOException {
        List<String> nameList = new ArrayList<>();
        String s = HttpUtil.get("https://api.bilibili.com/x/player/pagelist?bvid=BV1Af4y1972o&jsonp=jsonp");
        JSONObject jsonObject = new JSONObject(s);
        JSONArray data = (JSONArray) jsonObject.get("data");
        Iterator<Object> iterator = data.iterator();
        while (iterator.hasNext()) {
            JSONObject next = (JSONObject) iterator.next();
            String part = next.get("part").toString();
            nameList.add(part);
        }
        //--------------拿到名字--nameList------------------
        File folder = new File("E:\\学习视频\\Spring Cloud");
        File[] fileList = folder.listFiles();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");

        Console.log("NameList大小：{}，文件数量：{}", nameList.size(), fileList.length);


        for (int i = 0; i < 61; i++) {
            String fileName = nameList.get(i);
            File oldFile = fileList[i];
            String absolutePath = oldFile.getAbsolutePath();
            String savePath = absolutePath.substring(0, absolutePath.lastIndexOf("\\") + 1);
            String oldFileName = oldFile.getName();
            String suffix = oldFile.getName().substring(oldFileName.lastIndexOf("."), oldFileName.length());
            fileName = fileName + suffix;
            File newFile = new File(savePath + fileName);
            long copy = IoUtil.copy(new FileInputStream(oldFile), new FileOutputStream(newFile));
            Console.log("拷贝文件，文件大小：{}KB（约{}MB）\t\t原文件名:\t{}\t\t\t新文件名:\t{}",
                    copy / 1024,
                    copy / 1024 / 1024,
                    oldFile.getName(),
                    newFile.getName());
        }
    }
}
