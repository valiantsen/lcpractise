package main.java.com.valiantsen.lcpractise.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the
 * candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 
 * @ClassName: CombinationSumII
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月14日
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> list = new ArrayList<>();

        findTarget(list, new ArrayList<Integer>(), candidates, target, 0);
        return list;
    }

    private void findTarget(List<List<Integer>> list, List<Integer> temp, int[] nums, int target, int start) {
        if (target == 0) {
            list.add(new ArrayList<>(temp));
            return;
        }
        int i = start;
        while (i < nums.length) {
            if (target < nums[i])
                break;
            temp.add(nums[i]);
            findTarget(list, temp, nums, target - nums[i], i + 1);
            temp.remove(temp.size() - 1);
            i++;
            while (i < nums.length && nums[i] == nums[i - 1])
                i++;

        }
    }
}
