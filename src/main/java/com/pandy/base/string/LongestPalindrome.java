package com.pandy.base.string;

/**
 * @author Pandy
 * @date 4/1/2022
 * 最长回文子串
 */
public class LongestPalindrome {
    // 暴力解法
    public static String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
//                    ans = s.substring(i, j);
                    max = Math.max(max, test.length());
                }
            }
        }
        return ans;
    }

    // 判断是否为回文
    public static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
