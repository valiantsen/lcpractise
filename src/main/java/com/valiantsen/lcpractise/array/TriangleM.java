package main.java.com.valiantsen.lcpractise.array;

import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row
 * below.
 * 
 * For example, given the following triangle
 * [
 * [2],
 * [3,4],
 * [6,5,7],
 * [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * @ClassName: TriangleM
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月7日
 */
public class TriangleM {

    public int minimumTotal(List<List<Integer>> triangle) {
        int max = 0;
        if (triangle != null && triangle.size() > 0) {
            List<Integer> dp = triangle.get(triangle.size() - 1);

            for (int i = triangle.size() - 2; i > -1; i--) {
                for (int j = 0; j < triangle.get(i).size(); j++) {
                    dp.set(j, Math.min(dp.get(j), dp.get(j + 1)) + triangle.get(i).get(j));
                }
            }
            max = dp.get(0);
        }
        return max;
    }
}
