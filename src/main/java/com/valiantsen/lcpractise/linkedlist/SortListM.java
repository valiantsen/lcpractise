package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * 
 * @ClassName: SortListM
 * @author zhangyasen
 * @date 2017年5月28日
 */
public class SortListM {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode fast = head, slow = head, pre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
        return mergeList(l1, l2);

    }

    private ListNode mergeList(ListNode m, ListNode n) {
        ListNode p = new ListNode(0), l = p;
        while (m != null && n != null) {
            if (m.val < n.val) {
                p.next = m;
                m = m.next;
            } else {
                p.next = n;
                n = n.next;
            }
            p = p.next;
        }
        if (m != null) {
            p.next = m;
        }
        if (n != null) {
            p.next = n;
        }
        return l.next;
    }
}
