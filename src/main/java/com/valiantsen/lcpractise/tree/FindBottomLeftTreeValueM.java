package main.java.com.valiantsen.lcpractise.tree;

import java.util.LinkedList;
import java.util.Queue;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, find the leftmost value in the last row of the tree.
 * 
 * Example 1: Input:
 * 
 * 2 / \ 1 3
 * 
 * Output: 1 Example 2: Input:
 * 
 * 1 / \ 2 3 / / \ 4 5 6 / 7
 * 
 * Output: 7 Note: You may assume the tree (i.e., the given root node) is not NULL.
 * 
 * @ClassName: FindBottomLeftTreeValueM
 * @author zhangyasen
 * @date 2017年10月1日
 */
public class FindBottomLeftTreeValueM {

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int val = root.val;
        while (!queue.isEmpty()) {
            int m = queue.size();
            for (int i = 0; i < m; i++) {
                TreeNode now = queue.poll();
                if (i == 0)
                    val = now.val;
                if (now.left != null)
                    queue.add(now.left);
                if (now.right != null)
                    queue.add(now.right);
            }
        }
        return val;
    }
}
