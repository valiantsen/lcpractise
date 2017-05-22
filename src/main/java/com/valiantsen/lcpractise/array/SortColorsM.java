package main.java.com.valiantsen.lcpractise.array;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent,
 * with the colors in the order red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * click to show follow up.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then
 * 1's and followed by 2's.
 * 
 * Could you come up with an one-pass algorithm using only constant space?
 * 
 * @ClassName: SortColorsM
 * @Description:
 * @author zhangyasen
 * @date 2017年5月22日
 */
public class SortColorsM {

    /**
     * The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
     * 
     * It is hard to define what is a "one-pass" solution but this algorithm is bounded by O(2n), meaning that at most
     * each element will be seen and operated twice (in the case of all 0s). You may be able to write an algorithm which
     * goes through the list only once, but each step requires multiple operations, leading the total operations larger
     * than O(2n).
     * TODO
     * 
     * @param nums
     */
    public void sortColors(int[] nums) {

        int low = 0, high = nums.length - 1;
        for (int i = 0; i <= high;) {
            if (nums[i] == 0) {
                int temp = nums[low];
                nums[low] = nums[i];
                nums[i] = temp;
                low++;
                i++;
            } else if (nums[i] == 2) {
                int temp = nums[high];
                nums[high] = nums[i];
                nums[i] = temp;
                high--;
            } else {
                i++;
            }
        }
    }
}
