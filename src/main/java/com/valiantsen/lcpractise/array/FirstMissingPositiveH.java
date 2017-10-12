package main.java.com.valiantsen.lcpractise.array;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example, Given [1,2,0] return 3, and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @ClassName: FirstMissingPositiveH
 * @author zhangyasen
 * @date 2017年10月12日
 */
public class FirstMissingPositiveH {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length;) {
            if (nums[i] < 1 || nums[i] > nums.length || nums[i] == i + 1 || nums[nums[i] - 1] == nums[i]) {
                i++;
                continue;
            }
            if (nums[i] != i + 1) {
                swap(i, nums[i] - 1, nums);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                return i + 1;
        }
        return nums.length + 1;
    }

    private void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
        return;
    }
}
