package com.pandy.company.pdd;

/**
 * @author: Pandy
 * @create: 2022/7/7
 **/
public class GetMaxMatrix {
    public int[] getMaxMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int max = matrix[0][0];
        int[] res = new int[4];

        // 构造列的前缀和
        int[][] preSum = new int[m + 1][n];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 0; j < n; j++) {
                preSum[i][j] = preSum[i - 1][j] + matrix[i - 1][j];
            }
        }

        // 合并行
        for (int top = 0; top < m; top++) {
            for (int bottom = top; bottom < m; bottom++) {
                // 构造一维矩阵
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = preSum[bottom + 1][i] - preSum[top][i];
                }
                // 最大子数组问题
                int start = 0;
                int sum = arr[0];
                for (int i = 1; i < n; i++) {
                    if (sum > 0) {
                        sum += arr[i];
                    } else {
                        sum = arr[i];
                        start = i;
                    }
                    if (sum > max) {
                        max = sum;
                        res[0] = top;
                        res[1] = start;
                        res[2] = bottom;
                        res[3] = i;
                    }
                }
            }
        }

        return res;
    }
}
