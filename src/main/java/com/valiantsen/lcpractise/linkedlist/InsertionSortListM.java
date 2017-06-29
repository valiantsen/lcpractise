package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 
 * 
 * @ClassName: InsertionSortListM
 * @author zhangyasen
 * @date 2017年5月28日
 */
public class InsertionSortListM {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        if (head != null) {
            ListNode nxt = null, com = head.next;
            head.next = null;
            while (com != null) {
                ListNode point = dummy;
                nxt = com.next;
                while (point.next != null && point.next.val < com.val) {
                    point = point.next;
                }
                ListNode low = point.next;
                point.next = com;
                com.next = low;

                com = nxt;
            }
        }


        return dummy.next;
    }
}
