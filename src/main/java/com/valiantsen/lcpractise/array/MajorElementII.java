package main.java.com.valiantsen.lcpractise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The
 * algorithm should run in linear time and in O(1) space.
 * 
 * @ClassName: MajorElementII
 * @author zhangyasen
 * @date 2017年9月26日
 */
public class MajorElementII {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        int val1 = nums[0], val2 = nums[0], counter1 = 1, counter2 = 0;
        for (Integer a : nums) {
            if (a == val1) {
                counter1++;
            } else if (a == val2) {
                counter2++;
            } else if (counter1 == 0) {
                val1 = a;
                counter1++;
            } else if (counter2 == 0) {
                val2 = a;
                counter2++;
            } else {
                counter1--;
                counter2--;
            }
        }
        counter1 = 0;
        counter2 = 0;
        for (Integer b : nums) {
            if (val1 == b)
                counter1++;
            else if (val2 == b)
                counter2++;
        }
        if (counter1 > nums.length / 3)
            result.add(val1);
        if (counter2 > nums.length / 3)
            result.add(val2);
        return result;
    }
}
