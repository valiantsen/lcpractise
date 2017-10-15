package main.java.com.valiantsen.lcpractise.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * 
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * 
 * Note: The result may be very large, so you need to return a string instead of an integer.
 * 
 * @ClassName: LargestNumberM
 * @author zhangyasen
 * @date 2017年10月14日
 */
public class LargestNumberM {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s1 + s2).compareTo(s2 + s1);
            }
        });
        StringBuilder sb = new StringBuilder("");
        for (int i = strs.length - 1; i > -1; i--) {
            sb.append(strs[i]);
        }

        return sb.toString().startsWith("0") ? "0" : sb.toString();
    }
}
