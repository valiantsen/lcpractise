package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @ClassName: RorateListM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月25日
 */
public class RorateListM {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0)
            return head;
        int size = 0;
        ListNode first = head, second = head, counter = head;
        while (counter != null) {
            size++;
            counter = counter.next;
        }
        int x = k % size;
        while (x > 0) {
            second = second.next;
            x--;
        }
        if (second != head) {
            while (second.next != null) {
                first = first.next;
                second = second.next;

            }
            counter = first.next;
            first.next = null;
            second.next = head;
            return counter;
        }

        return head;
    }

    public ListNode rotateRight1(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int size = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (fast.next != null) {
            size++;
            fast = fast.next;
        }
        int x = size - k % size;
        while (x > 0) {
            slow = slow.next;
            x--;
        }
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}
