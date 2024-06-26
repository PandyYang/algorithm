package com.pandy.huawei.shousi;

import com.pandy.common.ListNode;

public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode ptr1 = head;
                ListNode ptr2 = slow;
                while (ptr1 != ptr2) {
                    ptr2 = ptr2.next;
                    ptr1 = ptr1.next;
                }
                return ptr1;
            }
        }
        return null;
    }
}
