package main.java.com.valiantsen.lcpractise.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all
 * unique quadruplets in the array which gives the sum of target.
 * 
 * Note: The solution set must not contain duplicate quadruplets.
 * 
 * For example, given array S = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 * [-1, 0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2, 0, 0, 2]
 * ]
 * 
 * @ClassName: FourSumM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月16日
 */
public class FourSumM {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            int s = i + 1;
            if (target >= 2 * (nums[i] + nums[s])) {
                while (s < nums.length - 2) {
                    if (s > i + 1 && nums[s] == nums[s - 1]) {
                        s++;
                        continue;
                    }
                    int m = s + 1, n = nums.length - 1;
                    while (m < n) {
                        int sum = nums[i] + nums[s] + nums[m] + nums[n];
                        if (sum == target) {
                            list.add(Arrays.asList(nums[i], nums[s], nums[m], nums[n]));
                            while (m < n && nums[m + 1] == nums[m])
                                m++;
                            while (m < n && nums[n] == nums[n - 1])
                                n--;
                            m++;
                            n--;
                        } else if (sum > target)
                            n--;
                        else
                            m++;
                    }
                    s++;
                }
            }
        }

        return list;
    }
}
