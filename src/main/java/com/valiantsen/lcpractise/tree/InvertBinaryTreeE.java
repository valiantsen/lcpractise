package main.java.com.valiantsen.lcpractise.tree;

import java.util.Deque;
import java.util.LinkedList;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Invert a binary tree.
 * 
 * 4 / \ 2 7 / \ / \ 1 3 6 9 to 4 / \ 7 2 / \ / \ 9 6 3 1 Trivia: This problem was inspired by this
 * original tweet by Max Howell: Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so fuck off.
 * 
 * @ClassName: InvertBinaryTreeE
 * @author zhangyasen
 * @date 2017年7月4日
 */
public class InvertBinaryTreeE {

    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public TreeNode invertTreeNo(TreeNode root) {
        if (root == null)
            return null;
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            TreeNode left = node.left;
            node.left = node.right;
            node.right = left;

            if (node.left != null)
                stack.push(node.left);
            if (node.right != null)
                stack.push(node.right);
        }
        return root;
    }
}
