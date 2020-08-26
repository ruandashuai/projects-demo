package com.hutool;

import cn.hutool.extra.tokenizer.Result;
import cn.hutool.extra.tokenizer.TokenizerEngine;
import cn.hutool.extra.tokenizer.TokenizerUtil;
import cn.hutool.extra.tokenizer.Word;

import java.util.Iterator;

/**
 * 分词器
 */
public class HutoolTokenizer {
    public static void main(String[] args) {
        //自动根据用户引入的分词库的jar来自动选择使用的引擎
        TokenizerEngine engine = TokenizerUtil.createEngine();
        //解析文本
        String text = "一位超级着急的靓仔！";
        Result result = engine.parse(text);
        //输出：这 两个 方法 的 区别 在于 返回 值
        for (Word word : result) {
            System.out.println(word);
        }
    }
}
