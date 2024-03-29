package com.pandy.base.string;

/**
 * @author: Pandy
 * @create: 2022/1/25
 * 判断是否为回文串
 * <p>
 * 使用双指针进行逼近判断
 * 只考虑字母和数字字符 可以忽略大小写
 **/
public class isPalindrome {
    public static boolean isPalindrome(String s) {
        if (s.length() == 0) return true;
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            } else {
                // 判断两者是否相等
                if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
                } else {
                    l++;
                    r--;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        boolean abcdcba = isPalindrome("abcdcba");
        System.out.println("abcdcba = " + abcdcba);
    }
}
