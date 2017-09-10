package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

public class LCAInABinarySearchTreeE {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null)
            return null;

        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = (root.val - p.val) > 0 ? root.left : root.right;
        }
        return root;
    }
}
