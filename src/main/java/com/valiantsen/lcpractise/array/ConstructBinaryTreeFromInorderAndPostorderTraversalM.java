package main.java.com.valiantsen.lcpractise.array;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * @ClassName: ConstructBinaryTreeFromInorderAndPostorderTraversalM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月7日
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversalM {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode construct(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {
        TreeNode root = null;
        root = new TreeNode(postorder[poEnd]);
        if (poStart == poEnd) {
            root.left = root.right = null;
            return root;
        }
        int find = inStart;
        while (inorder[find] != postorder[poEnd] && find <= inEnd)
            find++;
        int leftLength = find - inStart;
        if (leftLength > 0) {
            root.left = construct(inorder, inStart, find - 1, postorder, poStart, poStart + leftLength - 1);
        }
        if (find < inEnd) {
            root.right = construct(inorder, find + 1, inEnd, postorder, poStart + leftLength, poEnd - 1);
        }

        return root;
    }

}
