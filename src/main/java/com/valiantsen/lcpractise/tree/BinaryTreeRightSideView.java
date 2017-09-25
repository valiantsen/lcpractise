package main.java.com.valiantsen.lcpractise.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
 * @ClassName: BinaryTreeRightSideView
 * @author zhangyasen
 * @date 2017年9月25日
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return result;
        queue.add(root);
        while(!queue.isEmpty()){
        int n = queue.size();
            for(int i=1;i<=n;i++){
                if(queue.peek().left!=null) queue.add(queue.peek().left);
                if(queue.peek().right!=null) queue.add(queue.peek().right);
                TreeNode now = queue.poll();
                if(i==n){
                    result.add(now.val);
                }
            }
        }
                    return result;

    }
    
    public List<Integer> rightSideViewLC(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        getView(result,root,0);
        return result;

    }
    
    private void getView(List<Integer> result,TreeNode node,int curDepth){
        if(node==null) return;
        if(result.size()==curDepth){
            result.add(node.val);
        }
        getView(result,node.right,curDepth+1);
        getView(result,node.left,curDepth+1);
    }
}
