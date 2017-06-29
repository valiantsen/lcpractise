package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * For example,
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes 1->2->3->5. Note: Given n
 * will always be valid. Try to do this in one pass.
 * 
 * @ClassName: RemoveNthNodeFromEndOfList
 * @author zhangyasen
 * @date 2017年5月29日
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode del = head, fast = head, pre = dummy;
        while (fast != null) {
            fast = fast.next;
            if (n > 0)
                n--;
            else {
                del = del.next;
                pre = pre.next;
            }
        }
        pre.next = del.next;

        return dummy.next;

    }
}
