package com.pandy.base.array.package3;

import java.util.Arrays;

/**
 * @author: Pandy
 * @create: 2022/6/29
 * <p>
 * 判断是否为字母异位词
 **/
public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }
}
