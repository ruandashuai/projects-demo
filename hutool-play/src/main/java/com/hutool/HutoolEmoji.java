package com.hutool;

import cn.hutool.extra.emoji.EmojiUtil;
import com.vdurmont.emoji.Emoji;

/**
 * 表情
 */
public class HutoolEmoji {
    public static void main(String[] args) {
        String s = EmojiUtil.toAlias("😄");
        System.out.println(s);
        String s1 = EmojiUtil.toUnicode(":smile:");
        System.out.println(s1);
        //转为HTML输出的
        String s2 = EmojiUtil.toHtml("😄");
        System.out.println(s2);
    }
}
