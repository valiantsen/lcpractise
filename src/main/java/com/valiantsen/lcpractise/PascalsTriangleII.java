package main.java.com.valiantsen.lcpractise;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * 
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * @ClassName: PascalsTriangleII
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年4月29日
 */
public class PascalsTriangleII {
    public List<Integer> getRowMineFirstAC(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        int oldValue = 1;
        for (int i = rowIndex + 1; i > 0; i--) {
            if (i == (rowIndex + 1)) {
                list.add(1);
                continue;
            }
            for (int m = 0, n = m + 1; n < list.size(); m++, n++) {
                int x = list.get(n);
                list.set(n, oldValue + list.get(n));
                oldValue = x;

            }
            list.add(1);
        }

        return list;
    }

    public List<Integer> getRowBeta(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(1);
            for (int j = i - 1; j > 0; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
        }

        return list;
    }
}
