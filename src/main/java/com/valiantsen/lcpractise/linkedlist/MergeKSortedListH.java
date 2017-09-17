package main.java.com.valiantsen.lcpractise.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

import main.java.com.valiantsen.lcpractise.struct.ListNode;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its
 * complexity.
 * 
 * 
 * @ClassName: MergeKSortedListH
 * @author zhangyasen
 * @date 2017年9月17日
 */
public class MergeKSortedListH {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode l1, ListNode l2) {
                if (l1.val > l2.val) {
                    return 1;
                } else if (l1.val == l2.val) {
                    return 0;
                } else {
                    return -1;
                }
            }
        });

        for (ListNode first : lists) {
            if (first != null)
                queue.add(first);
        }
        while (!queue.isEmpty()) {
            tail.next = queue.poll();
            tail = tail.next;
            if (tail != null && tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}
