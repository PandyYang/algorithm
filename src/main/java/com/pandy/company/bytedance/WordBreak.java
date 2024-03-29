package com.pandy.company.bytedance;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: Pandy
 * @create: 2022/7/3
 * <p>
 * 单词拼接
 *
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 **/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
