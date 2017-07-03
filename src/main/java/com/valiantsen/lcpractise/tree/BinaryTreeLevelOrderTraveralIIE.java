package main.java.com.valiantsen.lcpractise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from
 * left to right, level by level from leaf to root).
 * 
 * For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 / \ 15 7 return its bottom-up
 * level order traversal as: [ [15,7], [9,20], [3] ]
 * 
 * @ClassName: BinaryTreeLevelOrderTraveralIIE
 * @author zhangyasen
 * @date 2017年7月3日
 */
public class BinaryTreeLevelOrderTraveralIIE {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int num = queue.size();
            List<Integer> sub = new ArrayList<>();
            for (int i = 0; i < num; i++) {
                TreeNode m = queue.poll();
                if (m.left != null)
                    queue.offer(m.left);
                if (m.right != null)
                    queue.offer(m.right);
                sub.add(m.val);
            }
            result.add(0, sub);
        }
        return result;

    }

    public List<List<Integer>> levelOrderBottomDFS(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        mark(result, root, 0);
        return result;

    }

    private void mark(List<List<Integer>> result, TreeNode root, int level) {
        if (root == null)
            return;
        if (level >= result.size()) {
            result.add(0, new ArrayList<Integer>());
        }
        result.get(result.size() - level - 1).add(root.val);

        mark(result, root.left, level + 1);
        mark(result, root.right, level + 1);

    }
}
