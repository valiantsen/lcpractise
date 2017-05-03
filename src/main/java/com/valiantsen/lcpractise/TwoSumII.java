package main.java.com.valiantsen.lcpractise;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] indices = new int[2];
        int second = 0;
        for (int i = 0; i < numbers.length; i++) {
            if ((target - numbers[i]) >= numbers[i]) {
                second = binarySearch(numbers, i + 1, numbers.length - 1, target - numbers[i]);
                if (second != -1) {
                    indices[0] = i + 1;
                    indices[1] = second;
                }
            }
        }
        return indices;
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return (mid + 1);
            else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    public int[] twoSumBeta(int[] numbers, int target) {
        int[] indecies = new int[2];
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            if ((numbers[left] + numbers[right]) == target) {
                indecies[0] = left + 1;
                indecies[1] = right + 1;
                break;
            } else if ((numbers[left] + numbers[right]) > target)
                right--;
            else
                left++;
        }
        return indecies;
    }
}
