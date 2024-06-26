package com.pandy.huawei.shousi;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0) {
            if (i >= 0) {
                carry += num1.charAt(i) - '0';
            }

            if (j >= 0) {
                carry += num2.charAt(j) - '0';
            }

            sb.append(carry % 10);
            carry = carry / 10;

            i--;
            j--;
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
