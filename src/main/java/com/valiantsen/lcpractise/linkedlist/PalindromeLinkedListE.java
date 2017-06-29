package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 * 
 * @ClassName: PalindromeLinkedListE
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月25日
 */
public class PalindromeLinkedListE {

    public boolean isPalindrome(ListNode head) {

        ListNode first = head, second = head;
        if (head != null && head.next != null) {
            do {
                first = first.next;
                second = second.next.next;
            } while (second != null && second.next != null);
            ListNode mock = reverseList(first);
            while (mock != null) {
                if (mock.val != head.val) {
                    return false;
                }
                mock = mock.next;
                head = head.next;
            }
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
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
