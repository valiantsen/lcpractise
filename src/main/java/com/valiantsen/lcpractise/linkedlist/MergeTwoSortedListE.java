package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes
 * of the first two lists.
 * 
 * @ClassName: MergeTwoSortedListE
 * @Description:
 * @author zhangyasen
 * @date 2017年5月20日
 */
public class MergeTwoSortedListE {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}
