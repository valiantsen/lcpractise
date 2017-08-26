package main.java.com.valiantsen.lcpractise.array;

public class SearchForARangeM {
    private static int max = -1, min = 0;

    public int[] searchRange(int[] nums, int target) {
        min = nums.length;
        int left = 0, right = nums.length - 1;
        binary(nums, left, right, target);
        if (max == -1 || min == nums.length) {
            return new int[] {-1, -1};
        }
        return new int[] {min, max};
    }

    private void binary(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                max = Math.max(max, mid);
                min = Math.min(min, mid);
                binary(nums, left, mid - 1, target);
                binary(nums, mid + 1, right, target);
            } else if (nums[mid] > target) {
                binary(nums, left, mid - 1, target);
            } else {
                binary(nums, mid + 1, right, target);
            }
        }
    }

    public static void main(String[] args) {
        SearchForARangeM w = new SearchForARangeM();
        int[] a = w.searchRange(new int[] {1}, 1);
        System.out.println(a.length);
    }
}
