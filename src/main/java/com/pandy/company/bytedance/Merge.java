package com.pandy.company.bytedance;

/**
 * @author: Pandy
 * @create: 2022/7/3
 * <p>
 * 合并两个有序数组
 **/
public class Merge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0) {
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }

        while (n >= 0) {
            nums1[p--] = nums2[n--];
        }
    }
}
