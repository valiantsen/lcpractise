/**
 * Copyright (c) 2017, DiDiChuXing. All rights reserved.
 */
package main.java.com.valiantsen.lcpractise.linkedlist;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 * 
 * Note: Do not modify the linked list.
 * 
 * Follow up: Can you solve it without using extra space?
 * 
 * @ClassName: LinkedListCycleIIM
 * @author zhangyasen
 * @date 2017年6月16日
 */
public class LinkedListCycleIIM {
    public ListNode detectCycle(ListNode head) {
        if (head == null)
            return null;
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
