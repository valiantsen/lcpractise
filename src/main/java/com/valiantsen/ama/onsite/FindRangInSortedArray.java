package main.java.com.valiantsen.ama.onsite;

import java.util.LinkedList;
import java.util.List;

public class FindRangInSortedArray {

    public int[] findRange(int[] nums, int k) {
        if (nums == null || nums.length == 0)
            return new int[0];
        List<Integer> list = new LinkedList<>();
        find(0, nums.length - 1, nums, k, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void find(int begin, int end, int[] nums, int target, List<Integer> list) {
        if (begin > end)
            return;
        int mid = binarySearch(begin, end, nums, target);
        if (mid != -1) {
            find(begin, mid - 1, nums, target, list);
            list.add(mid);
            find(mid + 1, end, nums, target, list);
        }
    }

    private int binarySearch(int begin, int end, int[] nums, int target) {
        while (begin <= end) {
            int mid = (end - begin) / 2 + begin;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FindRangInSortedArray f = new FindRangInSortedArray();
        int[] array = {1, 2, 3, 3, 3, 4, 6, 7};
        int[] result = f.findRange(array, 8);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
