package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeLinkNode;

/**
 * Given a binary tree
 * 
 * struct TreeLinkNode { TreeLinkNode *left; TreeLinkNode *right; TreeLinkNode *next; } Populate
 * each next pointer to point to its next right node. If there is no next right node, the next
 * pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * Note:
 * 
 * You may only use constant extra space. You may assume that it is a perfect binary tree (ie, all
 * leaves are at the same level, and every parent has two children). For example, Given the
 * following perfect binary tree, 1 / \ 2 3 / \ / \ 4 5 6 7 After calling your function, the tree
 * should look like: 1 -> NULL / \ 2 -> 3 -> NULL / \ / \ 4->5->6->7 -> NULL
 * 
 * @ClassName: PopulatingNextRightPointersInEachNodeM
 * @author zhangyasen
 * @date 2017年9月29日
 */
public class PopulatingNextRightPointersInEachNodeM {
    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode p = root;
            while (p != null) {
                if (p.left != null)
                    p.left.next = p.right;
                if (p.right != null)
                    p.right.next = p.next == null ? null : p.next.left;

                p = p.next;
            }
            root = root.left;
        }
    }
}
