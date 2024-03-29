package com.pandy.base.list;

import com.pandy.common.ListNode;

/**
 * @author Pandy
 * @date 27/12/2021
 * <p>
 * 删除节点分为三种情况"
 * 头结点
 * 尾结点
 * 中间节点
 */
public class DeleteNode {

    /**
     * 按照节点删除
     *
     * @param head
     * @param deListNode
     */
    public void deleteNode(ListNode head, ListNode deListNode) {
        if (deListNode == null || head == null) return;
        // 头结点
        if (head == deListNode) head = null;
        else {
            // 最后一个节点
            if (deListNode.next == null) {
                ListNode pointListNode = head;
                // 一直走到倒数第二个节点
                while (pointListNode.next.next != null) {
                    pointListNode = pointListNode.next;
                }
                // 移除最后一个节点
                pointListNode.next = null;
            } else {
                // 中间节点
                deListNode.val = deListNode.next.val;
                deListNode.next = deListNode.next.next;
            }
        }
    }

    /**
     * 按照节点值删除
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return head;
        ListNode cur = head;
        ListNode pre = null;
        // 是头节点 则直接返回下一个节点
        if (cur.val == val) return head.next;

        while (cur.val != val) {
            // 记录上一个节点
            pre = cur;
            cur = cur.next;
        }

        // 在此处进行删除
        pre.next = pre.next.next;
        return head;
    }
}
