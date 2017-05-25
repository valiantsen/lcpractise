package main.java.com.valiantsen.lcpractise.linkedlist;


/**
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 * 
 * @ClassName: RemoveLinkedListElements
 * @Description:
 * @author zhangyasen
 * @date 2017年5月21日
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;
        ListNode start = head;
        ListNode pre = start;
        if (head != null)
            head = head.next;
        while (head != null) {
            if (head.val == val) {
                pre.next = head.next;
            } else {
                pre = head;
            }
            head = head.next;
        }
        return start;
    }

    public ListNode removeElements1(ListNode head, int val) {

        while (head != null && head.val == val)
            head = head.next;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public ListNode removeElements2(ListNode head, int val) {

        if (head == null)
            return head;
        ListNode next = removeElements(head.next, val);
        if (head.val == val)
            return next;
        head.next = next;
        return head;
    }
}
