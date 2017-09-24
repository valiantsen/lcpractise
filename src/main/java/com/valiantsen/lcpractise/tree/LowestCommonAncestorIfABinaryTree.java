package main.java.com.valiantsen.lcpractise.tree;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
For example, the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 * @ClassName: LowestCommonAncestorIfABinaryTree
 * @author zhangyasen
 * @date 2017年9月23日
 */
public class LowestCommonAncestorIfABinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode,TreeNode> parent = new HashMap<>();
        Deque<TreeNode> queue = new LinkedList<>();
        
        if(root ==null || p==null || q ==null) return null;
        parent.put(root,null);
        queue.add(root);
        while(!parent.containsKey(p) || !parent.containsKey(q)){
            TreeNode top = queue.pop();
                if(top.left!=null){
                parent.put(top.left,top);
                queue.add(top.left);
            }
            if(top.right!=null){
                parent.put(top.right,top);
                queue.add(top.right);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while(p!=null){
            ancestors.add(p);
            p=parent.get(p);
        }
        while(q!=null){
            if(ancestors.contains(q)){
                break;
            }
            q=parent.get(q);
        }
        return q;
    }
}
