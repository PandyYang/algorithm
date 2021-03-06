package com.pandy.base.array.package02;

/**
 * @author: Pandy
 * @create: 2022/6/25
 * <p>
 * 搜索旋转数组
 * <p>
 * 将数组一分为二，其中一定有一个是有序的，另一个可能是有序，也能是部分有序。此时有序部分用二分法查找。
 * 无序部分再一分为二，其中一个一定有序，另一个可能有序，可能无序。就这样循环.
 * <p>
 * 4 5 1 2 3
 * 2
 * <p>
 * 3 4 5 1 2
 * 2
 **/
public class SearchInRotateSortedArray {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
                // 右边有序 判断target在不在右边 如果在 逐步缩小
            } else if (nums[mid] < nums[right]) {

                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                // 左边有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
}
