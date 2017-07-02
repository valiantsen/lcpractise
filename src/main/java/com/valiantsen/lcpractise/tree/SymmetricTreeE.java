package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * 
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 * 1 / \ 2 2 / \ / \ 3 4 4 3 But the following [1,2,2,null,3,null,3] is not: 1 / \ 2 2 \ \ 3 3 Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * @ClassName: SymmetricTreeE
 * @author zhangyasen
 * @date 2017年7月2日
 */
public class SymmetricTreeE {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;

        return isSym(root.left, root.right);
    }

    private boolean isSym(TreeNode a, TreeNode b) {
        if (a == null || b == null) {
            return a == b;
        }
        if (a.val == b.val) {
            return isSym(a.left, b.right) && isSym(a.right, b.left);
        }
        return false;
    }
}
