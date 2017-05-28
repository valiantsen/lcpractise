package main.java.com.valiantsen.lcpractise.linkedlist;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @ClassName: RemoveDuplicatesFromSortedList
 * @Description:
 * @author zhangyasen
 * @date 2017年5月20日
 */
public class RemoveDuplicatesFromSortedListE {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode pointer = head;
        while (pointer != null) {
            while (pointer.next != null && pointer.next.val == pointer.val) {
                pointer.next = pointer.next.next;
            }
            pointer = pointer.next;
        }

        return head;
    }


}
