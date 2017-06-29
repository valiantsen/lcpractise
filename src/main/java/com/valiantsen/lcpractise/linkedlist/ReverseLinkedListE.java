package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Reverse a singly linked list.
 * 
 * 
 * @ClassName: ReverseLinkedListE
 * @Description:
 * @author zhangyasen
 * @date 2017年5月21日
 */
public class ReverseLinkedListE {

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode first = null, second = head, third = second.next;
        while (second != null) {
            second.next = first;
            first = second;
            second = third;
            if (third != null)
                third = third.next;
        }
        return first;
    }
}
