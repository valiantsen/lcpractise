package main.java.com.valiantsen.lcpractise.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design
 * an algorithm to find the maximum profit.
 * 
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * 
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * 
 * In this case, no transaction is done, i.e. max profit = 0.
 * 
 * @ClassName: BestTimeToBuyAndSellStock
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年4月30日
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int max = 0;
        int[] dp = new int[prices.length];
        if (prices.length > 0) {
            dp[0] = prices[0];
            for (int i = 1; i < prices.length; i++) {
                dp[i] = (prices[i] - dp[i - 1]) > 0 ? dp[i - 1] : prices[i];
                max = Math.max(max, prices[i] - dp[i]);
            }
        }
        return max;
    }
}
