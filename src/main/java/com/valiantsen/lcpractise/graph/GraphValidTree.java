package main.java.com.valiantsen.lcpractise.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of
 * nodes), write a function to check whether these edges make up a valid tree.
 * 
 * For example:
 * 
 * Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 * 
 * Hint:
 * 
 * Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid
 * tree? According to the definition of tree on Wikipedia: “a tree is an undirected graph in which
 * any two vertices are connected by exactly one path. In other words, any connected graph without
 * simple cycles is a tree.”
 * 
 * @ClassName: GraphValidTree
 * @author zhangyasen
 * @date 2017年10月14日
 */
public class GraphValidTree {

    private boolean isCircle = false;

    private int count = 0;

    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        boolean[] visited = new boolean[n];
        for (int[] pair : edges) {
            if (graph.containsKey(pair[0])) {
                graph.get(pair[0]).add(pair[1]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(pair[1]);
                graph.put(pair[0], l);
            }
            if (graph.containsKey(pair[1])) {
                graph.get(pair[1]).add(pair[0]);
            } else {
                List<Integer> l = new ArrayList<>();
                l.add(pair[0]);
                graph.put(pair[1], l);
            }
        }
        dfs(-1, 0, visited, graph);
        return !isCircle && count == n;
    }

    private void dfs(int pre, int current, boolean[] visited, Map<Integer, List<Integer>> graph) {
        if (visited[current]) {
            isCircle = true;
            return;
        }
        visited[current] = true;
        count++;
        for (Integer next : graph.get(current)) {
            if (next == pre)
                continue;
            dfs(current, next, visited, graph);
        }

    }

    public boolean validTreeUf(int n, int[][] edges) {
        int[] root = new int[n];

        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] pair : edges) {
            int x = findRoot(root, pair[0]), y = findRoot(root, pair[1]);
            if (x == y)
                return false;
            root[pair[1]] = x;
        }
        for (int i = 0; i < n - 1; i++) {
            if (findRoot(root, i) != findRoot(root, i + 1)) {
                return false;
            }
        }
        return true;
    }

    private int findRoot(int[] root, int i) {
        while (root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return root[i];
    }

    public static void main(String[] args) {
        int[][] pairs = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        int[][] pairs2 = {{0, 1}, {1, 2}, {2, 3}, {3, 1}, {1, 4}};
        int[][] pairs3 = {{0, 1}, {1, 2}, {3, 4}};
        GraphValidTree t = new GraphValidTree();
        System.out.println(t.validTree(5, pairs));
        System.out.println(t.validTree(5, pairs2));
        System.out.println(t.validTree(5, pairs3));
        System.out.println(t.validTreeUf(5, pairs));
        System.out.println(t.validTreeUf(5, pairs2));
        System.out.println(t.validTreeUf(5, pairs3));
    }
}
