package com.pandy.huawei.shousi;

public class CanJump {
    int maxLen = 0;
    public boolean canJump(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i > maxLen) {
                return false;
            }
            maxLen = Math.max(maxLen, i + nums[i]);
        }
        return maxLen >= nums.length - 1;
    }
}
