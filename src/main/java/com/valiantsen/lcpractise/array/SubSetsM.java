package main.java.com.valiantsen.lcpractise.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * For example,
 * If nums = [1,2,3], a solution is:
 * 
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 * 
 * @ClassName: SubSetsM
 * @Description:
 * @author zhangyasen
 * @date 2017年5月14日
 */
public class SubSetsM {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtracking(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    public void backtracking(List<List<Integer>> list, List<Integer> temp, int[] nums, int start) {
        list.add(new ArrayList<Integer>(temp));
        for (int i = start; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(list, temp, nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubSetsM s = new SubSetsM();
        s.subsets(new int[] { 1, 2, 2 });
    }
}
