package main.java.com.valiantsen.lcpractise.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * For example, Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Your algorithm should use only constant space. You may not modify the values in the list, only
 * nodes itself can be changed.
 * 
 * @ClassName: SwapNodesInPairsM
 * @author zhangyasen
 * @date 2017年5月30日
 */
public class SwapNodesInPairsM {

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = head, pointer = null, second = null, pre = dummy;
        while (first != null && first.next != null) {
            second = first.next;
            pointer = second.next;
            pre.next = second;
            second.next = first;
            first.next = pointer;
            pre = first;
            first = pointer;
        }
        return dummy.next;
    }
}
