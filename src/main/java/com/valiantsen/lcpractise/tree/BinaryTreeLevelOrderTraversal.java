package main.java.com.valiantsen.lcpractise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
]
 * @ClassName: BinaryTreeLevelOrderTraversal
 * @author zhangyasen
 * @date 2017年9月25日
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        if(root==null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
            List<TreeNode> list = new ArrayList<>();
            List<Integer> valList = new ArrayList<>();
            while(!queue.isEmpty()){
                list.add(queue.poll());
            }
            for(TreeNode node:list){
                valList.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(valList);
        }
        return result;
    }
}
