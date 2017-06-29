
package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, find its minimum depth.
 * 
 * The minimum depth is the number of nodes along the shortest path from the root node down to the
 * nearest leaf node.
 * 
 * @ClassName: MinimumDepthOfBinaryTreeE
 * @author zhangyasen
 * @date 2017年6月29日
 */
public class MinimumDepthOfBinaryTreeE {

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        if (root.left == null && root.right == null)
            return 1;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (left == 0)
            return 1 + right;
        if (right == 0)
            return 1 + left;
        return Math.min(1 + left, 1 + right);
    }
}
