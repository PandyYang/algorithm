package com.pandy.base.dynamic;

/**
 * @author: Pandy
 * @create: 2022/6/17
 *
 * 数组的区间
 **/
public class NumArray {

    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length+1];
        for (int i = 1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j+1] - sums[i];
    }
}
