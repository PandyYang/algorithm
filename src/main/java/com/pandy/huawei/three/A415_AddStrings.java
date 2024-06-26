package com.pandy.huawei.three;

public class A415_AddStrings {
    public String addStrings(String num1, String num2) {

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder();

        while (i >= 0 || j >= 0) {

            if (i >= 0) {
                carry += num1.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                carry += num2.charAt(j) - '0';
                j--;
            }

            stringBuilder.append(carry % 10);
            carry = carry / 10;
        }

        if (carry > 0) {
            stringBuilder.append(carry);
        }

        return stringBuilder.reverse().toString();
    }
}
