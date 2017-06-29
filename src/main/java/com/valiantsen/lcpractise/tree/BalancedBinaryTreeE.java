/**
 */
package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
 * the two subtrees of every node never differ by more than 1.
 * 
 * @ClassName: BalancedBinaryTreeE
 * @author zhangyasen
 * @date 2017年6月29日
 */
public class BalancedBinaryTreeE {

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        return (Math.abs(dept(root.left) - dept(root.right)) < 2) && isBalanced(root.left) && isBalanced(root.right);

    }

    private int dept(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return Math.max(1 + dept(node.left), 1 + dept(node.right));
    }
}
