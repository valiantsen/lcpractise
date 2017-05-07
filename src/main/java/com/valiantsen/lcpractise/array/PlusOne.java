package main.java.com.valiantsen.lcpractise.array;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * @ClassName: PlusOne
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年4月28日
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        for (; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] newNums = new int[digits.length + 1];
        newNums[0] = 1;
        return newNums;
    }
}
