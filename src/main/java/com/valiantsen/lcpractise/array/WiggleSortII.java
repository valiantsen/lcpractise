package main.java.com.valiantsen.lcpractise.array;

import java.util.Arrays;

/**
 * Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * Example: (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. (2)
 * Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Note: You may assume all input has valid answer.
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 * 
 * 
 * @ClassName: WiggleSortII
 * @author zhangyasen
 * @date 2017年10月9日
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        Arrays.sort(nums);
        int n = nums.length;
        int oushu = n / 2;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
        }
        int count = 0;
        int j = n - 1;
        for (int i = 1; i < n && count <= oushu; i += 2) {
            nums[i] = result[j];
            j--;
            count++;
        }
        for (int i = 0; i < n && count <= n; i += 2) {
            nums[i] = result[j];
            j--;
            count++;
        }
    }
}
