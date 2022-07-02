package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/2
 *
 * 下一个更大元素III
 **/
public class NextGreaterElement {

    public int nextGreaterElement(int n) {
        char[] nums = Integer.toString(n).toCharArray();
        int i = nums.length - 2;

        while (i >= 0 && nums[i] >= nums[i+1]) {
            i--;
        }

        if (i < 0) return -1;
        int j = nums.length - 1;

        // 找出第一个i升序前 然后路过波锋，的下一个降序。
        while (j >= 0 && nums[i] >= nums[j]) {
            j--;
        }

        swap(nums, i, j);
        reverse(nums, i +1);
        long ans = Long.parseLong(new String(nums));
        return ans > Integer.MAX_VALUE ? - 1 : (int) ans;
    }

    public void reverse(char[] nums, int begin) {
        int i = begin, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    public void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}