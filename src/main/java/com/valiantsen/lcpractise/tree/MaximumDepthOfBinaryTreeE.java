/**
 */
package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, find its maximum depth.
 * 
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 * 
 * @ClassName: MaximumDepthOfBinaryTreeE
 * @author zhangyasen
 * @date 2017年6月29日
 */
public class MaximumDepthOfBinaryTreeE {
    public int maxDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }
}
