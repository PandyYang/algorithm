package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/6/17
 * <p>
 * 爬楼梯
 * <p>
 * 有 N 阶楼梯，每次可以上一阶或者两阶，求有多少种上楼梯的方法。
 * 定义一个数组 dp 存储上楼梯的方法数(为了方便讨论，数组下标从 1 开始)，
 * dp[i] 表示走到第 i 个楼梯的方法数目。 第 i 个楼梯可以从第 i-1
 * 和 i-2 个楼梯再走一步到达，走到第 i 个楼梯的方法数为走到第 i-1
 * 和第 i-2 个楼梯的方法数之和。  考虑到 dp[i] 只与 dp[i - 1] 和
 * dp[i - 2] 有关，因此可以只用两个变量来存储 dp[i - 1] 和 dp[i - 2]，
 * 使得原来的 O(N) 空间复杂度优化为 O(1) 复杂度。
 **/
public class ClimbStairs {

    public int climbStairs(int n) {

        // 边界条件
        if (n <= 2) return n;

        int pre2 = 1, pre1 = 2;

        for (int i = 2; i < n; i++) {
            // 状态转移方程
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }
}
