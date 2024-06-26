package com.pandy.huawei.shousi;

public class MinDistance {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1]//替换或者插入，也就是说替换和插入是一回事，
                                    //要不然你在加个dp[i - 1][j - 1]也是一样的结果
                                    , dp[i][j - 1]), //删除2
                            dp[i - 1][j] //删除1
                    ) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}