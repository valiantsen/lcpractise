package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.StructUtil;
import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * same as the class name
 * 
 * @ClassName: ConvertBinaryTreeToDoubleLinkedList
 * @author zhangyasen
 * @date 2017年10月9日
 */
public class ConvertBinaryTreeToDoubleLinkedList {

    public TreeNode convert(TreeNode root) {
        TreeNode lastNode = getLastNode(root, null);
        while (lastNode != null && lastNode.left != null) {
            lastNode = lastNode.left;
        }
        return lastNode;
    }

    private TreeNode getLastNode(TreeNode root, TreeNode lastNode) {
        if (root == null) {
            return lastNode;
        }
        if (root.left != null) {
            lastNode = getLastNode(root.left, lastNode);
        }
        root.left = lastNode;
        if (lastNode != null) {
            lastNode.right = root;
        }
        lastNode = root;
        if (root.right != null) {
            lastNode = getLastNode(root.right, lastNode);
        }
        return lastNode;
    }

    public static void main(String[] args) {
        String[] tree =
                {"1", "2", "4", "null", "5", "null", "null", "null", "3", "null", "6", "7", "null", "null", "null"};
        TreeNode root = StructUtil.convertFromArrayToTreeNode(tree);
        ConvertBinaryTreeToDoubleLinkedList c = new ConvertBinaryTreeToDoubleLinkedList();
        TreeNode list = c.convert(root);
        while (list != null) {
            System.out.println(list.val);
            list = list.right;
        }
    }
}
