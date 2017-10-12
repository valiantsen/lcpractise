package main.java.com.valiantsen.lcpractise.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique
 * permutations.
 * 
 * For example, [1,1,2] have the following unique permutations: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * @ClassName: PermutationsIIM
 * @author zhangyasen
 * @date 2017年10月12日
 */
public class PermutationsIIM {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(result, new ArrayList<Integer>(), nums, used);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<Integer>(tempList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i])
                    continue;
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])
                    continue;
                tempList.add(nums[i]);
                used[i] = true;
                backTrack(result, tempList, nums, used);
                tempList.remove(tempList.size() - 1);
                used[i] = false;
            }
        }
    }
}
