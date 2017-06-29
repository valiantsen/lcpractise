package main.java.com.valiantsen.lcpractise.linkedlist;

import main.java.com.valiantsen.lcpractise.struct.ListNode;
import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height
 * balanced BST.
 * 
 * 
 * @ClassName: ConvertSortedListToBinarySearchTreeM
 * @author zhangyasen
 * @date 2017年5月29日
 */
public class ConvertSortedListToBinarySearchTreeM {

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null) {
            TreeNode root = new TreeNode(head.val);
            return root;
        }
        ListNode pre = null, fast = head, slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        TreeNode root = new TreeNode(slow.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(slow.next);
        return root;
    }
}
