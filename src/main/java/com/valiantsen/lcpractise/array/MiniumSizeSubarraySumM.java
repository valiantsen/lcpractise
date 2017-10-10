package main.java.com.valiantsen.lcpractise.array;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length of a
 * contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * For example, given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length
 * under the problem constraint.
 * 
 * click to show more practice.
 * 
 * More practice: If you have figured out the O(n) solution, try coding another solution of which
 * the time complexity is O(n log n).
 * 
 * @ClassName: MiniumSizeSubarraySumM
 * @author zhangyasen
 * @date 2017年10月8日
 */
public class MiniumSizeSubarraySumM {
    public int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 1, sum = nums[left];
        while (left <= right && right <= nums.length) {
            if (sum < s) {
                if (right == nums.length)
                    break;
                sum += nums[right++];
            } else {
                min = (min < (right - left)) ? min : (right - left);
                sum -= nums[left++];

            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public int minSubArrayLenLC(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0)
            return 0;
        int left = 0, right = 0, sum = 0;
        while (right < nums.length) {
            sum += nums[right++];
            while (sum >= s) {
                min = min < (right - left) ? min : (right - left);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
