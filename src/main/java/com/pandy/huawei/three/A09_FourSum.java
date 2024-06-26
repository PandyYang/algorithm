package com.pandy.huawei.three;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A09_FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 1; j < len - 2; j++) {
                int left = j + 1;
                int right = len - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum > target) {
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        if (!result.contains(list)) {
                            result.add(list);
                        }
                        left++;
                    }
                }
            }
        }
        return result;
    }
}
