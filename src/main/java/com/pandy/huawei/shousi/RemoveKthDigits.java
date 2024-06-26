package com.pandy.huawei.shousi;

public class RemoveKthDigits {
    public String removeKthDigits(String num, int k) {
        if (num.length() == k) return "0";
        StringBuilder s = new StringBuilder();

        for (int i = 0; i < k; i++) {
            int idx = 0;
            for (int j = 1; j < s.length() && s.charAt(j) >=s.charAt(j-1); j++) idx = j;
            s.delete(idx, idx + 1);
            while (s.length() > 1 && s.charAt(0) == '0') s.delete(0, 1);
        }
        return s.length() == 0 ? "0": s.toString();
    }
}
