package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Given a linked list, determine if it has a cycle in it.
 * 
 * Follow up:
 * Can you solve it without using extra space?
 * 
 * @ClassName: LinkedListCycleE
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月20日
 */
public class LinkedListCycleE {

    public boolean hasCycle(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null && second != null) {
            if (first.next != null) {
                first = first.next;
            } else {
                break;
            }
            if (second.next != null && second.next.next != null) {
                second = second.next.next;
            } else {
                break;
            }
            if (first == second)
                return true;
        }
        return false;
    }

    public boolean hasCycle1(ListNode head) {
        if (head == null)
            return false;
        ListNode first = head;
        ListNode second = head;
        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;

            if (first == second)
                return true;
        }
        return false;
    }
}
