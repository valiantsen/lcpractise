package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, every node has a int value, return the root node of subtree with the largest
 * sum up value.
 * 
 * @ClassName: MaxSubtreeSum
 * @author zhangyasen
 * @date 2017年10月1日
 */
public class MaxSubtreeSum {

    public TreeNode maxSubtreeSum(TreeNode root) {
        if (root == null)
            return null;
        TreeNode p = null;
        int max = 0;
        help(root, p, max);
        return p;
    }

    private void help(TreeNode root, TreeNode p, int max) {

    }
}
