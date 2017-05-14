package main.java.com.valiantsen.lcpractise.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C
 * where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 * [7],
 * [2, 2, 3]
 * ]
 * 
 * @ClassName: CombinationSumM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月14日
 */
public class CombinationSumM {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
        for (int i = start; i < nums.length; i++) {
            if (target < nums[i])
                break;
            temp.add(nums[i]);
            findTarget(list, temp, nums, target - nums[i], i);
            temp.remove(temp.size() - 1);

        }
    }
}
