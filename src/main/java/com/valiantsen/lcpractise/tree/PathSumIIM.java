package main.java.com.valiantsen.lcpractise.tree;

import java.util.ArrayList;
import java.util.List;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given
 * sum.
 * 
 * For example: Given the below binary tree and sum = 22, 5 / \ 4 8 / / \ 11 13 4 / \ / \ 7 2 5 1
 * return [ [5,4,11,2], [5,8,4,5] ]
 * 
 * @ClassName: PathSumIIM
 * @author zhangyasen
 * @date 2017年10月15日
 */
public class PathSumIIM {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), root, sum);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> temp, TreeNode root, int sum) {
        if (root == null)
            return;
        if (root.left == null && root.right == null && root.val == sum) {
            temp.add(root.val);
            result.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
        } else {
            temp.add(root.val);
            dfs(result, temp, root.left, sum - root.val);
            dfs(result, temp, root.right, sum - root.val);
            temp.remove(temp.size() - 1);
        }
    }
}
