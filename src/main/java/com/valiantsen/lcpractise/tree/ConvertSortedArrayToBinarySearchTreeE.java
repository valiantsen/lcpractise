package main.java.com.valiantsen.lcpractise.tree;

import main.java.com.valiantsen.lcpractise.struct.TreeNode;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * 
 * 
 * @ClassName: ConvertSortedArrayToBinarySearchTreeE
 * @author zhangyasen
 * @date 2017年7月2日
 */
public class ConvertSortedArrayToBinarySearchTreeE {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        return toTree(nums, 0, nums.length - 1);
    }

    private TreeNode toTree(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = (end + start) / 2;
            TreeNode r = new TreeNode(nums[mid]);
            r.left = toTree(nums, start, mid - 1);
            r.right = toTree(nums, mid + 1, end);
            return r;
        }
        return null;
    }
}
