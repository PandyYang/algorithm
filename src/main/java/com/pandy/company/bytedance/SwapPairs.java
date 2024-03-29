package com.pandy.company.bytedance;

import com.pandy.common.ListNode;

/**
 * @author: Pandy
 * @create: 2022/7/1
 * <p>
 * 两两交换链表中的节点
 * <p>
 * 找终止条件：本题终止条件很明显，当递归到链表为空或者链表只剩一个元素的时候，没得交换了，自然就终止了。
 * 找返回值：返回给上一层递归的值应该是已经交换完成后的子链表。
 * 单次的过程：因为递归是重复做一样的事情，所以从宏观上考虑，只用考虑某一步是怎么完成的。
 * 我们假设待交换的俩节点分别为head和next，next的应该接受上一级返回的子链表(参考第2步)。
 * 就相当于是一个含三个节点的链表交换前两个节点，就很简单了，想不明白的画画图就ok。
 **/
public class SwapPairs {
    public ListNode swapPairs(ListNode head) {
        //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
        if (head == null || head.next == null) return head;
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
    }
}
