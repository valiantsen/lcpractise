package main.java.com.valiantsen.lcpractise.array;

/**
 * Rotate an array of n elements to the right by k steps.
 * 
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * @ClassName: RotateArray
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月7日
 */
public class RotateArray {

    public void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }

    public void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0, prev = 0, current = 0, temp = 0, next = 0;
        for (int start = 0; count < nums.length; start++) {
            prev = nums[start];
            current = start;
            do {
                next = (current + k) % nums.length;
                temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }

    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp = 0;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}
