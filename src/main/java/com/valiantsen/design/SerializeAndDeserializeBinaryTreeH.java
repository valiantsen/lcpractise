package main.java.com.valiantsen.design;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary
 * tree can be serialized to a string and this string can be deserialized to the original tree
 * structure.
 * 
 * For example, you may serialize the following tree
 * 
 * 1 / \ 2 3 / \ 4 5 as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a
 * binary tree. You do not necessarily need to follow this format, so please be creative and come up
 * with different approaches yourself. Note: Do not use class member/global/static variables to
 * store states. Your serialize and deserialize algorithms should be stateless.
 * 
 * Credits: Special thanks to @Louis1992 for adding this problem and creating all test cases.
 * 
 * @ClassName: SerializeAndDeserializeBinaryTreeH
 * @author zhangyasen
 * @date 2017年9月24日
 */
public class SerializeAndDeserializeBinaryTreeH {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        String sb = "";
        return getStr(root, sb);
    }

    private String getStr(TreeNode root, String str) {
        if (root == null) {
            str += "-";
        } else {
            str += root.val;
        }
        str += ",";
        if (root != null) {
            str += getStr(root.left, "");
            str += getStr(root.right, "");
        }
        return str;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || "".equals(data)) {
            return null;
        }
        String fin = data.substring(0, data.length() - 1);
        String[] nodes = fin.split(",");
        Queue<String> queue = new LinkedList<>();
        for (String str : nodes) {
            queue.add(str);
        }
        return getTree(queue);
    }

    private TreeNode getTree(Queue<String> queue) {
        String val = queue.poll();
        if ("-".equals(val))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = getTree(queue);
            node.right = getTree(queue);
            return node;
        }
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        root1.left = root2;
        root1.right = root3;
        root2.left = root4;
        root4.right = root5;
        root3.right = root6;
        root6.left = root7;
        SerializeAndDeserializeBinaryTreeH a = new SerializeAndDeserializeBinaryTreeH();
        String s = a.serialize(root1);
        System.out.println(s);
        TreeNode root = a.deserialize(s);
        System.out.println(root.val);
        Map<String, String> map = new ConcurrentHashMap<>();
    }
}
