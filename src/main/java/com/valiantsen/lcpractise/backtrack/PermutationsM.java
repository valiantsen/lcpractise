package main.java.com.valiantsen.lcpractise.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1],
 * [3,1,2], [3,2,1] ]
 * 
 * @ClassName: PermutationsM
 * @author zhangyasen
 * @date 2017年8月22日
 */
public class PermutationsM {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(result, new ArrayList<Integer>(), nums);
        return result;
    }

    private void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        if (tempList.size() == nums.length)
            result.add(new ArrayList<Integer>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                backTrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
