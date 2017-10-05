package main.java.com.valiantsen.lcpractise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course
 * 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of
 * courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to
 * finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take course 3 you should
 * have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished
 * course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented. You may assume that there are no duplicate edges in
 * the input prerequisites.
 * 
 * @ClassName: CourseScheduleII
 * @author zhangyasen
 * @date 2017年10月3日
 */
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)
        // return new int[0];
        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int[] pairs : prerequisites) {
            if (map.containsKey(pairs[1])) {
                map.get(pairs[1]).add(pairs[0]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(pairs[0]);
                map.put(pairs[1], l);
            }
        }
        // 0 not-visited, 1-tem ,2-parmanent
        int[] visited = new int[numCourses];
        for (int[] pairs : prerequisites) {
            int start = pairs[1];
            if (visited[start] == 0) {
                if (!dfs(start, map, visited, stack)) {
                    return new int[0];
                }
            }
        }
        int[] result = new int[numCourses];
        int count = 0;
        while (!stack.isEmpty()) {
            result[count++] = stack.pop();
        }
        if (count < numCourses) {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i] == 0) {
                    result[count++] = i;
                }
            }
        }
        return result;
    }

    private boolean dfs(int m, Map<Integer, List<Integer>> map, int[] visited, Stack<Integer> stack) {
        if (visited[m] == 2)
            return true;
        if (visited[m] == 1)
            return false;
        visited[m] = 1;
        if (map.containsKey(m)) {
            for (Integer adjacent : map.get(m)) {
                if (!dfs(adjacent, map, visited, stack)) {
                    return false;
                }
            }
        }
        visited[m] = 2;
        stack.push(m);
        return true;
    }
}
