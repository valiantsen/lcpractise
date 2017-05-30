package main.java.com.valiantsen.lcpractise.linkedlist;

/**
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct
 * numbers from the original list.
 * 
 * For example, Given 1->2->3->3->4->4->5, return 1->2->5. Given 1->1->1->2->3, return 2->3.
 * 
 * @ClassName: RemoveDuplicatesFromSortedListIIM
 * @author zhangyasen
 * @date 2017年5月30日
 */
public class RemoveDuplicatesFromSortedListIIM {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, first = dummy.next;
        int nowVal = first.val;
        boolean gap = false;
        while (first.next != null) {
            if (first.next.val == nowVal) {
                gap = true;
            } else {
                nowVal = first.next.val;
                if (gap) {
                    // move
                    pre.next = first.next;
                    gap = false;
                } else {
                    pre = first;
                }
            }

            first = first.next;
        }
        if (gap)
            pre.next = null;
        return dummy.next;
    }

    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, first = dummy.next;

        while (first != null) {
            if (first.next != null && first.next.val == first.val) {
                first = first.next;
                continue;
            } else {
                if (pre.next == first) {
                    pre = pre.next;
                } else {
                    pre.next = first.next;
                }
            }

            first = first.next;
        }
        return dummy.next;
    }
}
