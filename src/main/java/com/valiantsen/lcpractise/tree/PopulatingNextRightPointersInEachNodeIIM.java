package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note:
 * 
 * You may only use constant extra space. For example, Given the following binary tree, 1 / \ 2 3 /
 * \ \ 4 5 7 After calling your function, the tree should look like: 1 -> NULL / \ 2 -> 3 -> NULL /
 * \ \ 4-> 5 -> 7 -> NULL
 * 
 * @ClassName: PopulatingNextRightPointersInEachNodeIIM
 * @author zhangyasen
 * @date 2017年10月1日
 */
public class PopulatingNextRightPointersInEachNodeIIM {
    public void connect(TreeLinkNode root) {
        TreeLinkNode pre, cur, head = root;
        while (head != null) {
            cur = head;
            pre = null;
            head = null;
            while (cur != null) {
                if (cur.left != null) {
                    if (pre != null) {
                        pre.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    pre = cur.left;
                }
                if (cur.right != null) {
                    if (pre != null) {
                        pre.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    pre = cur.right;
                }
                cur = cur.next;
            }
        }
    }
}
