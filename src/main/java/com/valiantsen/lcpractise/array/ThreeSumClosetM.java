package main.java.com.valiantsen.lcpractise.array;

import java.util.Arrays;

public class ThreeSumClosetM {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closet = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int s = i + 1, e = nums.length - 1;
            if (i == 0)
                closet = nums[s] + nums[e] + nums[i];
            while (s < e) {
                while (s < e) {
                    if (nums[s] + nums[e] + nums[i] == target) {
                        return target;
                    } else {
                        closet = Math.abs(closet - target) > Math.abs(nums[s] + nums[e] + nums[i] - target)
                                ? nums[s] + nums[e] + nums[i] : closet;
                }
                e--;
            }
                e = nums.length - 1;
                s++;
            }

        }
        return closet;
    }

    public int threeSumClosest1(int[] nums, int target) {
        int closet = 0;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            int s = i + 1, e = nums.length - 1;
            if (i == 0)
                closet = nums[s] + nums[e] + nums[i];
            while (s < e) {
                if (Math.abs(closet - target) > Math.abs(nums[s] + nums[e] + nums[i] - target)) {
                    closet = nums[s] + nums[e] + nums[i];
                }
                if (nums[s] + nums[e] + nums[i] > target) {
                    e--;
                } else {
                    s++;
                }
            }

        }
        return closet;
    }

    public static void main(String[] args) {
        ThreeSumClosetM t = new ThreeSumClosetM();
        int[] a = { -3, 1, 2, 0 };
        System.out.println(t.threeSumClosest(a, 1));
    }
}
