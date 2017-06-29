package main.java.com.valiantsen.lcpractise.string;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum
 * length of s is 1000.
 * 
 * Example:
 * 
 * Input: "babad"
 * 
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer. Example:
 * 
 * Input: "cbbd"
 * 
 * Output: "bb"
 * 
 * @ClassName: LongestPalindromicSubstringM
 * @author zhangyasen
 * @date 2017年6月22日
 */
public class LongestPalindromicSubstringM {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0, start = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && ((j - i < 3) || dp[i + 1][j - 1]));

                if (dp[i][j] && (j - i + 1) > maxLength) {
                    maxLength = j - i + 1;
                    start = i;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }
}
