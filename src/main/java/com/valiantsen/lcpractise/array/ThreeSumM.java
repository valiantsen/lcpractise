package main.java.com.valiantsen.lcpractise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in
 * the array which gives the sum of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 * 
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 
 * @ClassName: ThreeSumM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月14日
 */
public class ThreeSumM {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int s = i + 1, e = nums.length - 1;
            while (s < e) {
                if (nums[s] + nums[e] + nums[i] == 0) {
                    list.add(Arrays.asList(nums[i], nums[s], nums[e]));
                    while (s < e && nums[s + 1] == nums[s])
                        s++;
                    while (s < e && nums[e - 1] == nums[e])
                        e--;
                    s++;
                    e--;
                } else if (nums[s] + nums[e] + nums[i] > 0) {
                    e--;
                } else if (nums[s] + nums[e] + nums[i] < 0) {
                    s++;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSumM m = new ThreeSumM();
        int[] a = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> l = m.threeSum(a);
        System.out.println(l.size());
    }
}
