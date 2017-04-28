package main.java.com.valiantsen.lcpractise;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * 
 * For example,
 * Given nums = [0, 1, 3] return 2.
 * 
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space
 * complexity?
 * 
 * @ClassName: MissingNumber
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2017年4月27日
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = 0, total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += i;
            sum += nums[i];
        }
        total += nums.length;
        return total - sum;
    }

    public int missingNumberXOR(int[] nums) {
        int xor = 0, i = 0;
        for (; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
}
