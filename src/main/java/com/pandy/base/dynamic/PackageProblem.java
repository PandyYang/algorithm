package com.pandy.base.dynamic;

/**
 * @author Pandy
 * @date 23/2/2022
 * <p>
 * 描述：
 * 有N件物品和一个重量为V的包，第i件物品的重量为w[i]，对应的价值为v[i]，求
 * 将哪些物品放入背包可以使这些物品的重量总和不能超过背包容量，且价值总和最大。
 */
public class PackageProblem {

    // 3个物品的重量
    static int[] weight = {1, 4, 3};
    // 3个物品的价值
    static int[] value = {150, 300, 200};

    public static int pro1() {
        // 包最大可装重量
        int packageContainWeight = 4;

        int[][] dp = new int[weight.length + 1][packageContainWeight + 1];

        for (int i = 1; i <= value.length; i++) {
            for (int j = 1; j <= packageContainWeight; j++) {
                if (j >= weight[i - 1]) {
                    // 选当前商品（当前商品的价值 + 剩余空间可容纳的价值）
                    // dp[i-1][j-weight(i)]+value[i]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + value[i - 1]);
                } else {
                    // 不选当前商品
                    // dp[i-1][j]
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[weight.length][packageContainWeight];
    }

    /**
     * 递归解法
     *
     * @param i
     * @param j
     * @return
     */
    public static int pro2(int i, int j) {
        if (i == -1)
            return 0;
        int v1 = 0;
        if (j >= weight[i]) {
            v1 = pro2(i - 1, j - weight[i]) + value[i];
        }
        int v2 = pro2(i - 1, j);
        return Math.max(v1, v2);
    }

    public static int Bagging(int[] c, int[] v, int order) {
        //这些情况背包问题都是不成立的
        if (c == null || v == null || c.length != v.length) {
            return -1;
        }
        int n = c.length;
        int[][] dp = new int[n + 1][order + 1];
        //因为最后一行全为0 java数组默认都是0 从倒数第二行开始计算值
        for (int index = n - 1; index >= 0; index--) {
            for (int col = 0; col <= order; col++) {
                int p1 = dp[index + 1][col];
                int p2 = 0;
                if (col - c[index] >= 0) {
                    p2 += v[index] + dp[index + 1][col - c[index]];
                }
                dp[index][col] = Math.max(p1, p2);
            }
        }
        return dp[0][order];
    }

    public static void main(String[] args) {
        System.out.println(pro1());
    }
}
