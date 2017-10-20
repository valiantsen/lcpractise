package main.java.com.valiantsen.design;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is bar to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @ClassName: TrappingRainWaterH
 * @author zhangyasen
 * @date 2017年9月21日
 */
public class TrappingRainWaterH {
    public int trap(int[] height) {
        int area = 0;
        if (height == null || height.length == 0)
            return area;
        int left = 0, right = height.length - 1;
        int maxleft = height[left], maxright = height[right];
        while (left < right) {
            if (height[left] < height[right]) {
                while (++left < right && height[left] < maxleft) {
                    area += (maxleft - height[left]);
                }
                if (height[left] > maxleft) {
                    maxleft = height[left];
                }
                continue;
            } else {
                while (left < --right && height[right] < maxright) {
                    area += (maxright - height[right]);
                }
                if (height[right] > maxright) {
                    maxright = height[right];
                }
                continue;
            }
        }
        return area;

    }

    public static void main(String[] args) {
        int[] inputs = {2, 1, 0, 2};

    }

}
