package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/4/4
 * <p>
 * 机器人走的路径
 * <p>
 * 动态方程: dp[i][j] = dp[i-1][j] + ap[i][j-1]
 * 注意: 对于第一行dp[0][j] 或者第一列 dp[i]][0] 由于都是在边界 所以只能为1
 **/
public class UniquePath {

    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
