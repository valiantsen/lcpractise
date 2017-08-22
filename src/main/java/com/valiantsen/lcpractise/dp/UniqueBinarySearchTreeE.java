package main.java.com.valiantsen.lcpractise.dp;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * @ClassName: UniqueBinarySearchTreeE
 * @author zhangyasen
 * @date 2017年8月12日
 */
public class UniqueBinarySearchTreeE {

    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = g[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++)
                g[i] += g[i - j] * g[j - 1];
        }
        return g[n];
    }
}
