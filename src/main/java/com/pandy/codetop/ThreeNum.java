package com.pandy.codetop;

import com.pandy.base.tree.traversal.In;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res =  new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            // �ƽ���
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right --;
                }
            }
        }
        return res;
    }
}
