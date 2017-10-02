package main.java.com.valiantsen.lcpractise.stack;

import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar
 * is 1, find the area of largest rectangle in the histogram.
 * 
 * 
 * Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
 * 
 * 
 * The largest rectangle is shown in the shaded area, which has area = 10 unit.
 * 
 * For example, Given heights = [2,1,5,6,2,3], return 10.
 * 
 * 
 * @ClassName: LargestRectangleInHistogramH
 * @author zhangyasen
 * @date 2017年10月2日
 */
public class LargestRectangleInHistogramH {

    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0, top = -1, head = 0, now = -1;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                head = stack.pop();
                now = heights[head] * (stack.isEmpty() ? i : (i - stack.peek() - 1));
                if (now > top) {
                    top = now;
                }
            }
        }
        while (!stack.isEmpty()) {
            head = stack.pop();
            if (stack.isEmpty()) {
                now = heights[head] * i;
            } else {
                now = heights[head] * (i - stack.peek() - 1);
            }
            if (now > top) {
                top = now;
            }
        }
        return top;
    }
}
