package main.java.com.valiantsen.lcpractise.array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and
 * sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time
 * (ie, you must sell the stock before you buy again).
 * 
 * @ClassName: BestTimeToBuyAndSellStockII
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author zhangyasen
 * @date 2017年5月7日
 */
public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {
        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            total += (prices[i] - prices[i - 1]) > 0 ? (prices[i] - prices[i - 1]) : 0;
        }
        return total;
    }
}
