package main.java.com.valiantsen.lcpractise;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2
 * ⌋ times.
 * 
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * 
 * 
 * @ClassName: MajorityElement
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月1日
 */
public class MajorityElement {

    /**
     * hashmap
     * TODO
     * 
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int n : nums) {
            if (map.get(n) == null) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
            if (map.get(n) > (nums.length / 2))
                return n;
        }
        return 0;
    }

    /**
     * majority vote algorithm
     * TODO
     * 
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int major = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                major = nums[i];
                count++;
            } else if (nums[i] == major) {
                count++;
            } else {
                count--;
            }
        }
        return major;
    }

}
