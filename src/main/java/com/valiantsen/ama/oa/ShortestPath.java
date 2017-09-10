package main.java.com.valiantsen.ama.oa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ShortestPath {

    public int faltFields(List<List<Integer>> fields, int[] begin, int[] target) {
        int row = fields.size(), column = fields.get(0).size();
        int[][] visited = new int[row][column];
        Queue<Node> queue = new LinkedList<>();
        Node start = new Node(begin[0], begin[1], 0);
        queue.add(start);
        visited[begin[0]][begin[1]] = 1;
        while (!queue.isEmpty()) {
            Node now = queue.poll();
            int nx = now.x, ny = now.y, ndis = now.distance;
            if (nx == target[0] && ny == target[1])
                return ndis;
            for (int[] op : operations) {
                if (isValidNode(nx + op[0], ny + op[1], fields) && visited[nx + op[0]][ny + op[1]] == 0) {
                    Node ava = new Node(nx + op[0], ny + op[1], ndis + 1);
                    queue.add(ava);
                    visited[nx + op[0]][ny + op[1]] = 1;
                }
            }
        }

        return -1;
    }

    private boolean isValidNode(int x, int y, List<List<Integer>> fields) {
        if (x < 0 || x >= fields.size() || y < 0 || y >= fields.get(0).size() || fields.get(x).get(y) == 1) {
            return false;
        }
        return true;
    }

    private int[][] operations = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public class Node {
        int x;

        int y;

        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }


    public static void main(String[] args) {
        List<List<Integer>> codeList = new ArrayList<>();
        List<Integer> a = Arrays.asList(0, 0, 1, 0, 0);
        List<Integer> b = Arrays.asList(1, 0, 0, 0, 1);
        List<Integer> c = Arrays.asList(0, 1, 1, 0, 1);
        List<Integer> d = Arrays.asList(0, 1, 0, 1, 1);
        codeList.add(a);
        codeList.add(b);
        codeList.add(c);
        codeList.add(d);
        System.out.println(new ShortestPath().faltFields(codeList, new int[] {0, 1}, new int[] {2, 3}));
    }
}
