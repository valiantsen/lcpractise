package main.java.com.valiantsen.lcpractise.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
 * appears at least twice in the array, and it should return false if every element is distinct.
 * 
 * @ClassName: ContainsDuplicate
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年4月30日
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i]))
                return true;
        }
        return false;
    }
}
