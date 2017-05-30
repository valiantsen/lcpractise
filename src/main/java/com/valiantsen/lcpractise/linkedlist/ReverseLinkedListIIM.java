package main.java.com.valiantsen.lcpractise.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 * 
 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 * 
 * return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 ≤ m ≤ n ≤ length of list.
 * 
 * @ClassName: ReverseLinkedListIIM
 * @author zhangyasen
 * @date 2017年5月30日
 */
public class ReverseLinkedListIIM {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode start = pre.next, second = start.next;

        for (int i = 0; i < n - m; i++) {
            start.next = second.next;
            second.next = pre.next;
            pre.next = second;
            second = start.next;
        }
        return dummy.next;
    }
}
