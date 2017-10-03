package main.java.com.valiantsen.lcpractise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course
 * 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to
 * finish all courses?
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you should have finished
 * course 0. So it is possible.
 * 
 * 2, [[1,0],[0,1]] There are a total of 2 courses to take. To take course 1 you should have
 * finished course 0, and to take course 0 you should also have finished course 1. So it is
 * impossible.
 * 
 * Note: The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented. You may assume that there are no duplicate edges in
 * the input prerequisites.
 * 
 * @ClassName: CourseSchedule
 * @author zhangyasen
 * @date 2017年10月3日
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)
            return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pairs : prerequisites) {
            if (map.containsKey(pairs[0])) {
                map.get(pairs[0]).add(pairs[1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(pairs[1]);
                map.put(pairs[0], l);
            }
        }
        // 0 not-visited, 1-tem ,2-parmanent
        int[] visited = new int[numCourses];
        for (int[] pairs : prerequisites) {
            int start = pairs[0];
            if (visited[start] == 0) {
                if (!dfs(start, map, visited)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean dfs(int m, Map<Integer, List<Integer>> map, int[] visited) {
        if (visited[m] == 2)
            return true;
        if (visited[m] == 1)
            return false;
        visited[m] = 1;
        if (map.containsKey(m)) {
            for (Integer adjacent : map.get(m)) {
                if (!dfs(adjacent, map, visited)) {
                    return false;
                }
            }
        }
        visited[m] = 2;
        return true;
    }

    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0)
            return true;
        // node incoming degree
        int[] incoming = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pairs : prerequisites) {
            incoming[pairs[1]]++;
            if (map.containsKey(pairs[0])) {
                map.get(pairs[0]).add(pairs[1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(pairs[1]);
                map.put(pairs[0], l);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < incoming.length; i++) {
            if (incoming[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        while (!queue.isEmpty()) {
            int m = queue.poll();
            count++;
            if (map.containsKey(m)) {
                for (Integer n : map.get(m)) {
                    if (--incoming[n] == 0) {
                        queue.add(n);
                    }
                }
            }
        }
        return count == numCourses;
    }
}
