package main.java.com.valiantsen.lcpractise.unionfind;

import java.util.ArrayList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand
 * operation which turns the water at position (row, col) into a land. Given a list of positions to
 * operate, count the number of islands after each addLand operation. An island is surrounded by
 * water and is formed by connecting adjacent lands horizontally or vertically. You may assume all
 * four edges of the grid are all surrounded by water.
 * 
 * Example:
 * 
 * Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]. Initially, the 2d grid grid is
 * filled with water. (Assume 0 represents water and 1 represents land).
 * 
 * 0 0 0 0 0 0 0 0 0 Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 
 * 1 0 0 0 0 0 Number of islands = 1 0 0 0 Operation #2: addLand(0, 1) turns the water at grid[0][1]
 * into a land.
 * 
 * 1 1 0 0 0 0 Number of islands = 1 0 0 0 Operation #3: addLand(1, 2) turns the water at grid[1][2]
 * into a land.
 * 
 * 1 1 0 0 0 1 Number of islands = 2 0 0 0 Operation #4: addLand(2, 1) turns the water at grid[2][1]
 * into a land.
 * 
 * 1 1 0 0 0 1 Number of islands = 3 0 1 0 We return the result as an array: [1, 1, 2, 3]
 * 
 * Challenge:
 * 
 * Can you do it in time complexity O(k log mn), where k is the length of the positions?
 * 
 * @ClassName: NumberOfIslandsH
 * @author zhangyasen
 * @date 2017年10月5日
 */
public class NumberOfIslandsH {

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        int[] islandGroup = new int[m * n];
        for (int i = 0; i < islandGroup.length; i++) {
            islandGroup[i] = -1;
        }
        int count = 0;
        for (int[] pair : positions) {
            int id = m * pair[1] + pair[0];
            islandGroup[id] = id;
            count++;
            for (int[] op : operation) {
                int x = op[0] + pair[0], y = pair[1] + op[1];
                int curId = m * y + x;
                if (x > -1 && x < m && y > -1 && y < m && islandGroup[curId] != -1) {
                    int newId = findRoot(curId, islandGroup);
                    if (id != newId) {
                        islandGroup[id] = newId;
                        id = newId;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }

    private int[][] operation = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private int findRoot(int id, int[] group) {
        while (id != group[id]) {
            group[id] = group[group[id]];
            id = group[id];
        }
        return id;
    }

    public static void main(String[] args) {
        int[][] positoin = {{0, 0}, {0, 1}, {1, 1}, {2, 1}};
        NumberOfIslandsH no = new NumberOfIslandsH();
        List<Integer> result = no.numIslands2(3, 3, positoin);
        for (Integer n : result) {
            System.out.println(n);
        }
    }
}
