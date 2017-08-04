package main.java.com.valiantsen.lcpractise.tree;

import java.util.ArrayList;
import java.util.List;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 
 * The left subtree of a node contains only nodes with keys less than the node's key. The right
 * subtree of a node contains only nodes with keys greater than the node's key. Both the left and
 * right subtrees must also be binary search trees. Example 1: 2 / \ 1 3 Binary tree [2,1,3], return
 * true. Example 2: 1 / \ 2 3 Binary tree [1,2,3], return false.
 * 
 * @ClassName: ValidateBinarySearchTreeM
 * @author zhangyasen
 * @date 2017年8月3日
 */
public class ValidateBinarySearchTreeM {

    public boolean isValidBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).val >= list.get(i).val)
                return false;
        }
        return true;

    }

    private void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null)
            return;
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }
}
