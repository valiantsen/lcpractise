package main.java.com.valiantsen.lcpractise.tree;

import java.util.ArrayList;
import java.util.List;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * 
 * For example, given the following binary tree:
 * 
 * 1 / \ 2 3 \ 5 All root-to-leaf paths are:
 * 
 * ["1->2->5", "1->3"]
 * 
 * @ClassName: BinaryTreePaths
 * @author zhangyasen
 * @date 2017年7月25日
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        find(list, "", 0, root);
        return list;
    }

    private void find(List<String> list, String path, int depth, TreeNode root) {
        if (root == null) {
            return;
        }
        if (depth == 0) {
            path += root.val;
        } else {
            path += ("->" + root.val);
        }
        if (root.left == null && root.right == null) {
            list.add(path);
            return;
        }
        find(list, path, depth + 1, root.left);
        find(list, path, depth + 1, root.right);

    }
}
