package main.java.com.valiantsen.lcpractise.array;

public class SearchInRotatedSortedArrayM {
    public int search(int[] nums, int target) {
        // 1.find the mininum value
        int low = 0, high = nums.length - 1, small = 0;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] >= nums[low]) {
                low = mid + 1;
            }
        }
        small = low;

        low = 0;
        high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int realMid = (mid + small) % nums.length;
            if (nums[realMid] == target)
                return realMid;
            else if (nums[realMid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {3, 1};
        SearchInRotatedSortedArrayM m = new SearchInRotatedSortedArrayM();
        m.search(a, 0);
    }
}
