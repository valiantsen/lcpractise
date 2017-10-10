package main.java.com.valiantsen.lcpractise.struct;

import java.util.LinkedList;
import java.util.Queue;

public class StructUtil {

    /**
     * convert array to binary tree
     * 
     * @param treeArray
     * @return
     */
    public static TreeNode convertFromArrayToTreeNode(String[] treeArray) {
        if (treeArray == null || treeArray.length == 0)
            return null;
        Queue<String> queue = new LinkedList<>();
        for (String str : treeArray) {
            queue.add(str);
        }
        return getTree(queue);
    }

    private static TreeNode getTree(Queue<String> queue) {
        String val = queue.poll();
        if ("null".equals(val))
            return null;
        else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = getTree(queue);
            node.right = getTree(queue);
            return node;
        }
    }
}
