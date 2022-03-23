package com.pandy.base.list;

import com.pandy.common.ListNode;

import java.util.LinkedList;

/**
 * @author: Pandy
 * @create: 2022/2/26
 *
 *
 * 判断一个链表是否为回文链表
 * 借助栈的结构 进栈出栈再判断一次
 *
 *
 * 链表入栈 之后遍历和弹栈进行对比
 **/
public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        LinkedList<ListNode> stack = new LinkedList<>();
        ListNode cur = head;

        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {
            if (!Integer.valueOf(stack.pop().val).equals(Integer.valueOf(head.val))) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
