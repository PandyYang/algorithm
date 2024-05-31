package com.pandy.huawei;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字符，然后输出输入字符串中该字符的出现次数。（不区分大小写字母）
 *
 * 输入描述：
 * 第一行输入一个由字母、数字和空格组成的字符串，第二行输入一个字符（保证该字符不为空格）。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。（不区分大小写字母）
 *
 * 示例1
 * 输入：
 * ABCabc
 * A
 *
 * 输出：
 * 2
 */
public class HJ2 {

    // 注意类名必须为 Main, 不要有任何 package xxx 信息

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextLine()) { // 注意 while 处理多个 case
                String a = in.nextLine().toLowerCase();
                String b = in.nextLine().toLowerCase();
                HashMap<String, Integer> map = new HashMap<>();
                char[] chars = a.toCharArray();
                for (char aChar : chars) {
                    if (map.containsKey(String.valueOf(aChar))) {
                        Integer integer = map.get(String.valueOf(aChar));
                        map.put(String.valueOf(aChar), integer + 1);
                    } else {
                        map.put(String.valueOf(aChar), 1);
                    }
                }

                System.out.println(map.getOrDefault(b, 0));
            }
        }
}
