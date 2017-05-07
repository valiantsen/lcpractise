package main.java.com.valiantsen.lcpractise.array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @ClassName: MaxiumProductSubArrayM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月7日
 */
public class MaxiumProductSubArrayM {

    public int maxProduct(int[] nums) {
        int maxSofa = nums[0];
        int minSofa = maxSofa;
        int maxTotal = maxSofa, maxHere, minHere;
        for (int i = 1; i < nums.length; i++) {
            maxHere = Math.max(Math.max(maxSofa * nums[i], minSofa * nums[i]), nums[i]);
            minHere = Math.min(Math.min(minSofa * nums[i], maxSofa * nums[i]), nums[i]);
            maxSofa = maxHere;
            minSofa = minHere;
            maxTotal = Math.max(maxTotal, maxHere);
        }
        return maxTotal;

    }

    int maxProduct1(int A[], int n) {
        // store the result that is the max we have found so far
        int r = A[0];

        // imax/imin stores the max/min product of
        // subarray that ends with the current number A[i]
        for (int i = 1, imax = r, imin = r; i < n; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if (A[i] < 0)
                swap(imax, imin);

            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            imax = Math.max(A[i], imax * A[i]);
            imin = Math.min(A[i], imin * A[i]);

            // the newly computed max value is a candidate for our global result
            r = Math.max(r, imax);
        }
        return r;
    }

    public void swap(int a, int b) {

    }
}
